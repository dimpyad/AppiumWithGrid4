import org.testng.annotations.Test;



/*
 * This code will be performing parallel execution of login operation
 * on two different devices. Settings needed for multiple devices are
 * specified in testng.xml file
 */
public class NativeAppTests extends BaseTests{


    @Test
    public void testLogin() {
    	startAndroidDriver();
    	
    	System.out.println("The thread ID for this test = "+ Thread.currentThread().getId());
    	androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Login Screen\"]").click();
      	androidDriver.findElementByXPath("//android.widget.EditText[@content-desc=\"username\"]").sendKeys("alice");
    	androidDriver.findElementByXPath("//android.widget.EditText[@content-desc=\"password\"]").sendKeys("mypassword");
    	androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"loginBtn\"]/android.widget.TextView").click();
         
        String loginSuccess = androidDriver.findElementByXPath("//android.widget.TextView[contains(@text, 'alice')]").getText();
        System.out.println("Login Success Message = "+ loginSuccess);
        androidDriver.findElementByXPath("//android.widget.TextView[contains(@text, 'Logout')]").click();

        stopAndroidDriver();
    }

}

