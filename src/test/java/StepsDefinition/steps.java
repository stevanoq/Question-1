package StepsDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageLocator.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps extends variable{
    
    @Given("open browser")
    public void open_browser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        locator = new locator(driver, wait);

        WebDriverManager.chromedriver().setup();
        // System.getProperty("webdriver.chrome.driver", "/home/evan/Documents/MavenProjects/sqa_testing/src/test/Resource/Drivers/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @And("navigate to {string}")
    public void navigate_to(String url){
        driver.navigate().to(url);
    }

    @And("verify if navigated to {string} by get current url")
    public void verify_if_navigated(String url){
        // String current_url = driver.getCurrentUrl();
        boolean state;
        state = wait.until(ExpectedConditions.urlToBe(url));
        // if(current_url.equalsIgnoreCase(url)){
        //     state = true;
        // }
        // else{
        //     state = false;
        // }
        System.out.println(state);
        assertEquals(state, expected_boolean);
    }

    @When("user click {string} text")
    public void user_click_text(String text){
        String xPath = "//a[normalize-space()='"+text+"']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).click();
    }

    @Then("verify if login form is appear")
    public void verify_if_login_form_is_appear(){
        boolean state = false;
        boolean verify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.login_form))).isDisplayed();

        if(verify){
            state = true;
        }
        else{
            state = false;
        }

        assertEquals(state, expected_boolean);
    }

    @When("user input {string} as {string}")
    public void user_input_as(String input, String textBox){
        String xPath;
        String id = "";
        if(textBox.equalsIgnoreCase("phone nummber")){
            id = "email";
        }
        else if(textBox.equalsIgnoreCase("password")){
            id = "pass";
        }
        xPath = "//input[@id='"+id+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).sendKeys(input);
    }

    @And("user click {string} button")
    public void user_click_button(String buttonName){
        String xPath = "(//button[normalize-space()='"+buttonName+"'])[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).click();
    }

    @Then("close browser")
    public void close_browser(){
        driver.close();
        driver.quit();
    }

    @And("click {string} icon")
    public void click_icon(String svg){
        String xpath = "(//*[name()='svg'][@aria-label='"+svg+"'])[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @Then("click {string} option")
    public void click_option(String option){
        String xpath = "//span[normalize-space()='"+option+"']";
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
}
