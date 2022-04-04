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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import java.awt.Robot;
import java.awt.event.KeyEvent;




if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 'placeholder') != 
'Rechercher') {
    
}

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
}

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))

    println('Bouton plus cliqué')
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}

//Vérifier que le  champ pour la recherche recurrente s'affiche
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_Recurrente'), FailureHandling.OPTIONAL)) {
    //clic sur l'onglet "RECURRENTE"
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_Recurrente'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Selectionner une recherche rcurrente'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/option_Recherche-document'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_recurrente_button_Rechercher'), 30)	

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_recurrente_button_Rechercher'))
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 30)
}

WebUI.delay(5)

if (WebUI.verifyTextPresent('résultats /', false, FailureHandling.STOP_ON_FAILURE)) {
    
}

