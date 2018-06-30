package com.betterjavacode.reusablesociallogin;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;


@PropertySources({ @PropertySource(value = "classpath:application.properties") })
@SpringBootApplication
public class ReusablesocialloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReusablesocialloginApplication.class, args);
	}
}
