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
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.Select as Select
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


nom = 'E2E_Search'

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
		}
	

/********************Recherche du document nouvellement crée**********************/
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 'E2E_Document_PDC', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'))
	println('Bouton recherche cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Recherche n\'est pas disponible')
}

WebUI.delay(5)

GlobalVariable.ovw = WebUI.callTestCase(findTestCase('Test Cases/Tools/Controle existance nom de recherche'), ['nom': nom.trim()], FailureHandling.STOP_ON_FAILURE)
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))

//GlobalVariable.ovw = false
WebUI.callTestCase(findTestCase('Tools/Sauvegarde recherche'), ['nomSvd': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)

//Clic sur la liste
WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche':nom.trim()]))
WebUI.delay(3)

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_icon_bannette_personnelle'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_icon_bannette_personnelle'))
}

WebUI.delay(3)
/*//TestObject MyTestObject1 = findTestObject('Object Repository/Page_Doxtreem - Recherche/Nom de la bannette')
input = "/html/body/div[12]/md-dialog//input[starts-with(@id,'input_')]"
//claie = WebUI.getAttribute(MyTestObject1, "for")
WebUI.setText(findTestObject('Object Repository/Xpath',['index':input]), "Personnelle_Search_E2E")*/
for( int i =10 ; i<=12;i++) {
	input = "/html/body/div["+i+"]/md-dialog//input[starts-with(@id,'input_')]"
	WebUI.setText(findTestObject('Object Repository/Xpath',['index':input]), "Personnelle_Search_E2E", FailureHandling.OPTIONAL)
	if(WebUI.verifyTextPresent("Personnelle_Search_E2E", false, FailureHandling.OPTIONAL)) {
		break
		}
	}
WebUI.delay(3)
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_Crer la bannette'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_Crer la bannette'))
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/msg_confirmation'), 60)
	WebUI.refresh()
	CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
	/**************************************Trouver la bannette Personnelle_E2E et supprimer*************************************/
	
def entet = CustomKeywords.'utils.Bannettes.ChercheIdBannette'('Personnelle_Search_E2E')	
	
/*tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Tablo_explorer')).split('([0-9]*) / ([0-9]*)')

def entet
def num
tablo.eachWithIndex { it,i ->
	if (it.toString().split('\n').any { it.equals('Personnelle_Search_E2E') }) {
		num = i+1 
		entet = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/id_cible', ["index":num]), 'id', FailureHandling.STOP_ON_FAILURE)
	}
}*/

	button_delete = "//*[@id=\"" + entet + "\"]/section[1]/section[3]/button[2]/md-icon"
	
	
	
		WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression bannette perso'), ['index':button_delete], FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		CustomKeywords.'utils.Recherche.ClickButtonPlus'()
		WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression recherche sauvegardée'), ['varNom': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)
		println ('Suppression personnelle réussie')
		
	}

