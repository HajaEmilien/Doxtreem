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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static org.junit.Assert.*
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows



WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Gels/button_Sort final_Gels'))==true) {
            WebUI.click(findTestObject('Page_Doxtreem - Gels/button_Sort final_Gels'))
   }else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Gels (Sort final) n\'est pas disponible')
  
if((WebUI.verifyTextPresent('Administration des gels', false,FailureHandling.OPTIONAL))==false) {
	
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Test Case Ko : impossible d\'accèder à la page Gels')
}

WebUI.callTestCase(findTestCase('Tools/Deconnect'), [:], FailureHandling.OPTIONAL)

