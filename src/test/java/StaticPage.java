import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticPage {
    WebDriver driver;

    @Before
    public void setup(){
        // Configure Selenium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\andre\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/about/about_copyright.asp");
    }


    @Test
    public void w3Check(){

        // Configure Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/about/about_copyright.asp");

        //i get current url using getcurrenturl and print it
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        //reading the title of the webpage and print it
        String title = driver.getTitle();
        System.out.println(title);

    }
    @After
    public void close() {
        driver.quit();
    }
}

