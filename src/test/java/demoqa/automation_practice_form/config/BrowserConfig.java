package demoqa.automation_practice_form.config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources({"classpath:config/${run}.properties"})
public interface BrowserConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browser.version")
    String getVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/automation-practice-form")
    String getBaseUrl();

}
