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


if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))

    println('Bouton plus cliqué')
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}

//Vérifier que le  champ pour la recherche avancée s'affiche
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'))
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bt_radio_dossier'))
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher (Avancee)'))

//WebUI.delay(5)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)
assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL))



