package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static org.junit.Assert.*
import internal.GlobalVariable

public class Corbeille {
	def utilsFailKyewords= new utilsFail()
	@Keyword
	void AccesderPageCorbeille() {
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'), 120)
		//		//WebUI.delay(2)
		if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))==true) {
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))
		}else utilsFailKyewords.customlaunchFail('le button corbeille n\'est pas visible sur la page')

		//WebUI.delay(2)

		if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'))==false) {
			utilsFailKyewords.customlaunchFail('le button sous forme de trois points en vertical  n\'est pas visible page Corbeille inaccessible')
		}
	}
	@Keyword
	void VerifE2EDocCorbeille(String document) {
		//WebUI.delay(2)
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/OrdonnerNom'))) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/OrdonnerNom'))
		} else {
			utilsFailKyewords.customlaunchFail('Echec sur ordonner les noms dans la corbeille')
		}
		WebUI.delay(5)
		if (!(WebUI.verifyTextPresent(document, false, FailureHandling.OPTIONAL))) {
			utilsFailKyewords.customlaunchFail('Le document E2E_Document_PDC est introuvable sur la page')
		}
	}


	@Keyword
	void RestaurerDocument() {

		WebUI.check(findTestObject('Page_Doxtreem - Corbeille/div_DX_E2E_md-container md-ink-ripple'))
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille des utilisateurs_md-defau_843c7c'))
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/button_Valider (1)'))
	}

	@Keyword
	void SelectItem(String nom) {
		String [] tablo=""
		tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/tablo_list_element_corbeille')).split('\n')
		if (tablo != 'Aucun élément') {
			int nLigne=0
			int i
			for (i=0; i<=tablo.size()-1 ;i+=4) {
				nLigne++
				if (tablo[i] == nom) {
					WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/case_a_cocher',['nLigne':nLigne.toInteger()]))
				}
			}
			if (nLigne.toInteger()<=0) {
				utilsFailKyewords.customlaunchFail('Aucun élément correspondant au critère !!!')
			}
		}
	}

	@Keyword
	void BoutonValider(String titre) {
		int index
		String delete
		WebUI.delay(5)
		if (WebUI.verifyTextPresent(titre, false, FailureHandling.OPTIONAL)) {
			for (index = 9;index<=15;index++) {
				if (WebUI.getAttribute(findTestObject('Page_Doxtreem - Corbeille/Button_Valider_action',['index':index]), 'ng-click',FailureHandling.OPTIONAL)) {
					delete = WebUI.getText(findTestObject('Page_Doxtreem - Corbeille/Button_Valider_action',['index':index]))

					if (delete =='VALIDER') {
						WebUI.click(findTestObject('Page_Doxtreem - Corbeille/Button_Valider_action',['index':index]),FailureHandling.STOP_ON_FAILURE)
						WebUI.delay(5)
						if(WebUI.verifyTextPresent(titre, false, FailureHandling.OPTIONAL)){
							WebUI.click(findTestObject('Page_Doxtreem - Corbeille/Button_Valider_action',['index':index]),FailureHandling.STOP_ON_FAILURE)
							WebUI.delay(5)
						}
						break
					}
				}
			}
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Button_Menu_trois_points_vertical'), 180)
		} else {
			utilsFailKyewords.customlaunchFail('Pop-up de confirmation non affiché !!!')
		}
	}
	@Keyword
	void SelectAdminCorbeille() {
		this.AccesderPageCorbeille()
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille administrateur'), 120, FailureHandling.OPTIONAL)
		try {
			if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille administrateur'))==true) {
				WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille administrateur'))
				WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/tablo_list_element_corbeille'), 120)
				//				assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-select-value_Corbeille administrateur')))
			}
		}
		catch (Exception e) {
		}
	}
	@Keyword
	void DeleteItemSelected(String nom, String titre) {
		this.SelectItem(nom)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/button_Supprimer_selection'))
		//		this.BoutonValider(titre)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille' ), 120)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Btn_Valider_Suppr_Corbeille') )
	}
}

