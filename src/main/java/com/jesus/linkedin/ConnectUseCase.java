package com.jesus.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ConnectUseCase {

    @Autowired
    WebDriver driver;

    @Value("${search.url}")
    String searchUrl;

    @Value("${search.key-title-word}")
    String keyTitleWord;

    @Value("${search.page.first}")
    Integer firstPage;

    @Value("${search.page.last}")
    Integer lastPage;

    public void connect() {
        IntStream.rangeClosed(firstPage, lastPage).forEach(page -> {
            try {
                connectForPage(page);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void connectForPage(int page) throws InterruptedException {
        // Abrir la página de búsqueda de personas en LinkedIn
        //String url = "https://www.linkedin.com/search/results/people/?geoUrn=%5B%22100446943%22%5D&origin=FACETED_SEARCH&profileLanguage=%5B%22es%22%5D&sid=7YP&titleFreeText=IT%20recruiter&page=" + page;
        driver.get(getUrl(page));

        Thread.sleep(2500);
        List<WebElement> allButtons = driver.findElements(By.tagName("button"));
        List<WebElement> connectButtons = allButtons.stream().filter(btn -> btn.getText().equals("Conectar") || btn.getText().equals("Seguir")).collect(Collectors.toList());

        for (WebElement btn : connectButtons) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            Thread.sleep(1500);
            if (btn.getText().equals("Conectar")) {
                WebElement send = driver.findElement(By.xpath("//button[@aria-label='Enviar ahora']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", send);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", send);
//				WebElement close = driver.findElement(By.xpath("//button[@aria-label='Dismiss']"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
            }
            Thread.sleep(1500);
        }
    }

    private String getUrl(int page) {
        return new StringBuilder(searchUrl)
                .append("&titleFreeText=")
                .append(keyTitleWord.replace(" ", "%20"))
                .append("&")
                .append("&page=")
                .append(page)
                .toString();
    }
}
