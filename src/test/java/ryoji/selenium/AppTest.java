/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryoji.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ryoji
 */
public class AppTest {
    
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSimple() throws Exception {
        this.driver.get("http://www.google.com");
        assertEquals("Google", this.driver.getTitle());
    }
    
    @Test
    public void testSearch() {
        this.driver.get("http://www.yahoo.co.jp/");
        WebElement searchBox = this.driver.findElement(By.id("srchtxt"));
        searchBox.sendKeys("安倍晋三");
        this.driver.findElement(By.id("srchbtn")).click();
        this.driver.findElements(By.tagName("a")).get(80).click();
        String imageUrl = this.driver.findElements(By.tagName("img")).get(10).getAttribute("src");
        if (imageUrl.startsWith("http")) {
            this.driver.get(imageUrl);
        }
        this.driver.get("http://google.com");
        this.driver.findElement(By.id("lst-ib")).sendKeys("David Cameron");
        this.driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
    }

    @After
    public void tearDown() throws Exception {
        //this.driver.quit();
    }
}
