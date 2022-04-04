import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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


//String downloadPath = System.getProperty("user.home") + File.separator + "Downloads"
String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
def downloadFile = downloadFilepath.replace("/", "\\")
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'),120)
WebUI.rightClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Telecharger_Document'))

String nomFichier = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/nomFichier')).split('\n')[0]

File doc = new File(downloadFile +"\\"+nomFichier + ".pdf")

WebUI.delay(5)
  
if (doc.exists()) {
	println('Document bien téléchargé dans "' + downloadFile )
	
} else {
	println('Le fichier n\'est pas exporté dans "' + downloadFile)
}

doc.deleteOnExit()
