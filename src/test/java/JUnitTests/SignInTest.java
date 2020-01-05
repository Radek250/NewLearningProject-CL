package JUnitTests;

import PageObjects.LogInPage;
import PageObjects.LoggedUserMainPage;
import PageObjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    WebDriver driver;

    public String email = "michal.dobrzycki@coderslab.pl";
    public String password = "CodersLab";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void signIn(){
        MainPage mainPage= new MainPage(this.driver);
        mainPage.goToSignIn();

        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInForm(this.email, this.password);

        LoggedUserMainPage username = new LoggedUserMainPage(this.driver);
        username.loggedUserName();
        Assert.assertEquals("Automated Tester", username.loggedUserName());
    }

    @After
    public void tearDown(){
       // driver.quit();
    }
}
