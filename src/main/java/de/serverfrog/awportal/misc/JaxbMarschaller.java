package de.serverfrog.awportal.misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;

/**
 * Created by m-p-h_000 on 18.04.2017.
 */
public class JaxbMarschaller {

    private static ObjectMapper OM;

    static {
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        OM = new ObjectMapper();
        OM.registerModule(module);
    }

    public static <T> T unmarshal(Class<T> clazz, String content) {
        try {
            return OM.readValue(content, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
