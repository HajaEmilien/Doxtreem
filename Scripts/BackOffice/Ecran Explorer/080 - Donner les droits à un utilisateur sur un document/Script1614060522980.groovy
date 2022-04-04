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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration




////def bannette = GlobalVariable.Bannette
//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':'E2E_Document_PDC_1.pdf'], FailureHandling.STOP_ON_FAILURE)
assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_modifierDroits'),'aria-label') == 'acl')
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_modifierDroits'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/fenetre_ajoutDroitsUtilisateurs'),120)
//assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/fenetre_ajoutDroitsUtilisateurs')))

WebUI.callTestCase(findTestCase('Test Cases/Tools/Donner les droits à un utilisateur sur un document'), [:], FailureHandling.STOP_ON_FAILURE)
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)

