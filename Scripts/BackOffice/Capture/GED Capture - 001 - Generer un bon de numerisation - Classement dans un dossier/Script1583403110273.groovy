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



////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

//WebUI.delay(5)
CustomKeywords.'utils.Bannettes.AccèsDossierDepuisBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_BDN'), 120)
//WebUI.delay(5)

/********************************Est-ce que le bouton générer BDN dans la barre horizontale est accessible********************************/

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_BDN'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le boutton Bon de numérisation n\'est pas accessible')
		}
	

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_BDN'))

/******************selection de la catégorie du document*********************************************/

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Choisir une catgorie'))==false) {
			
			CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'element categorie n\'est pas clickable sur la page')
	
		}



WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Choisir une catgorie'))
//WebUI.delay(3)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Categorie_document_selection_liste_deroulant_BDN'),60)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Categorie_document_selection_liste_deroulant_BDN'))

/*************************************génération BDN********************************/


if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Gnrer'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton generer BDN n\'est pas clickable sur la page')
		}
	
//WebUI.delay(5)
 
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Gnrer'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/Message_Gnration du bon de numrisation russie'), 60)
//WebUI.delay(5)

/*********************Est-ce qu'on a au moins le message de confirmation*********************************/

String result = WebUI.getText(findTestObject('Object Repository/Page_Centre de distribution/Message_Gnration du bon de numrisation russie'),FailureHandling.STOP_ON_FAILURE)
//println result

if (WebUI.verifyEqual(result, "Génération du bon de numérisation réussie !", FailureHandling.OPTIONAL)) {
	println "Génération du bon de numérisation réussie !"
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Annuler_generation_BDN'))
	//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)
	//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
	
	
}else{
	CustomKeywords.'utils.utilsFail.customlaunchFail'('La génération de BDN a échoué !!!!!')
}
