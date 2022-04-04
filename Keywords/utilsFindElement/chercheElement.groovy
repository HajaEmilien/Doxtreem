package utilsFindElement

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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.utilsFail

public class chercheElement {
	def utilsFailKyewords= new utilsFail()
	@Keyword
	void Selectionner(String repostory, String Bouton) {
		if (WebUI.verifyElementVisible(findTestObject(''+repostory+'/'+Bouton+''), FailureHandling.OPTIONAL)) {


			WebUI.scrollToElement(findTestObject(''+repostory+'/'+Bouton+''), 5)

			WebUI.click(findTestObject(''+repostory+'/'+Bouton+''), FailureHandling.STOP_ON_FAILURE)
		}else utilsFailKyewords.customlaunchFail('Le bouton '+Bouton+' est inacessible ou non cliquable')
	}
	@Keyword
	void cliqueElement(String repostory, String Bouton) {
		if (WebUI.verifyElementVisible(findTestObject(''+repostory+'/'+Bouton+''), FailureHandling.OPTIONAL)) {


			WebUI.click(findTestObject(''+repostory+'/'+Bouton+''),FailureHandling.STOP_ON_FAILURE)
		}else utilsFailKyewords.customlaunchFail('Le bouton '+Bouton+' est inacessible ou non cliquable')
	}
	@Keyword
	void champDeSaisie (String repostory, String Bouton, Myframe, String valor) {
		WebUI.switchToFrame(Myframe, 5)
		//WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject(''+repostory+'/'+Bouton+''), 120)
		WebUI.setText(findTestObject(''+repostory+'/'+Bouton+''), valor)
		WebUI.switchToDefaultContent()
	}
	@Keyword
	void cliqueInFrame (String repostory, String Bouton, Myframe) {
		WebUI.switchToFrame(Myframe, 5)
		WebUI.click(findTestObject(''+repostory+'/'+Bouton+''))
		WebUI.switchToDefaultContent()
	}
	@Keyword
	listElement (String repostory, String Bouton, Myframe) {
		WebUI.switchToFrame(Myframe, 5)
		return WebUI.getText(findTestObject(''+repostory+'/'+Bouton+''))
		WebUI.switchToDefaultContent()
	}
	@Keyword
	listObjectElement (Myobjet, Myframe) {
		WebUI.switchToFrame(Myframe, 5)
		return WebUI.getText(Myobjet)
		WebUI.switchToDefaultContent()
	}
	@Keyword
	void Valider (Integer num,String repostory, String Bouton, String text) {

		TestObject validation = new TestObject()
		for (def index = num ;index<= (num + 5);index++) {

			if (index == (num + 4)) {
				utilsFailKyewords.customlaunchFail('le Button VALIDER n\'est pas clickable')
			}
			validation = findTestObject(''+repostory+'/'+Bouton+'',['index':index])

			if (WebUI.verifyElementText(validation, text,FailureHandling.CONTINUE_ON_FAILURE)== true) {
				WebUI.click(validation, FailureHandling.STOP_ON_FAILURE)
				break
			}
		}
	}
	@Keyword
	void PersoAjoutDossierDansBannette(String Dossier , String Bannette ) {
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Boutton_NouveauDossier'))
		WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/input_Nom_dossierCree'), Dossier)
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Crer'))

		/*************************************Est-ce qu'on a le message de confirmation**************************************/
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'), 20)
	}
}
