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

/*************connexion******************************/


/************ Accès adminstration fonctionnelle ***************************/
WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

/*Accéder à l'écran Utilisateur de l'onglet Gestion des identités*/
CustomKeywords.'utilsFindElement.chercheElement.Selectionner'("Administration","button_Utilisateurs")

WebUI.delay(5)

TestObject MyTestObject = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')

WebUI.switchToFrame(MyTestObject, 5)

assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/MenuUtilisateurs')))

WebUI.switchToDefaultContent()

WebUI.delay(3)

/***************************lance la recherche sur son propre nom utilisateur************************/
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'input_Recherche groupe', MyTestObject, 'DX_E2E')
WebUI.delay(3)

/*************************clique sur le bouton Modifier les rôles de l'utilisateur*******************/
CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'button_modifier_role', MyTestObject)
//WebUI.delay(2)

/*************************recherche le rôle DX_recycle_bin_admin*************************************/
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'RechercheRoles_popup', MyTestObject, 'DX_recycle_bin_admin')
//WebUI.delay(2)

/************************clique sur le resultat de la recherche dans las liste déroulante************/
CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'List_SAE_BACK', MyTestObject)
//WebUI.delay(2)

/***********************clique sur le bouton sauvegarder********************************************/
CustomKeywords.'utilsFindElement.chercheElement.cliqueInFrame'('Page_Doxtreem - Groupes', 'button_sauvegarde_infos', MyTestObject)

/********************Deconnexion*********************/
