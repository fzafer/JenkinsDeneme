package com.cydeo.utilities.MyUtils;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Set;

public class Xpath {

    public static WebElement xpath(String path){

        WebElement  webElement = Driver.getDriver().findElement(By.xpath(path));

        return webElement;


    }
    public static Set xpaths(String path){

        Set<WebElement> allElements = new HashSet<>(Driver.getDriver().findElements(By.xpath(path)));

        return allElements;
    }

    public static WebElement id(String path){

        WebElement  webElement = Driver.getDriver().findElement(By.id(path));

        return webElement;

    }

    public static WebElement name(String path){

        WebElement  webElement = Driver.getDriver().findElement(By.name(path));

        return webElement;
    }
    public static WebElement linkText(String path){

        WebElement  webElement = Driver.getDriver().findElement(By.linkText(path));

        return webElement;
    }

    public static WebElement text(String text){


        String path = "//*[text()='" + text + "']";

        WebElement  webElement = Driver.getDriver().findElement(By.xpath(path));

        return webElement;
    }
    public static WebElement text2(String text){

        String path = "//*[.='" + text + "']";
        WebElement  webElement = Driver.getDriver().findElement(By.xpath(path));

        return webElement;
    }

    public static WebElement textTableSibling(String text, int num){

        String path = "//*[.='" + text + "']";
        String pathSibling = path + "/following-sibling::td[" + num + "]";
        WebElement  webElement = Driver.getDriver().findElement(By.xpath(pathSibling));

        return webElement;
    }


}
