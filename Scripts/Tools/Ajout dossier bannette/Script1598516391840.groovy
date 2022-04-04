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


if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))			
			
		} else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Bannettes du menu lateral n\'est pas disponible')
	


WebUI.delay(5)



    /*************Est-ce qu'on a au moins  la bannette Test Homologation*****************/
    

    if (WebUI.verifyTextPresent('Test_([0-9]{13})', true, FailureHandling.OPTIONAL)) {
        println('Bannette déjà créer')
    } else {
        CustomKeywords.'utils.utilsFail.customlaunchFail'('Bannette Test Homologation introuvable ou non encore creee')
    }
   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Bouton_nouveau_dossier_Bannette'), 
                FailureHandling.STOP_ON_FAILURE)
	
    /*******************************************Creation dossier***********************************************/
    
           
if (WebUI.verifyElementClickable(findTestObject('Object Repository/button_01_AA_1598268558525'))) {
				WebUI.click(findTestObject('Object Repository/button_01_AA_1598268558525'))
            } else  CustomKeywords.'utils.utilsFail.customlaunchFail'('le dossier n\'est pas clickable sur la page')
     
    
    
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/button_Crer_bannette'))

    /*************************************Est-ce qu'on a le message de confirmation**************************************/
    String result = WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'), 
        FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyEqual(result, 'Le dossier a été ajouté', FailureHandling.OPTIONAL)) {
        println('création du dossier réussie')
    } /*************Est-ce qu'on a déjà le dossier quelque part*****************************/
    else {
        CustomKeywords.'utils.utilsFail.customlaunchFail'(result)
    }





