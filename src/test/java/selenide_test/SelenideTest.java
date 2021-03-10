package selenide_test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        System.out.println("BeforeSuite");
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.out.println("BeforeMethod");
        open("https://www.google.co.uk");
    }

    @Test(priority = 1, groups = {"login"})
    public void test1() {

        $(By.id("gb_70")).click();
        $(By.xpath("//input[@type='email']")).click();
        $(By.xpath("//input[@type='email']")).sendKeys("testing.testing2003@");
        $(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
        $(By.xpath("//div[@class='o6cuMc']")).shouldHave(text("Введите адрес электронной почты или номер телефона."));

    }

    @Test(groups = {"login"}, dependsOnMethods = "test1")
    public void automationTest2() {

        $(By.id("gb_70")).click();
        $(By.xpath("//input[@type='email']")).click();
        $(By.xpath("//input[@type='email']")).sendKeys("testing.testingnon-existent2003@gmail.com");
        $(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
        $(By.xpath("//div[@class='o6cuMc']")).shouldHave(text("Не удалось найти аккаунт Google"));
    }

    @Test(priority = 2, groups = {"login", "valid"})
    public void automationTest3() {

        $(By.id("gb_70")).click();
        $(By.xpath("//input[@type='email']")).click();
        $(By.xpath("//input[@type='email']")).sendKeys("testing.testing2003@gmail.com");
        $(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();

    }

//    @Test(groups = {"valid"},invocationCount = 3,threadPoolSize = 2)
    @Test(groups = {"valid"})
    public void automationTest4() {

        $(By.id("gb_70")).click();
        $(By.xpath("//button[@jsname='Cuz2Ue']")).click();
        $(By.xpath("//div[@class='Y4dIwd']")).shouldHave(text("Укажите номер телефона или резервный адрес электронной почты"));
    }

    @Test(groups = {"valid"},description = "Make sure 'Images' label is shown under 'Google' logo")
    public void automationTest5() {

        $(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='RNmpXc']")).click();
        $(By.id("logo")).shouldBe(appear);
    }

    @Test(groups = {"login"})
    public void automationTest6() {

        $(By.xpath("//a[@data-pid='2']")).click();
        $(By.xpath("//div[@class='logo-subtext']")).shouldHave(text("Картинки"));
        $(By.xpath("//span[@class='BwoPOe']")).shouldBe(appear);
        $(By.xpath("//div[@jscontroller='MC8mtf']")).shouldBe(appear);
        $(By.xpath("//div[@jscontroller='TJw5qb']")).click();
        $(By.id("cjyo4e")).shouldBe(appear);
        $(By.xpath("//a[@class='iOGqzf H4qWMc aXIg1b']")).shouldBe(appear);
    }

    @Test
    public void automationTest7() {

        $(By.xpath("//div[@class='gb_C gb_dd gb_i']")).click();
        switchTo().frame($(By.xpath("//iframe[@role='presentation']")));
        $(By.xpath("//div[@class='EHzcec eejsDc']")).shouldBe(appear);
        $(By.xpath("//span[contains(text(),'Play')]")).click();
        $(By.xpath("//div[@class='gb_pc']")).shouldBe(appear);
    }

    @Test
    public void automationTest8() {
        $(By.xpath("//div[@jscontroller='MC8mtf']")).click();

    }
}
