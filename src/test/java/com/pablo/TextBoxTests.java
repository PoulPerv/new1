package com.pablo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        open("/text-box");

        String name = "Pablo Black";
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("Pablo@gmail.com");
        $("[id=currentAddress]").setValue("Street");
        $("[id=permanentAddress]").setValue("House");
        $("[id=submit]").click();
        $("[id=output]").shouldHave(text(name), text("Pablo@gmail.com"), text("Street"), text("House"));
    }
}

