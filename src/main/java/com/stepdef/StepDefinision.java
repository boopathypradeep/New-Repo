package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinision {

@When("^user enters username and password and clicks login button$")
public void user_enters_username_and_password_and_clicks_login_button() throws Throwable {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).sendKeys("hello");
    driver.findElement(By.id("pass")).sendKeys("hai");
    driver.findElement(By.name("login")).click();
}

@Then("^user should be on the home page of the application$")
public void user_should_be_on_the_home_page_of_the_application() throws Throwable {
 System.out.println("user is on the home page of the application");
}
}
