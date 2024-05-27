package b239.practice04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Q1_Calculator {

    WebDriver driver;
    /*

    Create chrome driver by using @BeforeEach annotation and WebDriverManager
    Navigate to  https://testpages.herokuapp.com/styled/index.html
    Click on  Calculator under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on 'times' option from the dropdown
    Click on Calculate
    Get the result
    Verify the result
    Print the result
    Close the browser by using @AfterEach annotation

     */

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);  // Optional
       // driver.close();
    }

    @Test
    void multiply() {
            //        Navigate to  https://testpages.herokuapp.com/styled/index.html
            driver.get("https://testpages.herokuapp.com/styled/index.html");

//        Click on  Calculator under Micro Apps
            WebElement calculator = driver.findElement(By.id("calculatetest"));
            calculator.click();

            assertTrue(driver.getCurrentUrl().contains("calculator"));

//        Type any number in the first input
            WebElement number1 = driver.findElement(By.id("number1"));
            number1.sendKeys("7");
//        Type any number in the second input
            WebElement number2 = driver.findElement(By.id("number2"));
            number2.sendKeys("8");

//        Click on 'times' option from the dropdown
        WebElement dropdown=driver.findElement(By.id("function"));
        Select select=new Select(dropdown);
        select.selectByValue("times");
//        Click on Calculate
        WebElement submitButton=driver.findElement(By.id("calculate"));
        submitButton.click();

        // Get the result
        WebElement result=driver.findElement(By.id("answer"));
        String resultText=result.getText();
        //    Verify the result
        Assertions.assertTrue(result.isDisplayed());
        //    Print the result
        System.out.println("Result text : " + resultText);


        }
}
