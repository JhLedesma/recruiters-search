package com.jesus.linkedin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@SpringBootApplication
public class LinkedinApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinApplication.class, args);
	}

	@Bean
	public WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
}
