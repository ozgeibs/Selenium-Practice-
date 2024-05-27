package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC_05_RegisterUserWithExistingEmail {
    @Test
    public void registerWithExistingEmail(){
        //    1. Launch browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        //3. Verify that home page is visible successfully
        WebElement allHomePage=driver.findElement(By.xpath("(//section[@id='slider'])[1]"));
        Assertions.assertTrue(allHomePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signupLogin=driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        signupLogin.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup= driver.findElement(By.xpath("(//h2)[3]"));;
        Assertions.assertTrue(newUserSignup.isDisplayed());
        //6. Enter name and already registered email address
        WebElement nameBox=driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("ozge");
        WebElement emailBox=driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailBox.sendKeys("ozge@nehaber.com");
        //7. Click 'Signup' button
        WebElement signupButton=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signupButton.click();
       //8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExists=driver.findElement(By.xpath("//p[.='Email Address already exist!']"));
        Assertions.assertTrue(alreadyExists.isDisplayed());


    }
}
