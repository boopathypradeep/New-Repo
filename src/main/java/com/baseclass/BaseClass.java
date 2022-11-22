package com.baseclass;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static JavascriptExecutor executor;

	public static String readPropertyFile(String key) throws IOException {
		FileInputStream stream = new FileInputStream(
				"C:\\new eclipse workspace\\PVPM1\\src\\main\\java\\resources\\Environment.Properties");
		Properties properties = new Properties();
		properties.load(stream);
		return properties.get(key).toString();

	}

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
public static void deleteCookies() {
	driver.manage().deleteAllCookies();

}
	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void launchURL(String url) {
		driver.get(url);

	}

	public static void sendText(WebElement element, String keys) {
		element.sendKeys(keys);

	}

	public static void btnClick(WebElement element) {

		element.click();
	}

	@SuppressWarnings("depreciation")
	public static void implicitlyWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}

	public static void selectDropDown(String selectBy, WebElement element, String value, int index) {
		Select select = null;
		switch (selectBy) {
		case "value":
			new Select(element).selectByValue(value);
			break;
		case "visibleText":
			new Select(element).selectByVisibleText(value);
			break;
		case "Index":
			new Select(element).selectByIndex(index);
			break;

		default:
			break;
		}

	}
	public static String excelRead(int rowNo, int cellNo) throws
	 FileNotFoundException, IOException {
	 Workbook workbook=new XSSFWorkbook(new FileInputStream(new
	 File("C:\\new eclipse workspace\\PVPM1\\src\\main\\java\\excelSheels\\PVPM.xlsx")));
	 Cell cell = workbook.getSheet("Sheet1").getRow(rowNo).getCell(cellNo);
	 CellType type = cell.getCellType();
	 String value=null;
	 switch (type) {
	case STRING:
		 value = cell.getStringCellValue();
		break;
	case NUMERIC:
		if(DateUtil.isCellDateFormatted(cell)) {
			 Date date = cell.getDateCellValue();
			 SimpleDateFormat format=new SimpleDateFormat("dd-MM-YYYY");
			 value = format.format(date);
			 }else {
			 double numeric = cell.getNumericCellValue();
			 long l=(long) numeric;
			 value = String.valueOf(l);
			 }
		break;
	default:
		break;
	
	 }
	return value;
			 }

public static void print(Object value) {
		System.out.println(value);

	}

	public static WebElement findLocators(String locator, String value) {
		WebElement findElement = null;
		switch (locator) {
		case "id":
			findElement = driver.findElement(By.id(value));
			break;
		case "xpath":
			findElement = driver.findElement(By.xpath(value));
			break;

		default:
			break;
		}
		return findElement;

	}

	public static String eleText(WebElement element) {
		return element.getText();

	}

	public static void jsColour(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	public static void jsScrollToElement(WebElement element) {
		executor.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static String getAttributeValue(WebElement element, String name) {
		return element.getAttribute(name);
	}

	public static void windowHandle() {
		String prtWin = driver.getWindowHandle();
		Set<String> allChildWin = driver.getWindowHandles();
		for (String childWin : allChildWin) {
			
			if (!(prtWin.equals(childWin))) {
				driver.switchTo().window(childWin);
			}
		}

	}
public static void prtWindowControl() {
	String prtWin = driver.getWindowHandle();
	Set<String> allChildWin = driver.getWindowHandles();
	for (String childWin : allChildWin) {
		
		if ((prtWin.equals(childWin))) {
			driver.switchTo().window(childWin);
		}
	}

}


	public static void downloadImage(String APIURL,String date, String recordFirstName, String recordLastName) throws IOException {

		try (InputStream in = new URL(APIURL).openStream()) {
			
			String TIFImageLoc = "C:\\PK\\Workspace\\TestNG\\"+date+"\\Image\\"+ recordFirstName + "_" + recordLastName + ".tif";
			Files.copy(in, Paths.get(TIFImageLoc));
			System.out.println(TIFImageLoc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
