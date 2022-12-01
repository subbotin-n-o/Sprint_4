package ru.yandex.practicum.sprint_4.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.sprint_4.pages.MainPage;
import ru.yandex.practicum.sprint_4.pages.OrderPage;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String deliveryAdress;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String scooterColor;
    private final String commentCourier;
    private final String btnChoice;


    public OrderTest(String name, String surname, String deliveryAdress,
                     String metroStation, String phoneNumber, String deliveryDate,
                     String rentalPeriod, String scooterColor, String commentCourier, String btnChoice) {
        this.name = name;
        this.surname = surname;
        this.deliveryAdress = deliveryAdress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.commentCourier = commentCourier;
        this.btnChoice = btnChoice;
    }

    @Before
    public void setup() throws IOException {
        BaseTest.before();
    }

    @Test
    public void orderCompletedSuccessfullyTest() {
        MainPage mainPage = new MainPage();
        OrderPage orderPage = new OrderPage();

        mainPage.clickBtnAcceptСookies();
        mainPage.clickBtnOrder(btnChoice);

        orderPage.enterUserName(name, surname);
        orderPage.enterDeliveryAddres(deliveryAdress);
        orderPage.enterMetroStation(metroStation);
        orderPage.enterPhoneNUmber(phoneNumber);
        orderPage.clickBtnNext();
        orderPage.enterDeliveryDate(deliveryDate);
        orderPage.enterDropRentalPeriod(rentalPeriod);
        orderPage.setScooterColor(scooterColor);
        orderPage.enterCommentCourier(commentCourier);
        orderPage.clickBtnOrder();
        orderPage.clickBtnYes();

        String expectedText = "Заказ оформлен";
        String actualText = orderPage.getTextOrderProcessed();

        assertTrue(String.format("The success message should contain '%s'", expectedText), actualText.contains(expectedText));
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][] {
                {"Иван", "Иванов", "Можга, ул. Мира, д. 1", "Черкизовская",
                        "+73412777777", "27-е ноября 2022 г.", "сутки", "чёрный жемчуг", "Хорошего дня!!!", "Upper"},
                {"Петр", "Петров", "Казань, ул. Дружбы, д. 2", "Сокольники",
                        "+73412666666", "28-е ноября 2022 г.", "двое суток", "серая безысходность", "Всего хорошего!!!", "Lower"},
        };
    }

    @After
    public void teardown() {
        driver.close();
    }
}