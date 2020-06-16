package pl.adam.firstProject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@TestPropertySource(properties = "server.port=8080")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RegisterLoginAndCreateTrainerTest {

    //todo fix problem with LocalServerPort
    /*@Autowired
    static Environment environment;
    @LocalServerPort
    private static String port = environment.getProperty("local.server.port");*/

    @LocalServerPort
    private static int port;

    private static HtmlUnitDriver browser;

    private static final String HOME_PAGE_URL = "http://localhost:" + "8080" + "/";
    private static final String REGISTRATION_PAGE_URL = "http://localhost:" + "8080" + "/register";
    private static final String LOGIN_PAGE_URL = "http://localhost:" + "8080" + "/login";
    private static final String TRAINER_PAGE_URL = "http://localhost:" + "8080" + "/trainer";


    @BeforeAll
    public static void setup() {
        browser = new HtmlUnitDriver();
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

    @Test
    void registerLoginAndCreateTrainerPositive() throws Exception {
        browser.get(HOME_PAGE_URL);
        shouldSayCurrentUrlPageEqualTo(HOME_PAGE_URL);
        clickOnRegister();
        shouldSayCurrentUrlPageEqualTo(REGISTRATION_PAGE_URL);
        register();
        shouldSayCurrentUrlPageEqualTo(LOGIN_PAGE_URL);
        login();
        shouldSayCurrentUrlPageEqualTo(TRAINER_PAGE_URL);
        createTrainer();
    }

    private void shouldSayCurrentUrlPageEqualTo(String genericPage) {
        System.out.println(browser.getCurrentUrl());
        assertEquals(genericPage,browser.getCurrentUrl());
    }

    private void clickOnRegister() {
        browser.findElementById("register").click();
    }

    private void register() {
        browser.findElementByName("email").sendKeys("tester123");
        browser.findElementByName("password").sendKeys("123");
        browser.findElementByCssSelector("form#registerForm").submit();
    }

    private void login() {
        browser.findElementByName("email").sendKeys("tester123");
        browser.findElementByName("password").sendKeys("123");
        browser.findElementByCssSelector("form#loginForm").submit();
    }

    private void createTrainer() {
        browser.findElementByName("nick").sendKeys("Ash");
        browser.findElementByName("age").sendKeys("14");
        browser.findElementByName("gender").sendKeys("Male");
        browser.findElementByName("favPokemon").sendKeys("Picachu");
        browser.findElementByCssSelector("form#trainerForm").submit();
    }
}
