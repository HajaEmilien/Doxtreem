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

if (strPlaceholder !='Search'){
	
 if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))==true) {
				WebUI.click(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))
	        }else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Mon Profil n\'est pas disponible')
	 
	WebUI.delay(5)
	
 if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/button_Langues')) ==true )  {
				WebUI.click(findTestObject('Page_WSO2 Identity Server/button_Langues'))
			}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Langues est inaccessible')
	
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(en)'))) {
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(en)'), 120)
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(en)'))
		}
	}
	catch (Exception e) {
		Console.println("Msg error :" +e)
	}
	
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 200 , FailureHandling.OPTIONAL)
	WebUI.delay(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'), 200)
//	WebUI.waitForPageLoad(60)
	strPlaceholder = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'), 'placeholder')
		
	if (strPlaceholder ==  'Search') {
		println('Language successful changed to English !!!')
		
		
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('FAILED to change language in EN !!!')
	}
}

else{
		println('L\'application est déjà en Anglais')
		
}