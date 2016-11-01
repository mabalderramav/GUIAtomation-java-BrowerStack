package org.fundaionjala.broserstack02;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Administrator on 10/31/2016.
 */
public class BrowseStackTest {
    @Test
    public void test01() throws Exception {
        String USERNAME = System.getProperty("browserstack.username") != null? System.getProperty("browserstack.username"): "miguelaldobalder1";
        String AUTOMATE_KEY = System.getProperty("browserstack.key") != null ? System.getProperty("browserstack.key") : "FsyQMJ7r4yuvjo1wQfEa";
        System.out.println(USERNAME);
        final String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        //For HTTP
        System.getProperties().put("https.proxyHost", "172.31.90.146");
        System.getProperties().put("https.proxyPort", "3128");
        caps.setCapability("browser", "chrome");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "First build");

        WebDriver driver = new RemoteWebDriver(new URL(url), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();
        driver.quit();
    }
}
