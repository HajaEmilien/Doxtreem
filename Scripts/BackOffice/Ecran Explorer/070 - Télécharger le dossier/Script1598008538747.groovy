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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.util.zip.ZipFile
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory


////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)



//WebUI.callTestCase(findTestCase('Tools/Ajout plusieurs documents'),['nbdocument':2], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_telecharger_dossier'), 
    120)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_telecharger_dossier'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)

String nomFichier = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/nom_fichier_chemin-de-fer')) + '.zip'

String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
def downloadFile = downloadFilepath.replace("/", "\\")
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> webEleList = driver.findElements(By.xpath("//*[@id='inboxExplorerList']/div"));
List<String> listFichier =[]
for (WebElement element: webEleList) {
	listFichier.push(element.getText().split('\n')[0])
}

File nomZip = new File(downloadFile +"\\"+ nomFichier)

if (nomZip.exists()) {
	ZipFile zipfile = new ZipFile( downloadFile +"\\"+ nomFichier)
	entries = zipfile.entries()
	List<String> lst=[]
	while(entries.hasMoreElements()){
		lst.push(entries.nextElement().toString())
	}
	if (lst.size() > 0) {
		if (listFichier.size() == lst.size()) {
			println('Fichier téléchargé !!!')
			zipfile.close()
		} else {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur de téléchargement du fichier')
		}
	} else {
		println('Le dossier téléchargé est vide !!!')
		zipfile.close()
	}

} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le fichier ne se trouve pas dans '+ downloadFile)
}
nomZip.deleteOnExit()

//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)



