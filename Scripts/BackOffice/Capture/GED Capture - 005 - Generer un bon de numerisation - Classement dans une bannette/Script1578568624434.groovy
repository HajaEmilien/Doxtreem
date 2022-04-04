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





/***********Acceder a la page Centre de Distribution*********************************************/


if (WebUI.verifyElementClickable(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Centre de distribution n\'est pas cliquable')
        }
   
WebUI.click(findTestObject('Page_Centre de distribution/menuVertical_Centre_de_distribution'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Centre de distribution/button_genererBDN'), 60)
/*******************************Générer un BDN***************************************/

 if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Centre de distribution/button_genererBDN'))==false) {
			
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Générer un BDN n\'est pas cliquable')
        }
 
/**********************************capture url courant*******************************************************/

String urlDebut = WebUI.getUrl(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Centre de distribution/button_genererBDN'))

WebUI.delay(5)

/**********************************Basculer sur l'url courant****************************************/

WebUI.switchToWindowUrl(urlDebut)


/*********************************Est-ce qu'on a au moins le message de confirmation***************************************/

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Centre de distribution/Message_Gnration du bon de numrisation russie'), 60)
String result = WebUI.getText(findTestObject('Object Repository/Page_Centre de distribution/Message_Gnration du bon de numrisation russie'),FailureHandling.STOP_ON_FAILURE)


if (WebUI.verifyEqual(result, "Génération du bon de numérisation réussie !", FailureHandling.OPTIONAL)) {
	println "BND generé correctement"
}else{
	CustomKeywords.'utils.utilsFail.customlaunchFail'("Le BDN n\'est pas généré correctement")
}


//////WebUI.delay(10)



WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

//WebUI.waitForPageLoad(3000)
/*//WebUI.delay(2)
url = WebUI.getUrl(FailureHandling.STOP_ON_FAILURE)
//WebUI.delay(2)

if (WebUI.verifyLinksAccessible([url.substring(5)])) {
    println('l\'url est accessible - BDN generer')
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('l\'url n\'est pas accessible - le bon de numerisation n\'est pas generer')
}*/

WebUI.switchToWindowUrl(urlDebut)
//WebUI.delay(2)


