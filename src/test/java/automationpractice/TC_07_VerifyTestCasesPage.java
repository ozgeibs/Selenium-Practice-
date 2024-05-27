package automationpractice;

import b239.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_07_VerifyTestCasesPage extends TestBase {

//    1. Launch browser


    @Test
    void test07() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //            3. Verify that home page is visible successfully
        List<WebElement> allAd=driver.findElements(By.className("col-sm-12"));
        for (WebElement w : allAd) {
            Assertions.assertTrue(w.isDisplayed());
            break;
        }
//4. Click on 'Test Cases' button
            WebElement testCases=driver.findElement(By.xpath("//a[.=' Test Cases']"));
        testCases.click();
//5. Verify user is navigated to test cases page successfully
        WebElement testCasesPage=driver.findElement(By.xpath("//b[.='Test Cases']"));
        Assertions.assertTrue(testCasesPage.isDisplayed());
    }
}
