package com.magento.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magento.util.BasePage;

public class CreateOrderPage extends BasePage {

    By optionWomen_link = By.xpath("//a[contains(.,'Women')]");
    By optionWomenTops_link = By.xpath("//a[@id='ui-id-9']");
    By optionJackets_link = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]");
    By junoJacket = By.xpath("//img[contains(@alt,'Juno Jacket')]");
    By addJunoJacket = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[2]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]");
    By selectSizeJunoJacket = By.xpath("//div[@class='swatch-option text'][contains(.,'XS')]");
    By selectColorJunoJacket = By.xpath("//div[contains(@option-label,'Blue')]");
    By addtocartproduct = By.xpath("//button[@id='product-addtocart-button']");
    By messageProductAddedtoShoppingCart = By.xpath("//body/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]");
    By shoppingCart = By.xpath("//header/div[2]/div[1]/a[1]");
    By chaeckout_button = By.xpath("//button[@id='top-cart-btn-checkout']");
    String urlOrderDetails = "https://demo.nopcommerce.com/checkout/completed";
    By messageOrderSuccessfully = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
    By firsName = By.xpath("//input[@class='input-text' and @name='firstname']");
    By lastName = By.xpath("//input[@class='input-text' and @name='lastname']");
    By company = By.xpath("//input[@class='input-text' and @name='company']");
    By country = By.xpath("//select[@class='select' and @name='country_id']");
    By state = By.xpath("//select[@class='select' and @name='region_id']");
    By city = By.xpath("//input[@class='input-text' and @name='city']");
    By address1 = By.xpath("//input[@class='input-text' and @name='street[0]']");
    By address2 = By.xpath("//input[@class='input-text' and @name='street[1]']");
    By address3 = By.xpath("//input[@class='input-text' and @name='street[2]']");
    By zip = By.xpath("//input[@class='input-text' and @name='postcode']");
    By phone = By.xpath("//input[@class='input-text' and @name='telephone']");
    By shippingMethod = By.xpath("//input[@class='radio' and @name='ko_unique_3']");
    By acceptPlaceOrder = By.xpath("//button[@class='action primary checkout'][contains(.,'Place Order')]");
    By orderFinish = By.xpath("//span[@class='base'][contains(.,'Thank you for your purchase!')]");


    By Next = By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]");


    public CreateOrderPage(WebDriver driver2) {
        super(driver2);
    }

    public CreateOrderPage(WebDriver driver2, int timeoutSec) {
        this(driver2);
        setTimeoutSec(timeoutSec);
    }

    public void chooseProduct() throws InterruptedException {
        mouseOver(optionWomen_link);
        mouseOver(optionWomenTops_link);
        click(optionJackets_link);
        mouseOver(junoJacket);
        click(addJunoJacket);
        Thread.sleep(3000);
        click(selectSizeJunoJacket);
        click(selectColorJunoJacket);
        submit(addtocartproduct);
        Thread.sleep(3000);
    }

    public void makePurchase() throws InterruptedException {
        Thread.sleep(2000);
        isDisplayed(shoppingCart);
        click(shoppingCart);
        click(chaeckout_button);
        isDisplayed(firsName);
        type(firsName, "carla anahi");
        type(lastName, "arevilca vasquez");
        type(company, "undercontrol");
        type(address1, "abasto");
        type(address2, "santa rosita");
        type(address3, "los mangales");
        type(city, "Santa Cruz");
        Select sel_state = new Select(find(state));
        sel_state.selectByValue("5");
        type(zip, "+591");
        Select sel_country = new Select(find(country));
        sel_country.selectByValue("BO");
        type(phone, "74630525");
        click(shippingMethod);
        click(Next);
        Thread.sleep(5000);
        isDisplayed(acceptPlaceOrder);
        click(acceptPlaceOrder);
        Thread.sleep(2000);
    }

    public String successfullyOrder() {
        WebElement message = find(orderFinish);
        return message.getText();
    }


}
