package com.acme.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexWeatherDetailedPage {
    private WebDriver driver;

    @FindBy(linkText = "Подробный прогноз на 10 дней") //xpath = "//label[span[a[span[text()='Подробный прогноз на 10 дней']]]]")
    private WebElement detailedWeather;

    public YandexWeatherDetailedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexWeatherDetailedPage detailedWeatherClick() {
        detailedWeather.click();
        return this;
    }

    public WebElement getNightWeather() {
        //Page state design issue
        return driver.findElement(By.xpath("//*[text()='ночью']"));
    }

}
