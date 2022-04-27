package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDeals extends Utility {

String baseUrl = "https://mobile.x-cart.com/";

@Before
    public void setUp(){
    openBrowser(baseUrl);
}

@Test   // 1
public void verifySaleProductsArrangeAlphabetically() throws InterruptedException
{
    // Mouse hover on the “Hot deals” link
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

    //Mouse hover on the “Sale”  link and click
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
    clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));

    //Verify the text “Sale”
    String expectedMessage = "Sale";
    String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

    // Mouse hover on “Sort By” and select “Name A-Z”
    mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
    mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));

    //Verify that the product arrange alphabetically

    verifyText("Name A - Z", "Name A - Z", "Not in alphabetical order");
   // getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));
}

@Test //2
public void verifySaleProductsPriceArrangeLowToHigh(){
    // Mouse hover on the “Hot deals” link
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

    //Mouse hover on the “Sale”  link and click
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
    clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));

    //Verify the text “Sale”
    String expectedMessage = "Sale";
    String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

    // Mouse hover on “Sort By” and select “Price Low - High”
    mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
    mouseHoverClick(By.xpath("//span[contains(text(),'Price Low - High')]"));

    //Verify that the product arrange alphabetically

    verifyText("Price Low - High","Price Low - High ", "Not in alphabetical order");
    getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]"));
}

@Test   //3
    public void verifySaleProductsArrangeByRates(){
    // Mouse hover on the “Hot deals” link
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

    //Mouse hover on the “Sale”  link and click
    mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
    clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));

    //Verify the text “Sale”
    String expectedMessage = "Sale";
    String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

    // Mouse hover on “Sort By” and select "Rates”
    mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
    mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
    ////*[@id="content"]/div/div/div[2]/div/div/div[2]/div[1]/div/span[2]

    //Verify that the product arrange alphabetically

    verifyText("Rates","Rates", "Not in alphabetical order");
    getTextFromElement(By.xpath("//a[normalize-space()='Rates']"));
}

 @Test   //4
    public void verifyBestSellersProductsArrangeByZToA(){
     // Mouse hover on the “Hot deals” link
     mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

     //Mouse hover on the “Bestsellers”  link and click
     mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
     clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));

     //Verify the text “Bestsellers”
     String expectedMessage = "Bestsellers";
     String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
     Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

     // Mouse hover on “Sort By” and select “Name Z -A”
     mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
     mouseHoverClick(By.xpath("//a[normalize-space()='Name Z - A']"));

     //Verify that the product arrange alphabetically

     verifyText("Name Z - A","Name Z - A", "Not in alphabetical order");
     getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]"));

 }

    @Test   //5
    public void verifyBestSellersProductsPriceArrangeHighToLow(){
        // Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

        //Mouse hover on the “Bestsellers”  link and click
        mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));

        //Verify the text “Bestsellers”
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

        // Mouse hover on “Sort By” and select “Price High - Low”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price High - Low']"));

        //Verify that the product arrange alphabetically

        verifyText("Price High - Low","Price High - Low", "Not in alphabetical order");
        getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]"));

    }
    @Test   //6
    public void verifyBestSellersProductsArrangeByRates(){
        // Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

        //Mouse hover on the “Bestsellers”  link and click
        mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));

        //Verify the text “Bestsellers”
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

        // Mouse hover on “Sort By” and select “Rates”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));

        //Verify that the product arrange alphabetically

        verifyText("Rates","Rates", "Not in alphabetical order");
        getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));

    }

@After
public void tearDown(){
    closeBrowser();
}

}
