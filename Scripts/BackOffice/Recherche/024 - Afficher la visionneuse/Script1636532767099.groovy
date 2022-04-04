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
	
CustomKeywords.'utils.Recherche.ClickButtonPlus'()
CustomKeywords.'utils.Recherche.VerifierChampRechercheAvancer'()
WebUI.click(findTestObject('Page_Doxtreem - Recherche/bt_radio_document'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)
WebUI.delay(5)

int r = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat')).split(" ")[0].toInteger()
if (r >0) {
	for (i=1;i<=r;i++) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Liste_1Element',['numLigne':i]), 120)
		WebUI.delay(5)
		if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Liste_1Element',['numLigne':i])).contains('.pdf')) {
			WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Liste_1Element',['numLigne':i]))
			break
		}
	}
}
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf'), 120)
println('Affichage du document')
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf_closeViewer'))

