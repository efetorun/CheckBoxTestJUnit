package day11_seleniumWaits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){

        driver.quit();
    }
@Test
    public void implicitlyWaitTest(){
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// 1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
// 4. Remove butonuna basin.
    driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();
// 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    WebElement itsGone= driver.findElement(By.xpath("//p[@id=\"message\"]"));
    Assert.assertTrue(itsGone.isDisplayed());
// 6. Add buttonuna basin
    driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();
// 7. It’s back mesajinin gorundugunu test edin
    WebElement itsBack= driver.findElement(By.xpath("//p[@id=\"message\"]"));
    Assert.assertTrue(itsBack.isDisplayed());

}
@Test
    public void explicitlyWait(){
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    // 4. Remove butonuna basin.
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    WebElement itsGone= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));
    itsGone.click();
    Assert.assertTrue(itsGone.isDisplayed());
    // 6. Add buttonuna basin
    driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();
    // 7. It’s back mesajinin gorundugunu test edin
    WebElement itsBack= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));
    itsBack.click();
    Assert.assertTrue(itsBack.isDisplayed());
}
}
