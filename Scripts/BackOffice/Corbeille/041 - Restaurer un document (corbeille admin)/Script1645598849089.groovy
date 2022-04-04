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

//WebUI.callTestCase(findTestCase('Tools/Connect'), [:], FailureHandling.STOP_ON_FAILURE)
//
//CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'perso'], FailureHandling.OPTIONAL)
//WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'admin'], FailureHandling.OPTIONAL)

//********************************Créer un document***************************************/
WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
idElement = GlobalVariable.Identifiant
/********************************suppression document*************************************/
WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression document'), ['nomdosuppr':"E2E_Document_PDC"], FailureHandling.STOP_ON_FAILURE)

/*******************************Accèder à l'écran de la corbeille*********************************/
CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
/************************ supprimer un document de ma corbeille ********************/
WebUI.callTestCase(findTestCase('Tools/Supprimer un document (Corbeille)'), [:], FailureHandling.STOP_ON_FAILURE)
/****************************** Sélectionner Corbeille administrateur ***************** */
CustomKeywords.'utils.Corbeille.SelectAdminCorbeille'()
/**************************** Réstaurer le document E2E_Document *************************/
CustomKeywords.'utils.Corbeille.SelectItem'("E2E_Document_PDC")

// Restauration 
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Restaurer_selection'))
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/pop-up-restore'), 240)) {
	//	CustomKeywords.'utils.Corbeille.BoutonValider'('Restauration')
		 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/btn_Valider_Restauration'))
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Pop-up de confirmation de restauration non affiché en 240 secondes !!!')
}

CustomKeywords.'utils.Recherche.ClickButtonPlus'()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/Button_réinitialiser'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Button_réinitialiser'))

WebUI.click(findTestObject('Page_Doxtreem - Recherche/div_Tout_md-off'))

CustomKeywords.'utils.Recherche.SaisirNomCompletElement'('E2E_Document_PDC')

CustomKeywords.'utils.Recherche.CLickboutonRechercher'()
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'), 120)
/**** ------ Sélectionner l'élément à partir de l'identifiant  ------ ****/
if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche')).split('\n').any(){it.equals(idElement)}) {
	WebUI.callTestCase(findTestCase('Test Cases/Tools/Select by ID'), ['idElement':idElement], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/chemin_de_fer'), 240)
	assertTrue(WebUI.getText(findTestObject('Page_Doxtreem - Recherche/chemin_de_fer')) == GlobalVariable.Dossier )
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le document cible n\'est pas parmi la liste restaurée !!!')
	
}
