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
import static org.junit.Assert.*




 if (WebUI.verifyElementVisible(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))==true) {
	WebUI.click(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))        
}else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Centre de distribution n\'est pas disponible')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/Aperçu'), 120)

String [] txt = WebUI.getText(findTestObject('Object Repository/Page_Centre de distribution/list_imagette')).split('\n')

if (txt.size()>0) {
	WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/premiere_imagette'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/ico_information'),120)
	WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/ico_information'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/DialogContent'), 120)
	assertTrue(WebUI.verifyTextPresent('Information du document', false, FailureHandling.OPTIONAL) || WebUI.verifyTextPresent('Document information', false,FailureHandling.OPTIONAL))
	WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/Close_Dialogue'))

	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('La liste est vide !!!')
}

