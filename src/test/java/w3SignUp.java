import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class w3SignUp {
    WebDriver driver;

    @Before
    public void setup(){


        // Configure Selenium
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.findElement(By.id("accept-choices")).click();
    }


    @Test
    public void w3() throws InterruptedException {


//      Check for Sing Up
        WebElement CheckLogin = driver.findElement(By.xpath("//div[@id='loginactioncontainer']//a[1]"));
        if (CheckLogin.isDisplayed())
        {
            driver.findElement(By.xpath("//div[@id='loginactioncontainer']//a[1]")).click();
        }else {
            System.out.println("Create Log In Button Not Found");
        }

        driver.findElement(By.xpath("//span[text()=' Sign up']")).click();

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

//      Get the Temp email address
        WebDriver driver2 =  new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://temp-mail.app/");
        Thread.sleep(5000);
        WebDriverWait waitForTempMail = new WebDriverWait(driver2,120);
        waitForTempMail.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));

//      take the email as String
        String getMail = driver2.findElement(By.id("trsh_mail")).getAttribute("value");
        Thread.sleep(5000);

        WebDriverWait waitForPageLoad = new WebDriverWait(driver,120);
        //driver2.quit();
        waitForPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getMail);
        driver.findElement(By.xpath("//input[@name='new-password']")).sendKeys("sqat(E8AQDT)");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='_3wIjP']//button[1]")).click();

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//input[@id='modal_first_name']")).sendKeys("Andrei");
        driver.findElement(By.xpath("//input[@id='modal_last_name']")).sendKeys("Tester");

        Thread.sleep(5000);
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//span[text()='Continue']")).click();

        driver2.manage().window().maximize();

        WebDriverWait waitForLink = new WebDriverWait(driver2,1200000000);
        waitForLink.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='login@w3schools.com']")));
        driver2.findElement(By.xpath("//span[text()='login@w3schools.com']")).click();
        Thread.sleep(100);

        driver2.switchTo().frame("myIframe");
        driver2.findElement(By.linkText("Verify email")).click();
        Thread.sleep(200);

        driver.manage().window().maximize();
        Thread.sleep(100);
        driver2.quit();
    }


    @After
    public void close(){
        driver.quit();
    }

}
