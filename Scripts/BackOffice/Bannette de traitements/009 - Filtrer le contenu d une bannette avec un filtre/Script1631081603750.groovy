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
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.support.ui.Select




 if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))==true) {
            WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))
 } else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Bannettes "Vues des traitements" n\'est pas disponible')
    



btnGestionFacture = "//md-chips-wrap[starts-with(@id,'_md-chips-wrapper-')]//label[@class='layout-row'][normalize-space()='Gestion facture']"

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): btnGestionFacture]), FailureHandling.STOP_ON_FAILURE)

 WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Filtrer'), 10, FailureHandling.STOP_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Filtrer'), FailureHandling.STOP_ON_FAILURE)
 
 Test = " "
 DateFactureMin = "28/09/2021"
 DateExacte = " "
 for (int i=1 ;i<4 ; i++) {
 filtreVarier = "//*[starts-with(@id,'inbox-view-')]/section[2]/md-content/article["+i+"]"
Text = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):filtreVarier]))
switch(Text) {
	case "test" :
	        // WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):filtreVarier]), FailureHandling.STOP_ON_FAILURE)
	         break 
	case "FAC: Date facture min" :
	         WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):filtreVarier]), FailureHandling.STOP_ON_FAILURE)
	         id = "//*[starts-with(@id,'inbox-view-')]/section[2]/md-content/article[2]/section/div/div/div/div/form/md-input-container//input[starts-with(@id,'input_')]"
			 WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):id]),DateFactureMin)
		
			 break
	case "FAC : Date exacte" :
	         //WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):filtreVarier]), FailureHandling.STOP_ON_FAILURE)
	         break 
			 
	default : 
	        Console.println("aucun element trouvé ")
	        break
	}

 }
 
 
 ValideFiltre = "//*[starts-with(@id,'inbox-view-')]/section[2]/section//button[normalize-space()='Filtrer']"
 WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'):ValideFiltre]), FailureHandling.STOP_ON_FAILURE)
 /**********************Verify resultat filtre *********************************/
 
 Aidy = "//*[starts-with(@id,'tab-content-')]/div/md-content/inbox-view[2]/section[3]/md-content"
 Text2 = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):Aidy]))

 if(Text2 != " " && Text2.contains(DateFactureMin)) {
	Console.println("Filtre Ok ")
 }else  {
	Console.println("aucun résultat pour le filtre")
 } 
 /******************************************Réinitialisation du filtre**************************/

 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Filtrer'), FailureHandling.STOP_ON_FAILURE)
 
 RenialiserFiltre = "//*[starts-with(@id,'inbox-view-')]/section[2]/section//button[normalize-space()='Réinitialiser']"
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): RenialiserFiltre]), FailureHandling.STOP_ON_FAILURE)
Text2 = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'):Aidy]))
