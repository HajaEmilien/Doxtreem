import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

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
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

//Capture l'identifiant du document situer à droite 
String CaptureInfoDroite() {
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'),60)
	WebUI.callTestCase(findTestCase('Tools/ClickDocCible'), ['docCible':nomdoc], FailureHandling.STOP_ON_FAILURE)
    WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Onglet_Details'), 2)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Onglet_Details'))
	WebUI.delay(2)
	def result
	
	/*********************************capturer tous ceux qui sont présents dans l\'écran de droite******************************************/
	
	result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Droite')).split('\n')
	def num
//	Console.println(result)
	result.eachWithIndex { it,i ->
		
		if (it.toString().equals("Identifiant de l'objet")) {
//				println it
				num = (i+1)
			}
	}
//	println num
	if (!WebUI.verifyTextPresent(result[num],false, FailureHandling.OPTIONAL)) {
		
		CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'identifiant de l\'objet '+ result[num] + ' est introuvable sur la page')
	}else {
		return GlobalVariable.Identifiant = result[num]
	}
	
}
// Ajouter un document 
void ajoutDoc() {
	//WebUI.delay(2)
	
		def filePath1 = RunConfiguration.getProjectDir() + '/Document2Deposer/E2E_Document_PDC_1.pdf'
		
		
			WebUI.click(findTestObject('Page_Doxtreem - Explorateur/new_document'))
				
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'), 60)
			WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/GLISSER VOS DOCUMENTS ICI'),filePath1, FailureHandling.OPTIONAL)
			
			WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/NomDuDocument'), nomdoc,FailureHandling.STOP_ON_FAILURE)
			
			
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'))
			
			WebUI.delay(5)
			
			if( WebUI.verifyTextPresent("Doublon détecté !",false,FailureHandling.OPTIONAL)==true) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_valider_doublon'))
			}
			
		if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Chargemeent_Importation_Doc'), 30, FailureHandling.OPTIONAL)==false) {
				 WebUI.refresh()
				
				 WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
				 WebUI.delay(3)
				 if((WebUI.verifyTextPresent(nomdoc, false,FailureHandling.OPTIONAL))==true) {
			
					 CaptureInfoDroite()
			
				 }else {CustomKeywords.'utils.utilsFail.customlaunchFail'("Error d'importation du document")}
		
		}else   CaptureInfoDroite()
	
		
}
//verification si on a le bon bouton d'ajout document 
boolean verificationNOnImportationDoc() {
	WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 60)
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/new_document'), 60)
if (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/new_document'))=='Document') {
	return true 
	}else return false 
	
}
//Verification si le document 'E2E_Document' est déjà présent sur la page 
void verificationDoc() {
	if (WebUI.verifyTextNotPresent(nomdoc, false, FailureHandling.OPTIONAL)) {
		ajoutDoc()
	}else {
		WebUI.refresh()
		
        WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
		WebUI.delay(2)
		CaptureInfoDroite()
	}
}
//Recherche la position du dossier dans la liste du tableau 
def recherche = {def table, String ban ->
	def num
	table.eachWithIndex { it,i ->
		if (it.toString().split('\n').any { it == ban }) {
			num = i+1
		}
	}
	return num
}

/*****************************début du traitement*****************************************/
//CustomKeywords.'utils.Bannettes.CreationBannette'(GlobalVariable.Bannette)
//CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier )
CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
WebUI.delay(5)
def entet
//def contenu_Ban
/**************************************Trouver Id de la  bannette*************************************/

entet = CustomKeywords.'utils.Bannettes.ChercheIdBannette'(GlobalVariable.Bannette)
//contenu_Ban = "//*[@id=\"" + entet + "\"]/md-content"

tablo = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ListContenuBannette', ['index': entet]), FailureHandling.STOP_ON_FAILURE).split(':[0-9][0-9]'))
println GlobalVariable.Dossier
def num = recherche(tablo,GlobalVariable.Dossier)



/***************************Si dossier absent dans la bannette séléctionnée créée sinon ouvrir*****************************/
if (num == null || num == " ") {
	println "dossier introuvable"
	CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
	ArrayList<String> folderName = new ArrayList<>();

	tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), FailureHandling.STOP_ON_FAILURE).split('\n'))

			if (tablo.any {it.equals(GlobalVariable.Dossier)}) {
				for (int index = 0; index <= tablo.size()-1; index +=4){
					folderName.add(tablo[index])
				}
				folderName.eachWithIndex { it, i ->
					if (it.toString().equals(GlobalVariable.Dossier)) {
							println "double click"
							WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':i.toInteger()+1]))
							if (verificationNOnImportationDoc()==true) {
									verificationDoc()
							} else {
									WebUI.refresh()
									WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
									WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':i.toInteger()+1]))
									WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 60)
									WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
									WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/new_document'), 60)
									verificationDoc()
								}
						
					}
				}
			} else {
				CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
				CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)
				WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':1]))
				if (verificationNOnImportationDoc()==true) {
					verificationDoc()
			     } else {
				       WebUI.refresh()
					   WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
					   WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':1]))
					   WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 60)
					   WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
					   WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/new_document'), 60)
					   verificationDoc()
				}
			}


}else {

CustomKeywords.'utils.Bannettes.AccèsDossierDepuisBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)
if (WebUI.verifyTextNotPresent(nomdoc, false, FailureHandling.OPTIONAL)) {
	WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 60)
	WebUI.delay(2)
	WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
	ajoutDoc()
}else {
	CaptureInfoDroite()
}

}
