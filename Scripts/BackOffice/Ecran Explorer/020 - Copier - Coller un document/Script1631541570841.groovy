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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration



WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':"E2E_Document_PDC"], FailureHandling.STOP_ON_FAILURE)

/*Copier et Coller */
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'), 120)
WebUI.delay(5)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Copier'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tableau_ListeDossier'))
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'), 120)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'), 120, FailureHandling.STOP_ON_FAILURE)
if(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'))==true) {
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'))
}
/*-----------------*/

WebUI.delay(5)
if (WebUI.verifyTextPresent('Sélectionner la catégorie du document', false)) {
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/liste_categorie'))
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/list_element'))
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/btn_valider'))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Impossible de coller le document !!!')
}
WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Chargement_Action_En_cours') , 10 , FailureHandling.OPTIONAL)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
t_nbA = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'))).split('\n')
int cptElement

for (el in t_nbA) {
	if ((el == 'E2E_Document_PDC')) {
		cptElement++
		
	}
}

if (cptElement >1) {
	println('Copie OK. ==> ' + cptElement)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
	//WebUI.delay(2)
	////CustomKeywords.'utils.Bannettes.SuppressionBannette'(GlobalVariable.Bannette)
	//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)
	
} else {
	
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur de copie !!!')
}
