package practice02;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q1_BeforeEach_fillForm {

    /*
Create chrome driver by using @BeforeEach annotation and WebDriverManager
Go to url : http://www.gmibank.com/
Click on 'User Icon'
Click on 'Register'
Enter SSN
Enter First Name
Enter Last Name
Enter Address
Enter Phone Number
Enter Username
Enter Email
Enter New password
Enter New password confirmation
Click on Register button
Assert that user registered
Close the browser by using @AfterEach annotation

     */

    WebDriver driver;  // class variable
    //        Create chrome driver by using @BeforeEach annotation and WebDriverManager

    @BeforeEach
    public void setUp(){
        // WebDriverManager was used to set up the system for drivers
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait only waits when it's needed

    }


    @Test
    public void formTest() throws InterruptedException {

//        Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

//        Click on 'User Icon'
        WebElement userIcon =  driver.findElement(By.id("account-menu"));
        userIcon.click();
        Thread.sleep(2000);


//        Click on 'Register'
        WebElement registerOption = driver.findElement(By.linkText("Register"));
        registerOption.click();
        Thread.sleep(2000);

        // Verify using if statement

        String url = driver.getCurrentUrl();
        if (url.contains("register1")){
            System.out.println("Register option is clicked successfully!");
        } else {
            System.out.println("Register option is not clicked successfully!");
        }

        //assertTrue(url.contains("register"));  // Hard Assertion

        WebElement ssnBox=driver.findElement(By.xpath("//input[@id='ssn']"));
        ssnBox.sendKeys("1231555411");

        WebElement firstNameBox=driver.findElement(By.xpath("//input[@id='firstname']"));
        firstNameBox.sendKeys("admin");

        WebElement lastNameBox=driver.findElement(By.xpath("//input[@id='lastname']"));
        lastNameBox.sendKeys("admin");

        WebElement addressBox=driver.findElement(By.xpath("//input[@id='address']"));
        addressBox.sendKeys("San jose CR");


        WebElement phoneBox=driver.findElement(By.xpath("//*[@id='mobilephone']"));
        phoneBox.sendKeys("05074366623");

        WebElement usernameBox=driver.findElement(By.xpath("//*[@id='username']"));
        usernameBox.sendKeys("admin");



        WebElement emailBox=driver.findElement(By.xpath("//*[@id='email']"));
        emailBox.sendKeys("ozge_006@gmail.com");

        WebElement passBox=driver.findElement(By.xpath("//*[@id='firstPassword']"));
        passBox.sendKeys("Aa123456*");

        WebElement passBox2=driver.findElement(By.xpath("//*[@id='secondPassword']"));
        passBox2.sendKeys("Aa123456*");

        driver.findElement(By.xpath("//*[@id='register-submit']")).click();


//        Enter SSN
//        Enter First Name
//        Enter Last Name
//        Enter Address
//        Enter Phone Number
//        Enter Username
//        Enter Email
//        Enter New password
//        Enter New password confirmation
//        Click on Register button
//        Assert that user registered
//        Close the browser by using @AfterEach annotation



    }


//    @AfterEach
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000); // Hard Wait
//        driver.close();
//
//    }

}