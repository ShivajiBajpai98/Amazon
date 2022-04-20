// Add a product to amazon cart only use of jva code with selenium web driver.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AmazonCart {

    @Test
    void addProductToAmazonCart() throws InterruptedException {





                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();



        driver.get("https://www.amazon.in");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("soap");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        // driver.findElement(By.xpath("//*[contains(text(),'Park Avenue Soap')]")).click();
        driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String tab = driver.getWindowHandle();
        // System.out.println(tab);


        Set<String> tabs = driver.getWindowHandles();
        System.out.println(tabs);

        Iterator<String> iterator = tabs.iterator();
        String parentTab = iterator.next();
        String childTab = iterator.next();

        driver.switchTo().window(childTab);

        Thread.sleep(20000);

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
}
