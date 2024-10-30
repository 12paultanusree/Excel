package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation  {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
       WebElement username= driver.findElement(By.id("user-name"));
       username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement login=driver.findElement(By.id("login-button"));
        login.click();
        WebElement slider=driver.findElement(By.className("bm-burger-button"));
        slider.click();
        WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        driver.quit();
        System.out.println("Logged out successfully....");
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement register= driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));



    }
}
