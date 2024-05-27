package b239.practice05;

import b239.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homework2 extends TestBase {
    @Test
    void test01() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        WebElement clickMe=driver.findElement(By.id("growbutton"));
Thread.sleep(5000);
        //Click on "click me" button
        clickMe.click();
        //Verify that "Event Triggered"
WebElement eventTriggered=driver.findElement(By.id("growbuttonstatus"));
Assertions.assertTrue(eventTriggered.isDisplayed());

    }




    @Test
    void test02() throws InterruptedException {
       // Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
//        When
//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep);
        List<String>toDoList=new ArrayList<>();
        toDoList.add("Prepare breakfast");
        toDoList.add("Wash the dishes");
        toDoList.add("Take care of baby");
        toDoList.add("Help your kid's homework");
        toDoList.add("Study Selenium");
        toDoList.add("Sleep");
        WebElement addNewTodo=driver.findElement(By.xpath("//input[@type='text']"));
        for (String w : toDoList){
            addNewTodo.sendKeys(w,Keys.ENTER);
        }
        //Strikethrough all todos.
        List<WebElement>all=driver.findElements(By.tagName("li"));

        for (WebElement w : all) {
                w.click();
            }
        //  Delete all todos.
        List<WebElement>delete=driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for (WebElement w : delete) {
            Thread.sleep(1000);
            w.click();
        }
        Thread.sleep(2000);
        all=driver.findElements(By.tagName("li"));
        //      Assert that all todos deleted.
        Assertions.assertTrue(all.isEmpty());


    }







//
}
