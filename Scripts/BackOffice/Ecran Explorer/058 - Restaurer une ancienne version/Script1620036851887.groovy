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



//WebUI.callTestCase(findTestCase('Tools/Créer une nouvelle version'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':'E2E_Document_PDC_1.pdf'], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/onglet_Version'))

 //WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Version1'))
 //WebUI.delay(2)
 XpathContent = "/html[1]/body[1]/div[10]/md-menu-content[1]"
 
 if (WebUI.verifyElementNotPresent(findTestObject('Xpath',['index':XpathContent]), 10, FailureHandling.OPTIONAL)){
	 XpathContent = "/html[1]/body[1]/div[11]/md-menu-content[1]"
 }
 
idRestaurer = ""+XpathContent+"/md-menu-item[3]//button[normalize-space()='Restaurer']"
WebUI.waitForElementClickable(findTestObject('Xpath',['index':idRestaurer]), 30)
WebUI.delay(5)
WebUI.click(findTestObject('Xpath',['index':idRestaurer]))
WebUI.delay(5)
////def bannette = GlobalVariable.Bannette
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'),20)
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)


