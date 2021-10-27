package demoqa.automation_practice_form.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.automation_practice_form.config.BrowserConfig;
import demoqa.automation_practice_form.config.CredentialsConfig;
import demoqa.automation_practice_form.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    static WebDriver driver;
    static BrowserConfig config;


    static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    static String loginForSelenoid = credentials.login();
    static String passwordForSelenoid = credentials.password();


    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;

        String environment = "local";
        System.setProperty("run", environment);
        config = ConfigFactory.create(BrowserConfig.class, System.getProperties());
        switch (environment) {
            case "local":
                Configuration.baseUrl = config.getBaseUrl();
                break;
            case "remote":
                Configuration.remote = config.getBaseUrl();
                break;
        }
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersion();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}