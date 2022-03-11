package outlook_automation;

import factory.OutlookFactory;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import static constants.LandingPageConstants.*;
import static constants.Messages.ElementNotFoundMessage;

public class BaseTest {
    protected static WindowsDriver outlookSession;
    protected static OutlookFactory outlookFactory;

    @BeforeClass
    public void setup() {
        DesiredCapabilities outlookCapabilities = new DesiredCapabilities();
        outlookCapabilities.setCapability(appCap, outlookPath);
        outlookCapabilities.setCapability(waitAppCap, 5);
        try {
            outlookSession = new WindowsDriver<WindowsElement>(new URL(hubHost), outlookCapabilities);
            outlookFactory = new OutlookFactory(outlookSession);
            closeActivationWindow();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void closeActivationWindow() {
        try {
            if (outlookFactory.activationWindow().isDisplayed()) {
                outlookFactory.activationWindow().click();
                outlookFactory.closeButtons().get(1).click();
            }
            if (outlookFactory.acceptableWindow().isDisplayed()) {
                outlookFactory.acceptButton().click();
            }
        } catch (Exception e) {
            System.out.println(ElementNotFoundMessage);
        }
    }

    @AfterClass
    public void tearDown() {
        outlookSession.quit();
    }
}
