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

WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)


		if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Plan de classement modèle' , ('An') : 'Template filing plan'], FailureHandling.OPTIONAL)==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Plan de classement modèle" n\'est pas visible sur la page')
		}
	

//WebUI.delay(2)
/*****************************************Est-ce qu'on a le PDCM à supprimer***************************************/
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/menu_deroulante'),FailureHandling.OPTIONAL)
def clay
def nomb
for (int i = 1; ; i++) {
	
	if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/div_container',["index":i]), 'class', FailureHandling.STOP_ON_FAILURE).contains("md-active")  == true) {
		clay = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/div_container',["index":i]), FailureHandling.STOP_ON_FAILURE).split("\n")
		nomb = i
		break
	}


}

def boolean reponse = false
def num = 1
for (item in clay) {
	if (item.contains("01_E2E_RECETTE_")) {
		println item
		reponse = true
		break
	}
	num++
}


if (reponse == true) {
	
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/item_select',["index":nomb, "iter":num]),1,FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/item_select',["index":nomb, "iter":num]),FailureHandling.STOP_ON_FAILURE)

	/*****************************************suppression du PDCM********************************************************/



		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_supprimer_plan_de_classement_modele'))) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_supprimer_plan_de_classement_modele'))
		} else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton creer PCMD est inaccessible')
	




/******************************************Confirmation de la suppréssion******************************************/	
for (int second = 1; ; second++) {
		if (second >= 20) {
			break
			}
		
		
				
	
		if (WebUI.getAttribute(findTestObject('Object Repository/Administration/division', ["index":second]), 'class',FailureHandling.OPTIONAL) == "md-dialog-container") {
			WebUI.click(findTestObject('Object Repository/Administration/button_oui',["index":second]), FailureHandling.STOP_ON_FAILURE)
			break
		}
	}
}
	/*********************************************Retour à la page Administration fonctionnelle************************************************************/
	
	for (int second = 0; ; second++) {
		if (second >= 2) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Button_retour inaccessible')
				}
				
		try {
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_retour'))) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_retour'))
			break
		}
				}
				catch (Exception e) {
				}
				
		Thread.sleep(1000)
	}
	

