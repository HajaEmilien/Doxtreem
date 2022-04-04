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
import static org.junit.Assert.*

//def newFile = new File("fichierTest.pdf")

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/new_document'))
WebUI.delay(5)
//WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/GLISSER VOS DOCUMENTS ICI'),newFile.getAbsolutePath(), FailureHandling.STOP_ON_FAILURE)
WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/GLISSER VOS DOCUMENTS ICI'),file, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Importer'))
if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Chargemeent_Importation_Doc'), 30, FailureHandling.OPTIONAL)==false) {
	WebUI.refresh()
//	idLoad = "//div[@class='loading-percent loading-text js-loading-percent']"
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
	//WebUI.delay(2)
	}
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation'), 20)
WebUI.delay(5)
println('Ajout document pdf terminé !!!')