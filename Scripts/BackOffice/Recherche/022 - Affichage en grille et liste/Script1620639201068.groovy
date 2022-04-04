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

//for (int second = 0; ; second++) {
//    if (second >= 1) {
//        CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
//    }
//    
//    try {
//        if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))) {
//            break
//        }
//    }
//    catch (Exception e) {
//    } 
//    
//    Thread.sleep(1000)
//}

WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'),'.pdf')

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_recherche'))
	println('Bouton recherche cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Recherche n\'est pas disponible')
}

//if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau'), FailureHandling.OPTIONAL)) {
//	println('Affichage en cours : LISTE')
//	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList',['position':5]))
//	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bloc1_grille')))
//	println('Affichage Liste == > Grille OK')
//	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList',['position':5]))
//}else {
//	println('Affichage en cours : GRILLE')
//	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList',['position':5]))
//	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau')))
//	println('Affichage en mode "Grille" vers "Liste" OK')
//}
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)

if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList'), 'class').contains('selectedViewIcon')) {
	println('Affichage en cours : LISTE')
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageGrille'), 120)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageGrille'))
	assertTrue(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/bloc1_grille'), 120))
	println('Affichage Liste == > Grille OK')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList'))
}else {
	println('Affichage en cours : GRILLE')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_AffichageList'))
	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/entete_tableau')))
	println('Affichage en mode "Grille" vers "Liste" OK')
}


