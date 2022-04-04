import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


////WebUI.delay(10)
nomSearch = 'E2E_Search'

CustomKeywords.'utils.Recherche.VerifierChampReherche'()

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/searchButton'))
/*
//Vérifier que le  champ pour la recherche avancée s'affiche
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bt_radio_dossier'))
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher (Avancee)'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 60)
WebUI.delay(5)
*/
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 160)
String resultat = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL)).split('/')[1]

GlobalVariable.ovw = WebUI.callTestCase(findTestCase('Test Cases/Tools/Controle existance nom de recherche'), ['nom': 'E2E_Search'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/Sauvegarde recherche'), ['nomSvd': nomSearch], FailureHandling.STOP_ON_FAILURE)

/*-----------------------------------*/
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), 60)
WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)
WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche': nomSearch]), 5)){
	WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche': nomSearch]))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'objet '+ nomSearch + ' est introuvable !!!')
}

//WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_genererRequete'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_genererRequete'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_Requete'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_champ'), 30)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_champ'), FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_champ'), Keys.chord(Keys.CONTROL, 'V'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Tester'), FailureHandling.OPTIONAL)
//idX = '//*[@id="expert-tab"]/div[2]'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_requete'), 5, FailureHandling.OPTIONAL)) {
msgIfError = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_requete'))
String Error = msgIfError.toLowerCase()
if (Error.contains('erreur')) {
	println (msgIfError)
	CustomKeywords.'utils.utilsFail.customlaunchFail'(msgIfError)
} 
}  
//if (WebUI.verifyTextPresent('line',false, FailureHandling.OPTIONAL)) {
//	println ('La requête copiée n\'est pas correcte')
//	CustomKeywords.'utils.utilsFail.customlaunchFail'('Echec: la requête générée dans le press-papier n\'est pas correcte')
//}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Rechercher'), FailureHandling.OPTIONAL)
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Doxtreem - Recherche/Message_Error'), 5, FailureHandling.OPTIONAL)) {
	msgIfError = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Message_Error'))
	String Error = msgIfError.toLowerCase()
	if (Error.contains('erreur')) {
		println (msgIfError)
		CustomKeywords.'utils.utilsFail.customlaunchFail'(msgIfError)
	}
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)
//WebUI.delay(5)

String resultat2 = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL)).split('/')[1]

if (resultat != resultat2) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Résultat incohérent\n Résultat avant : ' + resultat +'\nRésultat après : ' + resultat2)
} else {
	CustomKeywords.'utils.Recherche.ClickButtonPlus'()
	WebUI.callTestCase(findTestCase('Tools/Suppression recherche sauvegardée'), ['varNom':nomSearch], FailureHandling.OPTIONAL)
	println('Suppression de la recherche sauvegardée : ' + nomSearch)
	WebUI.delay(3)
	
}
