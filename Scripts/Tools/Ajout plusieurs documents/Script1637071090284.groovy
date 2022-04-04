import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

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


  
   def filePath2 = RunConfiguration.getProjectDir() + '/Document2Deposer/E2E_Document_PDC_4.pdf'
   def filePath3 = RunConfiguration.getProjectDir() + '/Document2Deposer/E2E_Document_PDC_5.pdf'
   def concatenatedFilePath = filePath2 +"\n" + filePath3
   WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 120, FailureHandling.OPTIONAL)
   WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
   WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/new_document'), 120)
   if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Explorateur/new_document'))) {
	   WebUI.click(findTestObject('Page_Doxtreem - Explorateur/new_document'))
   }
   else
   {
	   CustomKeywords.'utils.utilsFail.customlaunchFail'('Echec de l\'ajout de document')
   }
   

   WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Ajouter_Document'), 10)
 
   WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/GLISSER VOS DOCUMENTS ICI'),concatenatedFilePath, FailureHandling.OPTIONAL)
   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'))
   WebUI.delay(5)
   if( WebUI.verifyTextPresent("Doublon détecté !",false,FailureHandling.OPTIONAL)==true) {
	   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Creer_doublon2'))
	   WebUI.delay(2)
	   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_valider_doublon'))
	   
	   
   }
   WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation'), 200)
   
  

/*for (int i = 1; i<=nbdocument ; i++) {
WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC_'+i+'.pdf'], FailureHandling.STOP_ON_FAILURE)
}
/*WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC_2.pdf'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC_3.pdf'], FailureHandling.STOP_ON_FAILURE)*/
