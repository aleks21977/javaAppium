package lib.ui;

import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class ArticlePageObject extends MainPageObject{

    protected static String // было private static final String
        TITLE,// = "xpath://android.view.View[@resource-id='content']/android.view.View[1]",
        TITLE_TWO,// = "//android.view.View[@resource-id='content']/*[@text='Java (programming language)']",
        DESCRIPTION,// = "xpath://*[@text='Object-oriented programming language']",
        FOOTER_ELEMENT,// = "xpath://*[@text='View page in browser']",
        OPTIONS_ADD_TO_MY_LIST_BUTTON,// = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark']",
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,// = "",
        GOT_IT_OVERLAY,// = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']",
        CREATE_NEW,// = "xpath://*[@resource-id='org.wikipedia:id/create_button']",
        INPUT_NAME_SAVE_FOLDER,// = "xpath://*[@resource-id='org.wikipedia:id/text_input']",
        MY_LIST_OK_BUTTON,// = "xpath://*[@text='OK']",
        CLOSE_ARTICLE_BUTTON,// = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
        MY_LIST_NAME_INPUT;// = "xpath://*[@text='Learning programming']";

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 10);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public WebElement waitForDescriptionElement()
    {
        return this.waitForElementPresent(DESCRIPTION, "Cannot find article description on page!", 10);
    }

    public String getArticleDescription()
    {
        WebElement description_element = waitForDescriptionElement();
        return description_element.getAttribute("text");
    }


    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    20
            );
        }
//        else if (Platform.getInstance().isIOS()) {
//            this.swipeUpTillElementAppear(
//                    FOOTER_ELEMENT,
//                    "Cannot find the end of article",
//                    40);
//        } else {
//            this.scrollWebPageTillElementNotVisible(
//                    FOOTER_ELEMENT,
//                    "Cannot find the end of article",
//                    40
//            );
//        }

    }

    public void addArticleOneToMyList(String name_of_folder)
    {
        //кликаем по кнопке добавить в избранное
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,//"//*[@resource-id='org.wikipedia:id/article_menu_bookmark']"
                "Cannor find button to add article to reading list",
                5
        );

        //кликаем по кнопке попапа GOT IT
        this.waitForElementAndClick(
                GOT_IT_OVERLAY, //"//*[@resource-id='org.wikipedia:id/onboarding_button']"
                "Cannor find 'GOT IT' tip overlay'",
                5
        );

        //кликаем по кнопке Create new
        this.waitForElementAndClick(
                CREATE_NEW,//"//*[@resource-id='org.wikipedia:id/create_button']"
                "Cannor find button 'Create new'",
                5
        );

        // вводим название папки Learning programming
        this.waitForElementAndSendKeys(
                INPUT_NAME_SAVE_FOLDER,//'//*[@resource-id='org.wikipedia:id/text_input']"
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
                OPTIONS_ADD_TO_MY_LIST_BUTTON,//"//*[@resource-id='org.wikipedia:id/article_menu_bookmark']"
                "Cannor find button to add article to reading list",
                5
        );

        waitForElementAndClick(
                MY_LIST_NAME_INPUT,
                "Cannor find save list 'Learning programming'",
                5
        );

    }

    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannor find button to add article to reading list(2)", 5);
    }


    public void removeArticleFromSavedIfItAdded ()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            "Cannot click button to remove an article from saved.",
            1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before.",
                    1
            );
        }
    }


    public void closeArticle()
    {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,//"//android.widget.ImageButton[@content-desc='Navigate up']"
                    "Cannot close article, cannot find Exit button",
                    5
            );
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public int getAmmountOfElements()
    {
        List elements = driver.findElements(By.xpath(TITLE_TWO));
        return elements.size();
    }


}
