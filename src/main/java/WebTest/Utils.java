package WebTest;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {

    //1) Clicking element
    public void clickElement(By by) {

        driver.findElement( by ).click();

    }

    //2) Clear Text form inout box/area
    public static void clearField(By by) {
        driver.findElement( by ).clear();
    }

    //3)  Enter text in input field
    public static void enterText(By by, String text) {
        driver.findElement( by ).sendKeys( text );
    }
   //4 ENTER ELEMENT
    public static void enterElement(By by, String text) {
        driver.findElement( by ).sendKeys(text);
    }

    //4)  Clear and enter text in input field
    public void clearAndEnter(By by, String text) {
        driver.findElement( by ).clear();
        driver.findElement( by ).sendKeys( text );

    }
    //5)  Checking WebElemnt present in DOM

    public boolean isElementPresent(By by) {

        try {
            driver.findElement( by ).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //  6)  Checking WebElemnt displayed or not
    public boolean isElementDisplayed(By by) {
        try {
            driver.findElement( by ).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //7)  Wait for fixed time given in seconds

    public static void waitForWebElementToBeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait( driver, seconds );
        wait.until( ExpectedConditions.elementToBeClickable( by ) );

    }

//8)  Try to click element three times if not available in first go

    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3) {
            try {
                Thread.sleep( 10 );
                driver.findElement( by ).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempt++;
        }
        return result;
    }


    // 9)  Wait for locator to be clickable for given time in seconds

    public static void waitForLocatorToBeClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait( driver, second );
        wait.until( ExpectedConditions.elementToBeClickable( by ) );

    }

    // 10)  Wait for element Locator  for given time in second
    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait( driver, time );
        wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( by ) );

    }

// 11)  Wait for element for given time in second

    public static void explicitWaitForElement(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait( driver, seconds );
        wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( by ) );

    }

    //  12) date stamp short

    public static void dateStampShort() {
        DateFormat dateFormat = new SimpleDateFormat( "mm/dd/yyyy/hhmmss" );
        Date date = new Date();
        String getCurrentDateTime = dateFormat.format( date );
    }

    //13) date stamp long

    public static void dateStampLong() {
        Date ts = new Date( System.currentTimeMillis() );
        Date date = new Date( ts.getTime() );
        System.out.println( date );

    }

    //14) select from visible text

    public static void selectFromVisibleText(By by, String text) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByVisibleText( text );
    }

    // 15) Select from visible number

    public static void selectFromVisibleNumber(By by, int number) {
        Select select = new Select( driver.findElement( by ) );
        select.deselectByIndex( number );
    }

    //16) Select from value

    public static void selectFromValue(By by, int number) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByIndex( number );
    }

// ) 17) get selected value from dropdown

    public void selectValueFromDropDown(By by, String data) {
        Select select = new Select( driver.findElement( by ) ); //( BasePage.driver.findElement( by )
        select.selectByValue( data );

    }
    // 18 ) select text by value  // For DOB , currecny

    public  void selectTextByValue(By by, String text) {
        Select select = new Select( driver.findElement( by ) ); //( BasePage.driver.findElement( by )
        select.selectByValue( text );
    }


//18)Scroll to element and click

    public static void scrollToElementAndClick(By by) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript( "window.scrollBy(0,250)", "" );
        driver.findElement( by ).click();

    }

    //19) Wait for alert to display

    public static void waitForAlertToDisplay(int time) {
        try {
            WebDriverWait wait = new WebDriverWait( driver, time );
            wait.until( ExpectedConditions.alertIsPresent() );
            Alert alert = driver.switchTo().alert();
            System.out.println( "Alert box text" + alert.getText() );
            alert.accept();
        } catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();

        }
    }

    //20) Get attribute of element

    public static void getAttibutrEletment(By by) {
        driver.findElement( by ).getText();


    }

    // 21) get css property of element

    public static void getCssPropertyOfElement(By by, String a) {
        driver.findElement( by ).getCssValue( a );
    }


    // 22) assert  urll

    public static void assertCurrentURL(String URL) {

        Assert.assertTrue( driver.getCurrentUrl().equals( URL ) );
    }
    //23
    public static void assertURL(String text) {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals( URL,"text");

    }


    //23 )  Method for call Assort

    public static String gerTextMessage(By by) {
        return null;
    }

    public static void assortTextMessage(String expected, By by) {
        String accual = gerTextMessage( by );
        Assert.assertEquals( expected, accual );

    }
    // 24) isdorpdown present
// Fro Drop down if Text is present
    public  static  void  dropDownPresent(By by, String text){
        Select select = new Select( driver.findElement( by ) );
        select.selectByVisibleText( text );
    }
    //25) get visibility text

    public static void getVisibilityText(By by, String text) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByVisibleText( text );
    }

    //26) hover to element mouse hover method

    public void hoverElement(By by){
        // xpath store in ele or we can use direct
        WebElement ele = driver.findElement( by );
        Actions act = new Actions( driver );

        // single element perform if multiple we use build.perform

        act.moveToElement( ele ).perform();
    }


//    25) take screenshot of browser

//    public static void takeScreenShotBrowser() {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );
//        try {
//            FileUtils.copyFile( scrFile, new File( "src\test\CaptureScreenshoot");
//            System.out.println( e.getMessage() );
//
//        }
//    }

//wait for element to be invisible

//Scroll to view element

//take screenshot of current display(full)
//convert date....
}

