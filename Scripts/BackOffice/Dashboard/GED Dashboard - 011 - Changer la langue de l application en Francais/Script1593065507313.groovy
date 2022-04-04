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




String strPlaceholder = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'), 'placeholder')

if (strPlaceholder !='Rechercher'){
	
     if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))) {
				WebUI.click(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))
			
			} else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Mon Profil n\'est pas disponible')
	
	WebUI.waitForElementVisible(findTestObject('Page_WSO2 Identity Server/button_Langues'), 120)
	if (WebUI.verifyElementClickable(findTestObject('Page_WSO2 Identity Server/button_Langues')))  {
				WebUI.click(findTestObject('Page_WSO2 Identity Server/button_Langues'))
			
			}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Langues est inaccessible')
	
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/button_Francais(fr)'))) {
			WebUI.waitForElementClickable(findTestObject('Page_WSO2 Identity Server/button_Francais(fr)'), 120)
			WebUI.delay(5)
			WebUI.click(findTestObject('Page_WSO2 Identity Server/button_Francais(fr)'))
		}
	}
	catch (Exception e) {
	}
//	WebUI.waitForPageLoad(60)
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 200 , FailureHandling.OPTIONAL)
	WebUI.delay(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'), 200)
	strPlaceholder = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'), 'placeholder')
	
	if (strPlaceholder ==  'Rechercher') {
		println('Changement de langues en FR réussi')
		
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le changement de langues en FR a échoué !!!')
	}
}

else{
		println('L\'application est actuellement en Français')
		
}