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
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.*
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.Select as Select
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory



////WebUI.delay(10)
nomSearch = 'E2E_Search'
CustomKeywords.'utils.Recherche.VerifierChampReherche'()

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/searchButton'))

WebUI.waitForElementPresent( findTestObject('Object Repository/Page_Doxtreem - Recherche/vertical_container'), 120)
WebUI.delay(5)

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

WebUI.delay(5)

/*-----------------------------------*/

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Charger la recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Charger la recherche'))
}else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Charger la recherche n\'est pas cliquable')
}
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Champ_Mot_prsnt'), 30)

if (WebUI.verifyTextPresent('Catégorie du PDCM', false, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Recherche/vertical_container'), 120)
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Problème de chargement de l\'onglet AVANCEE !!!')
}

WebUI.delay(5)
String resultat2 = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL)).split('/')[1]

if (resultat != resultat2) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Résultat incohérent\n Résultat avant : ' + resultat +'\nRésultat après : ' + resultat2)
} else {
	CustomKeywords.'utils.Recherche.ClickButtonPlus'()
	WebUI.callTestCase(findTestCase('Tools/Suppression recherche sauvegardée'), ['varNom':nomSearch], FailureHandling.OPTIONAL)
	println('Suppression de la recherche sauvegardée : ' + nomSearch)
	WebUI.delay(3)
	
}
