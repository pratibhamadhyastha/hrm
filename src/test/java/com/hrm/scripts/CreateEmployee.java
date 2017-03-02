package com.hrm.scripts;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AddEmpPage;
import com.pages.DashboardPage;
import com.pages.EmpPersonalDetailsPage;

public class CreateEmployee extends BaseTest {
	 @Test
	 public void testCreateEmployee()
	 {
		 //click on PIM
		 DashboardPage dbPage=new DashboardPage(driver);
		 dbPage.clickPIM_Menu();
		 //click on Add Emp
		 dbPage.clickAddEmp_Menu();
		 //verify AddEmpPage
		 AddEmpPage aePage=new AddEmpPage(driver);
		 aePage.verifyURLhas("addEmployee");
		 //enter valid FN
		 aePage.setFirstName("pratibha");
		 //enter valid LN
		 aePage.setLastName("madhyastha");
		 //click on Save
		 aePage.clickSave();
		 //verify Emp Personal Details page
	 EmpPersonalDetailsPage epdPage=new EmpPersonalDetailsPage(driver);
		 epdPage.verifyURLhas("viewPersonalDetails");
		 //verify the FN
		 epdPage.verifyFirstName("pratibha");
	 }
}






