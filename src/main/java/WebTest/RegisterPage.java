package WebTest;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends Utils {




    String timeStamp = new SimpleDateFormat( "dd.MM.yy.HH.mm.SS" ).format(new Date(  ) );

    public void enterDetailsForRegistration() {

        enterText( By.id( "FirstName" ), "Md" );
        enterText( By.id( "LastName" ), "sayed" );
//enter dob
//        getVisibilityText( By.xpath( "//select[@name='DateOfBirthDay']" ), "15" );
//        getVisibilityText( By.xpath( "//select[@name='DateOfBirthMonth']" ), "01" );
//        getVisibilityText( By.xpath( "//select[@name='DateOfBirthYear']" ), "1980" );
// enter User email Id for registration
        driver.findElement( By.id( "Email" ) ).sendKeys( "masayed"+ timeStamp+"@gmail.com" );
        // set the password
        driver.findElement( By.id( "Password" ) ).sendKeys( "ssss1234" );
        // Confirm the set password
        driver.findElement( By.id( "ConfirmPassword" ) ).sendKeys( "ssss1234" );
        // Click on Register Buton for submit the registration form
        driver.findElement( By.id( "register-button" ) ).click();
        System.out.println("I clicked on register button");
        System.out.println(driver.getCurrentUrl());
        // checking  the successfull result
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualRegistrationSuccessMessege = driver.findElement(By.xpath("//div[@class='page-body']/div[@class='result']")).getText();
        System.out.println(actualRegistrationSuccessMessege);

        Assert.assertEquals( "Your registration completed", actualRegistrationSuccessMessege);

    }
}


