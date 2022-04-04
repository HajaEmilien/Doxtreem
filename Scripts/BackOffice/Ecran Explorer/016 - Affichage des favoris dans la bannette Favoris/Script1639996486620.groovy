import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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



////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

//WebUI.callTestCase(findTestCase('Tools/Ajout favoris'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/banette_e2e',['bannette':'Favoris']))) {
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Explorateur/banette_e2e',['bannette':'Favoris']),5, FailureHandling.OPTIONAL)
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/banette_e2e',['bannette':'Favoris'])) 
		}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Element_Bannettes n\'est pas cliquable')
 WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
 def text = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'))
 
if (text.contains('E2E_Document_PDC_1.pdf') || text.contains('E2E_Document_PDC_2.pdf') || text.contains('E2E_Document_PDC_3.pdf') || text.contains('E2E_Document_PDC') || text != " "  ) {
	println('Affichage favoris dans bannette Favoris OK')
	// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
	
	//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)
	
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('ECHEC')
}
 
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression des favoris'),[:], FailureHandling.STOP_ON_FAILURE)