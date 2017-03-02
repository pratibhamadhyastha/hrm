package com.hrm.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.DashboardPage;
import com.pages.EmpInfoPage;

public class VerifyDuplicateOption extends BaseTest {
	@Test
	public void testVerifyDuplicateOption(){
		
		//click on PIM
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		//verify the include box has duplicates
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyDuplicateOption();
	}

}
