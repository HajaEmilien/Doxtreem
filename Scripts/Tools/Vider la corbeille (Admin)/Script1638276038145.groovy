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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


CustomKeywords.'utils.Corbeille.SelectAdminCorbeille'()
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Corbeille/libelle_element_selectionne'), 120)

def libelle = (WebUI.getText(findTestObject('Page_Doxtreem - Corbeille/libelle_element_selectionne')))
def nb

if (libelle != '' && libelle.contains('/')) {
	println libelle
	nb = libelle.split('/')[1].replaceAll("[a-zA-Zé ]","")
	println nb
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le libellé n\'est pas récupéré !!!')
}


if (nb !='' && nb.toInteger() > 0) {
	for (i=1;i<=nb.toInteger();i+=10) {
		WebUI.scrollToElement(findTestObject('Page_Doxtreem - Corbeille/line_element',[('position'): i]),5)
	}
	WebUI.delay(5)
	boolean btOption = true;
	
	try {
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))) {
		btOption = false
//		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), 200)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Slectionner tout'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Supprimer_selection'))
//		CustomKeywords.'utils.Corbeille.BoutonValider'('Suppression')
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille') ,120)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille'))
		}
	}
	catch (Exception e) {
	}
	
	if (btOption){
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton option est indisponible')
	}
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/pop-up-delete'),FailureHandling.OPTIONAL)) {
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Corbeille/pop-up-delete'), 120)
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'), 200)
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'))
		} else {
			WebUI.refresh()
			WebUI.callTestCase(findTestCase('Test Cases/Tools/Vider la corbeille (Admin)'), [:], FailureHandling.OPTIONAL)
		}
	} else {
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'), 200)
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'))
		} else {
			WebUI.refresh()
			WebUI.callTestCase(findTestCase('Test Cases/Tools/Vider la corbeille (Admin)'), [:], FailureHandling.OPTIONAL)
		}
	}
//	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), 120)
	WebUI.delay(3)
	
	if (WebUI.getText(findTestObject('Page_Doxtreem - Corbeille/libelle_element_selectionne')).split('/')[1].replaceAll("[a-zA-Zé ]","").toInteger()>0) {
		WebUI.callTestCase(findTestCase('Test Cases/Tools/Vider la corbeille (Admin)'), [:], FailureHandling.OPTIONAL)
	}else {
		return 'OK'
	}
}
else
{
	return 'OK'
}