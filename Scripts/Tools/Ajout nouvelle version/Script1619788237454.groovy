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

def newFile = new File("fichierTest.pdf")

int nb

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
for (int index = 0; index < tablo.size(); index +=5){
	nb++
	if (tablo[index].contains('.pdf')) {
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':nb]))
		break
	}
	
}

WebUI.delay(5)

assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker')))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/onglet_Version'))
v1 = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/version')) =~ /v\d+\.\d+/).findAll()

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Extraire'))

////WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'))

assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker')))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker'))

WebUI.delay(5)

WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/champ_ajoutDoc'),newFile.getAbsolutePath(), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker_ChampAjoutDoc'))
////WebUI.delay(10)

WebUI.click(findTestObject('Page_Doxtreem - Explorateur/button_Actualiser'))
WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':nb]))

v2 = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/version')) =~ /v\d+\.\d+/).findAll()

if (v1 != v2) {
	println('Création nouvelle version réussie !')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur de création de nouvelle version !!!')
}