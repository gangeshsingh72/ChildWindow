import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChildWindow {

    public static <Takescreenshot> void main(String[] args) {

        /* //>>>>>>>>>>>>>>>>>>   This is for SSl certificates - Code begins  <<<<<<<<<<<<<<<<<<<<<<<<
        //Desired capabilities=
        //general chrome profile
            DesiredCapabilities ch=DesiredCapabilities.chrome();
        //ch.acceptInsecureCerts();
            ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //Belows to your local browser
            ChromeOptions c= new ChromeOptions();
            c.merge(ch);
            System.setProperty("webdriver.chrome.driver", "");
            WebDriver driver=new ChromeDriver(c);

        *///>>>>>>>>>>>>>>>>>>   SSl certificate code ends   <<<<<<<<<<<<<<<<<<<<<<<<



        System.setProperty("webdriver.chrome.driver", "src/main/utilities/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();                 //  maximise the window
        driver.manage().deleteAllCookies();                  //  delete all Cookies
        //driver.manage().deleteCookieNamed("ABCDEF");       //  delete named cookie


        /*//>>>>>>>>>>>>>>>>>>>>>>>   Multiple window Handles begins  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        driver.get("https://the-internet.herokuapp.com/");
        //driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();

            driver.findElement(By.linkText("Multiple Windows")).click();
            driver.findElement(By.cssSelector("a[href*='windows']")).click();

            Set<String> abc = driver.getWindowHandles();
            Iterator<String> it = abc.iterator();
            String parentWindow = it.next();

            driver.switchTo().window(it.next());

            System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

            driver.switchTo().window(parentWindow);
            System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
        //   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     Multiple window Handles ends  <<<<<<<<<<<<<<<<<<<<<<<<<<<<  */

    /*
        //   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Multiple window Handles Example 02 begins  <<<<<<<<<<<<<<<<<<<<<<<<
            //1. Give me the count of links on the page.
            //2. Count of footer section-

        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());       // Counting all links on page
        WebElement footerdriver=driver.findElement(By.id("gf-BIG"));           // Limiting webdriver scope to footer
        System.out.println(footerdriver.findElements(By.tagName("a")).size()); // Count all Links in footer

        //3- Limiting the driver further in Footer section
        WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumndriver.findElements(By.tagName("a")).size());

        //4- Click on each link in the coloumn and check if the pages are opening-
        for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
        {
            //String clickonlinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);             // Holding the control key and enter
            String clickonlinkTab= Keys.chord(Keys.COMMAND,Keys.ENTER);
            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);

        }                                                                          // opens all the tabs

        Set<String> abc=driver.getWindowHandles();                                 //Handling multiple windows
        Iterator<String> it=abc.iterator();

        while(it.hasNext())
        {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
            driver.close();
        }

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Example 02 ends   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    */



        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Example 03 --> Date Selector  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        // Select the date of May 21 on the date on website
        driver.get("https://www.ticketstoindia.co.uk/");

        driver.findElement(By.xpath("//*[@id='FDptDateDDMMYY']")).click();  // Click the date window

        // This is to select Month of May
        while(!driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText().contains("May"))
        {
         driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
        }

        List<WebElement> dates= driver.findElements(By.className("ui-state-default"));   // Select all dates.

        //Grab common attribute//Put into list and iterate
        int count=driver.findElements(By.className("ui-state-default")).size();     // Get the count of all dates

        for(int i=0;i<count;i++)
        {
            String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
            if (text.equalsIgnoreCase("21"))
            {
                driver.findElements(By.className("ui-state-default")).get(i).click();
                break;
            }

        }

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Example 03 ends <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    }
}