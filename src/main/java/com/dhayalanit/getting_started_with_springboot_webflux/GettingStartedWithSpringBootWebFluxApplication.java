package com.dhayalanit.getting_started_with_springboot_webflux;

import com.dhayalanit.getting_started_with_springboot_webflux.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GettingStartedWithSpringBootWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(GettingStartedWithSpringBootWebFluxApplication.class, args);
        Client client = new Client();
        client.check();
    }

}
