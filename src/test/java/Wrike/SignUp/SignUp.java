/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrike.SignUp;

import Wrike.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Dell
 */
public class SignUp extends WebDriverSettings {

    @Test
    public void signUp() {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.open();

        signUpPage.getStarted();

        signUpPage.setAndConfirmEmail();

        ConfirmPage confirmPage = PageFactory.initElements(driver, ConfirmPage.class);

        Assert.assertTrue(confirmPage.checkPage("https://www.wrike.com/resend"));

    }
    
    @Test
    public void surveyPassing(){
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.open();

        signUpPage.getStarted();

        signUpPage.setAndConfirmEmail();

        ConfirmPage confirmPage = PageFactory.initElements(driver, ConfirmPage.class);
        
        confirmPage.passSurvey();
        
        Assert.assertTrue(confirmPage.checkSurveySuccess());
    }
    
    @Test
    public void checkTwitter(){
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.open();
        
        boolean containsIcon = signUpPage.checkTwitterIcon();
        
        boolean checkTwitterLink = signUpPage.checkTwitterLink();
        
        Assert.assertTrue(containsIcon && checkTwitterLink);
    }
}
