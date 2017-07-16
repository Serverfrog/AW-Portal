package de.serverfrog.awportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.tools.jar.CommandLine;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner{



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    }
}
