import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTests {
	
	    RemoteWebDriver webDriver;
	    AndroidDriver<MobileElement> androidDriver;
	    DesiredCapabilities capabilities;
        String serverUrl;
        String platformName;
        
	    @BeforeClass(alwaysRun = true)
	    @Parameters({"appium_url","platform", "udid", "systemPort","device", "appType"})
	    public void setup(String appiumUrl,String platform, 
	    		String udid, String systemPort, 
	    		String device, String appType) throws Exception {

	        String[] platformInfo = platform.split(" ");
	        platformName = platformInfo[0];
	        capabilities = new DesiredCapabilities();
	        serverUrl = appiumUrl;
	        if(!appType.equals("web"))
	        {	        
		        capabilities.setCapability("automationName", "uiautomator2");
		        capabilities.setCapability("platformName", platformInfo[0]);
		        capabilities.setCapability("appium:deviceName", device);
		        capabilities.setCapability("appium:udid", udid);
		        capabilities.setCapability("systemPort", systemPort);
		        capabilities.setCapability("appium:app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk");
	        }
	        else
	        {
	        	if(!platformName.equals("Windows"))
	 	        {
	 		        capabilities.setCapability("platformName", platformName);
	 		        capabilities.setCapability("appium:deviceName", device);
	 		        capabilities.setCapability("appium:udid", udid);
	 		        capabilities.setCapability("browserName", "Chrome");
	 		        capabilities.setCapability("automationName", "Appium");
	 	        }
	        }
	       
	    }
	    
	    protected void startAndroidDriver()
	    {
	    	try {
				androidDriver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    
	    
	    
	    protected void stopAndroidDriver() {
	    	if(androidDriver!=null)
	    		 androidDriver.quit();
		}
	    
	    protected void startWebDriver(String platform)
	    {
	    	if(platform.equals("Android"))
	    	{
		    	try {
		    		webDriver = new AndroidDriver<WebElement>(new URL(serverUrl), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    	}
	    	if(platform.equals("Windows"))
	    	{
	    		 try 
	    		 {
					webDriver = new RemoteWebDriver(new URL(serverUrl), new ChromeOptions());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 webDriver.manage().window().maximize();
	    	}
	    	 webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    
	    
	    
	    protected void stopWebDriver() {
	    	if(webDriver!=null)
	    		 webDriver.quit();
		}
	    @AfterTest
	    public void tearDown()
	    {   	 
	    	 if(webDriver!=null)
	    		 webDriver.quit();
	    }
	    

}
