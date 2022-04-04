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




CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'), 120)
//for (int second = 0; ; second++) {
//	if (second >= 1) {
//		CustomKeywords.'utils.utilsFail.customlaunchFail'('le button corbeille de la barre verticale n\'est pas visible sur la page')
//	}
//	
//	try {
//		if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))) {
//			break
//		}
//	}
//	catch (Exception e) {
//	}
//	
//	Thread.sleep(1000)
//}
//
//WebUI.click(findTestObject('Page_Doxtreem - Corbeille/md-icon_Corbeille_leftbar'))
//
//for (int second = 0; ; second++) {
//    if (second >= 1) {
//        CustomKeywords.'utils.utilsFail.customlaunchFail'('Le menu_deroulant_Corbeille n\'est pas clickable sur la page')
//    }
//    
//    try {
//        if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'))) {
//            break
//        }
//    }
//    catch (Exception e) {
//    } 
//    
//    Thread.sleep(1000)
//}

/*vérifie si la page courante est déjà la page Ma corbeille */
result = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Corbeille/Menu_deroulante_corbeille'),FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyEqual(result, "Ma corbeille", FailureHandling.OPTIONAL)) {
 println "La page Ma corbeille est actuellement ouverte"
} else {
	 WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_ListeCorbeille'))
	 if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))) {
		 WebUI.click(findTestObject('Page_Doxtreem - Corbeille/span_Ma corbeille'))
	 } else {
		 CustomKeywords.'utils.utilsFail.customlaunchFail'("La page Ma corbeille est absente dans la liste des corbeilles")
	 }
 }



