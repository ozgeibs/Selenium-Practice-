package automationpractice;

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

public class RegisterUser {











//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


WebDriver driver;
    @BeforeEach
    void setUp() {
        //    1.Launch browser
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterEach
    void tearDown() {
        //19. Close the web pages.
    }

    @Test
    void name() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
       // 3. Verify that home page is visible successfully
        WebElement pageLogoVisible=driver.findElement(By.className("header-middle"));
        Assertions.assertTrue(pageLogoVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signupButton=driver.findElement(By.xpath("//*[.=' Signup / Login']"));
        signupButton.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.className("signup-form"));
        Assertions.assertTrue(newUserSignup.isDisplayed());
        //6. Enter name and email address
        WebElement nameBox=driver.findElement(By.cssSelector("input[name='name']"));
        nameBox.sendKeys("ozge");

        WebElement mailBox=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mailBox.sendKeys("o366@gmail.com");

//7. Click 'Signup' button
        WebElement submitButton=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        submitButton.click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount=driver.findElement(By.xpath("//*[.='Enter Account Information']"));
        Assertions.assertTrue(enterAccount.isDisplayed());
//9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement radio2=driver.findElement(By.id("id_gender2"));
        radio2.click();
        WebElement passBox=driver.findElement(By.xpath("//input[@type='password']"));
        passBox.sendKeys("123456");
        WebElement day=driver.findElement(By.id("days"));
        Select dayS=new Select(day);
        dayS.selectByValue("25");

        WebElement month=driver.findElement(By.id("months"));
        Select monthsS=new Select(month);
        monthsS.selectByIndex(5);

        WebElement year=driver.findElement(By.id("years"));
        Select yearsS=new Select(year);
        yearsS.selectByVisibleText("1996");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.name("optin")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameBox=driver.findElement(By.id("first_name"));
        firstNameBox.sendKeys("ozge");

        WebElement lastNameBox=driver.findElement(By.id("last_name"));
        lastNameBox.sendKeys("yildiz");

        WebElement companyBox=driver.findElement(By.id("company"));
        companyBox.sendKeys("Microsoft");

        WebElement addressBox1=driver.findElement(By.id("address1"));
        addressBox1.sendKeys("Mamak");

        WebElement addressBox2=driver.findElement(By.id("address2"));
        addressBox1.sendKeys("Ankara");

        WebElement countryDropbox=driver.findElement(By.id("country"));
        Select select= new Select(countryDropbox);
        select.selectByVisibleText("United States");

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("San jose");


        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("rohrmoser");

        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("01200");

        WebElement mobileNumber=driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("0505511311");

        //13. Click 'Create Account button'
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

         //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement login=driver.findElement(By.xpath("//*[.='Account Created!']"));
        Assertions.assertTrue(login.isDisplayed());

        //15. Click 'Continue' button

        WebElement continueButton=driver.findElement(By.linkText("Continue"));
        continueButton.click();

       //16. Verify that 'Logged in as username' is visible

        WebElement loggedAs=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assertions.assertTrue(loggedAs.isDisplayed());

        //17. Click 'Delete Account' button

        WebElement deleteAccount=driver.findElement(By.cssSelector("i[class='fa fa-trash-o']"));
        deleteAccount.click();

      //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button



        WebElement deletedText=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assertions.assertTrue(deletedText.isDisplayed());


        //19 Click on 'Continue' Button
        WebElement continueButton2=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continueButton2.click();

        driver.close();


















    }
}
