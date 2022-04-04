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
import static org.junit.Assert.*
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


def bannette = GlobalVariable.Bannette
//CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'perso'], FailureHandling.OPTIONAL)
//WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)
CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'('E2E_Dossier_PDC_Delete', bannette)
//WebUI.callTestCase(findTestCase('Tools/Ajout dossier'), ['dossier':'E2E_Dossier_PDC_Delete'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':'E2E_Dossier_PDC_Delete'], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
//CustomKeywords.'utils.Corbeille.VerifE2EDocCorbeille'('E2E_Dossier_PDC_Delete')
WebUI.delay(3)

/*vérifie si la page courante est déjà la page Ma corbeille */
result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'),FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyEqual(result, "Ma corbeille", FailureHandling.OPTIONAL)) {
	println "La page Ma corbeille est actuellement ouverte"
}else{
	WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
	if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))) {
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'("La page Ma corbeille est absente dans la liste des corbeilles")
	}
}
CustomKeywords.'utils.Corbeille.SelectItem'('E2E_Dossier_PDC_Delete')
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Restaurer_selection'))
/*WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/popup-confirmation-titre'), 60)
def opt = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/popup-confirmation-titre'))*/
//CustomKeywords.'utils.Corbeille.BoutonValider'("Restauration")

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/btn_Valider_Restauration'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/btn_Valider_Restauration'))

/*for (index = 10;index<=12;index++) {
	idValider = "/html/body/div["+index+"]/md-dialog/form/md-dialog-actions[2]/button[2]"
	if(WebUI.getText(findTestObject('Object Repository/Xpath',['index':idValider]), FailureHandling.OPTIONAL).contains("Valider")) {
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Xpath',['index':idValider]))
	}
}*/
CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(bannette)

//assertTrue(WebUI.verifyTextPresent('E2E_Dossier_PDC_Delete', false))
//CustomKeywords.'utils.Bannettes.CheckBannetteVueDocumentaire'(GlobalVariable.Bannette)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
if (WebUI.verifyTextPresent('E2E_Dossier_PDC_Delete', false)) {
	WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), [('Dossier') : 'E2E_Dossier_PDC_Delete'], FailureHandling.STOP_ON_FAILURE)
//	////def bannette = GlobalVariable.Bannette
	// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
	WebUI.delay(3)
	
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le dossier n\'est pas restauré !!!')
}


