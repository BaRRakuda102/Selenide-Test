package gitHub;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    void  openMainPage() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue("Selenide").pressEnter();
        $$(".repo-list").first().$("a").click();
        $("#wiki-tab").$(byText("Wiki")).click();
        $("#wiki-pages-box button").click();
        $$("#wiki-pages-box li").find(Condition.text("SoftAssertions")).click();
        $$(".markdown-body h4").find(Condition.text("Junit5")).shouldBe(Condition.visible);
    }
}