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

CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
if (WebUI.verifyElementInViewport(findTestObject('Page_Doxtreem - Bannettes/Bouton_Actualiser_Bannette'), 5, FailureHandling.STOP_ON_FAILURE)){
	WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Bouton_Actualiser_Bannette'))
	assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/Bouton_Actualiser_Bannette')))
	
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Echec de l\'actualisation de la bannette')
}
