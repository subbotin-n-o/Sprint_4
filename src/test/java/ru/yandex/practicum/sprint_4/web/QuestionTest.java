package ru.yandex.practicum.sprint_4.web;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.sprint_4.pages.MainPage;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuestionTest extends BaseTest {

    private static final String missing = "The text does not match the condition";
    private static final List<String> textAnswerExpected = Arrays.asList(
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

    @Before
    public void setup() throws IOException {
        BaseTest.before();
    }

    @Test
    public void a_textAnswerOneTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(0);

        String textAnswerActual = mainPage.getTextAnswer(0);

        assertEquals(missing, textAnswerExpected.get(0), textAnswerActual);
    }

    @Test
    public void b_textAnswerTwoTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(1);

        String textAnswerActual = mainPage.getTextAnswer(1);

        assertEquals(missing, textAnswerExpected.get(1), textAnswerActual);
    }

    @Test
    public void c_textAnswerThreeTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(2);

        String textAnswerActual = mainPage.getTextAnswer(2);

        assertEquals(missing, textAnswerExpected.get(2), textAnswerActual);
    }

    @Test
    public void d_textAnswerFourTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(3);

        String textAnswerActual = mainPage.getTextAnswer(3);

        assertEquals(missing, textAnswerExpected.get(3), textAnswerActual);
    }

    @Test
    public void e_textAnswerFiveTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(4);

        String textAnswerActual = mainPage.getTextAnswer(4);

        assertEquals(missing, textAnswerExpected.get(4), textAnswerActual);
    }

    @Test
    public void f_textAnswerSixTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(5);

        String textAnswerActual = mainPage.getTextAnswer(5);

        assertEquals(missing, textAnswerExpected.get(5), textAnswerActual);
    }

    @Test
    public void g_textAnswerSevenTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(6);

        String textAnswerActual = mainPage.getTextAnswer(6);

        assertEquals(missing, textAnswerExpected.get(6), textAnswerActual);
    }

    @Test
    public void h_textAnswerEightTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.findHeaderListQuestions();
        mainPage.clickBtnListQuestions(7);

        String textAnswerActual = mainPage.getTextAnswer(7);

        assertEquals(missing, textAnswerExpected.get(7), textAnswerActual);
    }

    @After
    public void teardown() {
        driver.close();
    }
}