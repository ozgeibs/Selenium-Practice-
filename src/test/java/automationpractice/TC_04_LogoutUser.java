package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC_04_LogoutUser {
    WebDriver driver;
    @BeforeEach
    // Launch browser
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }









//9. Click 'Logout' button
//10. Verify that user is navigated to login page
    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        //            3. Verify that home page is visible successfully
        WebElement category=driver.findElement(By.xpath("//h2[.='Category']"));
        Assertions.assertTrue(category.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton=driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        signupLoginButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginText=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assertions.assertTrue(loginText.isDisplayed());
        //6. Enter correct email address and password
        WebElement emailBox=driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        emailBox.sendKeys("ozge@nehaber.com");

        WebElement passBox=driver.findElement(By.xpath("(//input[@name='password'])[1]"));
        passBox.sendKeys("12345");
//7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
//8. Verify that 'Logged in as username' is visible
        WebElement loggedAs=driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assertions.assertTrue(loggedAs.isDisplayed());
    }


}
