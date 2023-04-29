package autopilot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseCucumberTest extends BaseSelenium {

    @Before
    public void startDriver() {
        setWebDriver();
    }
    @After
    public void quitDriver(Scenario scenario){
        closeBrowser(scenario);
    }

    @Given("I scroll to bottom")
    public void scrollToBottom() {
        scrollToBottomOfPage();
    }
    @Given("I scroll to top")
    public void scrollToTop() {
        scrollToTopOfPage();
    }

    @Given("I scroll to element id {string}")
    public void scrollToElement(String id) {
        scrollToElementById(id);
    }
    @Given("I scroll to element name {string} {int}")
    public void scrollToElement(String name, int index) {
        scrollToElementByName(name, index);
    }
    @Given("I scroll to element tag {string}")
    public void scrollToElementTag(String tag) {
        scrollToElementByTag(tag);
    }

    @Then("I see message {string} in div {string}")
    public void validateSuccessModalMessage(String message, String divId) {
        matchDivText(message, divId);
    }

    @Given("As {string} user")
    public void as_user(String userType) {

    }
    @When("I navigate to {string}")
    public void i_navigate_to_page(String pageName) {
        switch (pageName) {
            case "homepage" -> gotoPage(HOME_PAGE);
            case "new-homepage" -> gotoPage(HOME_PAGE + "/page/index");
            default -> gotoPage(pageName.startsWith("/") ? HOME_PAGE + pageName : pageName);
        }
    }
    @When("I click on first {string}")
    public void clickOnFirst(String name) {
        elementsByName(name).get(0).click();
    }

    @Then("I see {string} page")
    public void displayedPage(String pageName) {
        String url = switch (pageName) {
            case "home" -> HOME_PAGE;
            case "new-homepage" -> HOME_PAGE + "/static/event/theme2/index.html";
            case "event-detail" -> HOME_PAGE + "/event";
            case "manage-event" -> HOME_PAGE + "/page/manage-event";
            case "my-groups" -> HOME_PAGE + "/page/manage-groups";
            case "create-event" -> HOME_PAGE + "/page/create-event";
            case "my-events" -> HOME_PAGE + "/page/manage-events";
            case "about-us" -> HOME_PAGE + "/page/about-us";
            case "blog" -> HOME_PAGE + "/page/blog";
            case "contact-us" -> HOME_PAGE + "/page/contact-us";
            case "settings" -> HOME_PAGE + "/page/settings";
            case "rsvp" -> HOME_PAGE + "/event/rsvp";
            case "cart" -> HOME_PAGE + "/event/cart";
            case "change-password" -> HOME_PAGE + "/page/change-password";
            case "my-tickets" -> HOME_PAGE + "/page/my-tickets";
            case "privacy-policy" -> HOME_PAGE + "/page/privacy";
            case "my-new-profile" -> HOME_PAGE + "/page/my-profile";
            case "ca-consumer-policy" -> HOME_PAGE + "/page/ca-privacy";
            case "terms-of-service" -> HOME_PAGE + "/page/terms";
            case "cookie-policy" -> HOME_PAGE + "/page/cookie-policy";
            case "feedback" -> HOME_PAGE + "/page/feedback";
            case "facebook" -> "https://www.facebook.com/funzippyevents";
            case "twitter" -> "https://twitter.com/eventsfunzippy";
            case "instagram" -> "https://www.instagram.com/stories/funzippyevents/";
            case "pintrest" -> "https://www.pinterest.com/funzippyevents/";
            case "linkedin" -> "https://www.linkedin.com/in/funzippy-events-nearyou";
            case "my-profile" -> HOME_PAGE + "/user/profile/edit";
            default -> HOME_PAGE + pageName;
        };
        validateUrlStartWith(url);
    }

    @Then("I see external page {string}")
    public void displayedExternalPage(String page) {
        validateUrlContains(page);
    }


    @Then("I see div list with name {string}")
    public void i_see_div_list(String name) {

    }

    @Then("I sleep {int} seconds")
    public void sleep(int seconds) {
        sleepFor(seconds);
    }

    @Then("I switch to modal {string}")
    public void switchToModal(String modalId) {
        switchToModalDialog(modalId);
    }

    @Then("I read {string} in tag {string}")
    public void iReadInTag(String text, String tag) {
        tagTextEquals(tag, text);
    }
    @Then("I read text contains {string} in tag {string}")
    public void iReadTextContainsInTag(String text, String tag) {
        tagTextContains(tag, text);
    }
    @Then("I read text contains {string} in tag {string} index {int}")
    public void iReadTextContainsInTag(String text, String tag, int index) {
        tagTextContains(tag, text, index);
    }

    @Then("I wait for modal class {string} close")
    public void iWaitForModalClassClose(String modalClose) {
        waitForModalToClose(modalClose);
    }
}
