import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class w3LogIn {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){


        // Configure Selenium
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://profile.w3schools.com/log-in");
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();

    }


    @Test
    public void w3SignUp() throws InterruptedException {


//      Check for SignIn
        WebElement CheckLogin = driver.findElement(By.xpath("//input[@id='modalusername']"));
        if (CheckLogin.isDisplayed())
        {
            driver.findElement(By.xpath("//input[@id='modalusername']")).sendKeys("tedob59939@richdn.com");
        }else {
            System.out.println("Create Log In Button Not Found");
        }

        driver.findElement(By.xpath("//input[@id='current-password']")).sendKeys("test.P455");
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        Thread.sleep(100);

        //submit form from user
        driver.get("https://www.w3schools.com/html/exercise.asp?filename=exercise_html_attributes1");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[text()='Accept all & visit the site']")).click();
        driver.findElement(By.tagName("input")).sendKeys("test");
        driver.findElement(By.xpath("//button[@class='w3s-exercisebtn']")).click();

        //i sent form from user and go back to login again
        driver.navigate().back();

    }


    @After
    public void close() throws InterruptedException {
        WebElement CheckLogin = driver.findElement(By.xpath("//input[@id='modalusername']"));
        if (CheckLogin.isDisplayed())
        {
            driver.findElement(By.xpath("//input[@id='modalusername']")).sendKeys("tedob59939@richdn.com");
        }else {
            System.out.println("Create Log In Button Not Found");
        }

        driver.findElement(By.xpath("//input[@id='current-password']")).sendKeys("test.P455");
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        Thread.sleep(1000);

        WebDriverWait waitLoad = new WebDriverWait(driver,120);
        waitLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Log out']")));
        driver.findElement(By.xpath("//button[@title='Log out']")).click();
        driver.quit();
    }

}
