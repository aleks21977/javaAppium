package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {


   static {
       FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
               ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
               REMOVE_FROM_SAVED_BUTTON = "xpath://a[contains(@class,'watched')]";////ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]
               ARTICLE_BY_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']";
//               TEXT_APPIUM_IN_SAVE_LIST = "xpath://XCUIElementTypeLink[contains(@name,'Appium')]";
//               NAME_FOR_IOS = "xpath://XCUIElementTypeLink[contains(@name,'Java (programming language)')]";
//               DELETE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Unsave']";
   }

    public MWMyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
