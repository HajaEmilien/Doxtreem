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
import internal.GlobalVariable

import org.eclipse.core.runtime.Assert
import org.openqa.selenium.Keys as Keys


WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)

 if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Editeur de workflow/button_Editeur de workflows'))==false) {
            CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Editeur de workflows   introuvable ou inaccessible')

  }else {
  
	  		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Editeur de workflow/button_Editeur de workflows'))

		    Assert.isTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Editeur de workflow/Titele_Edition_Workflows')))
  		}
		  


