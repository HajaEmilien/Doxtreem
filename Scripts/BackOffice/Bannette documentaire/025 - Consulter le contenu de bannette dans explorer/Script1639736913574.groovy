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



CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()

for (int i = 1; ; i++) {
	
	 aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_cible', ["index":i]), 'aria-label', FailureHandling.STOP_ON_FAILURE)
	
		println aydy
	
		if (aydy == "GED") {
			
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_cible', [('index') : i]), FailureHandling.STOP_ON_FAILURE)
			break
		}
	}



/*String txt =  WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/section_GED'))

println txt

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/section_GED'))

if(txt == (WebUI.getText(findTestObject('Page_Doxtreem - Bannettes/div_Document_GED')))){
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le contenu de bannette dans Explorer est différent de celui cliqué !!!')
}*/
