package com.magento.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.magento.util.BasePage;

public class HomePage extends BasePage {


    //get all elements
    //By login_link = By.linkText("Sign");
    By login_link = By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]");
    By register_link = By.linkText("Create an Account");
   // By myAccount_link = By.linkText("My account");
  //  By Addresses_link = By.linkText("Addresses");
 //   By ChangePassword_link = By.linkText("Change password");



    String base_URL = "https://magento.softwaretestingboard.com/";

    //constructor

    public HomePage(WebDriver driver) {
        super(driver);
        loadUrl(base_URL);
    }

    public HomePage(WebDriver driver, int timeoutSec) {
        this(driver);
        setTimeoutSec(timeoutSec);
    }

    public void goToRegister() {
        click(register_link);
    }

    public void goToLogin() {
        click(login_link);
    }


    /*public void goNewAddresses() {
        click(myAccount_link);
        click(Addresses_link);
    }

    public void goChangePassword() {
        click(myAccount_link);
        click(ChangePassword_link);
    }*/

}