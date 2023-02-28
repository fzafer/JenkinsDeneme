package com.cydeo.utilities.MyUtils;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MyUtils.Xpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class FleetGru {

    public static void fleetgruLogin(){

        //Configuration.properties dosyasında env, username ve password yazıldı:
        //fleetgru-env=https://qa.fleetgru.com/user/login
        //fleetgru-username=storemanager77
        //fleetgru-password=UserUser123

        //1. ConfigurationReader ile env yani web sitesini açıyoruz
        Driver.getDriver().get(ConfigurationReader.getProperty("fleetgru-env"));
        BrowserUtils.sleep(1); //1 saniye bekliyoruz

        //2. username ismini ConfReader ile bulup yazdırıyoruz (Xpath metodunu ben yaptım, findElement kısayolu için)
        Xpath.xpath("/html//input[@id='prependedInput']").sendKeys(ConfigurationReader.getProperty("fleetgru-username"));

        //3. password yine confreader ile bulup yazdırıyoruz
        Xpath.xpath("/html//input[@id='prependedInput2']").sendKeys(ConfigurationReader.getProperty("fleetgru-password"));

        //loginbuttonu locate edip tıklıyoruz (Keys.ENTER hata verdiği için)
        Xpath.xpath("/html//button[@id='_submit']").click();

        //bunu başka class'ta çağırmak için FleetGru.fleetgruLogin();  yazmak yeterli, sayfayı açıp login yapıyor

    }

    public static void verification(WebElement element, String expectedText){


        String actualText = element.getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);

        Assert.assertEquals(actualText, expectedText);
    }

    public static void verificationTitle(String expectedTitle){

        //wait until dynamic title loads and verify it
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);

        //wait until condition
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        String actualtitle = Driver.getDriver().getTitle();
        System.out.println("actualtitle = " + actualtitle);
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(actualtitle, expectedTitle);
    }
}
