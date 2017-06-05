package de.serverfrog.awportal;

import de.serverfrog.awportal.entity.Tank;
import de.serverfrog.awportal.misc.JaxbMarschaller;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by m-p-h_000 on 18.04.2017.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream resource = Test.class.getResourceAsStream("/tanks.json");
        StringWriter sw = new StringWriter();
        IOUtils.copy(resource,sw, Charset.forName("UTF-8"));
        Tank[] unmarshal = JaxbMarschaller.unmarshal(Tank[].class, sw.toString());
        System.out.println(Arrays.toString(unmarshal));

    }
}
