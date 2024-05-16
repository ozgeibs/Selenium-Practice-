package b239.practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_Calculator {

//    Create chrome driver by using @BeforeEach annotation and WebDriverManager
//    Navigate to  https://testpages.herokuapp.com/styled/index.html

//    Type any number in the first input
//    Type any number in the second input
//    Click on Calculate
//    Get the result
//    Verify the result

//    Close the browser by using @AfterEach annotation
    WebDriver driver;
Faker fake;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterEach
    void tearDown() {
       // driver.close();
    }
    @Test
    void test01() {
        //    Click on  Calculator under Micro Apps
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //    Type any number in the first input
        WebElement calculator=driver.findElement(By.xpath("//a[@id='calculatetest']"));
        calculator.click();
        WebElement box1=driver.findElement(By.id("number1"));
        box1.sendKeys(new Faker().number().digit());
        //    Type any number in the second input
        WebElement box2=driver.findElement(By.id("number2"));
        box2.sendKeys(new Faker().number().digit());
        //    Click on Calculate
        WebElement submitButton=driver.findElement(By.id("calculate"));
        submitButton.click();
        //    Get the result
        WebElement result=driver.findElement(By.id("answer"));
        String resultText=result.getText();
        //    Verify the result
        Assertions.assertTrue(result.isDisplayed());
        //    Print the result
        System.out.println("Result text : " + resultText);
    }



}
