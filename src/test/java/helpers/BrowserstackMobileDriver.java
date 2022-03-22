package helpers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        caps.setCapability("browserstack.user", "bsuser_lhwI3G");
        caps.setCapability("browserstack.key", "zQg8pVwyA1cKCyGoKSU8");

        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}