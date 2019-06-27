package com.hateyahighschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;

@SpringBootApplication
@ComponentScan({"com.hateyahighschool"})
public class HateyahighschoolApplication {

	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static";
	public static void main(String[] args) {
		new File(uploadDir).mkdir();
		SpringApplication.run(HateyahighschoolApplication.class, args);
	}

}
