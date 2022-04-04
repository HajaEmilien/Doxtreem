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
import com.kms.katalon.core.testobject.ConditionType
import static org.junit.Assert.*
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Bannettes' , ('An') : 'Inboxes'], FailureHandling.OPTIONAL)==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Bannettes" n\'est pas visible sur la page')
	}
	
for (int i =1;;i++) {
	if (i >=4) {
		break
	}
	

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Trois_button_clickable',["index":i]), FailureHandling.STOP_ON_FAILURE)
}

