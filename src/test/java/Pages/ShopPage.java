package Pages;

import Utils.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShopPage extends Parent{

    public ShopPage(){
        PageFactory.initElements(GWD.getDriver(),this);
    }


    @FindBy(xpath = "(//div[@class=\"m-productImageList\"])[2]")
    private WebElement product;
    //secilen urun

    @FindBy(id = "priceNew")
    private WebElement price;
    //ürünün sepete eklenmeden önceki fiyatı

    @FindBy(xpath = "//span[@class='o-productDetail__description']")
    private WebElement productDetail;
    //ürün detayları


    @FindBy(id = "addBasket")
    private WebElement addBasket;
    //sepete ekleme


    @FindBy(xpath = "//span[text()='M']")
    private WebElement size;
    //ürün bedeni


    @FindBy(xpath = "//a[@href='/cart'][1]")
    private WebElement basket;
    //sepet


    @FindBy(xpath = "(//span[@class=\"m-orderSummary__value\"])[1]")
    private WebElement basketPrice;
    //sepetteki fiyat


    @FindBy(id = "quantitySelect0-key-0")
    private WebElement piece;
    //adet


    @FindBy(id = "removeCartItemBtn0-key-0")
    private WebElement delete;
    //ürünleri silme

    @FindBy(xpath = "(//strong[@class=\"m-empty__messageTitle\"])[1]")
    private WebElement deleteVerify;

    public WebElement getDeleteVerify() {
        return deleteVerify;
    }

    public WebElement getPiece() {
        return piece;
    }

    public WebElement getBasketPrice() {
        return basketPrice;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getProductDetail() {
        return productDetail;
    }

    WebElement myElement;
    public void findAndClick(String strElement){
        switch (strElement){
            case "product":myElement=product;break;
            case "addBasket":myElement=addBasket;break;
            case "basket":myElement=basket;break;
            case "delete":myElement=delete;break;
            case "size":myElement=size;break;
        }
        clickFunction(myElement);
    }

    public void findAndContains(String strElement,String text){
        switch (strElement){
            case "basketPrice":myElement=basketPrice;break;
            case "deleteVerify":myElement=deleteVerify;break;
            case "piece":myElement=piece;break;
        }
        verifyContainsText(myElement,text);
    }
}
