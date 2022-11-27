package ru.yandex.practicum.sprint_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g']")
    private WebElement btnOrderUpper;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement btnOrderLower;

    @FindBy(xpath = ".//button[@id='rcc-confirm-button']")
    private WebElement btnAcceptСookies;

    @FindBy(xpath = ".//div[text()=\"Вопросы о важном\"]")
    private WebElement headerListQuestions;

    private final List<WebElement> btnListQuestions = driver.findElements(By.className("accordion__button"));
    private final List<WebElement> listAnswers = driver.findElements(By.xpath(".//div[@class='accordion__panel']/p"));

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickBtnListQuestions(int btnIndex) {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.elementToBeClickable(btnListQuestions.get(btnIndex)));
        btnListQuestions.get(btnIndex).click();
    }

    public String getTextAnswer(int answerIndex) {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOf(listAnswers.get(answerIndex)));
        return listAnswers.get(answerIndex).getText();
    }

    public void clickBtnOrder(String btnName) {
        if(btnName.equals("Upper")) {
            clickBtnOrderUpper();
        } else if(btnName.equals("Lower")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnOrderLower);
            clickBtnOrderLower();
        }
    }

    private void clickBtnOrderUpper() {
        btnOrderUpper.click();
    }

    private void clickBtnOrderLower() {
        btnOrderLower.click();
    }

    public void clickBtnAcceptСookies() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(btnAcceptСookies));
        btnAcceptСookies.click();
    }

    public void findHeaderListQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", headerListQuestions);
    }
}