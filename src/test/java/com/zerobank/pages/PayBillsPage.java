package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.BrokenBarrierException;

public class PayBillsPage extends BasePage{

    @FindBy (css = "#sp_amount")
    private WebElement amountInputBox;

    @FindBy (id = "sp_date")
    private WebElement dateInputBox;

    @FindBy (id = "sp_description")
    private WebElement descriptionInputBox;

    @FindBy (id = "pay_saved_payees")
    private WebElement payBtn;

    @FindBy(css = "[id='alert_content']>span")
    private WebElement successMessage;

    public void sendAmount(String str){
        BrowserUtils.sendKeys(amountInputBox,str);
    }

    public void sendDate(String str){
        BrowserUtils.sendKeys(dateInputBox,str);
    }

    public void sendDescription(String str){
        BrowserUtils.sendKeys(descriptionInputBox,str);
    }

    public void tapOnButton(){
        BrowserUtils.clickWithJS(payBtn);
    }

    public String getSuccessMessageText(){
       return BrowserUtils.getText(successMessage);
    }

    public String getAmountErrorMessage(){
       return amountInputBox.getAttribute("validationMessage");
    }

    public  String getDateErrorMessage(){
        return dateInputBox.getAttribute("validationMessage");
    }
   public boolean isDateBoxEmpty(){
        return dateInputBox.getAttribute("value").isEmpty();
    }


}
