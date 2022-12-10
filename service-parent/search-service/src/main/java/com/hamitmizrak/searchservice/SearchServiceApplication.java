package com.hamitmizrak.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableEurekaClient
public class SearchServiceApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}

}
