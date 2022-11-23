package com.app.subidaservice;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.app.subidaservice.service.FileUploadService;

@EnableEurekaClient
@SpringBootApplication
public class SubidaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubidaServiceApplication.class, args);
	}

}

// @SpringBootApplication
// public class SubidaServiceApplication implements CommandLineRunner{

// @Resource
// FileUploadService fileUploadService;

// public static void main(String[] args) {
// SpringApplication.run(SubidaServiceApplication.class, args);
// }

// @Override
// public void run(String... args) throws Exception {
// fileUploadService.deleteDirectory();
// fileUploadService.init();
// }
// }
