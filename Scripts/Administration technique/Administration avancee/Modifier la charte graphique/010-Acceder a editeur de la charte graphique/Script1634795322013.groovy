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


WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Modifier la charte graphique/button_EditeurCharteGraphique'))) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Modifier la charte graphique/button_EditeurCharteGraphique'))
        } else CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Modifier les couleur et le logo de l\'application  introuvable ou inaccessible')
   
 if(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Modifier la charte graphique/Title_Editeur de la charte graphique'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Titre Editeur de la chartre grapsehique n\'est pas présent sur la page.')	
 }

 if(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Modifier la charte graphique/Title_Couleurs de lapplication'))==false ) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Titre Couleurs de l\'application n\'est pas présent sur la page.')
 }

 if(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Modifier la charte graphique/Title_Changement des logos de lapplication'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Titre Changement des logos n\'est pas présent sur la page.')
 }
 if(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Modifier la charte graphique/Title_Personnalisation de la page de connexion'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Titre Personnalisation de la page de connexion n\'est pas présent sur la page.')
	
 }
