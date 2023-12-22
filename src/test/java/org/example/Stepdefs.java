package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Functionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stepdefs {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options.addArguments("--disable-notifications"));
    Functionalities func=new Functionalities();

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        func.navigate(driver,url);
    }

    @And("entering the username {string}")
    public void enteringTheUsername(String Username) throws InterruptedException {
        func.usernameLogin(driver,Username);
    }

//    @And("password {string}")
//    public void password(String password) throws InterruptedException {
//        func.passwordLogin(driver,password);
//    }

    @And("loging in")
    public void logingIn() throws InterruptedException {
        func.login(driver);
    }

    @And("Verifying OTP")
    public void verifyingOTP() throws InterruptedException {
        func.otpverification(driver);
    }

    @When("moving to fresh BliBli markert")
    public void movingToFreshBliBliMarkert() throws InterruptedException {
        func.freshByBliblimart(driver);
    }

    @And("select category")
    public void selectCategory() throws InterruptedException {
        func.selectCategory(driver);
    }

    @And("add product Directly")
    public void addProductDirectly() throws InterruptedException {
        func.addproductDirectly(driver);
    }

    @And("add {int} products in pdp")
    public void addProductsInPdp(int quantity) throws InterruptedException {
        func.addPrdouct(driver,quantity);
    }

    @And("add the last recommended product")
    public void addTheLastRecommendedProduct() throws InterruptedException {
        func.recommendedProduct(driver);
    }

    @And("checkout the products")
    public void checkoutTheProducts() throws InterruptedException {
        func.checkout(driver);
    }

    @Then("Buy the products")
    public void buyTheProducts() throws InterruptedException {
        func.buy(driver);
    }

    @And("password {string}")
    public void password(String arg0) throws InterruptedException {
        func.passwordLogin(driver,arg0);
    }
}
