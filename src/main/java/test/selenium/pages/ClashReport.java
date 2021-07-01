package test.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClashReport {

    public static WebElement getNavLoginBtn(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
    }
    public static WebElement getLoginSubmitBtn(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//body/cg-login-popup[1]/div[1]/div[1]/div[1]/div[1]/div[2]/cg-authentication-form[1]/div[1]/connect[1]/connect-react[1]/div[1]/div[1]/form[1]/button[1]"));
    }

    public static WebElement getEmailLoginInput(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//body/cg-login-popup[1]/div[1]/div[1]/div[1]/div[1]/div[2]/cg-authentication-form[1]/div[1]/connect[1]/connect-react[1]/div[1]/div[1]/form[1]/input[1]"));
    }

    public static WebElement getPasswordInput(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//body/cg-login-popup[1]/div[1]/div[1]/div[1]/div[1]/div[2]/cg-authentication-form[1]/div[1]/connect[1]/connect-react[1]/div[1]/div[1]/form[1]/input[2]"));
    }
    public static List<WebElement> getUsernames(WebDriver webDriver){
        return webDriver.findElements(By.className("nickname"));
    }

    public static List<WebElement> getDuration(WebDriver webDriver){

        return  webDriver.findElements(By.cssSelector(".duration  .info-value:first-child "));
    }
    public static List<WebElement> getScores(WebDriver webDriver){

        return  webDriver.findElements(By.cssSelector(".score  .info-value:first-child "));
    }

    public static List<WebElement> getPlayerReports(WebDriver webDriver){
        return  webDriver.findElements((By.cssSelector(".player-report ")));
    }

    public static int getSharedCode(WebElement element){

        return  element.findElements(By.className("view-solution-button")).size();
    }

    public static List<WebElement> getLanguages(WebDriver webDriver){
        return  webDriver.findElements(By.cssSelector(".language  .info-value:first-child "));
    }
}
