package autopilot.elements.select;

import io.cucumber.java.en.Then;

public class CucumberSelectEvents extends SeleniumSelectEvents {
    @Then("I see select box with id {string}")
    public void i_see_select_box(String id) {
        selectById(id);
    }
    @Then("I see dropdown with label {string}")
    public void i_see_select_box_with_label(String label) {
        findByLabel(label);
    }
    @Then("I select {string} into {string} dropdown id")
    public void i_select_select_box_with_id(String value, String id) {
        setSelectValueById(id, value);
    }
    @Then("I select {string} into {string} dropdown")
    public void iSelectIntoSelect(String value, String label) {
        setSelectValueByLabel(label, value);
    }
    @Then("I select {string} into {string} multiselect dropdown")
    public void iSelectIntoMultiSelect(String value, String label) {
        setMultiSelectValueByLabel(label, value);
    }
}
