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

public class Bannettes {
	def utilsFailKyewords= new utilsFail()
	def TestFileBannette = new TestFile()
	@Keyword
	ChercheIdBannette (String Bannette) {
		def recherche = {def table, String ban ->
			def num
			table.eachWithIndex { it,i ->
				if (it.toString().split('\n').any { it == ban }) {
					num = i+1
				}
			}
			return num
		}
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Tablo_explorer'), 10)
		def tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Tablo_explorer'),FailureHandling.STOP_ON_FAILURE).split('([0-9]*) / ([0-9]*)')
		String entet
		def num = recherche(tablo,Bannette)
		entet = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/id_cible', ["index":num]), 'id', FailureHandling.STOP_ON_FAILURE)
		return entet
	}
	@Keyword
	boolean VerificationBannette(String Bannette ) {
		WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Bannettes' , ('An') : 'Inboxes'], FailureHandling.OPTIONAL)
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ_Rechercher'), 120)
		WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ_Rechercher'), Bannette, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		if (!WebUI.getText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Resultat recherche')).isEmpty()) {
			def result = WebUI.getText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Resultat recherche')).split ('\n')
			if (result.toList().any { it == Bannette}) {
				println "La bannette " + Bannette + " est déjà créée"
				return true
			}else {
				Console.println("La "+Bannette+" n'est pas encore créée")
				return false
			}
		} else {
			Console.println("La "+Bannette+" n'est pas encore créée")
			return false
		}
	}
	@Keyword
	void AccessVuDocumenytaire() {
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'), 120)
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'), 120)
		if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))
		}else {
			utilsFailKyewords.customlaunchFail('Le bouton Bannettes du menu lateral n\'est pas disponible')
		}
	}
	@Keyword
	void ClickTitreBannetteVueDocumentaire(String Bannette) {
		def bannette = Bannette
				.replace("_", "-")
				.replace(" ","-")
				.replace(":","-")
				.replace(".","-")
		AccessVuDocumenytaire()
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Vues documentaires/Titre_Bannette',['bannette':bannette]), 120)
		if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Vues documentaires/Titre_Bannette',['bannette':bannette]), FailureHandling.OPTIONAL)) {
			WebUI.scrollToElement(findTestObject('Page_Doxtreem - Vues documentaires/Titre_Bannette',['bannette':bannette]),5, FailureHandling.OPTIONAL)
			WebUI.click(findTestObject('Page_Doxtreem - Vues documentaires/Titre_Bannette',['bannette':bannette]))
		}else utilsFailKyewords.customlaunchFail('Le titre de la bannette : '+Bannette+'n\'est pas clickable')
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 120)
		//		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorer_shader'), 10, FailureHandling.OPTIONAL)) {
		//			utilsFailKyewords.customlaunchFail("Accès dans la contenu du bannette KO")
		//		}
	}
	@Keyword
	boolean CheckBannetteVueDocumentaire(String Bannette) {
		def bannette = Bannette
				.replace("_", "-")
				.replace(" ","-")
				.replace(":","-")
				.replace(".","-")
		AccessVuDocumenytaire()
		WebUI.refresh()
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
		if (WebUI.verifyElementPresent(findTestObject('Page_Doxtreem - Vues documentaires/Titre_Bannette',['bannette':bannette]), 10, FailureHandling.OPTIONAL)) {
			return true
		} else return false
	}

	@Keyword
	void CreationBannette (String Bannette) {
		if(Bannette == GlobalVariable.Bannette) {
			TestFileBannette.UpgradTestBannetteInTrue()
		}
		if(VerificationBannette(Bannette)== false) {
			WebUI.callTestCase(findTestCase('Test Cases/Tools/Creer nouvelle Bannette'), ['Bannette':Bannette], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(2)
			WebUI.refresh()
			WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
			if(Bannette == GlobalVariable.Bannette) {
				TestFileBannette.Writefile(GlobalVariable.filePath2,"Creation Bannette Terminée")
			}
			ClickTitreBannetteVueDocumentaire(Bannette)
		}
		else {
			if(Bannette == GlobalVariable.Bannette) {
				TestFileBannette.Writefile(GlobalVariable.filePath2,"Creation Bannette Terminée")
			}
			ClickTitreBannetteVueDocumentaire(Bannette)
		}
	}
	@Keyword
	void ClickResultRechercheBannette(String Bannette) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ResultatBannette',['bannette' : Bannette]), 10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ResultatBannette',['bannette' : Bannette]), 10)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ResultatBannette',['bannette' : Bannette]))
	}
	@Keyword
	void SuppressionBannette(String Bannette) {
		if(VerificationBannette(Bannette)==true) {
			ClickResultRechercheBannette(Bannette)
			WebUI.callTestCase(findTestCase('Tools/Suppression bannette'), [:], FailureHandling.STOP_ON_FAILURE)
		}else Console.println("la bannette "+Bannette+"est déjà supprimée")
	}
	@Keyword
	void AjoutDossierDansBannette(String Dossier,String Bannette) {
		if (!WebUI.verifyTextPresent(Dossier, false,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Boutton_NouveauDossier'))
			WebUI.clearText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/input_Nom_dossierCree'))
			WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/input_Nom_dossierCree'), Dossier )
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Crer'))
			WebUI.delay(2)
			if (WebUI.verifyTextPresent(Dossier, false, FailureHandling.OPTIONAL)) {
				println('Création du dossier réussie')
			} else  utilsFailKyewords.customlaunchFail('Echec de création du nouveau dossier')
		} else println('Dossier déjà présent ')
	}
	@Keyword
	void AccèsDossierDepuisBannette(String Dossier , String Bannette) {
		def recherche = {def table, String ban ->
			def num
			table.eachWithIndex { it,i ->
				if (it.toString().split('\n').any { it == ban }) {
					num = i+1
				}
			}
			return num
		}

		this.AccessVuDocumenytaire()
		WebUI.delay(5)
		def entet
		def contenu_Ban
		/**************************************Trouver Id de la  bannette*************************************/
		entet = this.ChercheIdBannette(Bannette)
		entet.toString()
		def  tablo = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ListContenuBannette', ['index': entet]), FailureHandling.STOP_ON_FAILURE).split(':[0-9][0-9]'))
		def num = recherche(tablo,Dossier)
		if (num == null || num == " ") {
			println "dossier introuvable"
		}else {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/DosseirInBan', ['index':entet,'num': num]))
		}
	}
}