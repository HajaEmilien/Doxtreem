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
/*WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'), 120)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'),FailureHandling.STOP_ON_FAILURE)

if(WebUI.verifyElementNotVisible(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/inboxExplorerDisplayList'),FailureHandling.STOP_ON_FAILURE)
}*/

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), 10)
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Supprimer tous les favoris'),10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/favoriteButton'), FailureHandling.STOP_ON_FAILURE)
}

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Supprimer tous les favoris'),10,FailureHandling.OPTIONAL)==true) {
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Supprimer tous les favoris'), FailureHandling.OPTIONAL)==true) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Supprimer tous les favoris'), 10)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Supprimer tous les favoris'))
} else {
text  = WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/txt_btn-Supprimer-tous-les-favoris'))
Console.println(text)
if(text.contains("Supprimer tous les favoris")) {
  Aydi=	WebUI.getAttribute(findTestObject('Page_Doxtreem - Explorateur/txt_btn-Supprimer-tous-les-favoris'), "id", FailureHandling.STOP_ON_FAILURE)
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_deleteAllFavoris',['index':Aydi]), FailureHandling.OPTIONAL)==true) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_deleteAllFavoris',['index':Aydi]))
}
}
}
}