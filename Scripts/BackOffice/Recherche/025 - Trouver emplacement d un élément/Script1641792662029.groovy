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
import org.codehaus.groovy.runtime.StringGroovyMethods

def list = []


/********************Création d'un document**************************************/
//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)

/********************Recherche du document nouvellement crée**********************/
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), GlobalVariable.Identifiant, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'))
	println('Bouton recherche cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Recherche n\'est pas disponible')
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'), 120)
WebUI.delay(5)
TestObject findDoc = new TestObject()
findDoc = findTestObject('Object Repository/Page_Doxtreem - Recherche/RechercheResult')

assertTrue (WebUI.getText(findDoc,FailureHandling.STOP_ON_FAILURE).split('\n').any { it.toString().equals(GlobalVariable.Identifiant) })


list = WebUI.getText(findDoc).split('\n').grep { it.toString() ==~ '[0-9]*'}
def nline

if (!list.empty) {
		list.eachWithIndex { it, i ->
			if (it== GlobalVariable.Identifiant) {
				nline = i+1
			}
		}
	
} else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le resultat de la recherche est vide ou retourne un tableau vide')
println nline

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_resultat'), FailureHandling.OPTIONAL)) {
	println('Affichage en mode "Liste"')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Liste_1Element',['numLigne':nline]))
}else {
	println('Affichage en mode "Grille"')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Grille_1Element',['numLigne':nline]))
}

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement'))

String element

for (i=10;i<=15;i++) {
	if (WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]), 'aria-label', 'Ouvrir dans l\'onglet actuel', 2, FailureHandling.OPTIONAL)) {
			
			if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i])) != "") {
				element = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]))
				println('Emplacement trouver : '+element)
				
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]))
				
				
			}else {
				println('L\'élément n\'a pas de parent !!!')
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_close'))
				
			}
			break
		
	}
}



////def bannette = GlobalVariable.Bannette
//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)
