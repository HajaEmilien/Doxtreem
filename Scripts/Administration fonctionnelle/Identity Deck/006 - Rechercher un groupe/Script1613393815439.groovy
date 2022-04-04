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




String nomGroupe = "E2E_Group"
WebUI.callTestCase(findTestCase('Tools/Creer un groupe'), ['nomGroupe':nomGroupe], FailureHandling.OPTIONAL)
WebUI.switchToDefaultContent()
CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Administration', 'btn_Administration')
CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Administration', 'span_Administration fonctionnelle')
CustomKeywords.'utilsFindElement.chercheElement.Selectionner'('Administration','button_Groupes')


/*Recherche groupe */
//////WebUI.delay(10)


TestObject MyObject = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')
/*Création groupe */
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Groupes', 'input_Recherche groupe', MyObject, nomGroupe)

WebUI.delay(5)
WebUI.switchToFrame(MyObject, 5)
TestObject Mylist = findTestObject('Object Repository/Page_Doxtreem - Groupes/tab_Resultat')

if (!WebUI.getText(Mylist, FailureHandling.OPTIONAL).contains(nomGroupe)) {
	fail("Groupe  "+nomGroupe+" n'est pas trouvé dans la liste.")
	
}else {
	Console.println('Groupe  '+nomGroupe+' trouvé.')
		WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression groupe'), ['nomGroupe':nomGroupe], FailureHandling.OPTIONAL)
		WebUI.switchToDefaultContent()
		
}
