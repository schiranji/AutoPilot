package autopilot.elements.datetime;

import io.cucumber.java.en.Then;

public class CucumberDatetimeEvents extends SeleniumDatetimeEvents {
    @Then("I select date today in {string}")
    public void iSelectDateTodayIn(String buttonClass) {
        //TODO implement
        clickButtonByClass(buttonClass);
    }
    @Then("I select date {string} in {string}")
    public void iSelectDateIn(String date, String dateField) {
        //TODO implement
    }

    @Then("I select time {string} in {string}")
    public void iSelectTimeIn(String time, String list) {
        selectTime(list, time);
    }

    @Then("I set focus to element {string}")
    public void iSetFocusToElement(String id) {
        focusOnElement(id);
    }
    @Then("I set focus to element id {string}")
    public void iSetFocusToElementId(String id) {
        focusOnElementById(id);
    }
}
