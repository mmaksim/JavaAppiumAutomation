package lib.UI;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            MY_LISTS_LINK = "xpath://*[@content-desc='My lists']";

    public void clickMyList() {
        this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find 'My lists' button", 15);
    }
}
