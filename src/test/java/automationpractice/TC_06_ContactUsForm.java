package automationpractice;

import com.github.dockerjava.api.model.Link;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC_06_ContactUsForm {
    WebDriver driver;
    //1. Launch browser
    @BeforeEach
    void setUp() {
        //    1.Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterEach
    void tearDown() {
        //19. Close the web pages.
    }





//9. Click OK button


    @Test
    void test06() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
      //  3. Verify that home page is visible successfully
     List<WebElement> allAd=driver.findElements(By.className("col-sm-12"));
      for (WebElement w : allAd){
          Assertions.assertTrue(w.isDisplayed());
          break;

      }
        //4. Click on 'Contact Us' button
        WebElement contactUs=driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
      contactUs.click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch=driver.findElement(By.xpath("//h2[.='Get In Touch']"));
        getInTouch.click();
//6. Enter name, email, subject and message
        WebElement name= driver.findElement(By.name("name"));
        name.sendKeys("ozge");


        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("ozge@gmail.com");

        WebElement subject= driver.findElement(By.name("subject"));
        subject.sendKeys("product");
WebElement msj=driver.findElement(By.id("message"));
msj.sendKeys("i want to give back product");
//7. Upload file
WebElement upload=driver.findElement(By.name("upload_file"));
String path=System.getProperty("user.home")+"\\Desktop\\flower.jpg";
upload.sendKeys(path);

//8. Click 'Submit' button
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successText=driver.findElement(By.xpath("//div[.='Success! Your details have been submitted successfully.']"));
        Assertions.assertTrue(successText.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton=driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();

Thread.sleep(4000);
        String actualUrl=driver.getCurrentUrl();
        String expected="https://automationexercise.com/";
        Assertions.assertEquals(expected,actualUrl);
    }
}