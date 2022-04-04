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

WebUI.delay(5)

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

int num = 0
for (int index = 0; index <= tablo.size()-1; index +=5){
	num ++
	if (tablo[index]==nomDoc){
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Ajouter aux favoris'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Ajouter aux favoris'), FailureHandling.STOP_ON_FAILURE)
	}
}
