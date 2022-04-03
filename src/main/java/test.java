import cucumber.api.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {

    WebDriver driver;



    public void SetUp () {

        System.setProperty("webdriver.chrome.driver", "C:\\Practice\\demo\\test\\src\\driver\\chromedriver_1.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.investec.com/");
        System.out.println(driver.getTitle());
        System.out.println("Chrome launched successfully:" +" "+ driver.getCurrentUrl());

    }

    public void Navigate() {

        driver.navigate().to("https://www.investec.com/en_za/focus/money/understanding-interest-rates.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }



    public void SignUp(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement signBtn = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[7]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/button"));
        signBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Test");
        WebElement surname = driver.findElement(By.name("surname"));
        surname.sendKeys("Test");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@investec.co.za");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> Element = driver.findElements(By.className("checkbox-input__trigger-button"));
        Element.get(0).click();
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

       if (driver.getPageSource().contains("thank-you__heading")){
           System.out.println("User has been signed up successfully");
       }
       else
           System.out.println("User has not been signed up successfully");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }

    @After
    public void CloseWindow(){
        driver.quit();

    }

    @Test
    public void Test () {
        SetUp();
        Navigate();
        SignUp();
        CloseWindow();
    }
}
