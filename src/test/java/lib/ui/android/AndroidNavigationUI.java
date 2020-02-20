package lib.ui.android;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    private static final String
            CLICK_NO_THANKS = "xpath://*[@text='NO THANKS']",
            MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";


    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
