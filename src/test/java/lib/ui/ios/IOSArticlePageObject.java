package lib.ui.ios;

import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject { //было MainPageObject

    private static final String
        TITLE = "xpath://XCUIElementTypeOther[@name='Appium']",
        TITLE1 = "xpath://XCUIElementTypeLink[contains(@name,'Appium')]",
        TITLE2 = "xpath://XCUIElementTypeLink[contains(@name,'Java')]",
        CLEAR_BUTTON = "xpath://XCUIElementTypeButton[@name=\"clear mini\"]",
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
        ADD_TO_MY_LIST_BUTTON1 = "xpath://XCUIElementTypeButton[@name='Share']",
        ADD_TO_MY_LIST_BUTTON2 = "id:Add to reading list",//xpath://XCUIElementTypeButton[@name=Add]",
        ADD_TO_MY_LIST_BUTTON3 = "id:Add",
        GOT_IT_OVERLAY = "xpath://XCUIElementTypeButton[@name='places auth close']",
        CREATE_NEW = "xpath://XCUIElementTypeButton[@name='Add']",
        INPUT_NAME_SAVE_FOLDER = "xpath://XCUIElementTypeButton[@name='clear mini']/../../XCUIElementTypeTextField",
        MY_LIST_OK_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']",
        CLOSE_ARTICLE_BUTTON = "id:Back",
        MY_LIST_NAME_INPUT = "id:Learning programming",
        ADD_TO_READING_LIST_BUTTON = "xpath://XCUIElementTypeButton[contains(@name,'to a reading list?')]",
        UNSAVE_READING_LIST_BUTTON = "id:Add to reading list",


    FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']",
    ARTICLE_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']", //"//*[@text='{TITLE}']",
    ARTICLE_BY_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']",
    TEXT_APPIUM_IN_SAVE_LIST = "xpath://XCUIElementTypeLink[contains(@name,'Appium')]",
    NAME_FOR_IOS = "xpath://XCUIElementTypeLink[contains(@name,'Java (programming language)')]",
    DELETE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Unsave']";



    public IOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 10);
    }

    public WebElement waitForTitleElement1()
    {
        return this.waitForElementPresent(TITLE1, "Cannot find article title on page!", 10);
    }

    public WebElement waitForTitleElement2()
    {
        return this.waitForElementPresent(TITLE2, "Cannot find article title on page!", 10);
    }



    private static String getFolderXpathByName(String name_of_folder)//ИМЯ ПАПКИ Learning programming
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSaveArticleXpathByDescription(String article_description) //ОПИСАНИЕ СТАТЬИ Object-oriented programming language
    {
        return ARTICLE_BY_DESCRIPTION_TPL.replace("{DESCRIPTION}", article_description);
    }




//    public String getArticleTitle()
//    {
//        WebElement title_element = waitForTitleElement();
//        return title_element.getAttribute("name");
//    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForLableElement();
        return title_element.getAttribute("label");
    }

    public String getXpathArticle1()
    {
        WebElement title_element = waitForElementPresent(TITLE1, "Cannot find article title on page!", 10);
        return title_element.getAttribute("id");

    }


    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleOneToMyList(String name_of_folder)
    {
        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON1,
                "Cannor find button to add article to reading list1",
                5
        );


        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON2,
                "Cannor find button to add article to reading list2",
                5
        );


        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON3,
                "Cannor find button to add article to reading list3",
                5
        );


        // вводим название папки Learning programming
        this.waitForElementAndSendKeys(
                INPUT_NAME_SAVE_FOLDER,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        //кликаем по кнопке ОК
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,//"//*[@text='OK']"
                "Cannot press OK button",
                5
        );

    }

    public void addArticleToMyList(String name_of_folder)
    {
        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON1,
                "Cannor find button to add article to reading list1",
                5
        );


        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON2,
                "Cannor find button to add article to reading list2",
                5
        );


        waitForElementAndClick(
                MY_LIST_NAME_INPUT,
                "Cannor find save list 'Learning programming'",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,//"//android.widget.ImageButton[@content-desc='Navigate up']"
                "Cannot close article, cannot find Exit button",
                5
        );
    }


    public void clearSearchLine()
    {
        waitForElementAndClick(
                CLEAR_BUTTON,
                "Cannor find clear button",
                5
        );
    }



    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);//ВЕРНО
        this.waitForElementAndClick(
                folder_name_xpath,//"//*[@text='" + name_of_folder + "']"
                "Cannot find folder by name " + name_of_folder,
                10
        );
    }

    public void waitForArticleToAppearByDescription(String article_description)
    {
        String description_xpath = getSaveArticleXpathByDescription(article_description);
        this.waitForElementPresent(description_xpath, "Cannot find saved article by title " + article_description, 10);
    }

    public void waitForArticleToAppearByTitle(String title_xpath)
    {
        ///String title_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementPresent(title_xpath, "Cannot find saved article by title ", 10);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String title_xpath = getSaveArticleXpathByDescription(article_title);
        this.waitForElementNotPresent(title_xpath, "Saved article still present with title " + article_title, 10);
    }

    public void swipeByArticleOneToDelete(String article_description)
    {
        this.waitForArticleToAppearByDescription(article_description);
        String description_xpath = getSaveArticleXpathByDescription(article_description);
        this.swipeElementToLeft(
                description_xpath,//"//*[@text='Object-oriented programming language']"
                "Cannot find save article"
        );
        this.waitForArticleToDisappearByTitle(article_description);
    }


    public void swipeByArticleToDelete()
    {
        String article_xpath = NAME_FOR_IOS;
        this.waitForArticleToAppearByTitle(article_xpath);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find save article"
        );
        this.closeAlertForDeleteArticle();
        //this.waitForArticleToDisappearByTitle(article_xpath);
    }

    public void closeAlertForDeleteArticle()
    {
        this.waitForElementAndClick(DELETE_ARTICLE_BUTTON, "Cannot find delete button", 10);
    }



    public WebElement waitForLableElement()
    {
        return this.waitForElementPresent(TEXT_APPIUM_IN_SAVE_LIST, "Cannot find article with Appium!", 10);
    }



    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getSaveArticleXpathByDescription(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }


}
