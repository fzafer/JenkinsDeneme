package com.cydeo.utilities.MyUtils;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;

public class AlertZ {

    public static void Accept(){
        Alert alert = (Alert) Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    public static void Dismiss(){
        Alert alert = (Alert) Driver.getDriver().switchTo().alert();
        alert.dismiss();

    }

    public static void SendKeys(String keys){
        Alert alert = (Alert) Driver.getDriver().switchTo().alert();
        alert.sendKeys(keys);
        alert.accept();

    }


}
