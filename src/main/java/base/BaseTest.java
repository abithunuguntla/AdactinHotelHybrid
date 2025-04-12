package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver = null;
	public static FileInputStream fis1 = null;
	public static FileInputStream fis2 =null;
	public static Properties configprop = null;
	public static Properties locatorprop =null;
	@BeforeTest
	public void beforetest() {
     try {
		fis1 = new FileInputStream("D:\\Abhishek Workspace\\AdactinHotelTestCases\\Properties\\conflict.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     configprop = new Properties();
    try {
		configprop.load(fis1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     try {
		fis2=new FileInputStream("D:\\Abhishek Workspace\\AdactinHotelTestCases\\Properties\\locators.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     locatorprop = new Properties();
    try {
		locatorprop.load(fis2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@AfterMethod
	public void quit() {
		
		driver.quit();
	}

}
