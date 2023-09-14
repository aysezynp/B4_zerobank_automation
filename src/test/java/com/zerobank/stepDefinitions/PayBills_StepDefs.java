package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBills_StepDefs {

PayBillsPage payBillsPage=new PayBillsPage();


    @Then("Validate that user is on the pay bills page")
    public void validate_that_user_is_on_the_pay_bills_page() {
        String actual = Driver.get().getTitle();
        String expected = "Zero - Pay Bills";
        Assert.assertEquals(expected, actual);
    }

    @When("User sends {string} amount to input box")
    public void user_sends_amount_to_input_box(String string) {
        payBillsPage.sendAmount(string);
    }

    @When("USer sends {string} date to input box")
    public void u_ser_sends_date_to_input_box(String string) {
        payBillsPage.sendDate(string);

    }

    @When("User sends {string} data to input box")
    public void user_sends_data_to_input_box(String string) {
        payBillsPage.sendDescription(string);
    }

    @When("User taps on Pay Button")
    public void user_taps_on_pay_button() {
        payBillsPage.tapOnButton();
    }

    @Then("Validate that success message is visible")
    public void validate_that_success_message_is_visible() {
     String actualMessage= payBillsPage.getSuccessMessageText();
     String expect="The payment was successfully submitted.";
     Assert.assertEquals(expect,actualMessage);
    }

    @Then("Validate that error message appears on the amount box")
    public void validate_that_error_message_appears_on_the_amount_box() {
        String expected="Lütfen bu alanı doldurun.";
        String actual=payBillsPage.getAmountErrorMessage();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that error message appears on the date box")
    public void validate_that_error_message_appears_on_the_date_box() {
        String expected="Lütfen bu alanı doldurun.";
        String actual=payBillsPage.getDateErrorMessage();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that date box is still empty")
    public void validate_that_date_box_is_still_empty() {
    Assert.assertTrue(payBillsPage.isDateBoxEmpty());

    }
}
