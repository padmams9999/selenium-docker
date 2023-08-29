package com.searchmodule.tests;

import com.searchmodule.pages.LoginPage;

import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
    	System.out.println("*********************** Execution started ********************");
    	
    	String Exp_res = "Sorry we were unable to complete this step because :";
    	
    	LoginPage LoginPage = new LoginPage(driver);
    	LoginPage.goTo();
    	LoginPage.login(keyword, "learn");
        String act_res = LoginPage.getErrorMessage();
        Assert.assertEquals(Exp_res, act_res);
        if(Exp_res.equals(act_res))
		{
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
    }
}
