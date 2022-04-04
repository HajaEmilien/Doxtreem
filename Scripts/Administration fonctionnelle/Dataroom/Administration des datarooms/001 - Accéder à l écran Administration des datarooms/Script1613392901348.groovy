import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Administration/button_AdministrationDatarooms'))) {
			WebUI.click(findTestObject('Administration/button_AdministrationDatarooms'))
	}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Administration des datarooms est inacessible')
	

WebUI.delay(5)

assertTrue(WebUI.verifyTextPresent('Administration des datarooms', false))


