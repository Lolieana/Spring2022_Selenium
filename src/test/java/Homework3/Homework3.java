package Homework3;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework3 {

    // Due date: Fri (Apr 29)

    /**
     * TC-1:  darksky.net
     * Verify correct temperature value is displayed after changing temperature units
     */


    @Test
    public void verifyCorrectTempIsDisplayed () {

        // launch darksky page and get current temp
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        String tempXpath = "//span[@class='summary swap']";
        By tempLocator = By.xpath(tempXpath);
        WebElement currentTemp = MyDriver.getDriver().findElement(tempLocator);
        String currentTempVal =  currentTemp.getText();

        Misc.pause(3);

        // find the locator for the arrow and click it
        String arrowXpath = "(//div[@class='selectric-wrapper selectric-units'])[1]//b";
        By arrowLocator = By.xpath(arrowXpath);
        WebElement arrowFound = MyDriver.getDriver().findElement(arrowLocator);
        arrowFound.click();

        Misc.pause(3);

        // find the locator for C degree and click it
        String celDropdownXpath = "//div[contains(@class,'selectric-open')]//li[contains(text(),'˚C') and contains(text(),'m/s')]";
        By celDropdownLocator = By.xpath(celDropdownXpath);
        WebElement celDropdownFound = MyDriver.getDriver().findElement(celDropdownLocator);
        celDropdownFound.click();

        Misc.pause(3);

        // noe get the temp after change it from F to C and verify its changed
        String tempXpath_2 = "//span[@class='summary swap']";
        By tempLocator_2 = By.xpath(tempXpath_2);
        WebElement currentTemp_2 = MyDriver.getDriver().findElement(tempLocator_2);
        String CurrentTempVal_2 =  currentTemp_2.getText();
        //Assert.assertEquals(currentTemp_2, currentTempVal,"Temp changed");
        Assert.assertFalse(currentTempVal.equals(CurrentTempVal_2), "Temp did not change.");

        //MyDriver.quitWindows();
    }



    /**
     * TC-2: facebook.com
     * Verify current date is selected in the dropdown when user lands on the Create new account form
     */

    @Test
    public void verifyCurrentDateIsSelected () {

        // launch facebook page and get the locator for creat new account and click it
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        String createNewAccountXpath = "//a[text()='Create new account']";
        By createAccountLocator = By.xpath(createNewAccountXpath);
        WebElement createAccountButton = MyDriver.getDriver().findElement(createAccountLocator);
        createAccountButton.click();

        Misc.pause(3);

        // get the locator for the current month using select class
        String currentMonth = ("//select[@id='month']");
        By currentMonthLocator = By.xpath(currentMonth);
        WebElement currentMonthFound = MyDriver.getDriver().findElement(currentMonthLocator);
        Select currMonth = new Select(currentMonthFound);
        String selectedMonth= currMonth.getFirstSelectedOption().getText();

        Misc.pause(2);

        // get the locator for the current day using select class
        String currentDay = ("//select[@id='day']");
        By currentDayLocator = By.xpath(currentDay);
        WebElement currentDayFound = MyDriver.getDriver().findElement(currentDayLocator);
        Select currDay = new Select(currentDayFound);
        String selectedDay= currDay.getFirstSelectedOption().getText();

        Misc.pause(2);

        // get the locator for the current year using select class
        String currentYear = ("//select[@id='year']");
        By currentYearLocator = By.xpath(currentYear);
        WebElement currentYearFound = MyDriver.getDriver().findElement(currentYearLocator);
        Select currYear = new Select(currentYearFound);
        String selectedYear= currYear.getFirstSelectedOption().getText();
        String currentDate = selectedMonth + "/" + selectedDay + "/" + selectedYear;

        Misc.pause(2);

        // get the current date using date class and verify both dates are equals
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("MMM/dd/yyyy");
        String date_2 = date.format(now);

        Assert.assertEquals(currentDate,date_2,"Current date is not selected.");
    }



    /**
     * TC-3: https://classroomessentialsonline.com/
     * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
     */

    @Test
    public void verifyUserLandsOnRightPage () {

        // launch the page and get the locator for church chairs and mouse hover it by using a method from action class
        MyDriver.launchUrlOnNewWindow("https://classroomessentialsonline.com/");

        String churchChairsXpath = "//a[@href='/church-chairs/']";
        By churchChairsLocator = By.xpath(churchChairsXpath);
        WebElement churchChairsButton = MyDriver.getDriver().findElement(churchChairsLocator);

        Actions action = new Actions(MyDriver.getDriver());
        action.moveToElement(churchChairsButton).build().perform();

        Misc.pause(3);

        // find the locator for economy church chairs
        String chairsTypeXpath = "//a[@href='/economy-church-chairs/']";
        By chairsTypeLocator = By.xpath(chairsTypeXpath);
        WebElement chairsTypeFound = MyDriver.getDriver().findElement(chairsTypeLocator);

        // get the url before click the link
        String expectedURL = chairsTypeFound.getAttribute("href");

        chairsTypeFound.click();

        // get the current url and compare both if they are same or not
        String actualURL = MyDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"User landed on different page");
        Misc.pause(3);

        //MyDriver.quitWindows();
    }

}
