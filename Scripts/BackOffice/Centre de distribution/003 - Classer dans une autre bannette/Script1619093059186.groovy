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




 if (WebUI.verifyElementVisible(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))) {
			WebUI.click(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))
           
        }else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Centre de distribution n\'est pas disponible')
 
assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Centre de distribution/champ_recherche')))

String [] txt = WebUI.getText(findTestObject('Object Repository/Page_Centre de distribution/list_imagette')).split('\n')

if (txt.size()>0) {
	WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/premiere_imagette'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Centre de distribution/bannette_cible'),120)
	
	WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/bannette_cible'))
	
	if (!WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Centre de distribution/button_Transferer'))) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "TRANSFERER" est absent !!!')
	} else {
		WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/button_Transferer'))
		WebUI.refresh()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/Aperçu'), 120)
	/*if(	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/msg_confirmation'), 200, FailureHandling.OPTIONAL) ==true) {
		
		msg = (WebUI.getText(findTestObject('Object Repository/Page_Centre de distribution/msg_confirmation')))
		
		if (msg != 'Vous n\'avez pas les droits d\'écriture nécessaires sur ce document.') {
			println('TRANSFERT OK')
			
			
		} else println('TRANSFERT ECHOUE\n' + msg)
		
	} else CustomKeywords.'utils.utilsFail.customlaunchFail'("Le message n'est pas affiché ")*/
		
	}
		
} else CustomKeywords.'utils.utilsFail.customlaunchFail'('La liste est vide !!!')


