package day09_ActionsClasses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions extends TestBase {

@Test

    public void test01(){
    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    driver.get("https://the-internet.herokuapp.com/context_menu");
    //3- Cizili alan uzerinde sag click yapin
    Actions actions=new Actions(driver);
    WebElement ciziliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
    actions.contextClick(ciziliAlan).perform();
    ReusableMethods.wait(2);
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    String expectedAlertYazisi="You selected a context menu";
    String actualAlertYazisi=driver.switchTo().alert().getText();

    Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
//5- Tamam diyerek alert’i kapatalim
    String ilkSayfaWHD=driver.getWindowHandle();
    driver.switchTo().alert().accept();

//6- Elemental Selenium linkine tiklayalim

    driver.findElement(By.linkText("Elemental Selenium")).click();


    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    String ikinciSyfaWHD="";
    Set<String>windowHandlesHepsi=driver.getWindowHandles();

    for (String eachWhd:windowHandlesHepsi
         ) { if (!eachWhd.equals(ilkSayfaWHD)){
            ikinciSyfaWHD= eachWhd;
    }
    }
  driver.switchTo().window(ikinciSyfaWHD);
        String expectedYazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        ReusableMethods.wait(5);


}



}
