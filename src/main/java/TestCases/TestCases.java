package TestCases;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import PageMethods.SearchHotel;
//import PageMethods.SelectHotel;
import Utilities.Common;
import Utilities.GenericKeywords;
import Utilities.TestLinkConnection;
import dE.Page.Methods.PlanCanadaApplication;
import dE.Page.Methods.PlanCanadaHomePage;


@Listeners({ Utilities.TestListener.class })
public class TestCases extends Common {

	public static int count = 1;
	private PlanCanadaApplication planCanadaApplication;
	private PlanCanadaHomePage planCanadaHomePage;
	
//	private AdactinApplication adactinApplication;
//	private AdactinHomePage adactinHomePage;
//	private SearchHotel searchHotel;
//	private SelectHotel selectHotel;
//	private ForgetPassword ForgetPswd;
//	private ConfirmationPage confirmpage;
//	private NewUserRegistration Registrationpage;


	@BeforeClass
	public void start(){	
		GenericKeywords.extent.loadConfig(new File("./Config/extent-config.xml"));		
	}


	public void testStart(String testCaseDescription) {
		GenericKeywords.testFailure = false;
		GenericKeywords.currentStep = 0;
		reportStart(GenericKeywords.testCaseName,testCaseDescription);
		planCanadaApplication=new PlanCanadaApplication();
		planCanadaHomePage=planCanadaApplication.openPlanCanadaApplication();

	}

	public void testEnd() {
		try {
			planCanadaApplication.close();			
		} catch (Exception e) {
			System.out.println("Expception : " + e.getMessage());
		}finally{
			GenericKeywords.extent.endTest(GenericKeywords.parent);
			GenericKeywords.extent.flush();	
			if(getConfigProperty("UpdateTestLinkStatus").toString().trim().toUpperCase().equals("YES")){
				if(GenericKeywords.testFailure){
					TestLinkConnection.updateExecutionStatus(GenericKeywords.testCaseName, "", "FAIL");					
				}else{
					TestLinkConnection.updateExecutionStatus(GenericKeywords.testCaseName, "passed", "PASS");
				}
			}
		}
	}


	@Test(alwaysRun = true)
	public void Today_Donate_AS_A_GuestUser() {
		GenericKeywords.testCaseName = new Exception().getStackTrace()[0].getMethodName();
		testStart("Login to Adactin Application");


			for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			planCanadaHomePage.isValidPage();
			planCanadaHomePage.clickOnDonate();
			planCanadaHomePage.enterContactInformation();
			planCanadaHomePage.enterPaymentInformation();
			planCanadaHomePage.clickOnBillingInformationCheckbox();
			planCanadaHomePage.clickOnDonateNow();
			
			testStepInfoEnd(testDataSet);
		}
		testEnd();

	}
	@Test(alwaysRun = true)
	public void Today_Donate_AS_A_GuestUser_login() {
		GenericKeywords.testCaseName = new Exception().getStackTrace()[0].getMethodName();
		testStart("Login to Adactin Application");


			for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			planCanadaHomePage.isValidPage();
			planCanadaHomePage.clickOnDonate();
			planCanadaHomePage.enterContactInformation();
			planCanadaHomePage.enterPaymentInformation();
			planCanadaHomePage.clickOnBillingInformationCheckbox();
			planCanadaHomePage.clickOnDonateNow();
			
			testStepInfoEnd(testDataSet);
		}
		testEnd();

	}



	


	

}
