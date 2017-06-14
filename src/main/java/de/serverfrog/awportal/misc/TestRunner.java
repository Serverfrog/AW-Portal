package de.serverfrog.awportal.misc;

import de.serverfrog.awportal.entity.match.MatchEntry;
import de.serverfrog.awportal.entity.match.MatchHistory;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by Serverfrog on 05.06.17.
 */
public class TestRunner {

    public static void main(String[] args) {
        InputStream resource = TestRunner.class.getResourceAsStream("/match_history");
        StringWriter sw = new StringWriter();
        try {
            IOUtils.copy(resource, sw, UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MatchHistory unmarshal = JaxbMarschaller.unmarshal(MatchHistory.class, sw.toString());
        for (MatchEntry m : unmarshal.getMatchEntries()) {
            System.out.println(m.getStart());

        }
    }
}
