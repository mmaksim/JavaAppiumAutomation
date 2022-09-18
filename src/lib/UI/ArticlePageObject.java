package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "xpath://*[@text='GOT IT']",
            MY_LIST_NAME_INPUT = "xpath://*[@resource-id='org.wikipedia:id/text_input']",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Navigate up']",
            MY_LIST_EXIST = "xpath://*[contains(@text,'{TITLE}')]";

    private static String getMyListExist(String name_of_folder) {
        return MY_LIST_EXIST.replace("{TITLE}", name_of_folder);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "Cannot find 'More options' button", 15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find 'Add to reading list' button", 15);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "Cannot find 'GOT IT' button", 15);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT, "Cannot clear text 'My reading list'", 15);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT, name_of_folder, "Cannot put text into article folder", 15);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON, "Cannot find 'OK' button", 15);
    }

    public void addArticleToMyExistList(String name_of_folder) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "Cannot find 'More options' button", 15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find 'Add to reading list' button", 15);
        String folder_name_xpath = getMyListExist(name_of_folder);
        this.waitForElementAndClick(folder_name_xpath, "Cannot find folder by name " + name_of_folder, 15);
    }

    public void titleIsNotNull() {
        this.assertElementPresent(TITLE, "text", "title of article is not exist");
    }

    public void closeArticle() {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot find X button", 15);
    }
}
