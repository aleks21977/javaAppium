package lib.ui.android;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListsPageObject {
    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']"; //"//*[@text='{TITLE}']",
        ARTICLE_BY_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']";
        NAME_ARTICLE_TITLE_IN_SAVE_LIST = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";

    }

    public AndroidMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
