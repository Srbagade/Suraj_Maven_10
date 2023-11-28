package Module_01_LoginTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module_01_Login.SwagLabHomePage;
import Module_01_Login.SwagLabLoginPage;
import Module_01_Login.SwagLabMenuPage;

public class TC1_SwaglabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException 
	{
		initilizeBrowser();
		login=new SwagLabLoginPage(driver);
		home=new SwagLabHomePage(driver);
		menu=new SwagLabMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException 
	{
		login.inpSwagLabLoginPageUserName(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagePass(UtilityClass.getDataFromPF("PWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageLoginBtn();
	}
	@Test
	public void verifyTitle() throws EncryptedDocumentException, IOException 
	{
		TCID=121;
		String actTitle = home.getSwagLabHomePageTitle();
		String expTitle = UtilityClass.getTD(0, 2);
		Assert.assertEquals(actTitle, expTitle,"Failed, Both Results Are Diff");
	}
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException 
	{
		if (s1.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.captureSS(driver, TCID);
		}
		
		home.clickSwagLabHomePageMenuBtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPageLogoutBtn();
		Thread.sleep(1000);
	}
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
	
	
	

}
