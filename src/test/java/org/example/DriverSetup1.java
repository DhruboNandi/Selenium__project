package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class DriverSetup1 {
    public WebDriver driver;
    @BeforeSuite
   public WebDriver setDriver() throws InterruptedException {
        String BrowserName ="Edge";
        if(BrowserName.equals("Edge")){
            driver=new EdgeDriver();
        }
        else if(BrowserName.equals("Firefox")){
            driver=new FirefoxDriver();
        }
        else if(BrowserName.equals("Chrome")){
            driver=new ChromeDriver();
        }


       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        Assert.assertEquals(driver.getTitle(),"Your Store");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/");
        //driver.findElement(By.xpath("//a[title()='My Account']")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        return driver;


    }
}
