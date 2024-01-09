package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class signup extends DriverSetup1{
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test(priority = 1)
    public void SignupWithValidCredentials() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("drb");
        driver.findElement(By.id("input-lastname")).sendKeys("nandi");
        driver.findElement(By.id("input-email")).sendKeys("dhruba.nandi@g.bracu.ac.bd");
        driver.findElement(By.id("input-telephone")).sendKeys("01871241878");
        driver.findElement(By.id("input-password")).sendKeys("dhruba1256");
        driver.findElement(By.id("input-confirm")).sendKeys("dhruba1256");
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
       // driver.quit();
    }
    @Test(priority = 2)
    public void SignupWithInvalidEmail() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("drb");
        driver.findElement(By.id("input-lastname")).sendKeys("nandi");
        driver.findElement(By.id("input-email")).sendKeys("dhruba.nandig.bracu.ac.bd");
        driver.findElement(By.id("input-telephone")).sendKeys("01871241878");
        driver.findElement(By.id("input-password")).sendKeys("dhruba1256");
        driver.findElement(By.id("input-confirm")).sendKeys("dhruba1256");
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //driver.quit();


    }
    @Test(priority = 3)
    public void SignupWithInvalidPass() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("drb");
        driver.findElement(By.id("input-lastname")).sendKeys("nandi");
        driver.findElement(By.id("input-email")).sendKeys("dhruba.nandig.bracu.ac.bd");
        driver.findElement(By.id("input-telephone")).sendKeys("0187241878");
        driver.findElement(By.id("input-password")).sendKeys("dhruba1256");
        driver.findElement(By.id("input-confirm")).sendKeys("dhruba1000");
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //driver.quit();
    }
    @Test(priority = 4)
    public void SignupWithInvalidPhone() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("drb");
        driver.findElement(By.id("input-lastname")).sendKeys("nandi");
        driver.findElement(By.id("input-email")).sendKeys("dhruba.nandig.bracu.ac.bd");
        driver.findElement(By.id("input-telephone")).sendKeys("0187278");
        driver.findElement(By.id("input-password")).sendKeys("dhruba1256");
        driver.findElement(By.id("input-confirm")).sendKeys("dhruba1256");
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //driver.quit();
    }

    @Test(priority = 5)
    public void SignupWithNothing() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        String ActualWarning=driver.findElement(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
        Assert.assertTrue(ActualWarning.contains("Warning: You must agree to the Privacy Policy!"),"privacy message is not displayed");
        String FirstNameWarning =driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
        Assert.assertTrue(FirstNameWarning.contains("First Name must be between 1 and 32 characters!"),"error displayed");
        String LastNameWarning=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
        Assert.assertTrue(LastNameWarning.contains("Last Name must be between 1 and 32 characters!"),"error has");
        String EmailError=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
        Assert.assertTrue(EmailError.contains("E-Mail Address does not appear to be valid!"),"eror ache");
       // driver.quit();


    }
}
