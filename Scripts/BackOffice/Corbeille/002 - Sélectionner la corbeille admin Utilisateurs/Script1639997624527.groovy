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
import static org.junit.Assert.*
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject




//for (int second = 0; ; second++) {
//    if (second >= 1) {
//        CustomKeywords.'utils.utilsFail.customlaunchFail'('Le boutton corbeille n\'est pas visible sur la page')
//    }
//    
//    try {
//        if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))) {
//			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))
//            break
//        }
//    }
//    catch (Exception e) {
//    } 
//    
//    Thread.sleep(1000)
//}
CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()

assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille')))

WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))

try {
	WebUI.delay(2)
	if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille des utilisateurs'))) {
		WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-option_Corbeille des utilisateurs'))
		assertTrue(WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-select-value_Corbeille des utilisateurs')))
	}
}
catch (Exception e) {
}


