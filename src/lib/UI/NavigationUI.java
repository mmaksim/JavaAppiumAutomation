package lib.UI;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            MY_LISTS_LINK;

    public void clickMyList() {
        this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find 'My lists' button", 15);
    }
}
