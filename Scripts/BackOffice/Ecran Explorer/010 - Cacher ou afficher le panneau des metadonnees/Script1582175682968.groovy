import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join


if (WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'), FailureHandling.OPTIONAL)) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('l\'icone Taille_icon_folder n\'est pas visible sur la page')
	   }
  
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'))


if (WebUI.verifyElementNotVisible(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'), FailureHandling.OPTIONAL)) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('element md_icon_Voir_les_Infos non visible sur la page')
        }
   
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'), 120)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'))
if( WebUI.verifyTextNotPresent("DÉTAILS", false)) {
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'))
}
assertTrue(WebUI.verifyTextPresent("DÉTAILS", false))

