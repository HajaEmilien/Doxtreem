import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable




if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible') }


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

WebUI.delay(5)
println GlobalVariable.Identifiant
TestObject findDoc = new TestObject()
findDoc = findTestObject('Object Repository/Page_Doxtreem - Recherche/RechercheResult')

assertTrue (WebUI.getText(findDoc,FailureHandling.STOP_ON_FAILURE).split('\n').any { it.toString().equals(GlobalVariable.Identifiant) })


WebUI.callTestCase(findTestCase('Test Cases/Tools/Controle existance nom de recherche'), ['nom': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))
WebUI.callTestCase(findTestCase('Tools/Sauvegarde recherche'), ['nomSvd': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression recherche sauvegardée'), ['varNom': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)
//WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'), 20)
WebUI.delay(5)
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))


