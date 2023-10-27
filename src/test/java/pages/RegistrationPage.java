package pages;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $$(".custom-radio").findBy(text(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsContainer input").setValue(value);
        $(".subjects-auto-complete__menu-list").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#state").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#city").$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyModalWindowAppears() {
        $("#example-modal-sizes-title-lg").shouldHave(exactTextCaseSensitive("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage verifyModalWindowResult(String value) {
        $$(".table tr").findBy(exactTextCaseSensitive(value)).shouldBe(visible);

        return this;
    }

}
