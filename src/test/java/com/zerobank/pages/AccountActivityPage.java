package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath = "//select[@id='aa_accountId']")
    private WebElement dropDownMenu;


    @FindBy(xpath = "//thead//th") //thead başlıklar için
    private List<WebElement> columnElements;


    public String getDefaultSelectedElementsText() {
        Select select = new Select(dropDownMenu);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return BrowserUtils.getText(firstSelectedOption);
    }

    public List<String>getAllTextDropDownMenu(){
        Select select = new Select(dropDownMenu);
        List<WebElement> options = select.getOptions();
        return BrowserUtils.getElementsText(options);
    }

    public List<String> getColumnNames(){
       return BrowserUtils.getElementsText(columnElements);
    }
}
