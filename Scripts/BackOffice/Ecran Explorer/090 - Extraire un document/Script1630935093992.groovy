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
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows



////def bannette = GlobalVariable.Bannette

////CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':'E2E_Document_PDC_1.pdf'], FailureHandling.STOP_ON_FAILURE)
if(WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'), 5)==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'("Le bouton Extraire Stoker n'est plus present sur la page ")
}
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'), 10)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Extraire'), 10)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Extraire'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/icon-cadenas'), 10)

if (WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/icon-cadenas'), FailureHandling.OPTIONAL)) {
    //WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'))
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'extraction n\'est pas faite !!!')
} 
    
//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)



