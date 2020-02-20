package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
            CLICK_SKIP = "xpath://*[contains(@text, 'SKIP')]";
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
            SEARCH_INPUT = "xpath://*[contains(@text, 'Search Wikipedia')]";
            SEARCH_CANCEL_BUTTON = "className:android.widget.ImageButton";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[contains(@text,'{SUBSTRING}')]";
            SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup";
            SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
            CLEAR_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_close_btn']";
            ARTICLE_BY_DESCRIPTION_AND_TITLE = "xpath://android.view.ViewGroup/android.widget.TextView[@text='{TITLE}']/../android.widget.TextView[@text='{DESCRIPTION}']";
            ARTICLE_BY_NAME_APPIUM = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
