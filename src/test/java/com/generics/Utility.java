package com.generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Utility {
	// to sort the list
	
	public static boolean isListSorted(ArrayList<String> allText){
		ArrayList<String> clone=new ArrayList<String>(allText);
		//java.util.Collections.sort(clone);
		Collections.sort(clone);
		return allText.equals(clone);
	}
	//to read the elemnt from checkbox
	public static ArrayList<String> getAllTextFromListBox(WebElement listBox){
		Select select=new Select(listBox);
		List<WebElement> allOptions=select.getOptions();
		ArrayList<String> allText=new ArrayList<String>();
		for(int i=1;i<allOptions.size();i++){
			String text=allOptions.get(i).getText();
			allText.add(text);
		}
		return allText;
	}
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	
	public static String getScreenShot(WebDriver driver, String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		TakesScreenshot page=(TakesScreenshot) driver;
		try{
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		}catch(Exception e){
			
		}
		return imagePath;
		
	}
	
	public static String getScreenShot(String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		
		try{
			Dimension desktopSize=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		}
		catch(Exception e){
		}

		return imagePath;
		
	}
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(filePath));
			value=ppt.getProperty(key);
		}
		catch(Exception e){
		}
		return value;
	}
	
	public static void clickUsingJS(WebDriver driver,WebElement element){
		  JavascriptExecutor j=(JavascriptExecutor) driver;
		  j.executeScript("arguments[0].click();", element);
		  }
}
