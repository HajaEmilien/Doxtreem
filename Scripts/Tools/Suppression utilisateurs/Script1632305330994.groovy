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

////WebUI.delay(10)
TestObject Myframe = findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/iframe_Aide_idd')
WebUI.delay(3)
WebUI.switchToFrame(Myframe, 5)
WebUI.delay(3)

result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Groupes/premiere_ligne_user'), FailureHandling.OPTIONAL)
/*println result*/
if (result.contains(user)){
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Groupes/button_suppr_groupe',['index':4]), FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Utilisateurs/Supprimer'), FailureHandling.STOP_ON_FAILURE)
}
WebUI.switchToDefaultContent()
WebUI.delay(3)