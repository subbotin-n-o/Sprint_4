package ru.yandex.practicum.sprint_4.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.sprint_4.pages.MainPage;
import ru.yandex.practicum.sprint_4.pages.OrderPage;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

//@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

//    private final String name;
//    private final String surname;
//    private final String deliveryAdress;
//    private final String metroStation;
//    private final String phoneNumber;

//    public OrderTest(String name, String surname, String deliveryAdress, String metroStation, String phoneAdress) {
//        this.name = name;
//        this.surname = surname;
//        this.deliveryAdress = deliveryAdress;
//        this.metroStation = metroStation;
//        this.phoneNumber = phoneAdress;
//    }



    @Before
    public void setup() throws IOException {
        BaseTest.before();
    }

    @Test
    public void orderSubmissionPathTest() {
        MainPage mainPage = new MainPage();
        OrderPage orderPage = new OrderPage();
        mainPage.clickBtnAcceptСookies();
        mainPage.clickBtnOrderUpper();

        orderPage.enterName("Иван");
        orderPage.enterSurname("Иванов");
        orderPage.enterDeliveryAddres("Можга, ул. Мира, д. 1");
        orderPage.enterMetroStation("Черкизовская");
        orderPage.enterPhoneNUmber("+72412666666");
        orderPage.clickBtnNext();
        orderPage.setDropDeliveryDate("27-е ноября 2022 г.");
        orderPage.setDropRentalPeriod("сутки");
        orderPage.setScooterColor("чёрный жемчуг");
        orderPage.setCommentCourier("Хорошего дня!!!");
        orderPage.clickBtnOrder();
        orderPage.clickBtnYesOrNot("Да");

        String actualText = orderPage.getTextOrderProcessed();
        String expectedText = "Заказ оформлен";

        assertTrue(expectedText, actualText.contains(expectedText));

    }

//    @Parameterized.Parameters
//    public static Object[][] getUserData() {
//        return new Object[][] {
//                {"Никита", "Субботин", "Ижевск, ул. Мира, д. 1, кв. 1", "Черкизовская", "+73412777777"},
//        };
//    }

    @After
    public void teardown() {
        driver.close();
    }
}