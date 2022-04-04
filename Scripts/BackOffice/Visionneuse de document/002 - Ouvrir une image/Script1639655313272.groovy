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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



 
//WebUI.callTestCase(findTestCase('Tools/Creer un document image'), [:], FailureHandling.STOP_ON_FAILURE)

String[] lista = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n')
pOs = CustomKeywords.'utils.listage.newTablo'(lista, 'E2E_Image_PDC.jpg', 5)
if (pOs !='Critère absent !!!') {
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ligne_teableau___',['position': pOs ]))
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'image n\'est pas importer correctement ou time out !!!')
}
WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ligne_teableau___',['position': pOs ]))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/imgViewer'), 120)

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/docViewerToolbar'), 240)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/docViewerContent'),FailureHandling.OPTIONAL)) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('La visionneuse affichée n\'est pas celle de l\'image !!!')
	} else {
		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/docViewerToolbar'))) {
			WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf_closeViewer'))
		}
	}
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('La visionneuse n\'est pas affichée correctement !!!')
}
/*******************************suppression dossier***************************************/
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)

/*******************************suppression de la Bannette********************************/
 //CustomKeywords.'utils.Bannettes.SuppressionBannette'(GlobalVariable.Bannette)


