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
import static org.junit.Assert.*
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows



WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)

/****************************Acceder a la page Editeur CMIS***************************************************************/

   if (WebUI.verifyElementClickable(findTestObject('Administration/button_Editeur_de_fichier_CMIS'))==false) {
             CustomKeywords.'utils.utilsFail.customlaunchFail'('button editeur fichier CMIS n\'est pas visible sur la page')
        }
 

WebUI.click(findTestObject('Administration/button_Editeur_de_fichier_CMIS'))

WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Administration technique/bloc_element'), 120)

////WebUI.delay(10)

/*****************************séléctionnner le document ***************************************************************************************/
WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Administration technique/div_ecmuploadConfiguration'), 
    5)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/div_ecmuploadConfiguration'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_CaptureDefaultJson'))

WebUI.verifyTextPresent('Titre : captureDefault.json', false, FailureHandling.OPTIONAL)

WebUI.verifyTextPresent('Commentaire de version :', false, FailureHandling.OPTIONAL)



