package com.app.subidaservice;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.subidaservice.service.FileUploadService;

@SpringBootApplication
public class SubidaServiceApplication implements CommandLineRunner{

	@Resource
	FileUploadService fileUploadService;

	public static void main(String[] args) {
		SpringApplication.run(SubidaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileUploadService.deleteDirectory();
		fileUploadService.init();
	}


	

}
