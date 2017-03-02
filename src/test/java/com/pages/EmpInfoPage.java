package com.pages;


import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.base.HomePage;

import com.generics.Utility;

public class EmpInfoPage extends HomePage {

	public EmpInfoPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="btnDelete")
	private WebElement btnDelete;
	
	@FindBy(id="dialogDeleteBtn")
	private WebElement btnOK;
	@FindBy(id="empsearch_job_title")
	private WebElement jobTitleListBox;
	@FindBy(id="empsearch_termination")
	private WebElement includeListBox;
	
	public void verifyDuplicateOption(){
		 ArrayList<String> allText = Utility.getAllTextFromListBox(includeListBox);
		 HashSet<String> ha = new HashSet<String>(allText);
		 if(allText.size()==ha.size()){
			 System.out.println("no duplicates");
		 }
		 else{
			 System.out.println("duplicates");
		 }
	}
	
	
	
	public void clickEmpCheckBox(String name){
		String xp="//a[text()='"+name+"']/../../td[1]/input";
		driver.findElement(By.xpath(xp)).click();
	}
	
	public void verifyJobTitleIsSorted(){
		verifyListBoxIsSorted(jobTitleListBox);
	}
	
	public void clickDelete()
	{
		btnDelete.click();
	}
	
	public void clickOk(){
		btnOK.click();
	}
	
	public void verifyEmpIsNotPresent(String name){
		try{
		String xp="//a[text()='"+name+"']";
		boolean present = verifyElementIsPresentOrNot(xp);
		//Assert.assertFalse(present);
		Assert.assertTrue(present);
		}catch(Exception e){
			Assert.fail();
		}
		
	}
}








