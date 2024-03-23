import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAutomation {
    private WebDriver driver;

    public WebAutomation() {
        // Initialize WebDriver (assuming ChromeDriver for this example)
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void performSearch(String keyword, String data[]) {
        switch (keyword.toLowerCase()) {
        	case "launch":
        		launchweb();
        		break;
            case "login":
                registration(data);
                break;
            case "search":
        		searchdesktop();
        		break;
            
        }
    }
    
    private void launchweb()
    {
    	driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }
    
    private void registration(String[] data) {
        WebElement person = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        person.click();
        WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        loginbtn.click();
        WebElement mail=driver.findElement(By.xpath("//*[@id=\"input-email\"]"));  
        mail.sendKeys(data[0]);
        WebElement pass=driver.findElement(By.xpath("//*[@id=\"input-password\"]"));  
        pass.sendKeys(data[1]);
        WebElement submit=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));  
        submit.click();
        
      
      
      
    }
    private void searchdesktop()
    {
    	WebElement desktop= driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
    	desktop.click();
        WebElement opt = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a"));
        opt.click();
    }

    
    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
    	String[] array= {"yuvadaraneep.aids2020@citchennai.net","1@2@3"};
    	WebAutomation search = new WebAutomation();
    	search.performSearch("launch",null);
        search.performSearch("login", array);
        search.performSearch("search", null);
        
        //search.closeBrowser();
    }
}

