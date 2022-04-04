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


CustomKeywords.'utils.Recherche.VerifierChampReherche'()
assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/searchButton')))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/searchButton'))
////WebUI.delay(10)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/Compteur_Resultat_recherche'), 120)
Text = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/Compteur_Resultat_recherche')).split('/')//.substring(0,3)
nb = Text[0].split(' ')[0]
//int nb = Text as Integer
//assertTrue(nb>0)
if(nb.toInteger() > 0) {
	Console.println("Recherche simple Ok avec nombre de resultat : " + nb )
}else CustomKeywords.'utils.utilsFail.customlaunchFail'("Recherche Simple → Resultat vide")

