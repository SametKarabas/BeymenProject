package StepDefinitions;

import Pages.HomePage;
import Pages.ShopPage;
import Utils.ExcelUtils;
import Utils.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.util.ArrayList;



public class BeymenSteps {

    HomePage hp=new HomePage();
    ShopPage sp=new ShopPage();


    ArrayList<ArrayList<String>> list=
            ExcelUtils.getListData("src/test/java/ApachePOI/CucumberExcel.xlsx","Sayfa1",1);

    @Given("Navigate to Beymen")
    public void navigateToBeymen() {
        GWD.getDriver().get("https://www.beymen.com/");
        hp.findAndClick("cokies");
    }

    @When("Verify open the Beymen")
    public void verifyOpenTheBeymen() {
        hp.findAndContains("siparis","Sipariş Takibi");
    }

    @And("First stage with search")
    public void firstStageWithSearch() {
        hp.findAndSend("searchInput",list.get(0).get(0));
    }

    @Then("Clean the search box")
    public void cleanTheSearchBox() {
        hp.getSearchInput().sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
    }

    @Then("Second stage with search")
    public void secondStageWithSearch() {
        hp.findAndSend("searchInput",list.get(1).get(0));
    }

    @And("Push the enter key")
    public void pushTheEnterKey() {
        Actions actions=new Actions(GWD.getDriver());
        Action action=actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        action.perform();
    }

    @And("Choose a random product")
    public void chooseARandomProduct() {
        sp.findAndClick("product");
    }

    @And("Export selected product information to txt file")
    public void exportSelectedProductInformationToTxtFile() {


        FileWriter fw = null;
        String path = "src/test/java/ApachePOI/ProductDetails.txt";
        try {
            fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Price :" + sp.getPrice().getText());
            pw.println("Product :" + sp.getProductDetail().getText());
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @And("The selected product is added to the cart")
    public void theSelectedProductIsAddedToTheCart() {
        sp.findAndClick("size");
        sp.findAndClick("addBasket");
    }

    @And("Product price comparison")
    public void productPriceComparison() {
        if (sp.getPrice() == sp.getBasketPrice())
            System.out.println("Fiyatlar Aynı");
        else
            System.out.println("Fiyatlar Aynı Değil");
    }

    @And("Increase the amount of product verify the product number")
    public void ıncreaseTheAmountOfProductVerifyTheProductNumber() {
        sp.findAndClick("basket");
        Select select=new Select(sp.getPiece());
        select.selectByValue("2");
        sp.findAndContains("piece","2 adet");
    }

    @Then("Verify that the cart is empty by deleting the items from the cart")
    public void verifyThatTheCartIsEmptyByDeletingTheItemsFromTheCart() {
        sp.findAndClick("delete");
        sp.findAndContains("deleteVerify","BULUNMAMAKTADIR");
    }
}
