package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "css:#content h1";
        FIND_DATA_ID = "xpath://li[contains(@data-id,'80351')]";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch.mw-ui-icon-with-label-desktop";
        OPTIONS_ADD_TO_MY_LIST_BUTTON2 = "css:#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[contains(@title,'Remove this page from your watchlist')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON2 = "xpath://a[contains(@title,'Unwatch')]";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
