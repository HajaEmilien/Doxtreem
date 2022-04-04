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


//def bannette = GlobalVariable.Bannette
//CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'perso'], FailureHandling.OPTIONAL)
//WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)
//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)
//CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'('E2E_Dossier_PDC_Delete', bannette)
//WebUI.callTestCase(findTestCase('Tools/Ajout dossier'), ['dossier':'E2E_Dossier_PDC_Delete'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), [('Dossier') : GlobalVariable.Dossier], FailureHandling.STOP_ON_FAILURE)

/*******************************Accèder à l'écran de la corbeille*********************************/
CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
/************************ supprimer le Dossier dans le corbeille  ********************/
WebUI.callTestCase(findTestCase('Tools/Supprimer Dossier (Corbeille)'), [:], FailureHandling.STOP_ON_FAILURE)

/****************************** Sélectionner Corbeille administrateur ***************** */
CustomKeywords.'utils.Corbeille.SelectAdminCorbeille'()

/**************************** Séléction dossier *************************/
CustomKeywords.'utils.Corbeille.SelectItem'(GlobalVariable.Dossier)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Restaurer_selection'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/btn_Valider_Restauration'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/btn_Valider_Restauration'))

CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)

if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier')).contains(GlobalVariable.Dossier)) {
	assertTrue(WebUI.verifyTextPresent(GlobalVariable.Dossier, false))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le dossier n\'est pas restauré !!!')
}


