package com.slaughterhouse.firststation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StationStartupRunner implements CommandLineRunner {

    @Value("${grpc.server.port}")
    private int serverPort;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("First Station Service is up and running on a port: " + serverPort);
    }
}
