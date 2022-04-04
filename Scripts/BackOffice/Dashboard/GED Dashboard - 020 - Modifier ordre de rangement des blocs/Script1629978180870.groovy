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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType
import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))) {
	WebUI.click(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))
	
}else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Accueil n\'est pas disponible')

WebUI.click(findTestObject('Page_Doxtreem - Tableau de bord/md-icon_Dashboard'))

def nomBloc
def nomBloc1


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes'))==false) {
		   
		   CustomKeywords.'utils.utilsFail.customlaunchFail'('La bannette cible n\'est pas disponible')
	   }
   
		
int position
if ((WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/bloc_Dashboard'))).contains('BANNETTES')) {
	for (int index = 0; index < 20; index++) {
		if (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes_tmp',['index':index])).split('\n')[0] =='BANNETTES'){
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes_tmp',['index':index]), 5)
			nomBloc = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bloc_Bannettes_tmp',['index':index])).split('\n')[0]
			position = index
			break
		}
	}
	
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bloc cible (BANNETTES) n\'est pas présent dans le dashboard !!!')
}

/*Nombre des blocs*/
WebDriver driver = DriverFactory.getWebDriver()
def blocCount = driver.findElements(By.xpath("//md-grid-tile")).size()

/*Déplacement du bloc "BANNETTES", à droite ou à gauche, selon sa position*/

if(position == blocCount.toInteger()-1){

	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bouton_AGauche',['position':position]))
	nomBloc1 = WebUI.getText(findTestObject('Page_Doxtreem - Tableau de bord/titre_module',['position':position.toInteger()-1])).split('\n')[0]

}else{
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Tableau de bord/Bouton_ADroite',['position':position]))
	nomBloc1 = WebUI.getText(findTestObject('Page_Doxtreem - Tableau de bord/titre_module',['position':position.toInteger()+1])).split('\n')[0]
	
}

println nomBloc + ' :::::: ' + nomBloc1

if (nomBloc==nomBloc1){
	println('Ordre de rangement modifié.')
	
}else{
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Ordre de rangement non modifié !!!')
}
