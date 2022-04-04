import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable




CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Administration', 'btn_Administration')
CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Administration', 'span_Administration fonctionnelle')

/*Accéder à l'écran Habilitations*/

CustomKeywords.'utilsFindElement.chercheElement.Selectionner'('Administration','button_Role')

////WebUI.delay(10)

TestObject MyTestObject = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')

/*Création rôle */

/*****************************champ rechercher nom role******************************/
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Habilitations', 'input_nomRole', MyTestObject, nomRole)

WebUI.switchToFrame(MyTestObject, 5)
TestObject Mylist = findTestObject('Object Repository/Page_Doxtreem - Habilitations/tab_Resultat')

if (WebUI.getText(Mylist, FailureHandling.OPTIONAL).split('\n').length < 5) {

	
	/***********************Sélectionner le bouton  Nouveau rôle*******************************/
		
	
	CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Page_Doxtreem - Habilitations', 'span_Nouveau role')
	
	
	/****************************remplissement du champ Nom du role de l'écran de droite***************************/
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Habilitations/newRole'),nomRole)
	
	/************Case à cocher***********************/
	for (int second = 1;second <3 ; second++) {
		
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Habilitations/CaseHabilitation', ['index':second]), ,FailureHandling.STOP_ON_FAILURE)
		
	}
	
	/*************************Button Enregistrer**************************************/
	
	CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Page_Doxtreem - Habilitations', 'button_enregistrer')
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Habilitations/btn_Valider_Changement_de_licence'))
	
	
}else {
	println('Le role E2E_Role déjà créer')
}

/***************************Vérification***************************************/
if (WebUI.getText(Mylist, FailureHandling.OPTIONAL).split('\n').length < 5) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le groupe '+nomRole+'non creer')
	}


