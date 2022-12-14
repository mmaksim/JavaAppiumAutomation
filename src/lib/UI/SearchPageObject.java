package lib.UI;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject {

   protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_SUBSTRING_CONTAINS_TPL,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_EMPTY_MESSAGE,
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION;

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }


    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 10);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(
                SEARCH_INPUT, search_line, "Cannot find and type into search input", 15);
    }

    /* Template methods */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementContains(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_CONTAINS_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementByTitleAndDescription(String title, String description) {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }
    /* Template methods */

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 20);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 10);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 10);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button!", 10);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 30);
    }

    public int getAmountOfFoundArticles() {
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 10);
    }

    public void waitForEmptyMessage() {
        this.waitForElementPresent(SEARCH_EMPTY_MESSAGE, "Cannot find empty message", 10);
    }

    public void assertThereIsNoResultOfSearch() {
        this.waitForElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any result", 10);
    }

    public void assertSearchResultIsMoreOrEqualThan(String substring, int compared) {
        String search_result_xpath = getResultSearchElementContains(substring);
        this.assertSearchResultIsMoreOrEqualThan(search_result_xpath, "Result of searching is empty", compared, 30);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        this.waitForElementPresent(getResultSearchElementByTitleAndDescription(title, description),
                "Cannot find search result by title '" + title + "' and description '" + description + "'",
                15);
    }
}
