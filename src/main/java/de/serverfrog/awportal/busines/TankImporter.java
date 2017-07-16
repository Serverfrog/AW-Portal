package de.serverfrog.awportal.busines;

import de.serverfrog.awportal.eao.TankEao;
import de.serverfrog.awportal.entity.Tank;
import de.serverfrog.awportal.misc.JaxbMarschaller;
import de.serverfrog.awportal.misc.TestRunner;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by Serverfrog on 16.07.17.
 */
@Service
@Scope("singleton")
@Log4j
public class TankImporter {

    @Autowired
    private TankEao tankEao;

    @Scheduled(cron = "0 * * * * *")
    public void importTanks(){
        InputStream resource = TestRunner.class.getResourceAsStream("/tanks.json");
        StringWriter sw = new StringWriter();
        try {
            IOUtils.copy(resource, sw, UTF_8);
        } catch (IOException e) {
            log.warn("IO Exception",e);
        }
        Tank[] unmarshal = JaxbMarschaller.unmarshal(Tank[].class, sw.toString());

        if( unmarshal == null){
            return;
        }
        List<Tank> tanks = Arrays.asList(unmarshal);

        tankEao.save(tanks);
        log.debug("Saved Tanks. Amount="+ tankEao.count());

    }


}
