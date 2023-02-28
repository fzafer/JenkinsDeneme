package com.cydeo.utilities.MyUtils;

import com.cydeo.utilities.Driver;

import java.util.ArrayList;

public class SwitchTo {

    public static void switchTo(int i) {
        String currentWindow = Driver.getDriver().getWindowHandle();
        ArrayList<String> allHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

        String nextWindow = allHandles.get(i);
        Driver.getDriver().switchTo().window(nextWindow);






    }
}
