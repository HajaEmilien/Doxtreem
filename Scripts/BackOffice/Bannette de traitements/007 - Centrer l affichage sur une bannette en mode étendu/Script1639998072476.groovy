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



def entet
def aidy
def btnFiltre

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))==true) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))
}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Bannettes "Vues des traitements" n\'est pas disponible')


WebUI.delay(5)

/*******************Récupération id de la première  tag************************************************************************/

aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Premier_tag'), 'md-tab-id', FailureHandling.STOP_ON_FAILURE)

/*******************Sélection tag Validation Facture ****************************************************/
n=1
for (int i = aydy.toInteger(); ; i++) {
	if (n >= 20) {
		fail ('tag introuvable')
	}
	
	if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/tag', [('index'): i]), 'aria-label', FailureHandling.STOP_ON_FAILURE) == "Validation Facture") {
		WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/tag', [('index'): i]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/tag', [('index'): i]), FailureHandling.STOP_ON_FAILURE)
		break
	}
	n++
}
/******************************Trouver la bannette Rapprochement*****************************************************/

if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/content', [('index'): "_md md-active"]), 'id', FailureHandling.CONTINUE_ON_FAILURE) == null) {
	aidy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/content', [('index'): "_md md-no-transition md-active"]), 'id', FailureHandling.STOP_ON_FAILURE)
} else {
	aidy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/content', [('index'): "_md md-active"]), 'id', FailureHandling.STOP_ON_FAILURE)
}

aidyContent = "//*[@id=\"" + aidy + "\"]/div/md-content/inbox-view[1]/section[3]"

aydi = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/inbox',  [('index'): aidyContent] ), 'id', FailureHandling.STOP_ON_FAILURE)
ide = aydi.split('-')[2]

for (int i = ide.toInteger(); ; i++) {
	
	aydiInbox = "//*[@id=\"inbox-view-" + i + "\"]/section[1]/section[1]"
	btnFiltre = "//*[@id=\"inbox-view-" + i + "\"]/section[1]/section[3]/button[1]/md-icon"
	pound = "//*[@id=\"inbox-view-" + i + "\"]/section[1]/section[3]/section/button/md-icon"
	
	
	if (WebUI.verifyElementText(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): aydiInbox]),"Factures à moins de 5 jours de la date d'échéance", FailureHandling.OPTIONAL)) {
		WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): btnFiltre]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): btnFiltre]), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): pound]), FailureHandling.STOP_ON_FAILURE)
		break
	}
	
	
}


