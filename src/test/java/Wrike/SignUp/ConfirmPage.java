/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrike.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dell
 */
public class ConfirmPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    @FindBy(xpath = "//form[@name='survey-form']")
    private WebElement surveyForm;
    
    @FindBy(xpath = "//button[contains(text(),'Very interested')]")
    private WebElement firstCaseButton;
    
    @FindBy(xpath = "//div[@class='wg-cell wg-cell--md-6 wg-cell--lg-7']//div[2]//label[1]//button[1]")
    private WebElement secondCaseButton;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement thirdCaseButton;

    @FindBy(xpath = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[@class='survey-success']")
    private WebElement surveySuccess;
    
    public boolean checkPage(String correctURL){
        String newPageURL = driver.getCurrentUrl();
        return newPageURL.contains(correctURL);
    }
    
    public void passSurvey(){
        firstCaseButton.click();
        secondCaseButton.click();
        thirdCaseButton.click();
        submitButton.click();
        
        wait.until(ExpectedConditions.visibilityOf(surveySuccess));
    }
    
    public boolean checkSurveySuccess(){
        String surveySuccessAtributes;
        surveySuccessAtributes = surveySuccess.getAttribute("style");
        return surveySuccessAtributes.equals("display: block;");
    }
}
