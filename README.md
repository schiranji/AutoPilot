# AutoPilot
Test Framework

The "AutoPilot" framework is a powerful and intuitive tool for creating automated tests without needing to write Java code. It's built to be user-friendly, with an easy-to-use interface that allows automation testers and product owners to quickly create and run tests, even if they don't have extensive programming knowledge.
It is Built on Cucumber, makes it easy for automation testers and product owners to transition to.

Advantage of using this framework is write feature file and tester is done with. May need enhancements to framework. But it is not required to write a web page class for each page and lot of java clode to support it.
Also the feature steps simulates exactly how a user enters values in browser. Easy to undestand, easy to write, easy to modify tests in case of changes on web page.

AutoPilot is a powerful and user-friendly automated testing framework that is designed to make it easy for automation testers and product owners to create and run tests without needing to write Java code. With AutoPilot, you can improve the efficiency and quality of your testing processes, while reducing the time and resources required to create and maintain automated tests.


Start writing features at test/resources/


Available clause syntax. Open for other improvements.

* Link
  * I click {string} link
  * I click link containing {string}
  * I click {string} link id

* Button
 * I click {string} button id
 * I click {string} button name
 * I click {string} {int} button name
 * I click {string} button
 * I click {string} button in {string} div
 * I see {string} button text {string}

* Checkbox
 *  I click {string} checkbox id
 
* Div
 * I see div {string} display message {string}
 * I see div {string} contains text {string}
 * I see {string} div id show

* Radio
 * I click {string} radio
 * I click {string} radio id

* Select
 * I see select box with id {string}
 * I see dropdown with label {string}
 * I select {string} into {string} dropdown id
 * I select {string} into {string} dropdown
 * I select {string} into {string} multiselect dropdown

* Span
 * I click {string} span containing text

* Textarea
 * I enter {string} in textarea {string}

* textbox
 * I see input box with label {string}
 * I see input box with id {string}
 * I see input box with name {string}
 * I enter {string} into {string}" )
 * I enter {string} into {string} in {string}" )
 * I enter {string} into {string} text id" )
 * I enter {string} in textbox named {string}
 * I see {string} in {string} text id placeholder
 * I see input box {string} value {string}
 * I see input box {string} value {string} in {string}
 * I see input box id {string} value {string}
 * I see input box {string} value contains {string}

* Typeahead
 * I select option {int} in type ahead into {string} 

* General
  *    I see message {string} in div {string}
  *    I see {string} page
  *    I see external page {string}
  *    I see div list with name {string}
  *    I sleep {int} seconds
  *    I switch to modal {string}
  *    I read {string} in tag {string}
  *    I read text contains {string} in tag {string}
  *    I read text contains {string} in tag {string} index {int}
  *    I wait for modal class {string} close


  *    @Given("I scroll to bottom")
  *    @Given("I scroll to top")
  *    @Given("I scroll to element id {string}")
  *    @Given("I scroll to element name {string} {int}")
  *    @Given("I scroll to element tag {string}")
  *    @Given("As {string} user")
  *    @When("I navigate to {string}")
  *    @When("I click on first {string}")
   

