import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex18 extends CoreTestCase {

    @Test
    public void testEx18()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java"); //для вывода одного результата поиска ввести Discografia complena
        //try{Thread.sleep(3000);}  catch (Exception e){}//пауза

        String title = "Java";
        String description = "Object-oriented programming language";
        SearchPageObject.waitForElementByTitleAndDescription(title, description);

        int count_articles = SearchPageObject.getAmmountOfFoundArticles();
        System.out.print("Found elements >= 3 and = " + count_articles);
        assertTrue(
                "Elements is not found",
                count_articles > 3
        );
    }
}
