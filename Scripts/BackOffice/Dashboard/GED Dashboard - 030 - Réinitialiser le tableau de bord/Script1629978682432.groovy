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


import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'), 100, FailureHandling.STOP_ON_FAILURE)

 if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))) {
			WebUI.click(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))
            
        }else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Accueil n\'est pas disponible')


if (!WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/bloc_Dashboard'), FailureHandling.OPTIONAL)) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur d\'accès à la page Dashboard')
}

WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/menu_configuration'))

if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/button_Configuration_par_defaut'),FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Page_Doxtreem - Tableau de bord/button_Configuration_par_defaut'))
	
	if (WebUI.verifyTextPresent('Voulez-vous vraiment réinitialiser le dashboard ?', false)) {
		for (i = 10; i<=12; i++) {
			if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/test__bouton',['numero':i]), 'class', FailureHandling.OPTIONAL)) {
				if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/test__bouton',['numero':i]), 'class')=='md-primary md-confirm-button md-button md-ink-ripple md-default-theme md-focused') {
					println(WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/test__bouton',['numero':i])))
					WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/test__bouton',['numero':i]))
					break
				}
				
			}
		}		
	}
}





	