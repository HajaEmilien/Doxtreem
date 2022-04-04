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
import static org.junit.Assert.*
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory




/********************Création d'un document**************************************/
//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
def nomSearch = 'E2E_Search'
String resultat

/********************Recherche du document nouvellement crée**********************/
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), GlobalVariable.Identifiant, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'))
	println('Bouton recherche cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Recherche n\'est pas disponible')
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'), 120)
TestObject findDoc = new TestObject()
findDoc = findTestObject('Object Repository/Page_Doxtreem - Recherche/RechercheResult')

assertTrue (WebUI.getText(findDoc,FailureHandling.STOP_ON_FAILURE).split('\n').any { it.toString().equals(GlobalVariable.Identifiant) })


WebUI.callTestCase(findTestCase('Test Cases/Tools/Controle existance nom de recherche'), ['nom': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))
WebUI.callTestCase(findTestCase('Tools/Sauvegarde recherche'), ['nomSvd': nomSearch], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche':nomSearch]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Rechercher'), 60)

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Rechercher'), FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Rechercher'))
	WebUI.delay(5)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 60)
	findDoc = findTestObject('Object Repository/Page_Doxtreem - Recherche/RechercheResult')
	
	assertTrue (WebUI.getText(findDoc).split('\n').any { it.toString().equals(GlobalVariable.Identifiant) })
		CustomKeywords.'utils.Recherche.ClickButtonPlus'()
		WebUI.callTestCase(findTestCase('Tools/Suppression recherche sauvegardée'), ['varNom':nomSearch.trim()], FailureHandling.OPTIONAL)
		
		
	
}
else{
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur lors de sélection de la sauvegarde')
}

////def bannette = GlobalVariable.Bannette
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)


