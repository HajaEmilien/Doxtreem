import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**************Connexion**********************/


/************************Creation utilisateur***********/
String user = "DX_AdminE2E"
WebUI.callTestCase(findTestCase('Tools/Creer un utilisateur'), ['user':user], FailureHandling.OPTIONAL)

	/********************Bouton Groupe**********************/
    //////WebUI.delay(10)
    TestObject MyTestObject = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')
    WebUI.switchToFrame(MyTestObject, 5)
	WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Doxtreem - Groupes/button_suppr_groupe', ['index':2]), 120)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Groupes/button_suppr_groupe', ['index':2]), FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(3)
	WebUI.switchToDefaultContent()
	WebUI.delay(3)
	
	/********************Recherche et ajout groupe SAE_Back*******************/
	CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheGroup_popup', MyTestObject, 'SAE_Back')
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
	WebUI.delay(2)
	/*******************basculer vers l'onglet Roles***************************/
	WebUI.switchToFrame(MyTestObject, 5)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Groupes/icone_role_grp'), 120)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Groupes/icone_role_grp'))
	WebUI.switchToDefaultContent()
	
//	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'icone_role_grp', MyTestObject)
	WebUI.delay(2)
	/******************Recherche et ajout plusieurs rôles**********************/
	CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheRoles_popup', MyTestObject, 'functional_admin')
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
	WebUI.delay(2)
	WebUI.switchToFrame(MyTestObject, 5)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Habilitations/btn_Valider_Changement_de_licence'),FailureHandling.OPTIONAL)
	WebUI.switchToDefaultContent()
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheRoles_popup', MyTestObject, 'technical_admin')
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheRoles_popup', MyTestObject, 'DX_recycle_bin_admin')
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheRoles_popup', MyTestObject, 'LOG_VIEWER')
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
	WebUI.delay(2)
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'button_sauvegarde_infos', MyTestObject)
	WebUI.delay(5)
	
	/******************Suppression de l'utilisateur DX_AdminE2E****************/
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'button_suppr_DX_Admin', MyTestObject)
	WebUI.delay(3)
	CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Utilisateurs', 'Supprimer', MyTestObject)
	WebUI.delay(3)
	WebUI.switchToDefaultContent()
	
