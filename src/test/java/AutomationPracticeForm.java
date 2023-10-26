import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        pageLoadTimeout = 90000;
        browser = "edge";
        holdBrowserOpen = true;
    }

    @Test
    void practicefillformtest() {

        String userFirstName = "Oleg";
        String userLastName = "Viktorkin";
        String userEmail = "viktorkn01@gmail.com";
        String userGender = "Male";
        String userNumber = "9309642888";
        String userMonthOfBirth = "May";
        String userYearOfBirth = "2002";
        String userDayOfBirth = "30";
        String userSubjects = "Biology";
        String userHobbies = "Reading";
        String userFile = "Foto.PNG";
        String userAddress = "Milky Way, Earth";
        String userState = "Haryana";
        String userCity = "Karnal";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $$(".custom-radio").findBy(text(userGender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(userMonthOfBirth);
        $(".react-datepicker__year-select").selectOption(userYearOfBirth);
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsContainer input").setValue(userSubjects);
        $(".subjects-auto-complete__menu-list").$(byText(userSubjects)).click();
        $("#hobbiesWrapper").$(byText(userHobbies)).click();
        $("#uploadPicture").uploadFromClasspath(userFile);
        $("#currentAddress").setValue(userAddress);
        $("#state").click();
        $("#state").$(byText(userState)).click();
        $("#city").click();
        $("#city").$(byText(userCity)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(exactTextCaseSensitive("Thanks for submitting the form"));
        $$(".table tr").findBy(exactTextCaseSensitive("Student Name " + userFirstName + " " + userLastName)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Student Email " + userEmail)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Gender " + userGender)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Mobile " + userNumber)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Date of Birth " + userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Subjects " + userSubjects)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Hobbies " + userHobbies)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Picture " + userFile)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("Address " + userAddress)).shouldBe(visible);
        $$(".table tr").findBy(exactTextCaseSensitive("State and City " + userState + " " + userCity)).shouldBe(visible);
    }
}
