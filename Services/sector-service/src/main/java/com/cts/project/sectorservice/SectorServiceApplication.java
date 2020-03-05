package com.cts.project.sectorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.cts.project")
@EnableDiscoveryClient
@EnableFeignClients
public class SectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SectorServiceApplication.class, args);
	}

}
