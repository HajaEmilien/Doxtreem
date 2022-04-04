import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


//********************************Créer un document***************************************/
//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)

/********************************suppression document*************************************/


WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Doc_Suppr'], FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression document'), ['nomdosuppr':'E2E_Doc_Suppr'], FailureHandling.STOP_ON_FAILURE)

/*******************************Accèder à l'écran de la corbeille*********************************/

CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()

/*******************************Est-ce qu'on trouve dans la corbeille le document supprimer****************/
CustomKeywords.'utils.Corbeille.VerifE2EDocCorbeille'("E2E_Doc_Suppr")

/*******************************suppression dossier***************************************/
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)

/*******************************suppression de la Bannette********************************/
//////def bannette = GlobalVariable.Bannette
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)



