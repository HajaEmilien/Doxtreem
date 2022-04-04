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
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Champ rechercher'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Champ rechercher n\'est pas visible')
}			


WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Champ rechercher'), Dossier +
	Keys.chord(Keys.ENTER))
WebUI.delay(5)

if (WebUI.verifyTextPresent('Aucun élément n\'a été retourné par la requête', false,FailureHandling.OPTIONAL) == true) {
	Console.println('Dossier déjà supprimé !!!')
} else {
	/***************Double-clique sur le dossier trouvé***********************/
	
	//Clique droite Sur le premier dossier trouvé 
	

	
if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Explorateur/Dossier_a_cliquer_resultat_recherche'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le dossier à supprimer n\'est pas accessible')
} else //WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/Dossier_a_cliquer_resultat_recherche'))
	   WebUI.rightClick(findTestObject('Page_Doxtreem - Explorateur/Dossier_a_cliquer_resultat_recherche'))
	
	   
	//Clique sur le boutton supprimer 
	   
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Boutton_Suppr'))   
	WebUI.delay(2)
	WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Corbeille/btn-validerSuppr-rep'), 120, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Page_Doxtreem - Corbeille/btn-validerSuppr-rep'))
	
	/*for (index = 10;index<=12;index++) {
		if (WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Doxtreem - Bannettes/class',['index':index]), 'class', 'md-dialog-container', 2, FailureHandling.OPTIONAL)) {
			delete = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Button_validation_suppression',['index':index]))
			
			if (delete =='VALIDER') {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Button_validation_suppression',['index':index]),FailureHandling.STOP_ON_FAILURE)
				break
			}
		}
	}*/
	WebUI.delay(5)
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Champ rechercher'), Dossier +
		Keys.chord(Keys.ENTER))
	WebUI.delay(5)
	
	if (WebUI.verifyTextPresent('Aucun élément n\'a été retourné par la requête', false,FailureHandling.OPTIONAL)==true) {
		Console.println('Dossier supprimé !!!')
	}
	else
	{
		WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier': Dossier], FailureHandling.STOP_ON_FAILURE)
	}
}


