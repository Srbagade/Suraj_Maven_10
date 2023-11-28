package Module_01_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement MenuBtn;
	WebDriver driver;

	public SwagLabHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSwagLabHomePageTitle() 
	{
		String actTitle = driver.getTitle();
		
		return actTitle;
	}
	public void clickSwagLabHomePageMenuBtn() 
	{
		MenuBtn.click();
	}
}
