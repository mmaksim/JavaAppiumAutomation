package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.MyListPageObject;
import lib.UI.NavigationUI;
import lib.UI.SearchPageObject;
import org.junit.Test;

public class Lesson_6 extends CoreTestCase {

    //Ex3
    @Test
    public void testCancelTheSearch() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Petrozavodsk");
        searchPageObject.assertSearchResultIsMoreOrEqualThan("Petrozavodsk", 1);
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForEmptyMessage();
    }

    //Ex5
    @Test
    public void testSaveTwoArticles() {
        String search_line = "Dead Space";
        String substring_one = "Video game series";
        String substring_two = "Air that does not take part in gas exchange";

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring(substring_one);

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitForTitleElement();
        String article_title_one = articlePageObject.getArticleTitle();
        String name_of_folder = "Dead Space folder";
        articlePageObject.addArticleToMyList(name_of_folder);
        articlePageObject.closeArticle();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring(substring_two);
        articlePageObject.waitForTitleElement();
        String article_title_two = articlePageObject.getArticleTitle();
        articlePageObject.addArticleToMyExistList(name_of_folder);
        articlePageObject.closeArticle();
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickMyList();
        MyListPageObject myListPageObject = new MyListPageObject(driver);
        myListPageObject.openFolderByName(name_of_folder);
        myListPageObject.swipeByArticleToDelete(article_title_one);
        myListPageObject.openArticleByTitle(article_title_two);
        String get_article_title = articlePageObject.getArticleTitle();
        assertEquals("We see unexpected title!", article_title_two, get_article_title);
    }

    //Ex6
    @Test
    public void testCheckTitle() {
        String search_line = "Dead Space";
        String substring = "Air that does not take part in gas exchange";
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring(substring);

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.titleIsNotNull();
    }

    //Ex9*: Рефакторинг темплейта
    @Test
    public void testSearchByTitleAndDescription(){
        String search_line = "Meshuggah";
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);

        searchPageObject.waitForElementByTitleAndDescription("Meshuggah","Swedish metal band");
        searchPageObject.waitForElementByTitleAndDescription("Meshuggah discography","Wikimedia band discography");
        searchPageObject.waitForElementByTitleAndDescription("Meshuggah (EP)","1989 self-titled debut EP by Meshuggah");
    }
}
