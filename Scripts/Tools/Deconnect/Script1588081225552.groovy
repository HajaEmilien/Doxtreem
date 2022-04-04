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


//WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_Rechercher_profil'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_WSO2 Identity Server/md-icon_Profil'), 10, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/md-icon_Profil'))
WebUI.click(findTestObject('Page_WSO2 Identity Server/button_Dconnexion'))

WebUI.waitForPageLoad(2000)

/*
if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/div_Vous avez t dconnect de Doxtreem')))
	WebUI.click(findTestObject('Page_WSO2 Identity Server/input_Vous avez t dconnect de Doxtreem_approve'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(2000)*/

if(WebUI.verifyElementVisible(findTestObject('Page_Connexion/UserName')))
{
		println('Déconnexion effectué.')
		//WebUI.closeBrowser();
}
else
{
	//WebUI.closeBrowser();
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur lors de la déconnexion.')
}

