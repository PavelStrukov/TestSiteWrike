/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrike.SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.forWrike.GenerateText;

/**
 *
 * @author Dell
 */
public class SignUpPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    @FindBy(xpath = "//div[@class='r']//button[@class='wg-header__free-trial-button wg-btn wg-btn--green'][contains(text(),'Get started')]")
    private WebElement getStartedButton;
    
    @FindBy(xpath = "//label[@class='modal-form-trial__label']//input[@placeholder='Enter your business email']")
    private WebElement businessEmailField;
    
    @FindBy(xpath = "//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']")
    private WebElement businessEmailConfirm;

    @FindBy(xpath = "//body[contains(@class,'siteorigin-panels-home')]/"
            + "div[contains(@class,'wg-layout wg-layout--outline')]/div[contains(@class,'wg-footer')]/div[contains(@class,'wg-footer__bottom-section')]/"
            + "div[contains(@class,'wg-footer__bottom-section-wrapper')]/div[contains(@class,'wg-footer__social-block')]/"
            + "div[contains(@class,'wg-footer__group wg-footer__group--social')]/ul[contains(@class,'wg-footer__social-list')]/li[1]/a[1]/*[1]")
    private WebElement twitterButton;
    
    @FindBy(xpath = "//div[contains(@class,'wg-footer__social-block')]//li[1]//a[1]/*[name()='svg']/*[name()='use']")
    private WebElement twitterIcon;
    
    public void open(){
        driver.get("https://www.wrike.com/");
    }
    
    public void getStarted(){
        getStartedButton.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//form[@class='wg-form modal-form-trial__form js-signup-modal bf_form_init']")));
    }
    
    public void setAndConfirmEmail(){
        String email = GenerateText.generateEmail();
        
        businessEmailField.sendKeys(email);
        
        businessEmailConfirm.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='survey-form']")));
    }
    
    public boolean checkTwitterLink(){
        
        twitterButton.click();
        
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab); 
            }       
        }
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"signin-link\"]")));
        
        return driver.getCurrentUrl().equals("https://twitter.com/wrike");
    }
    
    public boolean checkTwitterIcon(){
        
        String iconPath = twitterIcon.getAttribute("xlink:href");
        
        return iconPath.equals("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter");
    }
    
}
