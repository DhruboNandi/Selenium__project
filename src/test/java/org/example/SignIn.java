package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignIn extends DriverSetup1 {
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test(priority = 1)

    public void LogInWithValidCredential() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email' or @name='email' ]")).sendKeys("dhruba.nandi@g.bracu.ac.bd");
       driver.findElement(By.xpath("//input[@id='input-password' and @name='password']")).sendKeys("dhruba1256");
       driver.findElement(By.xpath("//input[@value='Login' and @class='btn btn-primary']")).click();
        // Assert.assertEquals();
        //driver.quit();


    }
    @Test(priority = 2)
    public void LogInWithInValidEmail() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email' or @name='email' ]")).sendKeys("dhruba.nandi.bracu.ac.bd");
        driver.findElement(By.xpath("//input[@id='input-password' and @name='password']")).sendKeys("dhruba1256");
        driver.findElement(By.xpath("//input[@value='Login' and @class='btn btn-primary']")).click();
        String ActualText=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        Assert.assertTrue(ActualText.contains("Warning: No match for E-Mail Address and/or Password."));
        // Assert.assertEquals();
       // driver.quit();


    }
@Test(priority = 3)
    public void LogInWithInValidPassword() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email' or @name='email' ]")).sendKeys("dhruba.nandi.bracu.ac.bd");
        driver.findElement(By.xpath("//input[@id='input-password' and @name='password']")).sendKeys("dhruba");
        driver.findElement(By.xpath("//input[@value='Login' and @class='btn btn-primary']")).click();
        String ActualText=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        Assert.assertTrue(ActualText.contains("Warning: No match for E-Mail Address and/or Password."));
        // Assert.assertEquals();
   // driver.quit();


    }
    @Test(priority = 4)
    public void LogInWithInBlank() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();
        //driver.findElement(By.xpath("//input[@id='input-email' or @name='email' ]")).sendKeys("dhruba.nandi.bracu.ac.bd");
        //driver.findElement(By.xpath("//input[@id='input-password' and @name='password']")).sendKeys("dhruba");
        driver.findElement(By.xpath("//input[@value='Login' and @class='btn btn-primary']")).click();
       String a= driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]/i")).getText();
        Assert.assertTrue(a.contains("Warning: No match for E-Mail Address and/or Password."),"abcdd");
        // Assert.assertEquals();
      //  driver.quit();


    }
}
