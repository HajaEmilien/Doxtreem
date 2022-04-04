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

WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)

/*******************************Rechargement du cache serveur********************************************/
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Recharge du cache serveur'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button recharge du cache serveur est inactif ou grisé')
		}


WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Recharge du cache serveur'),
	FailureHandling.STOP_ON_FAILURE)

/*******************************Validation de l'action********************************************/

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Valider'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('le button valider inactif ou griser')
		}
	

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Valider'), FailureHandling.STOP_ON_FAILURE)


WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/md-icon_BoutonProfil'), 200 , FailureHandling.OPTIONAL)

/*******************************Est-ce que le bouton Profil est visible sur la page********************************************/
if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Explorateur/md-icon_BoutonProfil'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button  profil n\' est pas visible sur la page')
		}




