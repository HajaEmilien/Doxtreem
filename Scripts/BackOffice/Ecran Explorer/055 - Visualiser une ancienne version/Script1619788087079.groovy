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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.SelectorMethod



//WebUI.callTestCase(findTestCase('Tools/Créer une nouvelle version'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':'E2E_Document_PDC_1.pdf'], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/onglet_Version'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Version1'))
TestObject content = findTestObject('Page_Doxtreem - Explorateur/w_content')
XpathContent = content.getSelectorCollection().get(SelectorMethod.XPATH)

if (WebUI.verifyElementNotPresent(findTestObject('Xpath',['index':XpathContent]), 10, FailureHandling.OPTIONAL)){
	TestObject content1 = findTestObject('Page_Doxtreem - Explorateur/w_content1')
	XpathContent = content1.getSelectorCollection().get(SelectorMethod.XPATH)

} 

WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/button_aperçu',['content':XpathContent]), 60)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_aperçu',['content':XpathContent]))

WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/toolbar_pdfviewer'),120)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_closeViewer'))

////def bannette = GlobalVariable.Bannette
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)



