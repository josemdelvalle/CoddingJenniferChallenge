package com.revature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import test.selenium.pages.ClashReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FirstSeleniumDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Enter URL:");
        Scanner myObj = new Scanner(System.in);
        String url = myObj.nextLine();
//        System.setProperty("webdriver.chrome.driver","C:/Users/JMDel/Documents/Revature/Selenium/chromedriver.exe" );
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver( new ChromeOptions().addArguments("--headless"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(url);
//
//        Thread.sleep(5000);
////        String MainWindow=driver.getWindowHandle();
////        driver.switchTo().alert().dismiss();
////        driver.switchTo().window(MainWindow);
//        Thread.sleep(5000);
        Thread.sleep(2000);
        WebElement navLoginBtn =ClashReport.getNavLoginBtn(driver);
        navLoginBtn.click();
        WebElement emailLoginInput =ClashReport.getEmailLoginInput(driver);
        WebElement passwordInput =ClashReport.getPasswordInput(driver);
        emailLoginInput.sendKeys("josemdelvalle@outlook.com");
        passwordInput.sendKeys("esoj9505");
        WebElement loginSubmitBtn =ClashReport.getLoginSubmitBtn(driver);
        loginSubmitBtn.click();

        Thread.sleep(5000);
        List<WebElement> usernames=ClashReport.getUsernames(driver);
        List<WebElement> duration=ClashReport.getDuration(driver);
        List<WebElement> scores=ClashReport.getScores(driver);
        List<WebElement> language=ClashReport.getLanguages(driver);
        List<WebElement> playerReports=ClashReport.getPlayerReports(driver);

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet( " Student Info ");

        //Create row object
        XSSFRow row;

        Map< String, Object[] > stdInfo = new TreeMap< String, Object[] >();

        for(int i=0;i<playerReports.size();i++){
            stdInfo.put(Integer.toString(i) ,new Object[]{
                    usernames.get(i).getText(),scores.get(i).getText(),duration.get(i).getText(),language.get(i).getText(),Integer.toString(ClashReport.getSharedCode(playerReports.get(i)))
            });
        }


        Set< String > keyid = stdInfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = stdInfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(
                new File("C:/Users/JMDel/Desktop/Writesheet.xlsx"));

        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");
        Thread.sleep(2000);
        driver.quit();
        //driver.close();
    }
}
