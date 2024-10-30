package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login  {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.wpeverest.com/user-registration/simple-registration-form/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement firstname= driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstname.sendKeys("Tanu");
        WebElement lastname= driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastname.sendKeys("Paul");
        WebElement username= driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        username.sendKeys("Bangalore");
        WebElement email= driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        email.sendKeys("paul12@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='user_pass']"));
        password.sendKeys("12345");
        WebElement confirmpass= driver.findElement(By.xpath("//*[@id=\"user_confirm_password\"]"));
        confirmpass.sendKeys("12345");
        WebElement bio= driver.findElement(By.xpath("//*[@id=\"description\"]"));
        bio.sendKeys("Hello there!!!!!!!!!!!!!!");
        WebElement submit= driver.findElement(By.xpath("//*[@id=\"user-registration-form-105\"]/form/div[3]/button"));
        submit.click();
        System.out.println("Registered successfully!!!!!!");
    }
}
