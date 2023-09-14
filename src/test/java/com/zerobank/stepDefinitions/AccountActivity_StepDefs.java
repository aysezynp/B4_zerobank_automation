package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.*;

public class AccountActivity_StepDefs {
    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @Then("Validate that user is on the account page")
    public void validate_that_user_is_on_the_account_page() {
      String actual= Driver.get().getTitle();
      String  expected="Zero - Account Activity";
        Assert.assertEquals(expected,actual);

    }

    @Then("Validate that the default option in dropdown menu is Savings")
    public void validate_that_the_default_option_in_dropdown_menu_is_savings() {
        String actual = accountActivityPage.getDefaultSelectedElementsText();
        String expected = "Savings";
        Assert.assertEquals(expected, actual);
    }

    @Then("Validate that the dropdown menu has followings")
    public void validate_that_the_dropdown_menu_has_followings(List<String> expected){
        List<String> actual=accountActivityPage.getAllTextDropDownMenu();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that columns have followings")
    public void validate_that_columns_have_followings(List<String> expected) {
        List<String> actual=accountActivityPage.getColumnNames();
        Assert.assertEquals(expected,actual);
    }

}
