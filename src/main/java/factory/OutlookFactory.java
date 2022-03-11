package factory;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.LandingPageConstants.*;

public class OutlookFactory {
    private WindowsDriver driver;

    public OutlookFactory(WindowsDriver windowsDriver) {
        this.driver = windowsDriver;
    }

    public WebElement activationWindow() {
        return driver.findElementByClassName(activationWindowClassName);
    }

    public WebElement acceptableWindow() {
        return driver.findElementByClassName(acceptableWindowClassName);
    }

    public WebElement acceptButton(){
        return driver.findElementByName(acceptButton);
    }

    public List<WebElement>closeButtons(){
        return driver.findElementsByName(windowCloseButton);
    }

}
