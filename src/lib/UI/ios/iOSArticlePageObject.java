package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://XCUIElementTypeOther[contains(@name,'banner')]";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='Content is available under']" +
                "/following-sibling::XCUIElementTypeLink[@name='CC BY-SA 3.0']" +
                "/following-sibling::XCUIElementTypeStaticText[@name='unless otherwise noted.']";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        ADD_TO_MY_LIST_OVERLAY = "xpath://XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[contains(@name='to a reading list?')]";
        MY_LIST_NAME_INPUT = "xpath://XCUIElementTypeStaticText[@name='Reading list name']/following-sibling:XCUIElementTypeTextField";
        MY_LIST_OK_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeNavigationBar[@name='W']";
        MY_LIST_EXIST = "id:{FOLDER_NAME}";
    }

    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

}
