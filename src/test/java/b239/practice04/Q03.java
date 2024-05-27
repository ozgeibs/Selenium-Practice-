package b239.practice04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q03 {
//    Go to https://amazon.com

//    Search for each first five options and print titles
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);  // Optional
        // driver.close();
    }

    @Test
    void test01() {
        driver.get("https://www.amazon.com.");
        WebElement tryDiffrnt = driver.findElement(By.linkText("Try different image"));
        tryDiffrnt.click();
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);
        List<WebElement> all=select.getOptions();
//    Print all the options in the 'Departments' dropdown on the left side of the search box
        for (WebElement each : all){
            System.out.println(each.getText());
        }
        System.out.println("***********************************************************");
        int counter=0;
        for (WebElement each : all){
            System.out.println(each.getText());
            counter++;
            if (counter==5){
                break;
            }
        }


    }
}