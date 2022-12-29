package day07_dropDown_avaScriptAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
    //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        //driver.get("https://the-internet.herokuapp.com/iframe");
    // 2 ) Bir metod olusturun: iframeTest
    //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //     ve  konsolda yazdirin.
    //  - Text Box’a “Merhaba Dunya!” yazin.
    //  - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
    //    ve  konsolda yazdirin.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

@Test
    public void test01(){
    //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    //driver.get("https://the-internet.herokuapp.com/iframe");
    // 2 ) Bir metod olusturun: iframeTest
    //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //     ve  konsolda yazdirin.
    //  - Text Box’a “Merhaba Dunya!” yazin.
    //  - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
    //    ve  konsolda yazdirin.
driver.get("https://the-internet.herokuapp.com/iframe");
    //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
    WebElement actualText=driver.findElement(By.xpath("//h3[text()=\"An iFrame containing the TinyMCE WYSIWYG Editor\"]"));
    Assert.assertTrue(actualText.isDisplayed());
    System.out.println(actualText.getText());
    //  - Text Box’a “Merhaba Dunya!” yazin.
    //yazdiramadik ve nosuchelementException aldik
    //o Iframe ye switchto yapmalaiyiz
   WebElement iframe= driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
   driver.switchTo().frame(iframe);
   WebElement yaziKutusu=driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
    yaziKutusu.clear();
    yaziKutusu.sendKeys("Merhaba Dunya!");
    //  - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
    //    ve  konsolda yazdirin.
//iframe in icine girince disina cikmaliyiz sonra selenium yazisini test edebiliriz
    //driver.switchTo().parentFrame();//bulundugu i farame den bir ust html sayfasibna gecer
    //bu daha cok ic icice iframe ler oldugunda tercih edilir
    driver.switchTo().defaultContent();//ana sayfaya gecis yapar
    WebElement elementelSelenium= driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));
Assert.assertTrue(elementelSelenium.isDisplayed());
    System.out.println(elementelSelenium.getText());
}

}
