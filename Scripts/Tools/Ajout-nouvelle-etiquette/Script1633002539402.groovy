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
import static org.junit.Assert.*


if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/bouton_editer_etiquette_bannettes'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/bouton_editer_etiquette_bannettes'))
}
else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Editer les étiquettes des bannettes" n\'est pas activé !!!')
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Bannettes/edit-inbox-tab-color-dialog'), 5, FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/edit-inbox-tab-color-dialog-dialogContent')).contains('E2E')) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/edit-inbox-tab-color-dialog-Annuler'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Search_bannette'), 20)
}
else
{
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/bouton-ajout-nouvelle-etiquette'))
	id = (WebUI.getAttribute(findTestObject('Page_Doxtreem - Bannettes/__input-tag'), 'for'))
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/champ-tag',['id':id]), 'E2E')
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/edit-inbox-tab-color-dialog-Sauvegarder'))
//	assertTrue(WebUI.verifyTextPresent('Les étiquettes ont été sauvegardées', false))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation'), 25)
	println(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation')))
	
}

