package b239.practice05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_MatchCaptcha {

//    •Go to https://form.jotform.com/73302671092956




    WebDriver driver;
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
      /*
    Go to https://form.jotform.com/73302671092956
    Click on start
    Enter firstname and lastname
    Click on next
    Enter email
    Click on next
    Enter message
    Click on next
    Handle captcha
    Click on submit
    Assert that submission is received

     */

    @Test
    public void test() throws InterruptedException {

//        Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

//        Click on start
        WebElement startButton = driver.findElement(By.id("jfCard-welcome-start"));
        startButton.click();
//        Enter firstname and lastname
        WebElement firstName = driver.findElement(By.id("first_1"));
        firstName.sendKeys("Tom");

        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.id("last_1"));
        lastName.sendKeys("Hanks");

//        Click on next
        WebElement nextButton = driver.findElement(By.xpath("(//button[text() = 'Next'])[1]"));
        nextButton.click();

//        Enter email
        WebElement emailField = driver.findElement(By.name("q2_email"));
        emailField.sendKeys(new Faker().internet().emailAddress());
//        Click on next
        WebElement nextButton2 = driver.findElement(By.xpath("(//button[text() = 'Next'])[2]"));
        nextButton2.click();

//        Enter message
        WebElement messageBox = driver.findElement(By.id("input_3"));
        messageBox.sendKeys("Hello, Welcome to our Practice session!");

//        Click on next
        WebElement nextButton3 = driver.findElement(By.xpath("(//button[text() = 'Next'])[3]"));
        nextButton3.click();


        driver.switchTo().frame(0);
//        Handle captcha

        int num1 =  Integer.parseInt(driver.findElement(By.id("number")).getText());

        int num2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
String  function = driver.findElement(By.id("function")).getText();

        WebElement resultField = driver.findElement(By.id("result"));
Thread.sleep(2000);
        int result;

        if (function.equals("+")){
            result= num1 + num2;
        } else if (function.equals("-")) {
            result = num1-num2;
        } else if (function.equals("*")) {
            result = num1*num2;
        }else {
            result = num1/num2;
        }
        resultField.sendKeys(result + "");

driver.switchTo().defaultContent();
//        Click on submit

        WebElement submitButton = driver.findElement(By.xpath("(//button[text() = 'Submit'])[4]"));
        submitButton.click();

//        Assert that submission is received
        String messageText = driver.findElement(By.xpath("//div[@tabindex='0']")).getText();
        System.out.println("messageText = " + messageText);

        Thread.sleep(2000);
        assertEquals("Your submission has been received!" , messageText);


    }
}