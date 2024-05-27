package b239.practice04;

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

public class Q04RemoveButton {

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
    void test01(){
       // Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
       // Click on the "Add Element" button 100 times
        WebElement addElement=driver.findElement(By.xpath("//button[.='Add Element']"));
        int counter=1;
       do {
           addElement.click();
           counter++;
       }while (counter<101);
        //    Click on the "Delete" button 20 times
        List<WebElement> delete=driver.findElements(By.className("added-manually"));
        int counter2=0;
        for (WebElement each : delete){
            each.click();
            counter2++;
            if (counter2==20){
                break;
            }
        }
        int firstTotalSizeOfDeleteButton=delete.size();
        delete=driver.findElements(By.className("added-manually"));
        //    Assert that 20 buttons were deleted.
        int lastTotalSizeOfDeleteButton=delete.size();
        int actualDeletedSize=firstTotalSizeOfDeleteButton-lastTotalSizeOfDeleteButton;
        int expectDeletedSize=20;
        Assertions.assertEquals(expectDeletedSize,actualDeletedSize);


    }
}
