package com.AppiumFramework;

import org.testng.annotations.DataProvider;

/**
 * Created by Tatiana on 5/18/2020.
 */
public class TestData {
    @DataProvider(name = "InputData")
    public Object[][] getDataforEditField() {
        //2 sets of data, "hello" , "!@#$$"
        Object[][] obj = new Object[][]
                {
                        {"QA_Testing"}, {"QA_!@#$%%"}
                };
        return obj;
    }
}
