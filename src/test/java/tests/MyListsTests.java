package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "Aleks21977",
            password = "123123+z";


    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleOneToMyList(name_of_folder);
        } else {
            try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
            ArticlePageObject.addArticlesToMySaved();
        }
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.addArticlesToMySaved();

            ArticlePageObject.waitForTitleElement();

            assertEquals("",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigatin();
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }
}
