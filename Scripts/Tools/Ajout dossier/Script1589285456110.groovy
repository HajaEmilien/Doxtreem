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
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/Button_Nouveau_Dossier_Barre_horizontale'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Boutton_NouveauDossier'))
WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/input_Nom_dossierCree'), dossier)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Crer'))

/************************************* Message de confirmation **************************************/
if (WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/Message_de_confirmation'), 120, FailureHandling.OPTIONAL)) {
	println('Création du dossier réussie')
} else 	CustomKeywords.'utils.utilsFail.customlaunchFail'('Echec de création du nouveau dossier')

