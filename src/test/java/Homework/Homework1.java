package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homework1 {


    @Test
    public void launchAmazon () {

        System.setProperty("webdriver.chrome.driver" , "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

    }














}
