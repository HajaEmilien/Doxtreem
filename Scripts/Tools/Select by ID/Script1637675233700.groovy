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

def tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_resultat')).split('\n')
int nline=0
for (i=5;i<=tablo.length-1;i+=7) {
	nline ++
	if (tablo[i]== idElement) {
		break
	}
}
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/tableau_Liste_1Element',['numLigne':nline]))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement'))

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup-title'), 120, FailureHandling.OPTIONAL)) {
	println WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup-title'))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le pop-up n\'est pas affiché !!!')
}
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup-title'), 120)

//for (i=4;i<=6;i++) {
//	if (WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement',['pos':i]), 'md-svg-src', 5, FailureHandling.OPTIONAL)) {
//		if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement',['pos':i]), 'md-svg-src') == 'mdi:folder-search') {
//			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_emplacement',['pos':i]))
//			break
//		}
//	}
//}
for (i=10;i<=15;i++) {
	if (WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]), 'aria-label', 'Ouvrir dans l\'onglet actuel', 2, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]))
			break
		
	}
}
	
	
 


//int pos
//
//for (i=10;i<=15;i++) {
//	if (WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement',['pos':i]), 'aria-label', 5, FailureHandling.OPTIONAL)) {
//		if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_emplacement', ['pos' : i]),'aria-label') =='LinkedCaseFiles') {
//			pos = i
//			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/popup_element',['pos': i]))
//			break
//		}
//	}
//}
