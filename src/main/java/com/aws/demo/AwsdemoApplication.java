package com.aws.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.utils.SystemSetting;

@SpringBootApplication
public class AwsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsdemoApplication.class, args);
	}

}
