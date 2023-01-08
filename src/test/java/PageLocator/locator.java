package PageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class locator {
    WebDriver driver;
    WebDriverWait wait;
    public locator(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String login_form = "//div[@class='_9axz']";
}
