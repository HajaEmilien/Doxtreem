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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



CustomKeywords.'utils.Recherche.ClickButtonPlus'()
WebUI.delay(3)
//Vérifier que le  champ pour la recherche avancée s'affiche
CustomKeywords.'utils.Recherche.VerifierChampRechercheAvancer'()
CustomKeywords.'utils.Recherche.SelectionnerGroupePropriete'('Confidentialité')
CustomKeywords.'utils.Recherche.SelectionnerPropriete'('Niveau de confidentialité')
CustomKeywords.'utils.Recherche.SelectionnerOperateur'('=')
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/property_value'))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Valeur_Propriete',['propriete':"Confidentiel"]))
//WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/property_add'))
//TestObject MyTestObject3 = findTestObject('Object Repository/Page_Doxtreem - Recherche/Propriete_date')
//WebUI.setText(MyTestObject3, new Date().format( 'ddMMyyyy' ), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'utils.Recherche.CLickboutonRechercher'()
//WebUI.delay(5)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), 120)
assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL))
CustomKeywords.'utils.Recherche.ClickButtonPlus'()
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Button_réinitialiser'))
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))

