package de.serverfrog.awportal.common;

/**
 * Created by Serverfrog on 05.06.17.
 */

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
public @interface AwPortal {
}
