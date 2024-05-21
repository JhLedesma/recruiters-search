package com.jesus.linkedin;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class LinkedinApplicationTests {

	@Autowired
	LinkedinService linkedinService;

	@Test
	void shouldConnectSuccessful() throws InterruptedException {
		linkedinService.connect();
	}
}
