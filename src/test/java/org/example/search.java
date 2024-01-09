package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class search extends DriverSetup1{
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test(priority = 1)
    public void searchproducts()  {
        driver.findElement(By.name("search")).sendKeys("hp");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());


    }
    @Test(priority = 2)
    public void InValidSearch() throws InterruptedException{
        driver.findElement(By.name("search")).sendKeys("dhruba");
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actualsearchmessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualsearchmessage,"There is no product that matches the search criteria","no product");

    }
    @Test(priority =3)
    public void WithoutSearch()throws InterruptedException{

        driver.findElement(By.name("search")).sendKeys("dhruba");
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actualsearchmessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualsearchmessage,"There is no product that matches the search criteria","no product");
    }
}
