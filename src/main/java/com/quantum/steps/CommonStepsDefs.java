/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.utils.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


@QAFTestStepProvider
public class CommonStepsDefs {

	@Then("I switch to frame \"(.*?)\"")
	public static void switchToFrame(String nameOrIndex) {
		if (StringUtil.isNumeric(nameOrIndex)) {
			int index = Integer.parseInt(nameOrIndex);
			new WebDriverTestBase().getDriver().switchTo().frame(index);
		} else {
			new WebDriverTestBase().getDriver().switchTo().frame(nameOrIndex);
		}
	}

	@Then("I switch to \"(.*?)\" frame by element")
	public static void switchToFrameByElement(String loc) {
		new WebDriverTestBase().getDriver().switchTo().frame(new QAFExtendedWebElement(loc));
	}

	@When("I am using an AppiumDriver")
	public void testForAppiumDriver() {
		if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
			ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");
	}

	@Then("I should see app first fragment screen with Hello first fragment text and NEXT button")
	public static void validateFirstScreen() {
		new ExpenseTrackerHomePage().validateFirstScreen();
	}

	@Then("I click the NEXT button")
	public static void clickNextButton() {
		new ExpenseTrackerHomePage().clickNextButton();
	}

	@Then("I should see second fragment screen with PREVIOUS button")
	public static void validateSecondScreen() {
		new ExpenseTrackerHomePage().validateSecondScreen();
	}

	@Then("I click the PREVIOUS button")
	public static void clickPreviousButton() {
		new ExpenseTrackerHomePage().clickPreviousButton();
	}

	
}