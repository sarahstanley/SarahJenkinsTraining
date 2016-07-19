package my.samples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{

    @DataProvider(name = "myTest")
    public Object [][] createData(){
    return new Object[][]{
        {"Nac Mac Feegles"},
        {"Granny Weatherwax"},
        {"Nanny Ogg"}
};

    }
    @Test (dataProvider = "myTest")
    public void bingSearch(String mySearch){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.bing.com");
        WebElement searchTextBox = driver.findElement(By.id("sb_form_q"));
        WebElement searchButton = driver.findElement(By.id("sb_form_go"));

        searchTextBox.sendKeys(mySearch);
        searchButton.click();
        // Wait for results to be shown
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains(mySearch));

        // Close the browser
        driver.quit();

    }
}
