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




WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 120)
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'),'.pdf')

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'))
	println('Bouton recherche cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Recherche n\'est pas disponible')
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)
WebUI.delay(5)

/*********************************détection mode d'affichage - Liste ou Grille**************************************/
//TestObject liste = new TestObject()
//for (index = 2; index <=9; index++) {
//	
//	if (index == 8) {
//		CustomKeywords.'utils.utilsFail.customlaunchFail'('La détection du bouton sélectionner n\'a pas réussi')
//		
//	}
//	liste = findTestObject ('Object Repository/Page_Doxtreem - Recherche/Button_selectionner', ['index': index])
//	if (WebUI.getAttribute(liste, 'class').contains('selectedViewIcon') == true) {
//		if (WebUI.getAttribute(liste, 'ng-class').contains('list') != true) {
//	
//			println('Changement en mode List')
//			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList',['position':5]))
//			break
//		}else break
//	}
//		
//}
if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageGrille'), 'class').contains('selectedViewIcon')) {
	println('Changement en mode Liste')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList'))
} else {
	println 'AFFICHAGE LISTE'
}
/*if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'), FailureHandling.OPTIONAL)) {
	println('Affichage en mode LISTE')
}else {
	println('Affichage en mode GRILLE')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList',['position':5]))
	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau')))
}*/

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Filtre'))
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_Filtre'),'date')

resultat = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_filtre')).split('\n')
println resultat
for (i = 1; i <= resultat.size(); i++) {
	if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/checkBox_tablo_filtre', [('checkbox') : i]), 'aria-checked').toString()=='false') {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/checkBox_tablo_filtre', [('checkbox') : i]))
	}
}
//println resultat[resultat.size()-2]
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_close_filtre'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'), 120)
WebUI.delay(5)
entete = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'))
//println entete
//assertTrue(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau')).contains(resultat[resultat.size()-2]))

WebUI.delay(5)

//Décocher tous les résultats
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Filtre'))
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_Filtre'),'date')

for (i = 1; i <= resultat.size(); i++) {
	if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/checkBox_tablo_filtre', [('checkbox') : i]), 'aria-checked').toString()=='true') {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/checkBox_tablo_filtre', [('checkbox') : i]))
	}
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_close_filtre'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'), 120)
WebUI.delay(5)
//entete = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'))

assertTrue(!WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau')).contains(resultat[1]))


