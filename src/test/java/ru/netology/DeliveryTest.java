package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryTest {

    @Test
    public void shouldOrderDelivery() {
        open("http://localhost:9999");
        $("[data-test-id=city] .input__control").setValue("Москва");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue("20.01.2022");
        $("[data-test-id=name] .input__control").setValue("Дмитрий Петров");
        $("[data-test-id=phone] .input__control").setValue("+79332225566");
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=notification]").shouldHave(text("Успешно! Встреча успешно забронирована на 20.01.2022"), Duration.ofSeconds(15));
            }
}
