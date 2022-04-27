package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {

        //Find on Shipping and click on it
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[3]/a"));

        //Find Web element and click on it
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));

        //Verify actual and expected message
        verifyText("Shipping", actualMessage, "Do not navigate to Shipping page ");
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //Find on New arrivals and click on it
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[4]/a/span"));
        //Find Web element and click on it
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));
        //Verify actual and expected message
        verifyText("New arrivals", actualMessage, "Not navigate to New page ");
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        //Find on Coming soon and click on it
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a/span"));
        //Find Web element and click on it
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Verify actual and expected message
        verifyText("Coming soon", actualMessage, "Not navigate to Coming soon page ");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        ////Find on Contact us and click on it
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a/span"));
        //Find Web element and click on it
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Verify actual and expected message
        verifyText("Contact us", actualMessage, "Not navigate to Contact us page ");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
