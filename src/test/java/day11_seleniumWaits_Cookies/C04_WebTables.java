package day11_seleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v104.overlay.model.LineStyle;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
@Test
    public void test01(){

 //1.“https://www.amazon.com” adresine gidin
    driver.get("https://www.amazon.com");
 //2.Sayfanin en altina inin
    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.END).perform();
 //3.Web table tum body’sini yazdirin
    WebElement tumBody=driver.findElement(By.xpath("//tbody"));
    tumBody.toString();
 //4.Web table’daki satir sayisinin 9 oldugunu test edin
    List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody/tr"));
    Assert.assertEquals(10,satirlarListesi.size());
 //5.Tum satirlari yazdirin
    for (WebElement eachsatirlar:satirlarListesi
         ) {
        System.out.println(eachsatirlar.getText());
    }
 //6. Web table’daki sutun sayisinin 13 olduğunu test edin
 //7. 5.sutunu yazdirin
 //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
    ReusableMethods.wait(5);
}



}
