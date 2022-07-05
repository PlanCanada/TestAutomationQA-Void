package dE.Page.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Common;

public class PlanCanadaHomePage extends Page {

	@FindBy(xpath="//div[@class='cta-button']//a[text()='Donate']")
	private WebElement btn_donateButton;
	
	@FindBy(xpath="//label[@class='switch-label switch-label-No']")
	private WebElement btn_oneTimeButton;
	
	@FindBy(xpath="//label[text()='$25']")
	private WebElement lbl_priceValue;
	
	@FindBy(xpath="//label[text()='$50']")
	private WebElement lbl_priceValue_50;
	
	@FindBy(xpath="//label[text()='$100']")
	private WebElement lbl_priceValue_100;
	
	@FindBy(xpath="//label[text()='Other']")
	private WebElement lbl_priceValue_Other;
	@FindBy(xpath="//button[@class='btn--primary formSubmit donationformsubmit']")
	private WebElement txt_continueMyDonate;
	
	@FindBy(id="VPCIFirstName")
	private WebElement txt_vpcifFirstName;
	
	@FindBy(xpath="//input[@id='VPCILastName']")
	private WebElement txt_vpcifLastName;

	@FindBy(xpath="//input[@id='VPCIFormModel_Email']")
	private WebElement txt_vpcifEmail;
	
	@FindBy(xpath="//input[@id='VPCIAddress']")
	private WebElement txt_vpcifAddress;
	
	@FindBy(xpath="//input[@id='VPCICity']")
	private WebElement txt_vpcifCity;
	
	@FindBy(xpath="//select[@id='VPCIProvince']")
	private WebElement slct_vpcifProvince;
	
	@FindBy(xpath="//input[@id='VPCIPostalCode']")
	private WebElement txt_vpcifPostalCode;
	
	@FindBy(xpath="//input[@id='VPCIPhoneOptional']")
	private WebElement txt_vpcifPhoneNumber;
		
	@FindBy(xpath="//input[@id='CardNumber']")
	private WebElement txt_cardNumber;
	
	@FindBy(xpath="//input[@id='ChFirstName']")
	private WebElement txt_chFirstName;
	
	@FindBy(xpath="//input[@id='ChLastName']")
	private WebElement txt_chLastName;
	
	@FindBy(xpath="//input[@id='ExpirationDate']")
	private WebElement txt_expirationDate;
	
	@FindBy(xpath="//input[@id='SecurityCode']")
	private WebElement txt_securityCode;
	
	@FindBy(xpath="//label[text()='Same as contact address']")
	private WebElement lbl_samebillingInformationCheckbox;
	
	@FindBy(xpath="//input[@id='Address']")
	private WebElement txt_billingAddress;
	
	@FindBy(xpath="//input[@id='AddressOptional']")
	private WebElement txt_billingAddressOptional;
	
	@FindBy(xpath="//input[@id='City']")
	private WebElement txt_billingCity;
	
	@FindBy(xpath="//select[@id='Province']")
	private WebElement slct_billingProvince;
	
	@FindBy(xpath="//input[@id='PostalCode']")
	private WebElement txt_billingPostalCode;
	
	@FindBy(xpath="//button[@class='btn--primary formSubmit']")
	private WebElement btn_donateNow;
	
	@FindBy(xpath="//h1[text()='Thank you for your donation!']")
	private WebElement txt_successValidationMsg;
	

	public PlanCanadaHomePage(WebDriver browser) {
		super(browser);		
	}

	@Override
	public boolean isValidPage() {
		if (isElementPresent(btn_donateButton)) {
			return true;
		}
		return false;
	}
//
//	@Override
//	protected void waitForPageLoad() {
//		try{
//			new WebDriverWait(browser,30).
//			until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")));				
//		}catch(Exception e){
//			System.out.println(e.getMessage());			
//		}
//	}
	
	
	//==========================================================
	
	public void clickOnDonate()
	{
		clickOn(btn_donateButton, "Donate button");
		clickOn(btn_oneTimeButton, "One Time");
		if(Common.retrieve("PriceValue").equals("25"))
		{
			clickOn(lbl_priceValue, "Price $25");
		}
		else if(Common.retrieve("PriceValue").equals("50"))
		{
			clickOn(lbl_priceValue_50, "Price $50");
		}
		
		else if(Common.retrieve("PriceValue").equals("100"))
		{
			clickOn(lbl_priceValue_100, "Price $100");
		}
		
		else if(Common.retrieve("PriceValue").equals("Other"))
		{
			clickOn(lbl_priceValue_Other, "Price $5");
		}
		
		clickOn(txt_continueMyDonate, "Continue My Donation");
	}
	public void enterContactInformation()
	{
		enterText(txt_vpcifFirstName,Common.retrieve("FirstName"));
		enterText(txt_vpcifLastName,Common.retrieve("LastName"));
		String emailAddressTimeStamp = getCurrentDateAndTimeStamp()+"_"+Common.retrieve("EmailAddress");
		enterText(txt_vpcifEmail,emailAddressTimeStamp);
		enterText(txt_vpcifAddress,Common.retrieve("Address"));
		enterText(txt_vpcifCity,Common.retrieve("City"));
		selectByVisisbleText(slct_vpcifProvince,"Province",Common.retrieve("Province"));
		enterText(txt_vpcifPostalCode,Common.retrieve("PostalCode"));
		enterText(txt_vpcifPhoneNumber,Common.retrieve("Phone"));
	}
	
	public void enterPaymentInformation()
	{
		enterText(txt_cardNumber, Common.retrieve("PaymentNumber"));
		enterText(txt_chFirstName, Common.retrieve("PaymentFirstName"));
		enterText(txt_chLastName, Common.retrieve("PaymentLastName"));
		enterText(txt_expirationDate, Common.retrieve("paymentExpDate"));
		enterText(txt_securityCode, Common.retrieve("PaymentSecurityCode"));
		
	}
	
	public void clickOnBillingInformationCheckbox()
	{
		clickOn(lbl_samebillingInformationCheckbox, "Same As contact Address");
		
	}
	
	public void clickOnDonateNow()
	{
		clickOn(btn_donateNow, "Donate Now");
		isElementPresent(txt_successValidationMsg);
		
	}

	public void enterBillingInformation()
	{
		enterText(txt_billingAddress, Common.retrieve("SameAsAddress"));
		enterText(txt_billingAddressOptional, Common.retrieve("SameAsAddressOptional"));
		enterText(txt_billingCity, Common.retrieve("SameAsCity"));
		selectByVisisbleText(slct_billingProvince, "BillingProvince","Ontario");
		enterText(txt_billingPostalCode, Common.retrieve("SameAsPostalCode"));
		
	}

	@Override
	protected void waitForPageLoad() {
		// TODO Auto-generated method stub
		
	}
	
}
