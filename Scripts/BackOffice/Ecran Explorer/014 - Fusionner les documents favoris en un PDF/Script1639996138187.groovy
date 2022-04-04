import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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



//CustomKeywords.'utils.Bannettes.CreationBannette'(GlobalVariable.Bannette)

//CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)

//WebUI.callTestCase(findTestCase('Tools/Ajout favoris'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), 120)
WebUI.delay(5)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Voir les favoris'), 120)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Voir les favoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/button_download_zip'), 200, FailureHandling.STOP_ON_FAILURE)

def text = WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/button_download_zip')).toLowerCase()


assertTrue(text.contains('créer un dossier compressé'))
assertTrue(text.contains('fusionner tous les documents'))

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_fuse'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/pop-up_fuse'), 120)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/pop-up_fuse-previsualisation'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0)

WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Explorateur/pop-up_fuse'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/pop-up_fuse_Download'), FailureHandling.STOP_ON_FAILURE)

/*Test complémentaire */
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-retour-dossier'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-favoris-telecharger'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-favoris-fusionner-tous-les-documents'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/pop-up_fuse'), 120)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/pop-up_fuse_Fermer'), FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression des favoris'),[:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'utils.Bannettes.SuppressionBannette'(GlobalVariable.Bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)



