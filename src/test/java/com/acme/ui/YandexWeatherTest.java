package com.acme.ui;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


public class YandexWeatherTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
//        System.setProperty("wdm.phantomjsDriverVersion", "2.1.1");
//        PhantomJsDriverManager.getInstance().setup();
    }

    @Before
    public void setUpBasePage() {
        driver = new ChromeDriver();
//        driver = new PhantomJSDriver();
        driver.get("http://yandex.ru");
    }

    @After
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldGetWeatherForMoscow() throws InterruptedException {
        WebElement weatherLink = driver.findElement(By.linkText("Погода"));
        weatherLink.click();
        WebElement detailedWeather = driver.findElement(By.xpath("//label[span[a[span[text()='подробно']]]]"));
        detailedWeather.click();
        driver.findElement(By.xpath("//*[text()='ночью']"));
    }
}
