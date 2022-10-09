package lib.UI;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MY_LIST_EXIST;

    private static String getMyListExist(String name_of_folder) {
        return MY_LIST_EXIST.replace("{TITLE}", name_of_folder);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 20);
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
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

    public void addArticleToMySaved(){
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 15);
    }
}
