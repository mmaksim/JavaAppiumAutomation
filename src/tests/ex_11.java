package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.SearchPageObject;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.MyListsPageObjectFactory;
import lib.UI.factories.NavigationUIFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ex_11 extends CoreTestCase {

    @Test
    public void testSaveTwoArticles() {
        String search_line = "Dead Space";
        String substring_one = "Video game series";
        String substring_two = "Air that does not take part in gas exchange";
        String name_of_folder = "Dead Space folder";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject myListPageObject = MyListsPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring(substring_one);

        articlePageObject.waitForTitleElement();


        if (Platform.getInstance().isAndroid()) {
            substring_one = articlePageObject.getArticleTitle();
            articlePageObject.addArticleToMyList(name_of_folder);
        } else {
            articlePageObject.addArticleToMySaved();
        }
        articlePageObject.closeArticle();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring(substring_two);

        articlePageObject.waitForTitleElement();

        if (Platform.getInstance().isAndroid()) {
            substring_two = articlePageObject.getArticleTitle();
            articlePageObject.addArticleToMyExistList(name_of_folder);
        } else {
            articlePageObject.addArticleToMySaved();
        }

        articlePageObject.closeArticle();

        navigationUI.clickMyList();

        if (Platform.getInstance().isAndroid()) {
            myListPageObject.openFolderByName(name_of_folder);
        }

        myListPageObject.swipeByArticleToDelete(substring_one);
        myListPageObject.openArticleByTitle(substring_two);
        String get_article_title = articlePageObject.getArticleTitle();
        assertEquals("We see unexpected title!", substring_two, get_article_title);
    }

}
