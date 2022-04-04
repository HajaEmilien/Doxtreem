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




if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('le button corbeille de la barre verticale n\'est pas visible sur la page')
		}else WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))
WebUI.delay(2)
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), 60)
if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))==false) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('le button sous forme de trois points en vertical  n\'est pas visible sur la page')
		} else WebUI.click(findTestObject('Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
WebUI.delay(2)
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Corbeille/button_Actualiser les documents'), 60)

if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/button_Actualiser les documents'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('le button actualiser les documents  n\'est pas visible sur la page')
		}else WebUI.click(findTestObject('Page_Doxtreem - Corbeille/button_Actualiser les documents'))


