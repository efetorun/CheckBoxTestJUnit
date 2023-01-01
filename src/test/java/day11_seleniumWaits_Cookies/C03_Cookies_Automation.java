package day11_seleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies_Automation extends TestBase {
@Test
    public void test01(){

   // Yeni bir class olusturun : cookiesAutomation
//1- Amazon anasayfaya gidin
    driver.get("https://www.amazon.com/");
//2- tum cookie’leri listeleyin
  Set<Cookie> tumCookieler = driver.manage().getCookies();
  int siraNo=1;
    for (Cookie eachCookie:tumCookieler
         ) {
        System.out.print(siraNo+"-"+eachCookie);

        siraNo++;
    }
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    Assert.assertTrue(tumCookieler.size()>5);
//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
   String expectedCookieValue="USD";
   String actualCookieValue="";
    for (Cookie eachCookie:tumCookieler
    ) {
        if (eachCookie.getName().equals("i18n-prefs")){
            actualCookieValue=eachCookie.getValue();
        }
    }
    Assert.assertEquals(expectedCookieValue,actualCookieValue);
//5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
    driver.manage().addCookie(cookie);
    tumCookieler = driver.manage().getCookies();
    siraNo=1;
    for (Cookie eachCookie:tumCookieler
    ) {
        System.out.println(siraNo+"- "+eachCookie);
        siraNo++;
    }
//6- eklediginiz cookie’nin sayfaya eklendigini test edin
    String expectedCookieValue2="cikolatali";
    String actualCookieValue2="";
    for (Cookie eachCookie:tumCookieler
    ) {
        if (eachCookie.getName().equals("en sevdigim cookie")){
            actualCookieValue2=eachCookie.getValue();
        }
    }
    Assert.assertEquals(expectedCookieValue2,actualCookieValue2);
//7- ismi skin olan cookie’yi silin ve silindigini test edin
    driver.manage().deleteCookieNamed("skin");
    tumCookieler = driver.manage().getCookies();
    int skinCookieSayisi=0;
    for (Cookie eachCookie:tumCookieler
    ) {
        if (eachCookie.getName().equals("skin")){
            skinCookieSayisi++;
        }
    }
    Assert.assertEquals(0,skinCookieSayisi);
//8- tum cookie’leri silin ve silindigini test edin
    driver.manage().deleteAllCookies();
    tumCookieler = driver.manage().getCookies();
    siraNo=0;
    for (Cookie eachcookieler:tumCookieler
         ) {
        System.out.println(siraNo+"-"+ eachcookieler );
        siraNo++;
    }
    //Assert.assertEquals(0,tumCookieler.size());

}

}
