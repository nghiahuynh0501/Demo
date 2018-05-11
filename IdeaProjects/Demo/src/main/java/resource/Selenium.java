package resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.steps.BeforeOrAfterStep;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.StepCandidate;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class Selenium extends Steps {
    public static WebDriver driver=null;

    @Given("Open brower")
    public void Open(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\maste\\IdeaProjects\\chromedriver.exe");
            DesiredCapabilities a = DesiredCapabilities.chrome();
            a.setCapability("marionette", true);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            driver.get("https://cc.lab.qup.vn/");
            //driver.manage().window().maximize();
            try {
                Thread.sleep(1800);
                driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nghiaadmin");
                driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Qup@12345");
                driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/button")).click();
            } catch (InterruptedException e) {
                System.out.println(e);
                ;
            }
        }
        driver.manage().deleteAllCookies();

    }
    @When("Navigation website QUp")
    public void Login(){
        System.out.println("ABC");
    }
    @Then("$title display")
    public void Action(String titlel){
        org.junit.Assert.assertEquals(titlel,driver.getTitle());
        }
    }

    public static void (){}
