package lib.UI.android;

import io.appium.java_client.AppiumDriver;
import lib.UI.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
        SEARCH_RESULT_BY_SUBSTRING_CONTAINS_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
        SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']/" +
                "../*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
