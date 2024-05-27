package b239.practice04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_LastElementList {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    void tearDown() {
        // driver.close();
    }

    @Test
    void name() {
//        •Go to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
//• When
//•   Enter the username as "standard_user"
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

//• And
//•   Enter the password as "secret_sauce"
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
//• And
//•   Click on login button
        driver.findElement(By.id("login-button")).click();
//• And
//•   Order products by "Price (low to high)"
        WebElement dropbox = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropbox);
        select.selectByIndex(2);
//• Then
//•   Assert that last product costs $49.99, first product costs $7.99
       List<WebElement> allProduct= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for(WebElement w : allProduct){
            System.out.println(w.getText());

        }
        String lowest=allProduct.get(0).getText();
        String highest=allProduct.get(allProduct.size()-1).getText();



        assertTrue( lowest.contains("$7.99"));

        assertEquals("$49.99",highest);
    }
}
