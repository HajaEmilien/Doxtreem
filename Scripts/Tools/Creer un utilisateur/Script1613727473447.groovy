import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

/* Appel Accès adminstration fonctionnelle */
WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)
/*Accéder à l'écran Utilisateur de l'onglet Gestion des identités*/

CustomKeywords.'utilsFindElement.chercheElement.Selectionner'('Administration','button_Utilisateurs')

WebUI.delay(15)

TestObject Myframe = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')
/*Recherche utilisateur */
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'input_Recherche groupe', Myframe, user)
WebUI.delay(3)
WebUI.switchToFrame(Myframe, 5)
WebUI.delay(3)
TestObject Mylist = findTestObject('Object Repository/Page_Doxtreem - Groupes/premiere_ligne_user')
if (!WebUI.getText(Mylist, FailureHandling.OPTIONAL).contains(user)) {

	
	WebUI.click(findTestObject('Page_Doxtreem - Utilisateurs/button_AjoutUser'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/input_userName'), user)
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/input_email'), 'aral@numen.mg')
	
	assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/button_Creer')))
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/button_Creer'))
	
	WebUI.delay(5)
	
	if(WebUI.verifyElementText(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/h1_nomUtilisateur'), user,FailureHandling.OPTIONAL)==false) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'utilisateur '+user+' non crée')
	}
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/button_Sauvegarder les informations'))
	
	WebUI.delay(5)
	
}else Console.println("User déjà Crée")
/********************************Vérification *****************************************/
if (!WebUI.getText(Mylist).contains(user)) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'utilisateur '+user+' non crée')
}
WebUI.switchToDefaultContent()