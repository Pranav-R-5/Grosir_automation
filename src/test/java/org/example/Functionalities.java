package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Functionalities {
    public  void navigate(WebDriver driver,String url){
        driver.get(url);
        String title= driver.getTitle();
        driver.manage().window().maximize();
        Assert.assertTrue(title.equals("Title Category"));
    }
    public void usernameLogin(WebDriver driver,String username) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
        } catch (Exception e) {
            System.out.println("No pop up");
        }
        driver.findElement(By.xpath("//button[@class='blu-btn btn__login b-outline b-small']")).click();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='text-field']/input"))));
        Thread.sleep(4000);
        WebElement email = driver.findElement(By.xpath("//div[@class='text-field']/input"));
        String label=driver.findElement(By.xpath("//div[@class='text-field']/label")).getText();

        email.click();
        email.sendKeys("grocerypayment@gdn-commerce.com");
        Assert.assertTrue(label.equals("Email/nomor HP"));


    }
    public void passwordLogin(WebDriver driver,String pass) throws InterruptedException {

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
//        String label=driver.findElement(By.xpath("//div[@class='blu-field login__password-container has-value has-password b-dark']/label")).getText();

        password.click();
        password.sendKeys(pass);
//        Assert.assertTrue(label.equals("Kata sandi"));
    }
    public void login(WebDriver driver) throws InterruptedException {

        WebElement loginButton=driver.findElement(By.xpath("//div[@class='login__button']/button"));
        loginButton.click();
    }
    public void otpverification(WebDriver driver) throws InterruptedException{
        Thread.sleep(5000);
        WebElement enter=driver.findElement(By.xpath("//div[@class='otp-type-selection__send']/button"));
        enter.click();
        Thread.sleep(1000);
        List<WebElement> otpfield=driver.findElements(By.xpath("//ul[@class='otp__codeField']/li"));
        System.out.println(otpfield.size());
        for(WebElement ele:otpfield){
            WebElement key=ele.findElement(By.xpath("//input[@class='otp__textField space active']"));
            key.click();
            key.sendKeys("3");
        }

    }

    public  void freshByBliblimart(WebDriver driver) throws InterruptedException{
        Thread.sleep(5000);
        WebElement mart=driver.findElement(By.xpath("//div[@class='favourite__content']/a"));
        mart.click();
        Thread.sleep(5000);
        WebElement cancel=driver.findElement(By.xpath("//div[@class='blu-modal__footer']/button"));
        cancel.click();
    }
    public  void selectCategory(WebDriver driver) throws InterruptedException{
        Thread.sleep(1000);
        WebElement categoryIcon=driver.findElement(By.xpath("//div[@class='category']/div[@class='category-trigger']"));
        categoryIcon.click();
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='category-dropdown-item']"));
        WebElement susur=list.get(1);
        Thread.sleep(1000);
        susur.click();
        List<WebElement> list1=driver.findElements(By.xpath("//div[@class='c2']/div[@class='category-dropdown-item']"));
        WebElement elements=list1.get(2);
        elements.click();
    }

    public void addproductDirectly(WebDriver driver)throws InterruptedException{
        Thread.sleep(3000);
        try{
        driver.findElement(By.xpath("//section[@class='blu-modal__header-main--item-leading']")).click();}
        catch(Exception e){}
        List<WebElement> productList=driver.findElements(By.xpath("//div[@class='input-stepper']"));
        System.out.println(productList.size());
        WebElement product1=productList.get(0);
        product1.click();
        try{
            Thread.sleep(2000);
            driver.findElement(By.xpath("//section[@class='blu-modal__header-main--item-leading']")).click();}
        catch(Exception e){}
        Thread.sleep(2000);
        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@class='onboarding-tooltip__footer b-footer-default']/button")).click();
        }catch(Exception e){}
        Thread.sleep(2000);
        WebElement product2=productList.get(3);
        product2.click();
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='onboarding-tooltip__footer b-footer-default']/button")).click();
        }catch(Exception e){}

    }

    public void addPrdouct(WebDriver driver,int quantity) throws  InterruptedException{
        Thread.sleep(2000);
        List<WebElement> productList=driver.findElements(By.xpath("//main[@class='product-card']"));
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//section[@class='blu-modal__header-main--item-leading']")).click();
        }catch(Exception e){}
        Thread.sleep(2000);
        productList.get(5).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='grocery-sticky-cta__container-price-button']/button")).click();
        WebElement addQuantity = driver.findElement(By.xpath("//div[@class='blu-input-stepper']/button[@class='blu-btn blu-input-stepper__plus b-ghost b-secondary']"));
        while(quantity>1) {
            addQuantity.click();
            quantity--;
        }

    }
    public void recommendedProduct(WebDriver driver) throws InterruptedException{
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1100)","");

        Thread.sleep(2000);
        WebElement next=driver.findElement(By.xpath("//span[@class='container-button']"));
        next.click();
        Thread.sleep(2000);
        List<WebElement> list=driver.findElements(By.xpath("//button[@class='blu-btn quantity-button b-white']"));
        list.get(list.size()-1).click();

    }
    public void checkout(WebDriver driver)throws  InterruptedException{
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='buy-chip']")).click();
    }

    public void buy(WebDriver driver)throws InterruptedException{
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-100)","");
        Thread.sleep(6000);
        WebElement buy=driver.findElement(By.xpath("//button[@class='blu-btn mobile-footer__content__total__button pay-button has-left-icon b-secondary']/div"));
        buy.click();

    }
}
