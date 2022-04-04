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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche')) == false ) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
        }
//clic sur le bouton +
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))

	println('Bouton plus cliqué')
	
	//Sélectionne l'onglet SAUVEGARDEE	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)
					
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}

WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)

/*Modification */
def now = new Date().format( 'yyyyMMdd-Hms')
if (varNom == ""){
	varNom = 'Save_Search-' + now
} else {
	println varNom
}

if (WebUI.verifyElementPresent(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche':varNom]), 5)){
	WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche':varNom]))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'objet '+ varNom + ' est introuvable !!!')
}

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Charger la recherche'), FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_button_Rechercher'))
	WebUI.delay(5)
}
else{
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur lors de sélection de la sauvegarde')
}
