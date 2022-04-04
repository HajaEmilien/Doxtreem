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

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
	println('Bouton plus cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_sauvegarde'), FailureHandling.OPTIONAL)
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), 60)
WebUI.click(findTestObject('Page_Doxtreem - Recherche/liste_recherche_sauvegardee'), FailureHandling.OPTIONAL)
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche': nom]), 5, FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Page_Doxtreem - Recherche/md-option_Recherche_Save',['nomRecherche': nom]))
	return GlobalVariable.ovw = true
} else {
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))
	return GlobalVariable.ovw = false
}

