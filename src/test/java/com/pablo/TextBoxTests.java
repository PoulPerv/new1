package com.pablo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
//import static com.codeborne.selenide.Selectors.byXpath; //если понадобится скролл
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class TextBoxTests {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        String name = "Pablo";
        String lastName = "Black";
        String email = "Pablo@gmail.com";
        String gender = "Male";
        String mobile = "0297563421";
        String hobby = "Sports";
        String subject = "English";
        String img = "src/test/resources/cv.jpg";
        File sis = new File(img);
        String currentAddress = "Minsk";
        String state = "NCR";
        String city = "Delhi";
        String day = "15";
        String year = "1987";
        String month = "May";


        $("[id=firstName]").setValue(name);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(mobile);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=subjectsInput]").setValue(subject).pressEnter();
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=hobbiesWrapper]").$(withText(hobby)).click();
        $("[id=state]").click(); $("[id=state]").$(byText(state)).click();
        $("[id=city]").click(); $("[id=city]").$(byText(city)).click();
        $("#uploadPicture").uploadFile(sis);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();
        $("[id=submit]").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(name + " " + lastName),
                text(email),
                text(gender),
                text(mobile),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobby),
                text(img.substring(19)),
                text(currentAddress),
                text(state + " " + city)
        );
    }
}

