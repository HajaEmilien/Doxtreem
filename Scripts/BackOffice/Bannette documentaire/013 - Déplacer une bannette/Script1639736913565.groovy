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


CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()

WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-icon_MenuGlobal'))

WebUI.click(findTestObject('Administration/Lien', [('titre') : 'Organisation des bannettes désactivée']), FailureHandling.STOP_ON_FAILURE)

/*****************************************Déplacer une bannette*************************************/


//leftPosition = WebUI.getElementLeftPosition(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bann_drop'))
//WebUI.dragAndDropToObject(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bann_drag'),findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bann_drop'))
//WebUI.delay(2)
WebUI.dragAndDropByOffset(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bann_drag'),485,40)
//WebUI.delay(2)
assertTrue(WebUI.verifyTextPresent("Ordre personnalisé des bannettes sauvegardé", false ))
//WebUI.delay(2)
CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
/****************************************Désactivée l'organisation des bannettes************************************/

WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-icon_MenuGlobal'))

if (WebUI.click(findTestObject('Administration/Lien', [('titre') : 'Organisation des bannettes activée']), FailureHandling.OPTIONAL)==false) {
     Console.println("Déja désactivé ")
	}


