package de.serverfrog.awportal.common;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.Map;

/**
 * Created by Serverfrog on 05.06.17.
 */
public class PuConfig {


    public final static String NAME = "awportal";

    public final static String DATASOURCE = "java:jboss/datasources/awportal";

    @PersistenceUnit(unitName = NAME)
    @Produces
    @AwPortal
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext(unitName = NAME)
    @Produces
    @AwPortal
    private EntityManager entityManager;

    @Resource(name = DATASOURCE)
    @Produces
    @AwPortal
    private DataSource dataSource;
}
