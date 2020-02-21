import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex17 extends CoreTestCase
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
            //try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
            ArticlePageObject.addArticlesToMySaved();
        }
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
         }
        ArticlePageObject.addArticlesToMySaved();
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        ArticlePageObject.waitForTitleElement();

        assertEquals("",
                article_title,
                ArticlePageObject.getArticleTitle()
        );
        ArticlePageObject.closeArticle();


        //сохраняем вторую статью
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        SearchPageObject.initSearchInput();
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        SearchPageObject.typeSearchLine("Rimini");
        String article2_dataid = "80351";
        SearchPageObject.clickByArticleWithSubstring("ity in Emilia-Romagna, Italy");
        ArticlePageObject.waitForTitleElement();
        String article2_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticlesToMySaved();
        ArticlePageObject.waitForTitleElement();

        assertEquals("",
                article2_title,
                ArticlePageObject.getArticleTitle()
        );
        ArticlePageObject.closeArticle();


        //переходим в список сохранненых статей MyList
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        NavigationUI.openNavigatin();
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки
        MyListsPageObject.swipeByArticleToDelete(article_title);
        try{Thread.sleep(2000);}  catch (Exception e){}//пауза для отладки

        assertEquals("",
                article2_dataid,
                ArticlePageObject.getDataId()
        );
    }
}
