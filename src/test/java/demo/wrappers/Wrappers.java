package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    WebDriver driver;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToForm() {
        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?pli=1");

    }

    public void verifyFormUrl() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("forms")) {
            System.out.println("current url is Google form");
        }
    }

    public void fieldToFill(WebElement element, String input) {
        element.sendKeys(input);

    }

    public void clickButton(WebElement element) {
        element.click();
    }

    public void selectDate(WebElement element, int day, int month, int year) {
        int previousDay = day - 7;
        int actualDay = 0;
        if (previousDay < 0) {
            actualDay = 31 + previousDay;
            month = month - 1;
        } else if (previousDay == 0) {
            actualDay = 31;
            month = month - 1;
        } else {
            actualDay = previousDay;
        }
        String date = actualDay + "-" + month + "-" + year;
        element.sendKeys(date);
        if (date.contains("27-07-2024")) {
            System.out.println("the current date is : " + date);
        }

    }

    public void confirmResponseForm(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // WebElement element = driver
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vHW8K']")));
        WebElement element1 = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String element1Text = element1.getText();
        if (url.contains("formResponse") && element1Text.contains("Thanks for your response")) {
            System.out.println("the form information is recorded");
        }
    }
}
