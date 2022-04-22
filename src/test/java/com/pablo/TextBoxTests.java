package com.pablo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
        String mobile = "375297563421";
        String hobby = "Sport";
        String subject = "English";
        String imgPath = "src/test/resources/x_aca7686e.jpg";
        String currentAddress = "Minsk";
        String state = "NCR";
        String city = "Delhi";
        String birth = "Delhi";


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
        $("#uploadPicture").uploadFromClasspath(imgPath);
        //$("[id=submit]").click();
    }
}

