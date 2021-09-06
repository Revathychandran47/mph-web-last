package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Refer_a_friend_positive_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement from,to,element;

	/*TC 001 - Validate that user can able to view Refer a Friend under Home page*/
	@Given("Browser is open")	
	public  void browser_launching() throws Exception  {
		try {
			Browser_Launch();
			browser_wait(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Login with valid data")
	public void loginWithValidData() throws Exception {
		try {
			login(6,7);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_loginWithValidData");
		}
	}	
	@Then("verify Tell your friends about Mpowered Health text and logo is displayed")
	public static void verify_logo() throws Exception   {
		try {
			browser_wait(6000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_home_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_home_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_verify_logo");
		}
	}

	/*TC 002 -   Validate that user can able to click on Refer a Friend button */
	@When("clicks on Refer a Friend")
	public static void click_refer_friend() throws Exception   {
		try {
			browser_wait(6000);
			click("refer_a_frnd_home_button");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_click_refer_friend");
		}
	}
	@And("navigated to Refer a Friend landing page")
	public void navigate_to_refer_a_friend() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_friend_navigate_to_refer_a_friend");
		}
	}
	@Then("verify referral code text is displayed")
	public static void verify_referral_text() throws Exception   {
		try {
			browser_wait(1000);
			browser_explicit_wait("refer_a_frnd_referral_code",60);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_referral_code"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_tc_003verify_referral_text");
		}
	}

	/*TC 003 -  Validate that user must be able to view the referral code text */
	@When("clicks on 'Share Link' button")
	public static void click_on_share_link() throws Exception{
		try {
			browser_wait(1000);
			click("refer_a_frnd_share_link_button");	
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_copy_link"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_click_on_share_link");
		}
	}
	@And("clicks on copy the link")
	public static void copy_link() throws Exception   {
		try {
			browser_wait(1000);
			click("refer_a_frnd_copy_link");				 
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_copy_link");
		}
	}
	@Then("verify 'copied text' is displayed")
	public static void verify_copied_text() throws Exception   {
		try {		
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_copied_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_verify_copied_text");
		}
	}

	/*TC_004- Validate that the user should able to see a Pop Up box when clicking on 'Share a link' */
	@When("clicks on 'Facebook'")
	public void clicks_on_facebook() throws Exception {
		try {
			browser_wait(5000);
			click_javascript("refer_a_frnd_share_link_button");
			browser_wait(1000);
			click("refer_a_frnd_facebook");				
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_clicks_on_facebook");
		}	
	}
	@Then("verify 'error message' is displayed")
	public static void error_message() throws Exception   {
		try {		
			browser_wait(1000);
			browser_handle();
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_facebook_error"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_close();
			browser_wait(1000);
			browser_switch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_error_message");
		}
	}

	/* TC_005-	Validate that the user should able to copy the link	 */
	@When("clicks on 'Mail'")
	public void clicks_mail() throws Exception {
		try {
			browser_wait(1000);
			click("refer_a_frnd_share_link_button");
			browser_wait(1000);
			click("refer_a_frnd_shareclose");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_clicks_mail");
		}			
	}
	@Then("verify mail is open")
	public static void open_mail() throws Exception   {
		try {
			browser_wait(10000);
			firebrowser_handle();	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_open_mail");
		}
	}

	/*TC 006 -  Validate that user can view How its works  */
	@When("Login with valid mail and password")
	public void login_mail() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("refer_a_frnd_email"))).sendKeys(td_reader("refer_a_frnd_email"));
			driver.findElement(By.xpath(OR_reader("refer_a_frnd_mailnext"))).click();
			element = waituntil("refer_a_frnd_mailpassword");
			element.sendKeys(td_reader("refer_a_frnd_mailpassword"));
			driver.findElement(By.xpath(OR_reader("refer_a_frnd_mailpasswordnext"))).click();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_login_mail");
		}
	}
	@Then("clicks on 'send'")
	public void clicks_send() throws Exception {
		try {
			element = waituntil("refer_a_frnd_mailto");
			element.sendKeys(td_reader("refer_a_frnd_mailto"));
			driver.findElement(By.xpath(OR_reader("refer_a_frnd_mailsend"))).click();
			browser_wait(9000);
			browser_switch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_clicks_send");
		}		
	}

	/*TC 007 - Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code*/
	@Given("verify Invite your friends to Mpowered Health is displayed")
	public static void first_grid_text_checker() throws Exception   {
		try {			
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_howits_work"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_first_grid_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_first_grid_text_checker");
		}
	}
	@When("clicks to slide the grid")
	public static void grid_slideer() throws Exception   {
		try {
			from = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_carousal_from")));
			to = driver.findElement(By.xpath(OR_reader("refer_a_frnd_carousal_to")));
			Actions action = new Actions(driver);
			action.dragAndDrop(from, to).perform();		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_grid_slideer");
		}
	}
	@Then("navigated to next slide")
	public static void nextslide() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_carousal_from"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_nextslide");
		}
	}

	/*TC 008 -  Validate that user can clicks on the link More information & FAQ and navigated to Frequently asked questions page*/
	@When("clicks on the link More information & FAQ")
	public static void clicks_on_more_info() throws Exception   {
		try {
			click("refer_a_frnd_faq_link");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_clicks_on_more_info");
		}
	}
	@Then("verify list of Frequently asked questions")
	public static void verify_faq() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Refer a friend positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_frnd_positive_verify_faq");
		}
	}
}