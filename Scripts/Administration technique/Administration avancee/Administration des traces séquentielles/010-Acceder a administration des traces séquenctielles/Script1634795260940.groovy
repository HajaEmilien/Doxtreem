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
import org.eclipse.core.runtime.Assert as Assert
import org.openqa.selenium.Keys as Keys



WebUI.callTestCase(findTestCase('Tools/Accès Administration Technique'), [:], FailureHandling.STOP_ON_FAILURE)

if ((WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Administration des traces séquentielles/button_Administration du SAE'),FailureHandling.OPTIONAL))==false ) {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Admnistration des traces séquentielles  introuvable ou inaccessible')

}else 
	
	{ 
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Administration technique/Administration des traces séquentielles/button_Administration du SAE'))
 
		WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Administration des traces séquentielles/h2_Administration du SAE'), 
    FailureHandling.STOP_ON_FAILURE)

		Assert.isTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Administration technique/Administration des traces séquentielles/h3_Administration des traces squentielles')))
        
	}


