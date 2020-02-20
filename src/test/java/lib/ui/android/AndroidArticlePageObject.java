package lib.ui.android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://android.view.View[@resource-id='content']/android.view.View[1]";
        TITLE_TWO = "//android.view.View[@resource-id='content']/*[@text='Java (programming language)']";
        DESCRIPTION = "xpath://*[@text='Object-oriented programming language']";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "";
        GOT_IT_OVERLAY = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        CREATE_NEW = "xpath://*[@resource-id='org.wikipedia:id/create_button']";
        INPUT_NAME_SAVE_FOLDER = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        MY_LIST_NAME_INPUT = "xpath://*[@text='Learning programming']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
