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



//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)

//def Content = "/html/body/div[10]"
//def XpathOuvrir = "//span[normalize-space()='Ouvrir']"

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'),120)
WebUI.rightClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'))
//idContent = WebUI.getAttribute(findTestObject('Object Repository/Xpath',['index':Content] ) , 'id', FailureHandling.OPTIONAL)
//XpathMenuContectuel = "//*[@id='"+idContent+"']/md-menu-content"
//WebUI.verifyElementVisible(findTestObject('Object Repository/Xpath',['index':XpathMenuContectuel] ))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Consulter'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Ouvrir_Autre_Onglet'))


/*int currentWindow = WebUI.getWindowIndex()
Console.println(currentWindow)
*/

////def bannette = GlobalVariable.Bannette
WebUI.switchToWindowTitle('Doxtreem - Explorateur')
//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)




