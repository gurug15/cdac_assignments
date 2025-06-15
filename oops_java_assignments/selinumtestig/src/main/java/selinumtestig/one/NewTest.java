package selinumtestig.one;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        // No need for System.setProperty if using Selenium 4.6+
        driver = new ChromeDriver(); // Selenium Manager auto-handles the driver
       // driver.manage().window().maximize();
    }

    @Test
    public void f() {
    	 driver.get("https://www.google.com");

    	    WebElement searchBox = driver.findElement(By.name("q"));
    	    searchBox.sendKeys("OpenAI ChatGPT");
    	    searchBox.submit();

    	    try {
    	        // Wait to see results before closing
    	        Thread.sleep(5000); // 5 seconds
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	    WebElement firstResult = driver.findElement(By.xpath("(//h3)[1]"));
    	    System.out.println("First result: " + firstResult.getText());
    }

    @AfterTest
    public void afterTest() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

