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


//

WebUI.delay(5)

/***********************************************Trouver la bannette de traitement non vide*************************************/

//def aydy
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): "//*[@id='template-module']/div/div[3]/div[2]/div/div[1]/div[1]/md-input-container"]), FailureHandling.STOP_ON_FAILURE)

//aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Centre de traitement/liste_bann'), 'id', FailureHandling.STOP_ON_FAILURE)


for (int i = 1; ; i++) {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Centre de traitement/ListItem', [('index'): i]), 10)
	String  Text  = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Centre de traitement/ListItem', [('index'): i]), FailureHandling.STOP_ON_FAILURE)
	if(Text !=" " && Text !=null) {
	println Text
	if (Text.contains("(0)") == false) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Centre de traitement/ListItem', [('index'): i]) , FailureHandling.STOP_ON_FAILURE)
		break
	}else {
		WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Centre de traitement/ListItem', [('index'): i]), FailureHandling.STOP_ON_FAILURE)
	}
	}

}

//
