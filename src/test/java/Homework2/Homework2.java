package Homework2;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework2 {

    // Due date: Apr-28

    /**
     * Testcase-1:
     *
     *
     * Verify "Keep me signed in" is NOT selected for messenger login page
     *
     * Click "Log in" button
     *
     * Verify "Incorrect email or phone number" is displayed
     *
     * Verify "Continue" button is enabled
     *
     *
     */

    // launch facebook page
    // find locator for messenger and then click it
    @Test
    public void verifyMessengerLoginPage () {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        String messengerXpath = "//a[text() = 'Messenger']";
        By messengerLocator = By.xpath(messengerXpath);
        WebElement messengerLink = MyDriver.getDriver().findElement(messengerLocator);
        messengerLink.click();

        Misc.pause(3);

        // find locator for keep me signed and verify its not selected
        String keepMeSignedInXpath = "//input[@type='checkbox']";
        By keepMeSignedInLocator = By.xpath(keepMeSignedInXpath);
        WebElement keepMeSignedInBox = MyDriver.getDriver().findElement(keepMeSignedInLocator);
        boolean isKeepMeSignedInNotSelected = keepMeSignedInBox.isSelected();
        Assert.assertFalse(isKeepMeSignedInNotSelected,"Yes is selected");

        Misc.pause(3);

         // had to find the locator for the banner and close it because was causing the testcase to fail
        String closeBanner = "//div[@id='close']";
        By closeBannerLocator = By.xpath(closeBanner);
        WebElement closeBanner_C = MyDriver.getDriver().findElement(closeBannerLocator);
        closeBanner_C.click();

        Misc.pause(3);

        // find locator for login button and then click it
        String logInXpath = "//button[text()='Log in']";
        By logInLocator = By.xpath(logInXpath);
        WebElement logInFound = MyDriver.getDriver().findElement(logInLocator);
        logInFound.click();

        Misc.pause(3);

        // find locator for the text and check if its displayed
        String verifyTextXpath = "//div[contains(text(),'Incorrect email')]";
        By verifyTextLocator = By.xpath(verifyTextXpath);
        WebElement verifyText = MyDriver.getDriver().findElement(verifyTextLocator);
        boolean isTextDisplayed = verifyText.isDisplayed();
        Assert.assertTrue(isTextDisplayed,"No is not displayed.");

        Misc.pause(3);

        // get continue button locator and verify its enabled
        String continueXpath = "//button[text()='Continue']";
        By continueLocator = By.xpath(continueXpath);
        WebElement continueButton = MyDriver.getDriver().findElement(continueLocator);
        boolean isContinueButtonEnabled = continueButton.isEnabled();
        Assert.assertTrue(isContinueButtonEnabled,"No is not enabled.");
    }


    /**
     * Testcase-2:
     * On Create new account page:
     *
     * Verify the "Sign Up" button is enabled when user lands on the form
     *
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     *
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     *
     */

      // launch facebook page
     // find locator for creat new account and then click it
    @Test
    public void verifySignUpIsEnabled () {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        String createNewAccountXpath = "//a[text()='Create new account']";
        By createAccountLocator = By.xpath(createNewAccountXpath);
        WebElement createAccountButton = MyDriver.getDriver().findElement(createAccountLocator);
        createAccountButton.click();

        Misc.pause(5);

        // get the locator for first name box and type name
        String firstNameXpath = "//input[@placeholder='First name']";
        By firstNameLocator = By.xpath(firstNameXpath);
        WebElement firstNameBox = MyDriver.getDriver().findElement(firstNameLocator);
        firstNameBox.sendKeys("joy");

        Misc.pause(3);

        // get the locator for last name box and type name
        String lastNameXpath = "//input[@name='lastname']";
        By lastNameLocator = By.xpath(lastNameXpath);
        WebElement lastNameBox = MyDriver.getDriver().findElement(lastNameLocator);
        lastNameBox.sendKeys("happy");

        Misc.pause(3);

         // get the locator for email box and type
        String emailXpath = "//input[@aria-label='Mobile number or email']";
        By emailLocator = By.xpath(emailXpath);
        WebElement emailBox = MyDriver.getDriver().findElement(emailLocator);
        emailBox.sendKeys("jhjh@test.com");

        Misc.pause(3);

        // get the locator for re-enter email box and type
        String re_EnteremailXpath = "//input[@aria-label='Re-enter email']";
        By re_EnteremailLocator = By.xpath(re_EnteremailXpath);
        WebElement re_EnteremailBox = MyDriver.getDriver().findElement(re_EnteremailLocator);
        re_EnteremailBox.sendKeys("jhjh@test.com");

        Misc.pause(3);

        // get the locator for password box and type
        String passwordXpath = "//input[@id='password_step_input']";
        By passwordLocator = By.xpath(passwordXpath);
        WebElement passwordBox = MyDriver.getDriver().findElement(passwordLocator);
        passwordBox.sendKeys("12345");

        Misc.pause(3);

        // get the locator for sign up button and click it
        String signUpXpath = "//button[@name='websubmit']";
        By signUpLocator = By.xpath(signUpXpath);
        WebElement signUpButton = MyDriver.getDriver().findElement(signUpLocator);
        signUpButton.click();

        Misc.pause(3);

        // get the locator for "Please choose a gender. You can change who can see this later." text and verify its displayed
        String chooseGenderXpath = "//div[contains(text(),'choose a gender.')]";
        By chooseGenderLocator = By.xpath(chooseGenderXpath);
        WebElement chooseGenderText = MyDriver.getDriver().findElement(chooseGenderLocator);
        boolean isChooseGenderDisplayed = chooseGenderText.isDisplayed();
        Assert.assertTrue(isChooseGenderDisplayed,"No is not displayed.");

    }














}
