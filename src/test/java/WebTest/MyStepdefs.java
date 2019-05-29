package WebTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sun.security.util.Password;

public class MyStepdefs {

    HomePage homePage = new HomePage();
    RegisterPage registerPage =new RegisterPage();
    LogInPage logInPage =new LogInPage();

    @Given("^user is on register page$")
    public void userIsOnRegisterPage() {
    }
    @When("^user enters all registration details$")
    public void userEntersAllRegistrationDetails() {
    }

    @Then("^user should able to register successfully$")
    public void userShouldAbleToRegisterSuccessfully() {
    }


    @Given("^user is on homepage$")
    public void userIsOnHomepage() {

    }

    @When("^use click on \"([^\"]*)\" link from the top manu$")
    public void useClickOnLinkFromTheTopManu(String arg0) throws Throwable {
    }

    @Then("^user should able to navegate to \"([^\"]*)\" successfull$")
    public void userShouldAbleToNavegateToSuccessfull(String link) throws Throwable {
        Utils.assertCurrentURL(link  );
    }

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {

    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterAnd(String email, String password) throws Throwable {
        logInPage.userLogInwithInvalidCredintian( email , password );
    }

    @Then("^user can not log in successufully with invalid user name or password$")
    public void userCanNotLogInSuccessufullyWithInvalidUserNameOrPassword(String errormessage) throws Throwable {

        boolean b;
        if (errormessage.contains( "Login was unsuccessful. Please correct the errors and try again.No customer account found" ) || errormessage.contains( "The credential provide are incorrect" )){
            b=true;

        }
        else {
            b = false;
        }
        Assert.assertTrue( b );
    }
}
