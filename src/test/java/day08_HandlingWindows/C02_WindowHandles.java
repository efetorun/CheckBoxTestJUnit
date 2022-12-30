package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {








WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

@Test
    public void test01(){
    //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    String expectedText="Opening a new window";
    String actualText=driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
    Assert.assertEquals(expectedText,actualText);
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String expectedTitle="The Internet";
    String actualTitle=driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);
    String ilkSayfaWindowsHandle=driver.getWindowHandle();
    //● Click Here butonuna basın.
    driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
   /*
   Kontrolsuz acilan Tab a gecis yapmak icin
   1- ilk safada iken o sayfanini WHD alip kaydedin
   2- 2.sayfa acildiktan sonra getWindowHandles() kulalnarak
   acik olan tüm sayfalarin WH degerlerinin bir SEt olarak kaydedin
   3-  Su an elimizde 2 elementli bir Set var,
       elementlerden bir tanesi 1. sayfanin WHD
       1.Sayfanin WHD'ne esit olmayan ise ".sayfanin WHD olur.
   4- bu sekiolde 2.sayfanin  WHD elde edildiokten Whd leri kullanarak sayfalar arasi gecis yapilabilir
    */
Set<String> tumWHDDegerleriSeti=driver.getWindowHandles();

    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    String ikinciSayfaWhd="";
    for (String eachWHD:tumWHDDegerleriSeti
         ) {
    if (!eachWHD.equals(ilkSayfaWindowsHandle)){
    ikinciSayfaWhd=eachWHD;
    }
    }

    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    driver.switchTo().window(ikinciSayfaWhd);
   String expectedText2="New Window";
   String actualText2=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
   Assert.assertEquals(expectedText2,actualText2);
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    driver.switchTo().window(ilkSayfaWindowsHandle);
    expectedTitle="The Internet";
    actualTitle=driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);
}

}
