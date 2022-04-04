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

//Sélection onglet SAUVEGARDEE	
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche':varNom]))


if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_icon_delete'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_icon_delete'))
}

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/h2_Supprimer une recherche'))) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde_msg_confirmation-button_Valider'))

//	assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/msg_confirmation_suppression'),FailureHandling.OPTIONAL))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/msg_confirmation_suppression'), 60)
	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/div_ Retour'))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Suppression échouée !!!')
}
	
