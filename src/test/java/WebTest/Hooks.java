package WebTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class Hooks extends Utils {

    BrowserSelector browserSelector = new BrowserSelector();
    static String timeStamp = new SimpleDateFormat( "dd.MM.yy.HH.mm.SS" ).format(new Date(  ) );


    @Before
    public  void setBrowser(){
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait( 20, TimeUnit.MILLISECONDS );
        driver.manage().window().fullscreen();
        driver.get( "https://demo.nopcommerce.com/" );

    }

    @After
    public void closeBrowser(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName() + timeStamp + ".png";
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );
                File destinationPath = new File( System.getProperty( "user.dir" ) + "/target/cucumber-reports/extent-reports/screenshots/" + screenshotName );
                copyFile( sourcePath, destinationPath );
                scenario.embed( ((TakesScreenshot) driver).getScreenshotAs( OutputType.BYTES ), "image.png" );
            } catch (IOException e) {

            }
            driver.close();

        }
        driver.close();
    }

}
