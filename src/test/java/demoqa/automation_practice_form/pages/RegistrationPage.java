package demoqa.automation_practice_form.pages;


import com.codeborne.selenide.SelenideElement;
import demoqa.automation_practice_form.components.CalendarForm;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.automation_practice_form.tests.TestData.*;


public class RegistrationPage {

    CalendarForm calendarForm = new CalendarForm();

    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            radioButtonMale = $(byXpath("//label[@for='gender-radio-1']")),
            mobilePhone = $("#userNumber"),
            subjects = $("#subjectsInput"),
            checkBoxHobbiesSport = $(byXpath("//label[@for='hobbies-checkbox-1']")),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public RegistrationPage typeLastName(String surname) {
        lastName.setValue(surname);
        return this;
    }

    public RegistrationPage setEmail(String mail) {
        email.setValue(mail);
        return this;
    }

    public RegistrationPage setRadioButtonMale() {
        radioButtonMale.click();
        return this;
    }

    public RegistrationPage setMobilePhone(String phone) {
        mobilePhone.setValue(phone);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setCheckBoxHobbiesSport() {
        checkBoxHobbiesSport.click();
        return this;
    }

    public RegistrationPage setBirthDate(String monthOfBirth, String yearOfBirth, String dayOfBirth) {
        calendarForm.setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth);
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        uploadPicture.uploadFile(new File(path));
        return this;
    }

    public RegistrationPage setSubjects(String favoriteSub) {
        subjects.setValue(favoriteSub).pressEnter();
        return this;
    }

    public RegistrationPage setState(String stateOfCountry) {
        state.find("input").setValue(stateOfCountry).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String cityOfCountry) {
        city.find("input").setValue(cityOfCountry).pressEnter();
        return this;
    }

    public RegistrationPage submitPage() {
        submit.scrollTo().click();
        return this;
    }

    public RegistrationPage checkForm() {
        $("tbody").shouldHave(text(name + " " + surname),
                text(mail),
                text("Male"),
                text(phone),
                text("15 September,1987"),
                text(favoriteSubject),
                text("terminator.jpg"),
                text(address),
                text(stateOfCountry),
                text(cityOfState)
        );
        return this;
    }

    public RegistrationPage checkFormWithMap(Map<String, String> value) {
        Iterator it = value.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            $(".table-responsive").$(byText((String) pair.getKey())).sibling(0).shouldHave(text((String) pair.getValue()));
        }
        return this;
    }

    public static Map<String, String> valuesToCheck = Map.of(
            "Student Name", name + " " + surname,
            "Student Email", mail,
            "Gender", "Male",
            "Mobile", phone,
            "Date of Birth", "15 September,1987",
            "Picture", "terminator.jpg",
            "Address", address,
            "State and City", stateOfCountry + " " + cityOfState);

}