package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    
    //create web_element
   	@FindBy(name ="logid")
   	private WebElement txt_userName;
   	
   	@FindBy(name="pswd")
   	private WebElement txt_password;
   	
   	@FindBy(xpath ="//input[@value='Login']")
   	private WebElement button_login;
   	
   	@FindBy(xpath ="//b[contains(text(),'Sorry we were unable')]")
   	private WebElement error_msg;	

    public void goTo(){
      //  this.driver.get("https://duckduckgo.com/");
    	this.driver.get("http://books.rediff.com/login");
    }
    
	// re_usable methods
	public void login( String username, String password)
	{
		txt_userName.sendKeys(username);
		txt_password.sendKeys(password);
		button_login.click();		
	}
	
	public String getErrorMessage()
	{
		String text = error_msg.getText();
		return text;
	} 
}
