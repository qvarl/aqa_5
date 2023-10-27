package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.*;

public class AutomationPracticeForm {

    RegistrationPage registrationPage = new RegistrationPage();

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
        String userSubject = "Biology";
        String userHobby = "Reading";
        String userFile = "Foto.PNG";
        String userAddress = "Milky Way, Earth";
        String userState = "Haryana";
        String userCity = "Karnal";

        registrationPage
                .openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setDateOfBirth(userYearOfBirth, userMonthOfBirth, userDayOfBirth)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .setFile(userFile)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit()

                .verifyModalWindowAppears()
                .verifyModalWindowResult("Student Name " + userFirstName + " " + userLastName)
                .verifyModalWindowResult("Student Email " + userEmail)
                .verifyModalWindowResult("Gender " + userGender)
                .verifyModalWindowResult("Mobile " + userNumber)
                .verifyModalWindowResult("Date of Birth " + userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                .verifyModalWindowResult("Subjects " + userSubject)
                .verifyModalWindowResult("Hobbies " + userHobby)
                .verifyModalWindowResult("Picture " + userFile)
                .verifyModalWindowResult("Address " + userAddress)
                .verifyModalWindowResult("State and City " + userState + " " + userCity);
    }
}
