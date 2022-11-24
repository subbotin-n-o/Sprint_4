package ru.yandex.practicum.sprint_4.web;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practicum.sprint_4.pages.AbstractPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static ru.yandex.practicum.sprint_4.web.BrowserName.GOOGLE_CHROME;
import static ru.yandex.practicum.sprint_4.web.BrowserName.MOZILLA_FIREFOX;

public class BaseTest {
    protected static WebDriver driver;

    public static void before() throws IOException {
        getDriver(GOOGLE_CHROME);
    }

    private static void getDriver(BrowserName browserName) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        if (browserName.equals(GOOGLE_CHROME)) {
            driver = new ChromeDriver();
        } else if (browserName.equals(MOZILLA_FIREFOX)) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }
}

enum BrowserName {
    GOOGLE_CHROME,
    MOZILLA_FIREFOX
}