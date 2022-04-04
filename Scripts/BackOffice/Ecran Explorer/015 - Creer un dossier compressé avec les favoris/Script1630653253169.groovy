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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.SimpleDateFormat;
import java.time.*


////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

//WebUI.callTestCase(findTestCase('Tools/Ajout favoris'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), 20)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Voir les favoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/button_download_zip'), 200, FailureHandling.STOP_ON_FAILURE)
def text = WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/button_download_zip')).toLowerCase()

assertTrue(text.contains('créer un dossier compressé'))
assertTrue(text.contains('fusionner tous les documents'))
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_download_zip'), FailureHandling.STOP_ON_FAILURE)

// 

/*Test complémentaire */
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/bouton-retour-dossier'), 10)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-retour-dossier'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), 10)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/bouton-favoris-telecharger'), 10)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-favoris-telecharger'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/bouton-creer-un-dossier-compresse'), 10)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/bouton-creer-un-dossier-compresse'), FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression des favoris'),[:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
String daty = format.format(new Date())
String nomDocument = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/nom_fichier_chemin-de-fer')) + '.zip'
String nomFichier = 'Favoris-' + daty + '-' + nomDocument

String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
def downloadFile = downloadFilepath.replace("/", "\\")
File fichier = new File(downloadFile + '\\' + nomFichier)

if (fichier.exists()) {
	println('Fichier compressé téléchargé !!! ==> ' + fichier)
} else {
	println('Fichier compressé non téléchargé !!!')
}

