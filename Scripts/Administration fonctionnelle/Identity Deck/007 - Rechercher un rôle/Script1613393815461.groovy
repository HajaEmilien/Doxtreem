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

/***************************Connexion************************************/


/************************Création role************************************/
String nomRole = "E2E_Role"
WebUI.callTestCase(findTestCase('Tools/Creer un rôle'), ['nomRole':nomRole], FailureHandling.OPTIONAL)
WebUI.switchToDefaultContent()

/*************************Trouver le role nouvellement créé***************/
TestObject MyTestObject = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')
CustomKeywords.'utilsFindElement.chercheElement.champDeSaisie'('Page_Doxtreem - Habilitations', 'input_nomRole', MyTestObject, nomRole)
WebUI.delay(3)
WebUI.switchToFrame(MyTestObject, 5)
WebUI.delay(3)
/***************************capturer le résultat de la recherche**********/
result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Habilitations/tab_Resultat'))

/***************************vérification si le rôle est présent dans la liste des résultats*****/
if (result.contains(nomRole)){
		println('Rôle trouvé.')
		/*********************Suppression role****************************/
		WebUI.callTestCase(findTestCase('Tools/Suppression role'), ['nomRole':nomRole], FailureHandling.OPTIONAL)
		WebUI.switchToDefaultContent()

}
