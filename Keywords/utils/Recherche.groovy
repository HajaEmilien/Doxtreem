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

import internal.GlobalVariable

public class Recherche {
	def utilsFailKyewords= new utilsFail()
	@Keyword
	void ClickButtonPlus() {
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))
			println('Bouton plus cliqué')
		} else {
			utilsFailKyewords.customlaunchFail('Erreur sur le clic du bouton plus')
		}
	}
	@Keyword
	void SelectionnerCategorie(String categorie) {
		//TestObject MyTestObject1 = findTestObject('Object Repository/Page_Doxtreem - Recherche/Categorie du PDCM')
		//def claie = WebUI.getAttribute(MyTestObject1, "for")
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Categorie du PDCM'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Recherche/CheckListCategorie',['categorie':categorie]),5)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/CheckListCategorie',['categorie':categorie]))
		//WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	void VerifierChampRechercheAvancer() {
		WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Recherche/Bloc_rechercher'))
		if (!WebUI.verifyTextPresent('Type',false, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'))
		}
	}
	@Keyword
	void SelectionnerGroupePropriete(String GroupePropriete) {

		//		TestObject MyTestObject1 = findTestObject('Object Repository/Page_Doxtreem - Recherche/Grp_propriete')
		//		def claie = WebUI.getAttribute(MyTestObject1, "for")
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Autocomplet_Groupe_proprerties'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Autocomplet_Grp_List_Propriete',['Propriete':GroupePropriete]))

		//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Click_Grp_propriete',['aid':claie]))
		//		WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Recherche/List_Goupe_Propriete',['Grp_proriete':GroupePropriete]),5)
		//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/List_Goupe_Propriete',['Grp_proriete':GroupePropriete]))
	}
	@Keyword
	void SelectionnerPropriete(String Propriete) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Autocomplet_Propriete'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Autocomplet_Grp_List_Propriete',['Propriete':Propriete]))
		//		TestObject MyTestObject2 = findTestObject('Object Repository/Page_Doxtreem - Recherche/propriete')
		//		def	claye = WebUI.getAttribute(MyTestObject2, "for")
		//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Click_propriete',['aid':claye]))
		//		WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Recherche/ListePropriete',['proriete':Propriete]),5)
		//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/ListePropriete',['proriete':Propriete]))
	}
	@Keyword
	void SelectionnerOperateur(String Op) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/property_operator'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Autocomplet_Grp_List_Propriete',['Propriete':Op]))
		//		WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Recherche/Liste_Operateur',['operateur':Op]),5)
		//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Liste_Operateur',['operateur':Op]))
	}
	@Keyword
	void SelectionnerUneRechercheRecurrente(String Reccurente) {
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Recherche/List_Recherche_Recurrente',['Recurrente':Reccurente]),5)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/List_Recherche_Recurrente',['Recurrente':Reccurente]))
	}
	@Keyword
	void CLickboutonRechercher () {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'), 60)
		if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))==false) {
			utilsFailKyewords.customlaunchFail('Le bouton Rechercher est introuvable')
		}else {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))
		}
	}
	@Keyword
	void SaisirNomCompletElement(String Element ) {

		WebUI.setText(findTestObject('Page_Doxtreem - Recherche/input_Nom_Complet'), Element)
	}
	@Keyword
	void VerifierChampReherche() {

		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))==false) {
			utilsFailKyewords.customlaunchFail('Le champ recherche n\'est pas disponible')
		}
	}
}
