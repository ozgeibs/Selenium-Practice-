package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC_02_LoginUserWithCorrectEmailAndPassword {
    @Test
    public void test01() {

//    1. Launch browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//            3. Verify that home page is visible successfully
        WebElement title=driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assertions.assertTrue(title.isDisplayed());
//4. Click on 'Signup / Login' button
     driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
//5. Verify 'Login to your account' is visible
WebElement login=driver.findElement(By.xpath("//h2[.='Login to your account']"));
Assertions.assertTrue(login.isDisplayed());
//6. Enter correct email address and password
        WebElement emailBox=driver.findElement(By.cssSelector("input[type='email']"));
        emailBox.sendKeys("ozge01@gmail.com");

        WebElement passwordBox=driver.findElement(By.name("password"));
        passwordBox.sendKeys("123");

//7. Click 'login' button
driver.findElement(By.xpath("//button[text()='Login']")).click();

//8. Verify that 'Logged in as username' is visible

        WebElement loogedAs=     driver.findElement(By.cssSelector("i[class='fa fa-lock']"));
        Assertions.assertTrue(loogedAs.isDisplayed());

//9. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
//10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleted=driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assertions.assertTrue(deleted.isDisplayed());


    }

}
