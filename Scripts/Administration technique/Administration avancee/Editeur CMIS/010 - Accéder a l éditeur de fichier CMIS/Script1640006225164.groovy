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




WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)

/*******************************Accéder à Editeur de fichier CMIS********************************************/

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Editeur_de_fichier_CMIS'))==false) {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button Editeur de fichier CMIS est inactif ou grisé')
 }else {
   
	 WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/button_Editeur_de_fichier_CMIS'), FailureHandling.STOP_ON_FAILURE)

	 assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Title_Editeur de fichier CMIS')))
 }

