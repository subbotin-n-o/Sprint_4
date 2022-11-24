package ru.yandex.practicum.sprint_4.web;


import org.junit.*;
import ru.yandex.practicum.sprint_4.pages.MainPage;

import java.io.IOException;

public class QuestionTest extends BaseTest {

    @Before
    public void setup() throws IOException {
        BaseTest.before();
    }

    @Test
    public void clickBtnOrderUpper() {
        MainPage mainPage = new MainPage();
        openURL();
        mainPage.clickBtnOrderUpper();
    }

    public void openURL() {
        driver.get(System.getProperty("site.url"));
    }

    @After
    public void teardown() {
        driver.close();
    }
}