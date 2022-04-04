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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ConditionType


if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))) {
	WebUI.click(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))
	
}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Accueil n\'est pas disponible')

if (!WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/bloc_Dashboard'), FailureHandling.OPTIONAL)) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur d\'accès à la page Dashboard')
}


 if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes'))==false) {
			
			CustomKeywords.'utils.utilsFail.customlaunchFail'('La bannette cible n\'est pas disponible')
        }
    

//*Recherche position du bloc "BANNETTES*/
int position
if ((WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/bloc_Dashboard'))).contains('BANNETTES')) {
	for (int index = 0; index < 20; index++) {
		if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes_tmp',['index':index])).split('\n')[0] =='BANNETTES'){
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes_tmp',['index':index]), 5)
			position = index
			break
		}
	}
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bloc cible n\'est pas présent !!!')
}


WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bouton3points_Bloc',['position':position]))

String ident = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bouton3points_Bloc',['position':position]),'aria-owns')
String [] menuContainer = WebUI.getText(findTestObject('Page_Doxtreem - Tableau de bord/menu_container',['menu_container': ident])).split('\n')

int posBtn
for (i=0; i<= menuContainer.length;i++) {
	if (i>=menuContainer.length) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Actualiser n\'est pas disponible !!!')
	}
	try {
		if (menuContainer[i] == 'Actualiser') {
			posBtn = i+1
			break
		}
	}
	 catch (Exception e) {
	}
	    
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/button_Actualiser',[('identificateur'):ident,('posBtn'):posBtn]), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)

println('Actualisation du bloc effectuée.')


