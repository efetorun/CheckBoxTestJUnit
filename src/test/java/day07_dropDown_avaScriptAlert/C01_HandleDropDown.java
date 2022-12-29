package day07_dropDown_avaScriptAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropDown {
WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
    //iligili ayarlari yapipi amazon ana sayfaya gidin
        driver.get("https://www.amazon.com/");
//arama kutusu yanindaki dropdown menu den book secip
        WebElement dropDownmenu= driver.findElement(By.id("searchDropdownBox"));
        Select dropdownSelect=new Select(dropDownmenu);
        dropdownSelect.selectByValue("search-alias=stripbooks-intl-ship");
        Thread.sleep(2000);
    // arama kutusuna java yazdirip aramayi yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
    //title in book ve java icerdiginin test edin
        String expectedTitle="Java";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

//dropDown menuden book secenegininin secildigini test edin
        //locate ettigimiz elementi bulamazsa NoSuchElementExceptiom verir
        //sayfa yenilendigi icin var olan elementi kullanamazsa
        //StaleElemtnException verrir
        //bu durumda locate ve selected secme islemini yeniden yapmamiz gerekir

        dropDownmenu=driver.findElement(By.id("searchDropdownBox"));
        dropdownSelect=new Select(dropDownmenu);
        dropdownSelect.selectByValue("search-alias=stripbooks-intl-ship");
        String actuelSelectedOption = dropdownSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption="Books";
        Assert.assertEquals(expectedSelectedOption,actuelSelectedOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin

        List<WebElement> optionsWebElemntListesi =dropdownSelect.getOptions();

        int actualOptionSayisi=optionsWebElemntListesi.size();
        int expectedOptionSayisi=28;
        System.out.println(actualOptionSayisi);
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

}
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





}
