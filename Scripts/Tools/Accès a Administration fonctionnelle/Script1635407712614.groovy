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

//void SelectionnerBoutton(String Boutton) {
//	WebUI.waitForElementVisible(findTestObject('Object Repository/Administration/'+Boutton+''), 120)
//	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Administration/'+Boutton+''))==false) {
//		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton '+Boutton+' est introuvable')
//	}else WebUI.click(findTestObject('Object Repository/Administration/'+Boutton+''))
//}
/****************************Accès à l'Administration**************************************/

//SelectionnerBoutton("btn_Administration")

/*---- Sélectionner Administration fonctionnelle ----*/
//id = '//*[@id="left-navbar"]/ul'
//if (WebUI.getText(findTestObject('Object Repository/Xpath',['index': id])).split('\n').contains('Administration fonctionnelle')) {
//	SelectionnerBoutton("span_Administration fonctionnelle")
//} else {
//	SelectionnerBoutton("btn_Administration")
//	SelectionnerBoutton("span_Administration fonctionnelle")
//}
def funcRefresh() {
	WebUI.refresh()
	WebUI.waitForElementVisible(findTestObject('Object Repository/Administration/btn_Administration'), 120)
	WebUI.click(findTestObject('Object Repository/Administration/btn_Administration'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Administration/span_Administration fonctionnelle'), 120)
	WebUI.click(findTestObject('Object Repository/Administration/span_Administration fonctionnelle'))
}

lMenu = WebUI.getText(findTestObject('Object Repository/Administration/Liste_menu'))
	
if (lMenu.contains('Administration fonctionnelle')) {
	WebUI.click(findTestObject('Object Repository/Administration/span_Administration fonctionnelle'))
} else {
	WebUI.click(findTestObject('Object Repository/Administration/btn_Administration'))
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Administration/span_Administration fonctionnelle'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Administration/span_Administration fonctionnelle'))
	} else {
		this.funcRefresh()
	}	
}
