package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class OrangeHRM {

    public String baseUrl = "https://www.saucedemo.com/";
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("Before Test executed");
        driver = new ChromeDriver();

        // Maximize window and navigate to URL
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit wait
    }

    @Test(priority = 1, enabled = true)
    public void loginAndLogout() throws InterruptedException {
        // Login using provided credentials
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='login-button']")).click(); // Click the login button

        // Wait for login to complete
        Thread.sleep(5000);

        // Scroll down to the bottom of the page using Actions class
        JavascriptExecutor  jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy (0,400)");// Scroll to the Add to Cart button
        Thread.sleep(2000); // Optional: wait for scrolling to complete

        // Click on the "Add to Cart" button using the provided XPath
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        Thread.sleep(2000);// Replace with your actual XPath
        jse.executeScript("window.scrollBy (400,0)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Omkar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Chaturvedi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("285466");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        Thread.sleep(22000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy (400,0)");
        Thread.sleep(2000);
        
        // Logout
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click(); // Open the menu
        Thread.sleep(5000); // Wait for the menu to open
        driver.findElement(By.linkText("Logout")).click(); // Click the Logout option
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000); // Wait before closing
        driver.close();
        driver.quit();
    }
}