package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
        ChromeDriver driver;

        /*
         * TODO: Write your tests here with testng @Test annotation.
         * Follow `testCase01` `testCase02`... format or what is provided in
         * instructions
         */

        /*
         * Do not change the provided methods unless necessary, they will help in
         * automation and assessment
         */
        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                // NOT NEEDED FOR SELENIUM MANAGER
                // WebDriverManager.chromedriver().timeout(30).setup();

                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
        }

        @Test
        public void testCase01() throws InterruptedException {

                driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                Wrappers form = new Wrappers(driver);
                form.navigateToForm();
                Thread.sleep(10000);
                form.verifyFormUrl();

                Thread.sleep(2000);
                WebElement name = driver
                                .findElement(By.xpath(
                                                "//div[@class='Xb9hP']//div[@class='ndJi5d snByac']/preceding-sibling::input"));
                form.fieldToFill(name, "Crio Learner");

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")));
                long currentEpochTimeMillis = System.currentTimeMillis();
                long currentEpochTimeSeconds = currentEpochTimeMillis / 1000;
                long epochTime = currentEpochTimeSeconds;
                WebElement element2 = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
                String textField2 = "I want to be the best QA Engineer! " + epochTime;
                System.out.println(textField2);
                form.fieldToFill(element2, textField2);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='i13']/div[3]/div")));
                WebElement element3 = driver.findElement(By.xpath("//div[@id='i13']/div[3]/div"));
                form.clickButton(element3);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='i30']/div[2]")));

                WebElement element4 = driver.findElement(By.xpath("//div[@id='i30']/div[2]"));
                form.clickButton(element4);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='i33']/div[2]")));
                WebElement element5 = driver.findElement(By.xpath("//div[@id='i33']/div[2]"));

                form.clickButton(element5);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='i39']/div[2]")));
                WebElement element6 = driver.findElement(By.xpath("//div[@id='i39']/div[2]"));
                form.clickButton(element6);

                Thread.sleep(4000);
                WebElement element7 = driver
                                .findElement(By.xpath("//div[@class='Qr7Oae']//span[text()='Choose']//parent::div"));
                form.clickButton(element7);

                Thread.sleep(3000);

                WebElement element8 = driver
                                .findElement(By.xpath(
                                                "//div[@class='OA0qNb ncFHed QXL7Te']//span[text()='Mr']//parent::div"));
                form.clickButton(element8);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='date']")));
                WebElement element9 = driver.findElement(By.xpath("//input[@type='date']"));
                Thread.sleep(10000);
                form.selectDate(element9, 3, 8, 2024);
                WebElement element10 = driver.findElement(By.xpath(
                                "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input"));
                WebElement element11 = driver.findElement(By.xpath(
                                "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input"));
                Thread.sleep(4000);
                form.fieldToFill(element10, "07");
                Thread.sleep(4000);
                // driver.wait(2000);
                form.fieldToFill(element11, "30");
                Thread.sleep(4000);
                WebElement element14 = driver.findElement(By.xpath("//div[@class='lRwqcd']/div"));
                form.clickButton(element14);
                Thread.sleep(5000);
                String currentUrl = driver.getCurrentUrl();
                form.confirmResponseForm(currentUrl);
        }

        @AfterTest
        public void endTest() {
                driver.close();
                driver.quit();

        }
}
