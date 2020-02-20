package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        CLICK_SKIP = "xpath://XCUIElementTypeButton[@name='Skip']";
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        CLEAR_BUTTON = "xpath://XCUIElementTypeButton[@name='clear mini']";
        ARTICLE_BY_DESCRIPTION_AND_TITLE = "xpath://XCUIElementTypeLink[@name='{TITLE}\n{DESCRIPTION}']";
        ARTICLE_BY_NAME_APPIUM = "xpath://XCUIElementTypeLink[@name='Appium']";
        ARTICLE_BY_NAME_JAVA = "xpath://XCUIElementTypeLink[contains(@name,'Java (programming language)')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}