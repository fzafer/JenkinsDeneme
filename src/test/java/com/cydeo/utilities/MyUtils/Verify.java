package com.cydeo.utilities.MyUtils;

import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class Verify {

    public void verifyText(String actualsPath, String expected){
        WebElement webElement = Xpath.xpath(actualsPath);
        String actual = webElement.getText();

       Assert.assertEquals(actual,expected);

    }
    public void verifyAttribute(String actualsPath, String attribute, String expected){
        WebElement webElement = Xpath.xpath(actualsPath);
        String actual = webElement.getAttribute(attribute);

        Assert.assertEquals(actual,expected);

    }
/*
    public void verifyIsSelected(String dropdownPath, String attribute, String expected){
        WebElement dropdown = Xpath.xpath(dropdownPath);
        Select dropdownObj = new Select(dropdown);



        Assert.assertEquals(dropdownObj.getFirstSelectedOption(), );

    }*/
}
