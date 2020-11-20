package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {

    @Test
    void DepositsTest() {
        open("http://alfabank.ru");
        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("#filter").$$("[data-widget-name=CatalogCard]").shouldHaveSize(5);

    }

    @Test
    void InsuranceTest1() {
        open("http://alfabank.ru");
        $(byText("Вклады")).click();
        $$(byText("Описание")).find(visible).parent().sibling(0).click();
        $$(byText("Страхование вкладов")).find(visible).parent().shouldBe(focused);

    }

    @Test
    void InsuranceTest2() {
        open("http://alfabank.ru");
        $(byText("Вклады")).click();
        $$(byText("Что такое вклад?")).find(visible).parent().preceding(1).sibling(0).click();
        $("#good-to-know").shouldHave(text("Альфа-Банк является участником системы обязательного"));

    }

    @Test
    void InsuranceTest3() {
        open("http://alfabank.ru");
        $(byText("Вклады")).click();
        $$(byText("Страхование вкладов")).find(visible).closest("button").click();
        $$(byText("Страхование вкладов")).find(visible).parent().shouldBe(focused);


    }

}