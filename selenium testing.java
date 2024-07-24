package Testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://magento.softwaretestingboard.com/");

        Thread.sleep(2000);

        
        assert driver.getTitle().contains("Luma") : "Test Case 1 Failed: Incorrect page";

        Thread.sleep(2000);

        // Print the URL and title of the page
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Current Title: " + driver.getTitle());

        Thread.sleep(2000);

        
        WebElement menLink = driver.findElement(By.linkText("Men"));
        menLink.click();

        Thread.sleep(2000);

        WebElement topsLink = driver.findElement(By.linkText("Tops"));
        topsLink.click();

        Thread.sleep(2000);

        
        WebElement Hoodies = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]"));
        Hoodies.click();

        Thread.sleep(2000);

        WebElement BothSweashirt = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a" ));
        BothSweashirt.click();

        Thread.sleep(5000);
        
        
        WebElement priceSort = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]"));
        priceSort.click();

        
        WebElement priceFilter = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[2]/a"));
        priceFilter.click();

        Thread.sleep(2000);

        // Selecting  any hoodie of our choice
        WebElement hoodieItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img"));
        hoodieItem.click();
        

        Thread.sleep(5000);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(5000);

        // Select a size and colour
        WebElement sizeXL = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));
        sizeXL.click();

        Thread.sleep(3000);

        WebElement color = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-51\"]"));
        color.click();

        Thread.sleep(5000);

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        addToCartButton.click();

        Thread.sleep(5000);

        
        WebElement goToCartButton = driver.findElement(By.xpath("//a[@class='action showcart']"));
        goToCartButton.click();

        WebElement VeiwCart= driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span"));
        VeiwCart.click();

        Thread.sleep(5000);

        WebElement ProceedToCheckout = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
        ProceedToCheckout.click();

        Thread.sleep(5000);

//      Gmail
        driver.findElement(By.xpath("//*[@id=\"customer-email\"]")).sendKeys("akmalyasheenw@gmail.com");
        Thread.sleep(10000);

//        First Name
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Akmal");
        Thread.sleep(2000);

//        last name
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Mohammed Yasheen");
        Thread.sleep(2000);

//        address
        driver.findElement(By.xpath("//*[@name='street[0]']")).sendKeys("Kuutuparambha");
        Thread.sleep(2000);

//        city
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Kozhikode");

        Thread.sleep(2000);
        
        Select country = new Select(driver.findElement(By.xpath("//*[@name='country_id']")));
        country.selectByVisibleText("India");



        Select state = new Select(driver.findElement(By.xpath("//*[@name='region_id']")));
        state.selectByVisibleText("Kerala"); // Replace "State Name" with the actual state name


        Thread.sleep(2000);

//        postal code
        WebElement Postcode = driver.findElement(By.xpath("//*[@name='postcode']"));
        Postcode.sendKeys("670001");

        

        Thread.sleep(2000);

        WebElement phoneField = driver.findElement(By.xpath("//*[@name='telephone']"));
        phoneField.sendKeys("8975757575");

//        next button

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();

        Thread.sleep(10000);
        
        
//         we place the order now

        driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
        
     //  we print the order number after placing the order for tracking
        Thread.sleep(5000);
        WebElement orderNumberElement = driver.findElement(By.xpath("//*[contains(text(),'Your order # is:')]"));
        String orderNumberText = orderNumberElement.getText();
        String orderNumber = orderNumberText.split(": ")[1].trim(); // Extract the order number
        System.out.println("Order Number: " + orderNumber);


    }
}