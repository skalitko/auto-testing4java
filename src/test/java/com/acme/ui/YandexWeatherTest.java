package com.acme.ui;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.fest.assertions.api.Assertions.assertThat;


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
        YandexWeatherPage weatherPage = new YandexWeatherPage(driver);
        YandexWeatherDetailedPage weatherDetailedPage = weatherPage
                .clickOnWeatherLink();

        WebElement nightWeather = weatherDetailedPage
                .detailedWeatherClick()
                .getNightWeather();

        assertThat(nightWeather.getText()).contains("Ночью");
    }
}
