package automationpractice;

import b239.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_09_SearchProduct extends TestBase {








    @Test
    void test09() throws InterruptedException {
        //    . Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //            3. Verify that home page is visible successfully
        List<WebElement> listSliders=driver.findElements(By.id("slider-carousel"));
        for (WebElement w : listSliders){
            Assertions.assertTrue(w.isDisplayed());
            break;
        }
        Thread.sleep(2000);

//4. Click on 'Products' button
        WebElement productButton=driver.findElement(By.xpath("//*[text()=' Products']"));
        productButton.click();
        Thread.sleep(2000);
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement ad=driver.findElement(By.xpath("//section[@id='advertisement'][1]"));
        Assertions.assertTrue(ad.isDisplayed());
        Thread.sleep(2000);
        //6. Enter product name in search input and click search button
        WebElement searchBox=driver.findElement(By.id("search_product"));
        searchBox.sendKeys("tshirt");
        driver.findElement(By.id("submit_search")).click();
        Thread.sleep(2000);
//7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assertions.assertTrue(searchedProduct.isDisplayed());
        //8. Verify all the products related to search are visible
       List<WebElement>allProduct=driver.findElements(By.id("cartModal"));
       for (WebElement w : allProduct){
           System.out.println(w.getText());
       }
    }
}
