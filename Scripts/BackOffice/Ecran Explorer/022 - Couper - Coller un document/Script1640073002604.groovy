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


//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/ligne_teableau___',['position':1]))

fichier = WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/ligne_teableau___',['position':1])).split('\n')[0]
repCible = GlobalVariable.Dossier 
repDestination = 'E2E_Dossier_PDC_2'

/*Couper et Coller */
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'), 120)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Couper'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Chemin_repertoire'))

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

if (!tablo.contains(repDestination)) {
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Boutton_NouveauDossier'))
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/input_Nom_dossierCree'), repDestination)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Crer'))
	
	/*************************************Est-ce qu'on a le message de confirmation**************************************/
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'), 20)
	
	tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
	
	def num = 0
	for (int index = 0; index <= tablo.size()-1; index +=4){
		num ++
		if (tablo[index]== repDestination){
			WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 120, FailureHandling.OPTIONAL)
			WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
			break
		}
	}
} else {
	def num = 0
	for (int index = 0; index <= tablo.size()-1; index +=4){
		num ++
		if (tablo[index]== repDestination){
			WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 120, FailureHandling.OPTIONAL)
			WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
			break
		}
	}
	
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tableau_ListeDossier'))
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'), 120)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_CopierCouperColler'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'), 120, FailureHandling.STOP_ON_FAILURE)
if(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'))==true) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Coller'))
}

WebUI.delay(5)
if (WebUI.verifyTextPresent('Sélectionner la catégorie du document', false)) {
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/liste_categorie'))
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/list_element'))
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/btn_valider'))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Impossible de coller le document !!!')
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
if (WebUI.verifyTextPresent(fichier, false, FailureHandling.OPTIONAL)) {
	println('Le fichier est bien collé dans le répertoire !')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le fichier n\'est pas collé dans le répertoire !!!')
}

/* Vérification dans le répertoire E2E_Dossier_PDC */
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Chemin_repertoire'))
tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

num = 0
for (int index = 0; index <= tablo.size()-1; index +=4){
	num ++
	if (tablo[index]== repCible){
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 120, FailureHandling.OPTIONAL)
		WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
		break
	}
}

assertTrue(WebUI.verifyTextNotPresent(fichier, false))
	
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)

