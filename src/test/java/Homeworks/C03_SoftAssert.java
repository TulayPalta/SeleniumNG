package Homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseBeforeMethodAfterMethod;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_SoftAssert extends TestBaseBeforeMethodAfterMethod {

        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        //2. Sign in butonuna basin
        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        //5. Sign in tusuna basin
        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
@Test
public void test01(){
//"http://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
//Sign in butonuna basin
        Driver.getDriver().findElement(By.cssSelector("[id=\"signin_button\"]")).click();
//Login kutusuna "username" yazin
        Driver.getDriver().findElement(By.xpath("//*[contains(@id,\"user_login\")]")).sendKeys("username");
//Password kutusuna "password" yazin
        Driver.getDriver().findElement(By.xpath("//*[contains(@type,\"password\")]")).sendKeys("password");
//Sign in tusuna basin
        Driver.getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();
        // WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOf())
        Driver.getDriver().navigate().back();
//Online banking menusu icinde Pay Bills sayfasina gidin
        WebElement onlineBaking=Driver.getDriver().findElement(By.xpath("//strong[text()='Online Banking']"));
        wait.until(ExpectedConditions.visibilityOf(onlineBaking));
        onlineBaking.click();
        Driver.getDriver().findElement(By.cssSelector("#pay_bills_link")).click();
//"Purchase Foreign Currency" tusuna basin
        Driver.getDriver().findElement(By.xpath("(//ul)[5]//li[3]")).click();
//"Currency" drop down menusunden Eurozone'u secin
        WebElement dropDown= Driver.getDriver().findElement(By.cssSelector("[class=\"span4\"][name=\"currency\"]"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");
//soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualDropDownTitle=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualDropDownTitle,"Eurozone (euro)");
//soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin  "
        List<WebElement> list=select.getOptions();
        List<String>expectedList=new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
        "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));
// Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China  (yuan)",
// "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)","Mexico (peso)",
// "Norway (krone)","New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        for (int i = 0; i <expectedList.size() ; i++) {
        softAssert.assertEquals(list.get(i).getText(),expectedList.get(i));
        }
        softAssert.assertAll();
        //Driver.quitDriver();
        }

}
