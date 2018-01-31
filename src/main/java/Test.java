import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
    public static WebDriver driver;

    public Test() {
        simpleTest();

    }

    public void simpleTest() {
        //PhantomJsDriverManager.getInstance().version("2.1.1").setup();
        //driver = new PhantomJSDriver();

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();


        driver.get("https://ru.aliexpress.com/ru_home.htm");
        WebElement search =
                driver.findElement(By.id("search-key"));
        search.sendKeys("adidas");

        WebElement buttonSearch =
                driver.findElement(By.className("search-button"));
        buttonSearch.submit();
        WebElement delivery =
                driver.findElement(By.className("check-icon"));
        delivery.click();


        WebElement element = driver.findElement(By.cssSelector("a.picRind.history-item "));
        // element.click();
        String href = element.getAttribute("href");
        driver.get(href);


        WebElement ranting = driver.findElement(By.id("j-customer-reviews-trigger"));
        Actions builder = new Actions(driver);
        builder.moveToElement(ranting).perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*WebElement search =
                driver.findElement(By.xpath("//*[@class='text-field text-field_large search__input js-search-field']"));
        search.sendKeys("adidas");

        WebElement buttonSearch =
                driver.findElement(By.xpath("//*[@class='button button_blue search__button js-search-button']"));
        buttonSearch.submit();
        */

        driver.quit();
    }
}
