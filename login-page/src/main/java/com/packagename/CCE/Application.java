package com.packagename.CCE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.util.HashMap;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    static HashMap<String, User> userArray = new HashMap<String, User>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
