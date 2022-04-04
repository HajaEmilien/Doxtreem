import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.*


void ActivAndDesecActivRechercheContextuelle (String data) {
Console.println(data)
WebUI.callTestCase(findTestCase('Tools/Accès Editeur Clefs application'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/input_Filtrer les cls_inputId'), 
    'contextualSearch', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('public.Doxtreem.contextualSearch', false)

def Text = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/span_false'), FailureHandling.STOP_ON_FAILURE)

Console.println(Text)

if (Text.toUpperCase() != data.toUpperCase()) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/span_false'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/SelectOption'), FailureHandling.STOP_ON_FAILURE)
    WebUI.click(findTestObject('Page_Doxtreem - Recherche/Recherche Contextuelle/div_True', ['value':data]))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Btn_sauvegarder'))

    WebUI.callTestCase(findTestCase('Tools/Recharge du cache serveur'), [:], FailureHandling.STOP_ON_FAILURE)
}
}
ActivAndDesecActivRechercheContextuelle ("True")
//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

CustomKeywords.'utils.Recherche.ClickButtonPlus'()

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Btn_Rercherche_Contextuelle'))

def Textcontextuelle = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Text_btn_contextuel'))

CustomKeywords.'utils.Recherche.SaisirNomCompletElement'('E2E_Document_PDC')

if (Textcontextuelle != 'Recherche contextuelle activée') {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Btn_Rercherche_Contextuelle'))
    WebUI.verifyElementText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Text_btn_contextuel'), 
        'Recherche contextuelle activée', FailureHandling.STOP_ON_FAILURE)
}
/*impossible de recuperer le text contenant : "context"*/
/*def textchamprrecherhe = WebUI.getText(findTestObject('Page_Doxtreem - Recherche/Recherche Contextuelle/ContainsCherch') )
Console.println(textchamprrecherhe)
if (textchamprrecherhe !=" ") {
assertTrue(WebUI.verifyTextPresent(" ", false))
//}*/

//WebUI.delay(2)
CustomKeywords.'utils.Recherche.CLickboutonRechercher'()

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Document_E2E'), 30)
def TextDoc = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Recherche Contextuelle/Document_E2E'))
assertTrue(TextDoc.contains("E2E_Document_PDC"))
/*******************************suppression dossier***************************************/
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)

/*******************************suppression de la Bannette********************************/
////def bannette = GlobalVariable.Bannette

// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

WebUI.delay(5)
ActivAndDesecActivRechercheContextuelle ("False")


