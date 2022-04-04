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

CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
CustomKeywords.'utils.Corbeille.VerifE2EDocCorbeille'('E2E_Document_PDC')

/*vérifie si la page courante est déjà la page Ma corbeille */
result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'),FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyEqual(result, "Ma corbeille", FailureHandling.OPTIONAL)) {
	println "La page Ma corbeille est actuellement ouverte"
}else{
	WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
	if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))) {
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'("La page Ma corbeille est absente dans la liste des corbeilles")
	}
}

CustomKeywords.'utils.Corbeille.SelectItem'('E2E_Document_PDC')

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Supprimer_selection'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/pop-up-delete'), 240)
//CustomKeywords.'utils.Corbeille.BoutonValider'('Suppression')
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_valider_suppression'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'))
WebUI.delay(3)
assertTrue(WebUI.verifyTextNotPresent('E2E_Document_PDC', false))