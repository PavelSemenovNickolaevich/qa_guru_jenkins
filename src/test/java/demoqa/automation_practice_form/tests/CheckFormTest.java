package demoqa.automation_practice_form.tests;

import demoqa.automation_practice_form.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static demoqa.automation_practice_form.tests.TestData.*;


public class CheckFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void shouldSaveCheckRegistrationForm() {

        registrationPage.typeFirstName(name)
                .typeLastName(surname)
                .setEmail(mail)
                .setRadioButtonMale()
                .setMobilePhone(phone)
                .setBirthDate(monthOfBirth, yearOfBirth, dayOfBirth)
                .setCheckBoxHobbiesSport()
                .uploadPicture(path)
                .setAddress(address)
                .setSubjects(favoriteSubject)
                .setState(stateOfCountry)
                .setCity(cityOfState)
                .submitPage()
                .checkForm();
    }

}
