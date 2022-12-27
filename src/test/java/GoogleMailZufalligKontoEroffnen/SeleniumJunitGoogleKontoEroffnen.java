package GoogleMailZufalligKontoEroffnen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumJunitGoogleKontoEroffnen {
//Gehen Sie zu ggogle.com
    //Ablehnen Sie Cookies
WebDriver driver;
@Before
public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@After
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    //driver.close();
}
@Test
    public void Test01() throws InterruptedException {
    driver.get("https://www.google.com/");
    driver.findElement(By.xpath("(//div[@class=\"QS5gu sy4vM\"])[1]")).click();
    driver.findElement(By.xpath("//input[@class=\"gLFyf\"]")).sendKeys("gmail"+ Keys.ENTER);
    driver.findElement(By.xpath("(//h3[@class=\"LC20lb MBeuO DKV0Md\"])[2]")).click();
    driver.findElement(By.xpath("(//span[@class=\"VfPpkd-vQzf8d\"])[3]")).click();
    driver.findElement(By.xpath("(//span[@class=\"VfPpkd-StrnGf-rymPhb-b9t22c\"])[1]")).click();
    driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[1]")).sendKeys("Emre");
    driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[2]")).sendKeys("Turhalli");
    driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[3]")).sendKeys("turhalliemre5555");
    driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[4]")).sendKeys("26Aralik2019..");
    driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[5]")).sendKeys("26Aralik2019..");
    WebElement next=driver.findElement(By.xpath("(//span[@class=\"VfPpkd-vQzf8d\"])[2]"));
    next.click();
    driver.findElement(By.xpath("//input[@class=\"VfPpkd-fmcmS-wGMbrd \"]")).sendKeys("017642946224");
    Thread.sleep(1500);
    WebElement next2= driver.findElement(By.xpath("(//span[@class=\"VfPpkd-vQzf8d\"])[1]"));
    next2.click();
}

}
