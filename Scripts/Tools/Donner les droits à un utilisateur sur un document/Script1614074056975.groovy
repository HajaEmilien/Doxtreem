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


WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/champ_ajoutUtilisateur'))

WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/champ_ajoutUtilisateur'),"E2E_User")
WebUI.delay(5)


Console.println(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/resultat_ajoutUtilisateur')))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/resultat_utilisateurSelectionné'), 30)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/resultat_utilisateurSelectionné'))

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/champ_listUser'))).split('\n')

//println tablo
nbUser = tablo.size()
//println nbUser

int n = 0

for (i=0; i<=nbUser-1 ;i++) {
	if (tablo[i]=='E2E_User') {
//		println 'Position : ' +  tablo[i] + '\t' + (i+1)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/autorisation_lecture',['position': i+1]))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/autorisation_ecriture',['position': i+1]))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/autorisation_suppression',['position': i+1]))
		break
	}
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_validerAjoutDroits'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_validerAjoutDroits'))

for (int num = 12; num <= 13;num++){
	
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), FailureHandling.OPTIONAL)){
		println(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num])) + " : " + num)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), 120)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_confirmAjoutDroits',['num':num]), FailureHandling.STOP_ON_FAILURE)
		break
	}
	
}

//assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/msg_confirmAjoutDroits')))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/msg_confirmAjoutDroits'),20)
