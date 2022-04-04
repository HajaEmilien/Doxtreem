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


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))==true) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Page_vues_des_traitements'))
}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Bannettes "Vues des traitements" n\'est pas disponible')

WebUI.delay(5)	

/****************Accèder au tags **************************************************/

attribute = WebUI.getText(findTestObject('Object Repository/Barre Horizontale')).split("\n")

for (i in attribute){
	
	try {
		
	println i.substring(0, 1) + ( i.substring(1).toLowerCase(Locale.ROOT))
	
	if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : i.substring(0, 1) + ( i.substring(1).toLowerCase(Locale.ROOT)),('An') :' '], FailureHandling.OPTIONAL)==false) {
		if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : i.substring(0).toLowerCase(Locale.ROOT),('An') :' '], FailureHandling.OPTIONAL)==false) {
			WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : i,('An') :' '], FailureHandling.OPTIONAL)
			}
		
		}
	break
	
	//WebUI.delay(2)
	}
	catch (Exception e) {
		
	}
	Thread.sleep(100)
}
/********************************** Passer en mode étendu *********************************************/	
if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Passer en mode étendu'], FailureHandling.OPTIONAL)==false) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le mode étendu n\' est pas activé')
}

