package Module_01_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage 
{
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")private WebElement LogoutBtn;
	
	public SwagLabMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwagLabMenuPageLogoutBtn() 
	{
		LogoutBtn.click();
	}
	

}
