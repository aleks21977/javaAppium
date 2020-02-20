package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

//    private static final String
//            DELETE_ARTICLE_BUTTON = "xpath:";

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLacatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresent(String locator, String error_message)
    {
        return waitForElementPresent(locator, error_message, 5);
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(locator, error_message, 10);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(locator, error_message, 5);
        element.sendKeys(value);//  через использование sendValue вместо sendKeys
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLacatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe)
    {
        if (driver instanceof AppiumDriver){
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int)(size.height * 0.8);
            int end_y = (int)(size.height * 0.2);

            action
                    .press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipeUpQuick()
    {
        swipeUp(200);
    }

    public void scrolWebPageUp() {
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 250)");
        } else {
            System.out.println("Method scrolWebPageUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

//    public void scrollWebPageTillElementNotVisible(String locator, String error_message, int max_swipes) {
//        int alredy_swipe = 0;
//
//        WebElement element = this.waitForElementPresent(locator, error_message);
//        while (!this.isElementLocateOnTheScreen(locator)) {
//            scrolWebPageUp();
//            ++alredy_swipe;
//            if (alredy_swipe > max_swipes) {
//                Assert.assertTrue(error_message, element.isDisplayed());
//            }
//        }
//    }

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes)
    {
        By by = this.getLacatorByString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0){

            if (already_swipe > max_swipes){
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++already_swipe;
        }
    }

    public void swipeElementToLeft(String locator, String error_massage)
    {
        if (driver instanceof AppiumDriver) {
            WebElement element = waitForElementPresent(
                    locator,
                    error_massage,
                    10
            );
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;
            //System.out.println("left_x =" + left_x + "; right_x =" + right_x + "; upper_y =" + upper_y + "; lower_y =" + lower_y + "; middle_y =" + middle_y);

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action
                    .press(PointOption.point(right_x, middle_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(left_x, middle_y))
                    .release()
                    .perform();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }//пауза
            right_x = right_x + 60;
            action
                    .tap(PointOption.point(right_x, middle_y))
                    .perform();
        } else {
            System.out.println("Method swipeElementToLeft() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickForDelete(String locator, String error_massage)
    {
        waitForElementPresent(
                locator,
                error_massage,
                5
        );
        this.waitForElementAndClick(
                locator,
                "Cannot delete article, cannot find Delete button",
                3
        );


    }

    public int getAmmountOfElements(String locator)
    {
        By by = this.getLacatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public boolean isElementPresent(String locator) { //возвращеат либо true либо false
        return getAmmountOfElements(locator) > 0;
    }


    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attempts) {
        int current_attemps = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts) {
            try {
                this.waitForElementAndClick(locator, error_message, 1);
                need_more_attempts = false;
            } catch (Exception e) {
                if (current_attemps > amount_of_attempts) {
                    this.waitForElementAndClick(locator, error_message, 1);
                }
            }
            ++ current_attemps;
        }
    }


    public void assertElementNotPresent(String locator, String error_message)
    {
        int amount_of_elements = getAmmountOfElements(locator);
        if (amount_of_elements > 0 ) {
            String default_message = "An element '" + locator + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeInSeconds);
        return element.getAttribute(attribute);
    }

    private By getLacatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("className")) {
            return By.className(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        }else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator " + locator_with_type);
        }
    }


}
