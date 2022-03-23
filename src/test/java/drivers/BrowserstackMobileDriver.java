package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
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

            String user = Credentials.config.user();
            String key = Credentials.config.key();

            caps.setCapability("browserstack.user", user);
            caps.setCapability("browserstack.key", key);

            caps.setCapability("app", "bs://2dd8632425e87ca33787c4ef2236cea360248fb8");

        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}