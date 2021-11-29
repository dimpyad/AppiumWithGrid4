import org.testng.annotations.Test;




/*
 * This is a sample web test opening and closing browser
 */
public class WebAppTests extends BaseTests{


	    
    @Test
    public void testGitlabTitle() {
    	 startWebDriver(platformName);
    	 
    	 System.out.println("The thread ID for this test = "+ Thread.currentThread().getId());

         // Opening URL
         webDriver.get("https://gitlab.com/");
         
         // Extracting page title
         System.out.println("Page title = " + webDriver.getTitle());
         
         stopWebDriver();
    }
    

}

