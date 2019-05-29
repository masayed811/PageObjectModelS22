package WebTest;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LogInPage extends Utils {
    LoadProp loadProp = new LoadProp();

    private By _loginEmailId = By.xpath( "//input[@name='Email']" );
    //By _Email = By.id( "Email" );
    private By _loginPassWord = By.xpath( "//input[@name='Password']" );
    //By _Password = By.id( "Password" );
    By _loginButton = By.xpath( "//input[@class='button-1 login-button']" );

    public void userOnLogInpage() {
        clickElement( By.linkText( "Log in" ) );
    }

    public void userLogInwithInvalidCredintian(String email, String password) {

        enterElement( _loginEmailId, email );
        enterElement( _loginPassWord, password);
        clickElement( _loginButton );
    }
}


    //String longInUnsucessFullMessege = driver.findElement( By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

       //  Assert.assertEquals()
