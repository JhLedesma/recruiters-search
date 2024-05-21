package com.jesus.linkedin;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkedinService {

    WebDriver driver;
    LoginUseCase loginUseCase;
    ConnectUseCase connectUseCase;

    @Autowired
    public LinkedinService(WebDriver driver, LoginUseCase loginUseCase, ConnectUseCase connectUseCase) {
        this.driver = driver;
        this.loginUseCase = loginUseCase;
        this.connectUseCase = connectUseCase;
    }

    public void connect() throws InterruptedException {
        loginUseCase.login();
        connectUseCase.connect();
        driver.quit();
    }
}
