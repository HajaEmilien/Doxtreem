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

import java.util.concurrent.ConcurrentHashMap.KeySetView

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


CustomKeywords.'utils.Recherche.ClickButtonPlus'()
//Vérifier que le  champ pour la recherche avancée s'affiche
WebUI.delay(3)
CustomKeywords.'utils.Recherche.VerifierChampRechercheAvancer'()
CustomKeywords.'utils.Recherche.SelectionnerCategorie'('test LRE (wlzaalala)')
//CustomKeywords.'utils.Recherche.ClickButtonPlus'()
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'))
if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'), 10, FailureHandling.OPTIONAL)==true) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/button_Rechercher'),FailureHandling.OPTIONAL)}	
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'), 120)
WebUI.delay(3)
Result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Resultat_recherche'))
Console.println(Result)
assertTrue("Resultat de recherche ne contient pas : 'test LRE' ou 'wlzaalala' ",Result.contains('test LRE') || Result.contains('wlzaalala'))
//assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL))
//CustomKeywords.'utils.Recherche.ClickButtonPlus'()
//WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/Button_réinitialiser'))


