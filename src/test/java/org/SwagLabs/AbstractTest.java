package org.SwagLabs;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getDriver().navigate().to("https://www.saucedemo.com"),
                "Страница не доступна");
        Assertions.assertTrue(true);

    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
