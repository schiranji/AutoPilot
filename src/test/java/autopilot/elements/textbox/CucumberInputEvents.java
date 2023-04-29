package autopilot.elements.textbox;

import io.cucumber.java.en.Then;

public class CucumberInputEvents extends SeleniumInputEvents {
    @Then("I see input box with label {string}")
    public void i_see_input_box_with_label(String label) {
        findByLabel(label);
    }

    @Then("I see input box with id {string}")
    public void i_see_input_box(String id) {
        inputById(id);
    }

    @Then("I see input box with name {string}")
    public void i_see_input_box_by_name(String name) {
        inputByName(name);
    }

    @Then("I enter {string} into {string}" )
    public void enterText(String text, String label) {
        try {
            setTextBoxValueByLabel(label, text);
        } catch (Exception e) {
            setTextBoxValueByPlaceholder(label, text);
        }
    }

    @Then("I enter {string} into {string} in {string}" )
    public void enterText(String text, String label, String div) {
        try {
            setTextBoxValueByLabel(label, text, div);
        } catch (Exception e) {
            setTextBoxValueByPlaceholder(label, text, div);
        }
    }

    @Then("I enter {string} into {string} text id" )
    public void enterTextById(String text, String id) {
        setTextBoxValueById(id, text);
    }

    @Then("I enter {string} in textbox named {string}")
    public void enterTextByName(String value, String name) {
        setTextBoxValueByName(name, value);
    }

    @Then("I see {string} in {string} text id placeholder")
    public void iSeeInTextIdPlaceholder(String placeholderText, String id) {
        validatePlaceHolderText(id, placeholderText);
    }
    @Then("I see input box {string} value {string}")
    public void iSeeInputBoxValue(String label, String text) {
        validateTextInInput(label, text);
    }
    @Then("I see input box {string} value {string} in {string}")
    public void iSeeInputBoxValue(String label, String text, String div) {
        validateTextInInput(label, text, div);
    }
    @Then("I see input box id {string} value {string}")
    public void iSeeInputBoxIdValue(String id, String text) {
        validateTextInInputId(id, text);
    }
    @Then("I see input box {string} value contains {string}")
    public void iSeeInputBoxValueContains(String label, String text) {
        validateTextInInputContains(label, text);
    }
}
