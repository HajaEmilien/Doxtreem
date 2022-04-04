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

/*******************Récupération id des tages sous forme de liste************************************************************************/

aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_entête'), 'aria-owns', FailureHandling.STOP_ON_FAILURE)


for (i in aydy.split(" ") ) {
	
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_tags', ["index":i]))

	/*************************************************Est-ce que le nom de la tage est égal GED*********************************************/
	
	if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_tags', ["index":i])) == "GED") {
		break
	}else {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_tags', ["index":i]))
	}
}
/**************************************Trouver la bannette Recette test*************************************/
for (int i = 1; ; i++) {
	
	 aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_cible', ["index":i]), 'aria-label', FailureHandling.STOP_ON_FAILURE)
	
		println aydy
	
		if (aydy == "GED") {
			
			/************************************Trouver le bouton Passer en mode étandu***********************************/
			
			entet = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Ettendu_icon', ["index":i]), 'id', FailureHandling.STOP_ON_FAILURE)
			tous = "//*[@id=\"" + entet + "\"]/section[1]/section[3]/button[1]"
			if(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'): tous]), FailureHandling.OPTIONAL)==false) {
				break
			}else {
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'): tous]),1)
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index'): tous]), FailureHandling.STOP_ON_FAILURE)
			break
			}
		}
	}



