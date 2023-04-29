package autopilot;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

@Slf4j
public class SeleniumSetup {
    public static final String SCREENSHOT_DIRECTORY = "tmp/";
    public static final int MAX_WAIT_SECONDS = 10;
    public static final int RECURRING_WAIT_MILLIS = 500;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<FluentWait<WebDriver>> wait = new ThreadLocal<>();

    private static final long TIME_IN_MILLIS = System.currentTimeMillis();

    public void setWebDriver() {
        if(driver.get() != null) {
            log.info("Driver already initialized.");
            return;
        }
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome" -> {
                //WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "/Users/srinivaschiranji/Downloads/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                //chromeOptions.addArguments("--headless");
                //chromeOptions.put("download.default_directory", "/directory/path");
                driver.set(new ChromeDriver(chromeOptions));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                driver.get().manage().window().maximize();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                driver.get().manage().window().maximize();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                driver.get().manage().window().maximize();
            }
            case "ie" -> {
                WebDriverManager.iedriver().setup();
                driver.set(new InternetExplorerDriver());
                driver.get().manage().window().maximize();
            }
            default -> throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_WAIT_SECONDS));
        wait.set(new FluentWait<>(driver.get()).withTimeout(Duration.ofSeconds(MAX_WAIT_SECONDS)).pollingEvery(Duration.ofMillis(RECURRING_WAIT_MILLIS)).ignoring(NoSuchElementException.class));
    }

    protected void closeBrowser(Scenario scenario) {
        log.info("----> Executing @After");
        if(scenario.isFailed()) {
            saveScreenshotsForScenario(scenario);
        }
        driver.get().close();
        driver.get().quit();
        driver.set(null);
        wait.set(null);
    }

    protected void saveScreenshotsForScenario(final Scenario scenario) {
        String screenShotFileName =  TIME_IN_MILLIS + "-" + scenario.getName();
        log.info("Saving screenshot {}", SCREENSHOT_DIRECTORY+screenShotFileName);
        Shutterbug.shootPage(getDriver(), Capture.FULL, true).withName(screenShotFileName).save(SCREENSHOT_DIRECTORY);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public Wait<WebDriver> getWait() {
        return wait.get();
    }
}
