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

void ModifierNomDossier(String NomDossier , String description ) {
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button-Editer ce groupe de propriete'),120)
	WebUI.delay(5)
	if(WebUI.verifyTextNotPresent("DÉTAILS", false,FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Information'))
	}
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button-Editer ce groupe de propriete'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Champ_Edition propriete_Nom'),NomDossier)
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Champ_Description_Edition des proprits'),description)
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/EDP_button_Enregistrer'))
	
	WebUI.delay(5)
	/*****************************vérification des noms************************************************************/
	if (!WebUI.verifyTextPresent(NomDossier, false,FailureHandling.OPTIONAL)) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('le nom du dossier n\'est pas renommé en : '+NomDossier+'')
	}
	if (!WebUI.verifyTextPresent(description, false,FailureHandling.OPTIONAL)) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('la description '+description+' n\'est pas visible sur la page')
	}
	
}


//////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.CreationBannette'(bannette)

/*CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)

if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier')).contains(GlobalVariable.Dossier )){
	tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
	
	int num = 0
	for (int index = 0; index <= tablo.size()-1; index +=4){
		num ++
		if (tablo[index]==GlobalVariable.Dossier ){
			WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
			break
		}
	}
	
} else {

	CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 120)
	
	tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
	
	int num = 0
	for (int index = 0; index <= tablo.size()-1; index +=4){
		num ++
		if (tablo[index]==GlobalVariable.Dossier ){
			WebUI.doubleClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
			break
		}
	}
}

 if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'))==false) {
      CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'icône Voir les informations n\'est pas visible sur la page')	
}

WebUI.delay(5)

/************Vérifie que le texte Informations générales est présent sur la page*********************
if (!WebUI.verifyTextPresent('Informations générales', false,FailureHandling.OPTIONAL)) {
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'))
}

/*******************Accés à la page d'édition des propriétés*****************************************************/
ModifierNomDossier('E2E_Dossier_Rename','E2E Edit description')

ModifierNomDossier(GlobalVariable.Dossier ,'E2E description' )

/*******************************suppression bannette********************************************/

 //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)


