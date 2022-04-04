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
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.*

user =(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tableau_droitsUtilisateur'))).split('\n')

int pos

if (!user.contains('E2E_User')) {
	fail('L\'utilisateur DX_E2E n\'existe pas')
} else {
	for (int index = 4;index <= user.size(); index ++){
		if (user[index] == "E2E_User"){
			pos = index-3
			break
		}
	}
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/utilisateur_droitsAsupprimer',[('pos'): pos]))

assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_supprimerDroits',[('pos'): pos])))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_supprimerDroits',[('pos'): pos]))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_validerAjoutDroits'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_validerAjoutDroits'))

for (int num = 12;num <= 13;num++){
	
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), FailureHandling.OPTIONAL)){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), 120)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), FailureHandling.STOP_ON_FAILURE)
		break
	}
	
}
assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/msg_confirmAjoutDroits')))
