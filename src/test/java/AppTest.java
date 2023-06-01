
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class AppTest {

    AndroidDriver driver;

    @Test
    public void Test() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "JNA6INOR59P7MVYL");
        dc.setCapability("appium:platformVersion", "13.0.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:appPackage", "net.one97.paytm");
        dc.setCapability("appium:appActivity", "net.one97.paytm.app.LauncherActivity");
        dc.setCapability("appium:fullReset", false);
        dc.setCapability("appium:noReset", true);
        dc.setCapability("appium:udid", "JNA6INOR59P7MVYL");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        // checking if element is visible to user then click of Pay
        if(waitForElement(3000,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ImageView", true)){
            WebElement payTo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ImageView"));
            payTo.click();
        }


        // checking if element is visible to user then clicking enter mobile number
        if(waitForElement(3000,"net.one97.paytm:id/enter_mobile_upi_tv", false)){
            WebElement payToNumber = driver.findElement(By.id("net.one97.paytm:id/enter_mobile_upi_tv"));
            payToNumber.click();
        }

        // checking if element is visible to user then entering mobile number
        if(waitForElement(3000,"net.one97.paytm:id/etSearchView", false)){
            WebElement payToNumber = driver.findElement(By.id("net.one97.paytm:id/etSearchView"));
            payToNumber.sendKeys("9946154170");
        }

        // checking if element is visible to user & clicking result
        if(waitForElement(3000,"net.one97.paytm:id/item_initials", false)){
            WebElement number = driver.findElement(By.id("net.one97.paytm:id/item_initials"));
            number.click();
        }

        // checking if element is visible to user & getting result and print
        if(waitForElement(3000,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.View/android.widget.ScrollView/android.widget.TextView[2]", true)){
            WebElement details = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.View/android.widget.ScrollView/android.widget.TextView[2]"));
            String value = details.getText();
            System.out.println(value);
        }

        // checking if element is visible to user & getting result and print
        if(waitForElement(3000,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.View/android.widget.ScrollView/android.widget.TextView[4]", true)){
            WebElement details = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.View/android.widget.ScrollView/android.widget.TextView[4]"));
            String value = details.getText();
            System.out.println(value);
        }


    }

    // return true if element is visible to user after 3 sec else false
    public boolean waitForElement(int timeInSeconds, String pathOfElement, Boolean isXpath){
        try{
            for(int i=0;i<timeInSeconds;i++){
                if(isXpath){
                    if(isElementExistByXpath(pathOfElement))
                        return true;
                }else {
                    if(isElementExistsById(pathOfElement))
                        return true;
                }
                Thread.sleep(1000);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //checking if element is visible to te user by ID
    public boolean isElementExistsById(String idOfElement){
        return driver.findElements(By.id(idOfElement)).size() > 0;
    }

    //checking if element is visible to te user by ID
    public boolean isElementExistByXpath(String xpathOfElement){
        return driver.findElements(By.xpath(xpathOfElement)).size() > 0;
    }
}
