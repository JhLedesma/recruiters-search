package com.jesus.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase {

    @Autowired
    WebDriver driver;

    @Value("${credentials.user}")
    String user;

    @Value("${credentials.pass}")
    String password;

    public void login() throws InterruptedException {

        driver.get("https://www.linkedin.com");

        // Esperar un tiempo para que cargue la página
        Thread.sleep(9000);

        // Encontrar los elementos de usuario y contraseña y enviar los valores
        WebElement usernameInput = driver.findElement(By.id("session_key"));
        WebElement passwordInput = driver.findElement(By.id("session_password"));

        usernameInput.sendKeys(user);
        passwordInput.sendKeys(password);

        // Encontrar el botón de inicio de sesión y hacer clic en él
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
}
