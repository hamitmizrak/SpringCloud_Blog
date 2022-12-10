package com.hamitmizrak.zipkinclientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

//eski sürüm kullandım
// http://localhost:9411/zipkin/
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerClientApplication.class, args);
    }
}
