package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class FirstTest {
    @Test
    public void TestSearchGoogle()  throws  InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("http://google.com");
//        driver.navigate().to("http://google.com");

        Set<String> oldWindow = driver.getWindowHandles();
        System.out.println("Oldwindow: " + oldWindow);

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://selenium.dev");


        Set<String> newWindow = driver.getWindowHandles();
        System.out.println("newWindow: " + newWindow);

        String firstUrl = driver.getCurrentUrl();
        System.out.println("First Url: " + firstUrl);
        Assert.assertEquals(firstUrl, "https://www.selenium.dev/");

        String firstTitle = driver.getTitle();
        System.out.println("First Title: " + firstTitle);
        Assert.assertEquals(firstTitle, "SeleniumHQ Browser Automation");

//        String firstPageSource = driver.getPageSource();
//        System.out.println("First Page source: " + firstPageSource);
        driver.close();
        //Assert.assertEquals(pageSource,"");

        driver.switchTo().window(tabs.get(0));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url: " + currentUrl);
        //Assert.assertEquals(currentUrl,"https://www.google.com/search?q=ChromeDriver&source=hp&ei=UJvNYPX9NuKSwPAPxsGcUA&iflsig=AINFCbYAAAAAYM2pYFzqITQoljCevYF5ZDZx_5qWIMT5");

        String currentTitle = driver.getTitle();
        System.out.println("Current Title: " + currentTitle);
        Assert.assertEquals(currentTitle,"ChromeDriver - Поиск в Google");

        driver.navigate().back();
        driver.navigate().refresh();

        String lastUrl = driver.getCurrentUrl();
        System.out.println("Last Url: " + lastUrl);
        Assert.assertEquals(lastUrl,"https://www.google.com/?gws_rd=ssl");

        driver.navigate().forward();
        driver.navigate().refresh();

        driver.get("https://github.com/sorynbassarov");
        Cookie authCoockie = new Cookie("user_session","fpYYNDYh5McQoROBhWTsisVOVxJmgYN_-1f26TUX_03gf-Uv");
        driver.manage().addCookie(authCoockie);
        driver.navigate().refresh();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Coockies: " + cookies);

        Cookie tzCoockies = driver.manage().getCookieNamed("tz");
        System.out.println("tz Coockies: " + tzCoockies);


        driver.manage().deleteAllCookies();
        System.out.println("Deleted coockies: " + driver.manage().getCookies()  );
        //driver.quit();


//        driver.navigate().to("https://www.facebook.com/login.php");
//        WebElement fillEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
//        fillEmail.sendKeys("170103017@stu.sdu.edu.kz");
//
//        WebElement fillPassword = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
//        fillPassword.sendKeys("Raelilblack1");
//
//        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
//        loginButton.submit();

//        driver.navigate().back();
//
//        WebElement signUp = driver.findElement(By.xpath("//a[@class=\"_97w5\"]"));
//        //signUp.click();


        driver.navigate().to("https://next.privat24.ua/mobile");
        WebElement inputFieldAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='amount']")));
        String defaultValue = inputFieldAmount.getAttribute("value");
        System.out.println("Default value: "+ defaultValue);
        Assert.assertEquals("50", defaultValue);




    }
}
