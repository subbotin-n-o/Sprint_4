package ru.yandex.practicum.sprint_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g']")
    private WebElement btnOrderUpper;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement btnOrderLower;

    List<WebElement> listQuestions = driver.findElements(By.className("accordion__button"));
    List<WebElement> listAnswers = driver.findElements(By.className("accordion__panel"));

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickBtnOrderUpper() {
        btnOrderUpper.click();
    }

    public void clickBtnOrderLower() {
        btnOrderLower.click();
    }

    public void clickListQuestions() {
        for (WebElement e : listQuestions) {
            e.click();
        }
    }

    public void getTextListAnswer() {
        for (WebElement e : listAnswers) {
            e.getText();
        }
    }
}