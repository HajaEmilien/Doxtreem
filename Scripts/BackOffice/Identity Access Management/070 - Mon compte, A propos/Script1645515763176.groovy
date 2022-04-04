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

//WebUI.callTestCase(findTestCase('Tools/Connect'), [:], FailureHandling.OPTIONAL)

	if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))) {
			WebUI.click(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))
			
	}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Mon Profil n\'est pas disponible')
	

if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Explorateur/button_ propos'))) {
    WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_ propos'))

    //assertTrue(WebUI.verifyTextPresent('A propos', false,FailureHandling.STOP_ON_FAILURE))
	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ propos_OK')))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ propos_OK'))
	
}
else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton A Propos n\'est pas disponible !!!')
}
//WebUI.callTestCase(findTestCase('Tools/Deconnect'), [:], FailureHandling.OPTIONAL)


