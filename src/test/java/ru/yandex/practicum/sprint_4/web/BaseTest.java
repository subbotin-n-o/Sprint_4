package ru.yandex.practicum.sprint_4.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practicum.sprint_4.pages.AbstractPage;

import java.io.IOException;
import java.time.Duration;

import static ru.yandex.practicum.sprint_4.web.BrowserName.GOOGLE_CHROME;
import static ru.yandex.practicum.sprint_4.web.BrowserName.MOZILLA_FIREFOX;

public class BaseTest {
    protected static WebDriver driver;

    public static void before() throws IOException {
        setup(MOZILLA_FIREFOX);
        openUrl();
    }

    private static void setup(BrowserName browserName) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));

        if (browserName.equals(GOOGLE_CHROME)) {
            driver = new ChromeDriver();
        } else if (browserName.equals(MOZILLA_FIREFOX)) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        AbstractPage.setDriver(driver);
    }

    private static void openUrl() {
        driver.get(System.getProperty("site.url"));
    }
}

enum BrowserName {
    GOOGLE_CHROME,
    MOZILLA_FIREFOX
}