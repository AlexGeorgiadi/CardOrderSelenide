package ru.netology.cardorderselenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

class CardOrderSelenideTest {

    String planningDate = Date.setDate(3);

    @Test
    void shouldRegister() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Нальчик");
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Георгиади Алексей");
        $("[data-test-id=phone] input").setValue("+79614660837");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(),'Забронировать')]").click();
        $("[data-test-id=notification]").should(Condition.appear, Duration.ofSeconds(13));
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}