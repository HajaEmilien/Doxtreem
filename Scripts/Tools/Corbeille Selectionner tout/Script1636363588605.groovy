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


TestObject obj = findTestObject('Page_Doxtreem - Corbeille/libelle_element_selectionne')

txt = WebUI.getText(obj)

txt_split = txt.split('/')
println txt_split


if (txt_split.size()>1){
	resultBefore = txt_split[0].replaceAll("[a-zA-Zé ]","")
	nbTotal =  txt_split[1].replaceAll("[a-zA-Zé ]","")
	
	if (nbTotal.toInteger() > 0) {
	
		for (i=1;i<=nbTotal.toInteger();i+=10) {
			WebUI.scrollToElement(findTestObject('Page_Doxtreem - Corbeille/line_element',[('position'): i]),5)
		}
		WebUI.delay(5)
		
		boolean btOption = true;
		
		try {
			if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))) {
			btOption = false
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Slectionner tout'))
			}
		}
		catch (Exception e) {
		}
		
		if (btOption){
					CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton option est indisponible')
		}
		
		resultAfter = (WebUI.getText(findTestObject('Page_Doxtreem - Corbeille/libelle_element_selectionne')).split('/')[0]).replaceAll("[a-zA-Zé ]","")
		
		if (resultBefore.toInteger() != resultAfter.toInteger()) {		
			if (resultAfter.toInteger() == nbTotal.toInteger()) {
				println('Tous les éléments sont sélectionnés.')
			} else {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Tous les éléments ne sont pas sélectionnés')
			}
		} else {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'action "Sélectionner tout" a échouée')
		}
	} else {
		println('La Corbeille est déjà vide !!!')
//		
		return 'CORBEILLE VIDE'
	}
	
} else {		
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur récupération nombre total des éléments dans Corbeille.')
}