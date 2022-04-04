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

def recherche = {def table, String ban ->
	def num
	table.eachWithIndex { it,i ->
		if (it.toString().split('\n').any { it == ban }) {
			num = i+1
		}
	}
	return num
}
void SelectLigne(String nom) {
	String [] tablo= WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n')
	def pOs = CustomKeywords.'utils.listage.newTablo'(tablo, nom, 5)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ligne_teableau___',['position': pOs ]))
}

CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
WebUI.delay(3)
def entet = CustomKeywords.'utils.Bannettes.ChercheIdBannette'(GlobalVariable.Bannette)
//def contenu_Ban = "//*[@id=\"" + entet + "\"]/md-content"

tablo = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ListContenuBannette', ['index': entet]), FailureHandling.STOP_ON_FAILURE).split(':[0-9][0-9]'))

def num = recherche(tablo,GlobalVariable.Dossier)
//def doss = "//*[@id=\"" + entet + "\"]/md-content/div[" + num + "]"

if (num == null || num == " ") {
	CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
	CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)
	WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':1]))
} else {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/DosseirInBan', ['index':entet, 'num': num]))
}

WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 60)
//WebUI.delay(2)

if (WebUI.verifyTextNotPresent('E2E_Image_PDC.jpg', false, FailureHandling.OPTIONAL)) {
	
	def filePath1 = RunConfiguration.getProjectDir() + '/Document2Deposer/E2E_Image_PDC.jpg'
	
       WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'), 60)
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/new_document'), 60)
	if (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/new_document'))=='Document') {
			WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/new_document'), 60)
			WebUI.click(findTestObject('Page_Doxtreem - Explorateur/new_document'))
	} else {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Echec de l\'ajout de document. Le bouton cliqué n\'est pas celui du nouveau document !!!')
		}
			
        WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'), 60)
		WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/GLISSER VOS DOCUMENTS ICI'),filePath1, FailureHandling.OPTIONAL)
		
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'))
		WebUI.delay(5)
			
			if( WebUI.verifyTextPresent("Doublon détecté !",false,FailureHandling.OPTIONAL)==true) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_valider_doublon'))
			}
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation'), 120)
	if(WebUI.verifyTextPresent('E2E_Image_PDC.jpg', false,FailureHandling.OPTIONAL)==false) {
			 WebUI.refresh()
//			 idLoad = "//div[@class='loading-percent loading-text js-loading-percent']"
			 WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
			 WebUI.delay(2)
			 if(WebUI.verifyTextPresent('E2E_Image_PDC', false,FailureHandling.OPTIONAL)==true) {
			 		println('Importation de l\'image OK.')
					SelectLigne('E2E_Image_PDC.jpg')
			 }else {CustomKeywords.'utils.utilsFail.customlaunchFail'("Error d'importation du document apres 60 secondes ")}
	
	}else   SelectLigne('E2E_Image_PDC.jpg') //CaptureInfoDroite()			

} else 	SelectLigne('E2E_Image_PDC.jpg') //CaptureInfoDroite()
	
	
