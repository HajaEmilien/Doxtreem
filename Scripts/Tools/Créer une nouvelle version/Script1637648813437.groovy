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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'),20)
//WebUI.rightClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

int num1 = 0
for (int index = 0; index <= tablo.size()-1; index +=5){
	num1 ++
	if (tablo[index]=='E2E_Document_PDC' ){
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num1]), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.rightClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num1]))
		
	}
}
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_CreationVersion'))
def filePath1 = RunConfiguration.getProjectDir() + '/Document2Deposer/E2E_Document_PDC_1.pdf'
WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Doxtreem - Explorateur/champ_ajoutDoc'),filePath1, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker_ChampAjoutDoc'), 200)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker_ChampAjoutDoc'))
WebUI.delay(5)
tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

int num2 = 0
for (int index = 0; index <= tablo.size()-1; index +=5){
	num2 ++
	if (tablo[index]=='E2E_Document_PDC' ){
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num2]), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num2]))
		
	}
}

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/onglet_Version'))==true) {
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/onglet_Version'))
}
def v1 = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/version')) =~ /v\d+\.\d+/).findAll()
/*WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ExtraireStocker'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Extraire'))*/
/*WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/icon-cadenas'), 60)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/icon-cadenas'), FailureHandling.OPTIONAL)


//assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker')))
//WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker'))


/*if(WebUI.verifyTextPresent("Stocker",false,, FailureHandling.OPTIONAL)==true ) {
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker_ChampAjoutDoc'), 200)
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Stocker_ChampAjoutDoc'))
}*/

/*WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Actualiser'), 200)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Actualiser'))*/

WebUI.delay(5)

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))

int num = 0
for (int index = 0; index <= tablo.size()-1; index +=5){
	num ++
	if (tablo[index]=='E2E_Document_PDC_1.pdf' ){
		WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
		
	}
}
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Explorateur/version'), 20)
v2 = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/version')) =~ /v\d+\.\d+/).findAll()

if (v1 != v2) {
	Console.println('Création nouvelle version réussie !')
} else CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur de création de nouvelle version !!!')


