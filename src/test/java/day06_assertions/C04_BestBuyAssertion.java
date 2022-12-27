package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAssertion {
    // 1) Create a class: BestBuyAssertions
    // 2) Go to https://www.bestbuy.com/ by creating different test methods
    // do the following tests
    // ○ Test that the page URL is equal to https://www.bestbuy.com/
    // ○ titleTest => Test if the page title does not contain “Rest”
    // ○ logoTest => Test that the BestBuy logo is displayed
    // ○ FrancaisLinkTest => French Test that the link is displayed
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
   public void Test01(){
        // ○ Test that the page URL is equal to https://www.bestbuy.com/
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertTrue(expectedURL.equals(driver.getCurrentUrl()));
    }
@Test
    public void Test02(){
    // ○ titleTest => Test if the page title does not contain “Rest”
    String unexpectedTitle="Rest";
    Assert.assertFalse(driver.getTitle().contains("Rest"));
}
@Test
    public void Test03(){
    // ○ logoTest => Test that the BestBuy logo is displayed
    Assert.assertTrue(driver.findElement(By.xpath("(//img[@class=\"logo\"])[1]")).isDisplayed());
}
@Test
    public void Test04(){
    // ○ FrancaisLinkTest => French Test that the link is displayed
    Assert.assertTrue(driver.findElement(By.xpath("//button[@lang=\"fr\"]")).isDisplayed());
}

}
