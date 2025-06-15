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
    	 driver.get("https://www.calculator.net/");

    	    WebElement seven = driver.findElement(By.xpath("//*[@id=\"sciout\"]/tbody/tr[2]/td[2]/div/div[1]/span[1]"));
    	    seven.click();
    	    WebElement plus = driver.findElement(By.xpath("//*[@id=\"sciout\"]/tbody/tr[2]/td[2]/div/div[1]/span[4]"));
    	    plus.click();
    	    WebElement four = driver.findElement(By.xpath("//*[@id=\"sciout\"]/tbody/tr[2]/td[2]/div/div[2]/span[1]"));
    	    four.click();
    	    WebElement equal = driver.findElement(By.xpath("//*[@id=\"sciOutPut\"]"));
    	    System.out.println(equal.getText());;
    	        	    

    	    try {
    	        // Wait to see results before closing
    	        Thread.sleep(5000); // 5 seconds
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	  //  WebElement firstResult = driver.findElement(By.xpath("(//h3)[1]"));
    	    //System.out.println("First result: " + firstResult.getText());
    }

    @AfterTest
    public void afterTest() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

