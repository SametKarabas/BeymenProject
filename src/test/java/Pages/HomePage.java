package Pages;

import Utils.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Parent{

    public HomePage(){
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "//a[@title='Sipariş Takibi']")
    private WebElement siparis;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cokies;

    @FindBy(xpath = "//input[@class=\"default-input o-header__search--input\"]")
    private WebElement searchInput;

    public WebElement getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(WebElement searchInput) {
        this.searchInput = searchInput;
    }

    WebElement myElement;
    public void findAndSend(String strElement,String value){
        switch (strElement){
            case "searchInput":myElement=searchInput;break;
        }
        sendKeyFunction(myElement,value);
    }

    public void findAndClick(String strElement){
        switch (strElement){
            case "cokies":myElement=cokies;break;
        }
        clickFunction(myElement);
    }

    public void findAndContains(String strElement,String text){
        switch (strElement){
            case "siparis":myElement=siparis;break;

        }
        verifyContainsText(myElement,text);
    }
}
