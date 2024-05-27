package automationpractice;

import b239.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TC_10_VerifySubscriptionHomePage extends TestBase {
//    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//4. Scroll down to footer
//5. Verify text 'SUBSCRIPTION'
//            6. Enter email address in input and click arrow button
//7. Verify success message 'You have been successfully subscribed!' is visible


    @Test
    void test01() throws InterruptedException {
        driver.get("http://automationexercise.com");

//            3. Verify that home page is visible successfully
        List<WebElement> listSliders=driver.findElements(By.id("slider-carousel"));
        for (WebElement w : listSliders){
            Assertions.assertTrue(w.isDisplayed());
            break;
        }
        Thread.sleep(2000);
        //4. Scroll down to footer
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //5. Verify text 'SUBSCRIPTION'
        WebElement subscript=driver.findElement(By.xpath("//h2[.='Subscription']"));
        String textSub=subscript.getText();
        Assertions.assertTrue(textSub.equalsIgnoreCase("SUBSCRIPTION"));
//            6. Enter email address in input and click arrow button
        WebElement subscriptionBox=driver.findElement(By.id("susbscribe_email"));
        subscriptionBox.sendKeys("ozge@gmail.com");
        driver.findElement(By.id("subscribe")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement messageSuccess=driver.findElement(By.xpath("//div[.='You have been successfully subscribed!']"));
        String message=messageSuccess.getText();
        Assertions.assertTrue(message.equalsIgnoreCase("You have been successfully subscribed!"));


    }
}
