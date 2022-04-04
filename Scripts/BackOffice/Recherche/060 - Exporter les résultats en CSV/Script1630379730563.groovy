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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.io.*
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration


/* Suppression du fichier export.csv présent dans le répertoire*/
String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
def downloadFile = downloadFilepath.replace("/", "\\")

File file = new File(downloadFile + "\\.")
File[] ls = file.listFiles()

for (File element : ls) {
	if (element.getName().startsWith('export') && element.getName().endsWith('.csv')) {
		element.delete()
	}
}
/**********************************/

WebUI.callTestCase(findTestCase('Test Cases/BackOffice/Recherche/010 - Recherche simple'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Export'), 60)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Export'))
WebUI.delay(5)
/* Contrôle après export */
File csv = new File(downloadFile+"\\export.csv")
if (csv.exists()) {
	println('Fichier bien exporté dans "' + downloadFile )
} else {
	println('Le fichier n\'est pas exporté dans "' + downloadFile)
}
csv.deleteOnExit()
/*************************/
