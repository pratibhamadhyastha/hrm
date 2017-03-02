package com.hrm.scripts;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.DashboardPage;
import com.pages.EmpInfoPage;

public class DeleteEmployee extends BaseTest{

	@Test
	public void testDeleteEmployee(){
		//click on PIM
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		//verify EMp Info Page
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyURLhas("viewEmployeeList");
		//select the CB of req emp
		eiPage.clickEmpCheckBox("pratibha");
		
		//click Delete
		eiPage.clickDelete();
		//click OK
		eiPage.clickOk();
		//verify emp is deleted
		eiPage.verifyEmpIsNotPresent("pratibha");
	}
}
