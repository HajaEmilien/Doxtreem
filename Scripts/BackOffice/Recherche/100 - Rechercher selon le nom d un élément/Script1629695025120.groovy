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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
}
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
	println('Bouton plus cliqué')
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}

//Vérifier que le  champ pour la recherche avancée s'affiche
WebUI.delay(3)
WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Recherche/Bloc_rechercher'))
if (!WebUI.verifyTextPresent('Type',false, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'))
}
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/input_Nom_Complet') , 'Document', FailureHandling.STOP_ON_FAILURE)
	
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))

WebUI.delay(5)

assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL))
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
	println('Bouton plus cliqué')
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Button_réinitialiser'))


