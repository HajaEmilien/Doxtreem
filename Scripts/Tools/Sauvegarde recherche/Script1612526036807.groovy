import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

if (GlobalVariable.ovw == true) {
	
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_sauvegarder_la_recherche'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_radio'), 30)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_radio'))
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/liste_recherche_existante'),FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(5)
	
	if (WebUI.verifyElementPresent(findTestObject('Page_Doxtreem - Recherche/md-option_Save_Search',['nomRecherche':nomSvd]), 5,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Save_Search',['nomRecherche':nomSvd]))
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('La recherche sauvegardée "'+ nomSvd + '" est absente de la liste !!!')
	}
		
	//Clic sur le bouton Sauvegarder
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Sauvegarder'),FailureHandling.OPTIONAL)){
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Sauvegarder'))
	}
	
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/msg_confirmationSave'),60)
	WebUI.delay(5)
	
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
		println('Bouton plus cliqué')
		
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
	}
	
} else {
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_sauvegarder_la_recherche'))
	
	//Saisir le nom de la sauvegarde
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_nom_echerche_sauvegarde'), nomSvd)
		
	//Clic sur le bouton Sauvegarder
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Sauvegarder'),FailureHandling.OPTIONAL)){
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Sauvegarder'))
	}
	
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/msg_confirmationSave'), 60)
	WebUI.delay(5)
//	assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Recherche/msg_confirmationSave'),FailureHandling.STOP_ON_FAILURE))

	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
		println('Bouton plus cliqué')
		
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
	}

}
