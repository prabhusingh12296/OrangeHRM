package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private DriverManager() {
    }

    public static void initializeDriver() {

        String browser = ConfigReader.get("browser");

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }

        DRIVER.set(driver);

        getDriver().manage()
                .window()
                .maximize();

        getDriver().manage()
                .timeouts()
                .pageLoadTimeout(
                        java.time.Duration.ofSeconds(
                                Long.parseLong(
                                        ConfigReader.get(
                                                "pageLoadTimeout"))));
    }

    public static WebDriver getDriver() {

        WebDriver driver = DRIVER.get();

        if (driver == null) {

            throw new IllegalStateException(
                    "WebDriver is not initialized.");
        }

        return driver;
    }

    public static void quitDriver() {

        WebDriver driver = DRIVER.get();

        if (driver != null) {

            driver.quit();
            DRIVER.remove();
        }
    }
}