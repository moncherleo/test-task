package okta;

import org.okta.pages.HomePage;
import org.okta.pages.TrialPage;
import org.okta.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OktaTest extends BaseTest {

    @Test(dataProvider = "fileDataProvider", dataProviderClass = DataProviders.class)
    public void captchaErrorValidationTest(String firstName, String lastName, String workEmail, String phoneNumber, String country, String province) {
        String captchaMessageText = "reCAPTCHA is required";

        HomePage homePage = new HomePage(driver);
        TrialPage trialPage = homePage.open().openTrialPage();
        String captchaText = trialPage.signUpFromCanada(firstName, lastName, workEmail, phoneNumber, country, province).readCaptchaAlertMessage();

        Assert.assertTrue(captchaText.contains(captchaMessageText));
    }
}
