package com.schoolMicro.school_micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
public class SchoolMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolMicroApplication.class, args);
	}

}
