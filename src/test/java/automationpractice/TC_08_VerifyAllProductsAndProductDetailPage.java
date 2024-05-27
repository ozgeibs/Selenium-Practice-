package automationpractice;

import b239.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_08_VerifyAllProductsAndProductDetailPage  extends TestBase {
    @Test
    void name() throws InterruptedException {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
//        3. Verify that home page is visible successfully
        //            3. Verify that home page is visible successfully
        List<WebElement> allAd=driver.findElements(By.className("col-sm-12"));
        for (WebElement w : allAd) {
            Assertions.assertTrue(w.isDisplayed());
            break;
        }
        Thread.sleep(2000);
//        4. Click on 'Products' button
        WebElement productsButton=driver.findElement(By.xpath("//*[text()=' Products']"));
        productsButton.click();
//        5. Verify user is navigated to ALL PRODUCTS page successfully
   WebElement searchProduct=driver.findElement(By.id("search_product"));
   Assertions.assertTrue(searchProduct.isDisplayed());

//        6. The products list is visible
        List<WebElement> allP=driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']"));
        for (WebElement w : allP){
            Assertions.assertTrue(w.isDisplayed());

        }

//        7. Click on 'View Product' of first product
        WebElement view=driver.findElement(By.xpath("(//a[.='View Product'])[1]"));
        view.click();

//        8. User is landed to product detail page
        Thread.sleep(2000);
        String actualUrl=driver.getCurrentUrl();
        String expected="https://automationexercise.com/product_details/1";
        Thread.sleep(2000);
        Assertions.assertEquals(actualUrl,expected);
//        9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

        WebElement name=driver.findElement(By.xpath("//h2[.='Blue Top']"));

        WebElement category=driver.findElement(By.xpath("//p[.='Category: Women > Tops']"));
        WebElement price = driver.findElement(By.xpath("//span[.='Rs. 500']"));
        WebElement availability = driver.findElement(By.xpath("//b[.='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//b[.='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//b[.='Brand:']"));


        Assertions.assertTrue(name.isDisplayed());
        Thread.sleep(2000);
        Assertions.assertTrue(category.isDisplayed());
        Thread.sleep(2000);
        Assertions.assertTrue(price.isDisplayed());
        Thread.sleep(2000);
        Assertions.assertTrue(availability.isDisplayed());
        Thread.sleep(2000);
        Assertions.assertTrue(condition.isDisplayed());
        Thread.sleep(2000);
        Assertions.assertTrue(brand.isDisplayed());


    }
}
