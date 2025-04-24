package com.codewise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
public class CodewiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodewiseApplication.class, args);
    }

}
