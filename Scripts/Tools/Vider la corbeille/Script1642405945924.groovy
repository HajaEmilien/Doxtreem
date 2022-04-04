import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

switch(corbeille) {
	case('admin') :
		if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'))!='Corbeille administrateur') {
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille administrateur'))
		} else println 'Corbeille administrateur'
		break
	case('perso') :
		if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'))!='Ma corbeille') {
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))
		} else println 'Ma corbeille'
		break
} 

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/tablo_list_element_corbeille'), 120)

//String idBouton = '//button[normalize-space()="Vider la corbeille"]'

 if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_vider_corbeille'), FailureHandling.OPTIONAL)) {
	 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_vider_corbeille'))
//	 idPopup = '//div[@class="md-toolbar-tools"]'
	 WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/popup_vider_corbeille'), 120)
//	 idValider = '//button[normalize-space()="Valider"]'
	 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_valider_popup'))
	 WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/tablo_list_element_corbeille'), 120)
	 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))
	 WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'), 120)
	 WebUI.delay(2)
	 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Actualiser les documents'))
	 
	 if ((WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/champ_Aucun_element'))=='Aucun élément')==false) {
		 WebUI.callTestCase(findTestCase('Test Cases/Corbeille/Vider la corbeille'), ['corbeille':corbeille], FailureHandling.OPTIONAL)
	 }
 } else {
	 println('Corbeille déjà clean')
 }
 