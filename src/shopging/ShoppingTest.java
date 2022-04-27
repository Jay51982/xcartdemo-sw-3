package shopging;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));

//        1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverClick(By.xpath("//li[@class='leaf has-sub']//li[2]//a[1]"));

//        1.3 Verify the text “Bestsellers”
        String expectedText = "Bestsellers";
        String acutalText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link", expectedText, acutalText);

//        1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverClick(By.xpath(("//span[@class='sort-by-label']")));
        mouseHoverClick(By.xpath(("//a[normalize-space()='Name A - Z']")));

//        1.5 Click on “Add to cart” button of the product “IPhone SE”

        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//img[contains(@alt,'iPhone 5S')]"));
        clickOnElement(By.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]"));

//        1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedCartMsg = "Product has been added to your cart";
        Thread.sleep(3000);
        String actualCartMsg = getTextFromElement(By.xpath("//li[@class='info']"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Product has not been added to the cart", expectedCartMsg, actualCartMsg);

//        1.7 Click on X sign to close the message
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[@title='Close']"));

//        1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));


//        1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(3000);
        String expectedCartMsg1 = "Your shopping cart - 1 item";
        String actualCartMsg1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Text:'Your shopping cart - 1 item'", expectedCartMsg1, actualCartMsg1);

//        1.10 Verify the Subtotal $299.00
        Thread.sleep(3000);
        String expectedSubTotal = "$299.00";
        String actualSubTotal = getTextFromElement(By.xpath("//ul[@class='sums']/li/span"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Subtotal is not correct.", expectedSubTotal, actualSubTotal);


//        1.11 Verify the total $106.23
        Thread.sleep(3000);
        String expectedTotal = "$309.73";
        String actualTotal = getTextFromElement(By.xpath("//li[@class='total']/span/span[1]"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Subtotal is not correct.", expectedTotal, actualTotal);


//        1.12 Click on “Go to checkout” button
        mouseHoverClick(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));

//        1.13 Verify the text “Log in to your account”
        Thread.sleep(3000);
        String expectedLoginMessage = "Log in to your account";
        String actualLoginMessage = getTextFromElement(By.xpath("//h3[normalize-space()='Log in to your account']"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Subtotal is not correct.", expectedLoginMessage, actualLoginMessage);

//        1.14 Enter Email address
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='email']"), "abc@gmail.com");

//        1.15 Click on “Continue” Button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));

//        1.16 Verify the text “Secure Checkout”
        Thread.sleep(3000);
        String expectedCheckOutMessage = "Secure Checkout";
        String actualCheckOutMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("Subtotal is not correct.", expectedCheckOutMessage, actualCheckOutMessage);

//        1.17 Fill all the mandatory fields
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Dhirubhai");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Ambani");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "Antalia");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "London");
        sendTextToElement(By.xpath("//select[@id='shippingaddress-country-code']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Westminster");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "W1 2DN");

//        1.18 Check the check box “Create an account for later use”
        Thread.sleep(2000);
        //  clickOnElement(By.xpath("input[@id='create_profile']"));
        //clickOnElement(By.xpath(("//a[@class='sign-in log-in']")));

//        1.19 Enter the password
//        1.20 Select the Delivery Method to “Local Shipping”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='method128']"));

//        1.21 Select Payment Method “COD”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='pmethod6']"));

//        1.22 Verify the total $311.03.00
        Thread.sleep(1000);
        String expectedTotalMessage = "$311.03";
//        String actualTotalMessage = getTextFromElement(By.xpath("//div[@class='total clearfix']//span[@class='part-prefix'][normalize-space()='$']"));
//        Assert.assertEquals("Subtotal is not correct.",expectedTotalMessage,actualTotalMessage);

//        1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//span[normalize-space()='Place order: $311.03']"));

//        1.24 Verify the text “Thank you for your order”
        Thread.sleep(1000);
        String expectedOrderConfirmMessage = "Thank you for your order";
        String actualOrderConfirmMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Subtotal is not correct.", expectedOrderConfirmMessage, actualOrderConfirmMessage);
    }


    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

//1.1 Mouse hover on the “Hot deals” link
        Thread.sleep(2000);
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));

//1.2 Mouse hover on the “Bestseller”  link and click
        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//li[@class='leaf has-sub']//li[2]//a[1]"));

//1.3 Verify the text “Bestsellers”
        Thread.sleep(2000);
        String expectedText = "Bestsellers";
        String acutalText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link", expectedText, acutalText);

//1.4 Mouse hover on “Sort By” and select “Name A-Z”
        Thread.sleep(2000);
        mouseHoverClick(By.xpath(("//span[@class='sort-by-label']")));
        mouseHoverClick(By.xpath(("//a[normalize-space()='Name A - Z']")));

//1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”

        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]"));

//1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedCartMsg = "Product has been added to your cart";
        Thread.sleep(2000);
        String actualCartMsg = getTextFromElement(By.xpath("//li[@class='info']"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Product has not been added to the cart", expectedCartMsg, actualCartMsg);

//1.7 Click on X sign to close the message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@title='Close']"));


//1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));

//1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(2000);
        String expectedCartMsg1 = "Your shopping cart - 1 item";
        String actualCartMsg1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));   ////li[contains(@class,'info')]
        Assert.assertEquals("Text:'Your shopping cart - 1 item'", expectedCartMsg1, actualCartMsg1);

//1.10 Click on “Empty your cart” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='clear-bag']"));

//1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        Thread.sleep(2000);
        switchToAlert();
        String expectedAlertMsg = "Are you sure you want to clear your cart?";
        String actualAlertMsg = getTextAlert();
        Assert.assertEquals("Text:'Your shopping cart - 1 item'", expectedAlertMsg, actualAlertMsg);

//1.12 Click “Ok” on alert
        Thread.sleep(1000);
        acceptAlert();

//1.13 Verify the message “Item(s) deleted from your cart”
        Thread.sleep(2000);
        String expectedCartMsg2 = "Item(s) deleted from your cart";
        String actualCartMsg2 = getTextFromElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Product has not been added to the cart",expectedCartMsg2,actualCartMsg2);

        //1.15 Verify the text “Your cart is empty”
        Thread.sleep(2000);
        String expectedCartText = "Your cart is empty";
        String actualCartText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}