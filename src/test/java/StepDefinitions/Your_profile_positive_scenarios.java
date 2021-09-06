package StepDefinitions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Your_profile_positive_scenarios extends Generic_function{
	public static boolean value;
	public static String text;
	public static File file;

	/*Browser launch*/
	@Given("launch the URL and open login page")
	public void launch_url() throws Exception {
		try {
			Browser_Launch();
			browser_wait(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Enter login data")
	public void login_data() throws Exception {
		login(9,5);
	}
	/*TC 001 - Validate that the  Your Profile  title  should be present in  Your Profile screen*/
	@Then("check Your Profile  title  should be present in  Your Profile screen")
	public void your_profile_positive_tc_001() throws Exception  {
		try {
			browser_wait(5000);
			click("header_menu");
			click("header_profile");
			browser_wait(20000);
			value = driver.findElement(By.xpath(OR_reader( "header_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader( "your_profile_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_001");
		}

	}

	/*TC 002 - Verify the scenario when dialogue box will appear, when click on edit icon  */
	@When("Click on edit icon")
	public void click_edit_icon() throws Exception {
			browser_wait(6000);
			click("profile_edit");
	}

	@Then("Verify the dialogue box")
	public void your_profile_positive_tc_002() throws Exception {
		try {
			browser_wait(7000);
			click("profile_checkbox");
			browser_wait(4000);
			click("profile_send_code");
			browser_wait(9000);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("otp"));
			browser_wait(3000);
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("login_password",11));
			browser_wait(9000);
			click("profile_verify");
			browser_wait(7000);
			click("tab_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_002");
		}
	}
	/*TC 003 - Verify the scenario when edit  the profile details*/
	@When("Edit  the profile details")
	public void yourprofile_positive_tc_003() throws Exception {
		try {
			browser_wait(4000);
			backspace("profile_firstname");
			backspace("profile_lastname");
			backspace("profile_preferredname");
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",2));
			driver.findElement(By.xpath(OR_reader( "profile_lastname"))).sendKeys(td_reader("profile_lastname",2));
			driver.findElement(By.xpath(OR_reader("profile_preferredname"))).sendKeys(td_reader("profile_preferred_name",2));
			click("profile_gender");
			browser_wait(1000);
			text = td_reader("profile_gender");
			drop_down(OR_reader( "profile_dropdownlist"),text); 
			click("profile_bloodgrp");
			browser_wait(1000);
			text = td_reader("profile_bloodgrp");
			drop_down(OR_reader( "profile_dropdownlist"),text); 
			browser_wait(1000);
			click("profile_calender");
			click("tab_ok");
			browser_wait(7000);
			click("profile_save");
			click("tab_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_003");
			System.out.println("fail");
		}
	}

	/*TC 004 - Verify the scenario when adding Email ID in contact details*/
	@When("Add Email ID in contact details")
	public void your_profile_positive_tc_004() throws Exception  {
		try {
			browser_wait(7000);
			click("profile_contact");
//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "profile_contact_assert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			browser_wait(10);
			click("profile_plus");
			value=driver.findElement(By.xpath(OR_reader("profile_add_email_title"))).isDisplayed();
//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "profile_email_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_back();
//			browser_wait(10);
//			driver.findElement(By.xpath(OR_reader("Object_locator", "profile_email"))).sendKeys(td_reader("profile_email",2));
			//click("profile_submit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_positive_tc_004");
			System.out.println("fail");
		}
	}

	/*TC 005 - Verify the scenario when Activate , Edit and  Deactivate the Email ID*/
	@When("Activate , Edit and  Deactivate the Email ID")
	public void your_profile_positive_tc_005() throws Exception {
		try {
//			browser_back(); //to change
			value = driver.findElement(By.xpath(OR_reader("profile_activate"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_explicit_wait("profile_activate",5);
			click("profile_activate");
			//click("profile_yes");
			browser_wait(2000);
			driver.findElement(By.xpath("//span[contains(.,'No')]")).click();
			//click("profile_no");
			//click("tab_ok");
		//	browser_explicit_wait("profile_email_edit");
			//--------------Commenting profile_email_edit as button doesnt work-----------------
			//click("profile_email_edit");
			//browser_back();
/*			click("profile_contact_assert");
			System.out.println(driver.findElement(By.xpath(OR_reader("profile_dot"))).getText());
			click("profile_dot");
			browser_wait(4000);
			text = td_reader("profile_dot");
			drop_down(OR_reader("profile_mail_list"),text); 
			click("profile_yes");
			click("tab_ok");*/
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_positive_tc_005");
		}
	}

	/*TC 006 - Verify the scenario when add Phone Number in contact details.*/
	@When("Add Phone Number in contact details")
	public void your_profile_positive_tc_006() throws Exception {

		try {
			browser_explicit_wait("profile_phno",5);
			click("profile_phno");
			//click("profile_plus");
			//value = driver.findElement(By.xpath(OR_reader("Object_Locator", "profile_add_phone_title"))).isDisplayed();
			//Assert.assertEquals(true,value);
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_phonenumber"))).sendKeys(td_reader("profile_phonenumber"));
			//click("profile_submit");
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_phno_code"))).sendKeys(td_reader("otp"));
			//click("profile_phno_verify");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_positive_tc_006");
			System.out.println("fail");
		}
	}

	/*TC 007 - Verify the scenario when Activate , Edit and  Deactivate the Phone Number*/
	@When("Activate , Edit and  Deactivate the Phone Number")
	public void yourprofile_positive_tc_007() throws Exception {
		try {
			browser_wait(10000);
			click("profile_phno_edit");
			value = driver.findElement(By.xpath(OR_reader("profile_contact_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_contact_assert");
//			click("profile_dot_phno");
//			browser_wait(10);
//			text = td_reader("profile_dot");
//			drop_down(OR_reader("Object_Locator", "profile_phno_list"),text); 
//			click("profile_yes");
//			click("profile_phno_activate");
//			click("profile_yes");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_007");
			System.out.println("fail");
		}

	}

	/*TC 008 - Verify the scenario when add Address in contact details. */
	@When("Add Address in contact details.")
	public void yourprofile_positive_tc_008() throws Exception {
		try {
			browser_wait(7000);
			click("profile_address");
			//click("profile_plus");
			//value = driver.findElement(By.xpath(OR_reader("Object_Locator", "profile_add_address_title"))).isDisplayed();
			//Assert.assertEquals(true,value);
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_save_as"))).sendKeys(td_reader("profile_save_as"));
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_add1"))).sendKeys(td_reader("profile_add1"));
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_add2"))).sendKeys(td_reader("profile_add2"));
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_city"))).sendKeys(td_reader("profile_city"));
			//text = td_reader("profile_state");
			//selectdrop_down("profile_state",text);
			//driver.findElement(By.xpath(OR_reader("Object_locator", "profile_zip"))).sendKeys(td_reader("profile_zip"));
			//click("profile_save");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_008");System.out.println("fail");
		}
	}

	/*TC 009 - Verify the scenario when Activate , Edit , Primary and  Deactivate the Address*/
	@When("Activate , Edit , Primary and  Deactivate the Address")
	public void yourprofile_positive_tc_009() throws Exception {
		try {
			browser_wait(7000);
			value = driver.findElement(By.xpath(OR_reader( "profile_address_activate"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_address_activate");
			click("profile_yes");
			click("profile_address_edit");
			click("profile_address_back");
			click("profile_contact_assert");
			click("profile_dot_address");
			browser_wait(9000);
			text = td_reader("profile_dot");
			drop_down(OR_reader( "profile_address_list"),text);
			click("profile_yes");
			click("profile_address_back");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_009");System.out.println("fail");
		}
	}

	/*TC 010 - Verify the scenario when add Plan coveragee*/
	@When("Add Plan coverage")
	public void yourprofile_positive_tc_010() throws Exception {
		try {
			browser_wait(7000);
			click("profile_plancoverage");
			value = driver.findElement(By.xpath(OR_reader( "profile_plan_coverage_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			//click("profile_plan_plus");
			//value = driver.findElement(By.xpath(OR_reader("profile_addassert"))).isDisplayed();
			//Assert.assertEquals(true,value);
			//driver.findElement(By.xpath(OR_reader( "profile_planname"))).sendKeys(td_reader("profile_planname"));
			//driver.findElement(By.xpath(OR_reader( "profile_plan_holderfname"))).sendKeys(td_reader("profile_plan_holderfname"));
			//driver.findElement(By.xpath(OR_reader( "profile_plan_holderlname"))).sendKeys(td_reader("profile_plan_holderlname"));
			//click("profile_plan_relationship");
			//browser_wait(10);
			//text = td_reader("profile_plan_relationship");
			//drop_down(OR_reader("Object_Locator", "profile_dropdownlist"),text); 
			//driver.findElement(By.xpath(OR_reader( "profile_plan_memberid"))).sendKeys(td_reader("profile_plan_holderlname"));
			//driver.findElement(By.xpath(OR_reader( "profile_plan_groupid"))).sendKeys(td_reader("profile_plan_holderlname"));
			//driver.findElement(By.xpath(OR_reader( "profile_plan_type"))).sendKeys(td_reader("profile_plan_holderlname"));
			//click("profile_plan_save");
			//click("tab_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_010");System.out.println("fail");
		}
	}

	/*TC 011 - Verify the scenario when Activate , Edit , Make primary and  Deactivate the Plan coverage*/
	@When("Activate , Edit , Make primary and  Deactivate the Plan coverage")
	public void yourprofile_positive_tc_011() throws Exception {
		try {
			browser_wait(10000);
			click("profile_plan_edit");
			value = driver.findElement(By.xpath(OR_reader( "profile_plan_editassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_plan_back");
			click("profile_dot_plan");
			browser_wait(1000);
			text = td_reader("profile_dot");
			drop_down(OR_reader( "profile_plan_list"),text);
		}
		catch(StaleElementReferenceException e){
			driver.findElement(By.xpath(OR_reader( "profile_plan_activate"))).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_011");System.out.println("fail");
		}
	} 

	/*TC 012 - Verify the scenario when change the password*/
	@When("Change the password")
	public void yourprofile_positive_tc_012() throws Exception {
		try {
			browser_wait(10000);
			click("profile_plancoverage_back");
			browser_explicit_wait("profile_password_button",5);
			click("profile_password_button");
			value = driver.findElement(By.xpath(OR_reader("profile_passwordassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_blank_password",1000));
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_newpassword",1));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_newpassword",1));
			click("profile_passwordsave");
			click("tab_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_012");System.out.println("fail");
		}

	}

	/*TC 013 -Verify the scenario when password should be displayed on clicking the eye and user can able to save the details*/
	@When("The password should be displayed on clicking the eye")
	public void yourprofile_positive_tc_013() throws Exception {
		try {
			browser_explicit_wait("logout",5);
			click("logout");
			driverquit();
			Browser_Launch();
			value = driver.findElement(By.xpath(OR_reader( "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",11));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("profile_newpassword",1));
			click("login");
			browser_explicit_wait("header_logo",5);
			value = driver.findElement(By.xpath(OR_reader( "header_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("header_menu");
			browser_wait(1000);
			click("header_profile");
			browser_wait(5000);
			value = driver.findElement(By.xpath(OR_reader( "your_profile_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(1000);
			click("profile_edit");
			browser_wait(1000);
			click("profile_checkbox");
			browser_wait(1000);
			click("profile_send_code");
			browser_explicit_wait("profile_enter_code",5);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("otp"));
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("profile_newpassword",1));
			browser_explicit_wait("profile_verify",5);
			click("profile_verify");
			browser_explicit_wait("tab_ok",5);
			click("tab_ok");
			click("profile_password_button");
			value = driver.findElement(By.xpath(OR_reader( "profile_passwordassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_newpassword",1));
			click("profile_oldeye");
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("login_password",15));
			click("profile_neweye");
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("login_password",15));
			click("profile_confirmeye");
			click("profile_passwordsave");
			click("tab_ok");
			System.out.println("Your profile positive");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_013");System.out.println("fail");
		}
	}
// Tc014 - Verify uploading of profile pic successfully
	@When("Click on the profile pic icon")
	public void click_profile_pic_icon() throws Exception {
		browser_back();
		value = driver.findElement(By.xpath(OR_reader( "your_profile_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("profile_picture");
		click("profile_picture");
	}

	@Then("Select file and upload image")
	public void File_UploadImage() throws Exception {
		try {
		click("profile_upload_image");
		click("profile_files");
		file = new File(getprofilepic());
		StringSelection ss = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(400);
		robot.keyRelease(KeyEvent.VK_ENTER);
		click("profile_pic_ok");
		browser_wait(9000);
	}
		catch (Exception Exception) {
			Exception.printStackTrace();
		}
	}

	@Then("Verify the successful upload")
	public void verify_successful_upload() throws Exception {
		value = driver.findElement(By.xpath(OR_reader( "profile_pic_save"))).isDisplayed();
		Assert.assertEquals(true,value);
		driverquit();
	}
}

