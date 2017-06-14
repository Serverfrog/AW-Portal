package de.serverfrog.awportal;


import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.undertow.WARArchive;

import java.net.URL;

/**
 * Created by Serverfrog on 14.06.17.
 */
public class Main {

    static final String[] webResources = {"compare","index","match"};


    public  void main(String[] args) throws Exception {

        System.out.println(Main.class.getClassLoader().getResource("project-defaults.yml"));

        URL stageConfig = Main.class.getClassLoader().getResource("project-defaults.yml");
        Swarm swarm = new Swarm();
        swarm.withConfig(stageConfig);


        swarm.fraction(new DatasourcesFraction()
                .dataSource("java:jboss/datasources/awportalDatasource", (ds) -> {
                    ds.driverName("mysql");
                    ds.connectionUrl("jdbc:mysql://localhost/awportal");
                    ds.userName("awportal");
                    ds.password("awportal");
                }));

        swarm.start();

        WARArchive archive = ShrinkWrap.create(WARArchive.class);
        archive.addPackage(Main.class.getPackage());


        ClassLoader classLoader = Main.class.getClassLoader();

        for(String s : webResources) {
            String fileName = s + ".xhtml";
            archive.addAsWebResource( new ClassLoaderAsset(fileName, classLoader), fileName);
        }


        archive.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()),
                "classes/META-INF/persistence.xml");

        archive.addAsWebInfResource(
                new ClassLoaderAsset("WEB-INF/web.xml", Main.class.getClassLoader()), "web.xml");
        archive.addAsWebResource(
                new ClassLoaderAsset("index.xhtml", Main.class.getClassLoader()), "index.xhtml");

        archive.addAllDependencies();


        swarm.deploy(archive);
    }
}
