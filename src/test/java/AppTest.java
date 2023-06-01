
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

        // click of Pay
        WebElement payTo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ImageView"));
        payTo.click();

        // checking if element is visible to user then clicking enter mobile number
        if(waitForElement(3000,"net.one97.paytm:id/enter_mobile_upi_tv")){
            WebElement payToNumber = driver.findElement(By.id("net.one97.paytm:id/enter_mobile_upi_tv"));
            payToNumber.click();
        }

        // checking if element is visible to user then entering mobile number
        if(waitForElement(3000,"net.one97.paytm:id/etSearchView")){
            WebElement payToNumber = driver.findElement(By.id("net.one97.paytm:id/etSearchView"));
            payToNumber.sendKeys("7478870112");
        }

        // checking if element is visible to user & clicking result
        if(waitForElement(3000,"net.one97.paytm:id/item_initials")){
            WebElement number = driver.findElement(By.id("net.one97.paytm:id/item_initials"));
            number.click();
        }


        // checking if element is visible to user & getting result and print
        if(waitForElement(3000,"net.one97.paytm:id/clMessageListingUI")){
            WebElement details = driver.findElement(By.id("net.one97.paytm:id/clMessageListingUI"));
            String value = details.getText();
            System.out.println(value);
        }

    }

    // return true if element is visible to user after 3 sec else false
    public boolean waitForElement(int timeInSeconds, String pathOfElement){
        try{
            for(int i=0;i<timeInSeconds;i++){
                if(isElementExists(pathOfElement))
                    return true;
                Thread.sleep(1000);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //checking if element is visible to te user
    public boolean isElementExists(String xpathOfElement){
        return driver.findElements(By.id(xpathOfElement)).size() > 0;
    }
}
