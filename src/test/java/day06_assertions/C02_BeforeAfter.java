package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C02_BeforeAfter {
    // create separate test method
    //.Method test if we go to amazon and go to amazon
    // Search for nutella on amazon in the method and test if the results contain nutella
    // Test that the number of nutella search results in the.method is more than 50
    WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.amzon.com/");
}
@After
    public void teardown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}
@Test
    public void test01(){
    String expectedWort="Amazon";
    String actuelTitle=driver.getTitle();
    Assert.assertTrue(actuelTitle.contains(expectedWort));
    System.out.println(actuelTitle);
}

@Test
public void test02(){
driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Nutella"+ Keys.ENTER);
    String searchResult=driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
    System.out.println(searchResult);
    Assert.assertTrue(searchResult.contains("Nutella"));
}
@Test
    public void test03() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Nutella"+ Keys.ENTER);
    Thread.sleep(2000);
    String resultsforNutella=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
    System.out.println(resultsforNutella);
    String[] resultArr=resultsforNutella.split(" ");
    String lastResult=resultArr[2];
    int lastresultInt;
    lastresultInt=Integer.parseInt(lastResult);
    Assert.assertTrue(lastresultInt>50);
    System.out.println(lastresultInt);
}



}
