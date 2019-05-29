package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils {

    public void UserShouldBeAbleToClickRegisterButtonSuccessfully() {

        clickElement( By.xpath( "//a[@class=\"ico-register\"]" ) );
    }

    public void navigateCategoryPage(String link) {
        clickElement( By.linkText( link ) );
    }

//    public void userOnLogInpage() {
//        clickElement( By.linkText( "Log in" ) );
//
//
//    }
}
