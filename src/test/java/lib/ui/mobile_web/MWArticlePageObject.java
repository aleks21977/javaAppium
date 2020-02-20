package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions-watch>#ca-watch.menu__item--page-actions-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-action li#ca-watch.mw-ui-icon-wikimedia-unStar-progressive watched button";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
