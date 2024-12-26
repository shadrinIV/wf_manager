package com.shadrin.wf_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WfManagerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "wfmanager-application");
		SpringApplication.run(WfManagerApplication.class, args);
	}

}
