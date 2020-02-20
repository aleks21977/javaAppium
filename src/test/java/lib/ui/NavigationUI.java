package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject{

    protected static String //было private static final String
            CLICK_NO_THANKS,// = "xpath://*[@text='NO THANKS']",
            MY_LISTS_LINK,// = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
            OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigatin()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button.", 5);
        } else {
            System.out.println("Method openNavigatin() does nothing for platform " + Platform.getInstance().getPlatformVar());

        }
    }

    public void clickNoThanks()
    {
        this.waitForElementAndClick(
                CLICK_NO_THANKS,//"//*[@text='NO THANKS']"
                "Cannot find button 'Create new'",
                5
        );
    }
    public void clickMyList()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }
}
