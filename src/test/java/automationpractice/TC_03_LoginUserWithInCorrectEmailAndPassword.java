package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC_03_LoginUserWithInCorrectEmailAndPassword {


    WebDriver driver;

    @BeforeEach
    public void before() {
        //    1. Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @Test
    public void test03() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//            3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//a[.=' Home']"));
        Assertions.assertTrue(home.isEnabled());
        //4. Click on 'Signup / Login' button
        WebElement loginSignupButton = driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        loginSignupButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assertions.assertEquals(loginToYourAccount.getText(), "Login to your account");
        //6. Enter incorrect email address and password
        WebElement mailBox = driver.findElement(By.name("email"));
        mailBox.sendKeys("ozge@nehaber.com");

        WebElement passBox = driver.findElement(By.name("password"));
        passBox.sendKeys("sssds");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

          //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement message = driver.findElement(By.xpath("//*[.='Your email or password is incorrect!']"));
        Assertions.assertTrue(message.isEnabled());




    }

}
