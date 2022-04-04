import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import static org.junit.Assert.*
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Bannettes' , ('An') : 'Inboxes'], FailureHandling.OPTIONAL)==false) {
            CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Bannettes" n\'est pas visible sur la page')
        }
if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/button_Creer une nouvelle bannette'))==false) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('La page Gestion des bannettes inacessible')
        }
   

/***************************************seléctionner la premère bannette ***************************************/
WebUI.delay(2)
CustomKeywords.'utils.gestionOrdreBanettes.SelectionnerUneBannette'("button_PremireBannette") 
//GestionBanette.SelectionnerUneBannette("button_PremireBannette")
/**************************************Faire Descendre la première bannette ***********************************/
CustomKeywords.'utils.gestionOrdreBanettes.FaireDescendreBannette'()
/*Saugarder l'ordre personnalisé et verifier la position du bannette */
CustomKeywords.'utils.gestionOrdreBanettes.SauvegarderOrdreBannette'()
/*Faire monter la première bannette */
WebUI.refresh()
/*Saugarder l'ordre personnalisé et verifier la position du bannette */
CustomKeywords.'utils.gestionOrdreBanettes.SelectionnerUneBannette'("Button_DeuxemeBannette")
CustomKeywords.'utils.gestionOrdreBanettes.FaireMonterBannette'()
/*Saugarder l'ordre personnalisé et verifier la position du bannette */
CustomKeywords.'utils.gestionOrdreBanettes.SauvegarderOrdreBannette'()
WebUI.refresh()
/*Selectionner la deuxième bannette*/
CustomKeywords.'utils.gestionOrdreBanettes.SelectionnerUneBannette'("Button_DeuxemeBannette")
/*Faire monter la deuxième bannette */
CustomKeywords.'utils.gestionOrdreBanettes.FaireMonterBannette'()
/*Saugarder l'ordre personnalisé et verifier la position du bannette */
CustomKeywords.'utils.gestionOrdreBanettes.SauvegarderOrdreBannette'()
WebUI.refresh()
CustomKeywords.'utils.gestionOrdreBanettes.SelectionnerUneBannette'("button_PremireBannette") 
CustomKeywords.'utils.gestionOrdreBanettes.FaireDescendreBannette'()



