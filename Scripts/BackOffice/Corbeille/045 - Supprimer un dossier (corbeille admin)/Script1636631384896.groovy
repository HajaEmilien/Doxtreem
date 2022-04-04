import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static org.junit.Assert.*


//CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'perso'], FailureHandling.OPTIONAL)
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'admin'], FailureHandling.OPTIONAL)

//********************************Ajout Dossier ***************************************/
//////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

//CustomKeywords.'utils.Bannettes.CreationBannette'(GlobalVariable.Bannette)
CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)

/********************************suppression Dossier*************************************/
WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), [('Dossier') : GlobalVariable.Dossier], FailureHandling.STOP_ON_FAILURE)

/*******************************Accèder à l'écran de la corbeille*********************************/
CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
/************************ supprimer le Dossier dans le corbeille  ********************/
WebUI.callTestCase(findTestCase('Tools/Supprimer Dossier (Corbeille)'), [:], FailureHandling.STOP_ON_FAILURE)

/****************************** Sélectionner Corbeille administrateur ***************** */
CustomKeywords.'utils.Corbeille.SelectAdminCorbeille'()

/**************************** Séléctionner le document E2E_Document *************************/
CustomKeywords.'utils.Corbeille.SelectItem'(GlobalVariable.Dossier)

assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Text_x_y_Selectionné'), 
        FailureHandling.STOP_ON_FAILURE))

/*************************** User clic on icon suprr **************************************/
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Supprimer_selection'))
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/pop-up-delete'), 120)) {
//	CustomKeywords.'utils.Corbeille.BoutonValider'('Suppression')
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille'), 120)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille'))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Pop-up de confirmation de restauration non affiché en 120 secondes !!!')
}
//
///**************************** User clic on button valider******* */
//CustomKeywords.'utils.Corbeille.BoutonValider'('Suppression')
/******************************* verifier que les doc E2E_Documment ne sont plus présent */
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'),120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'))
WebUI.delay(3)
def Text =  WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/tablo_list_element_corbeille'))
assertFalse(Text.contains(GlobalVariable.Dossier))

// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)



