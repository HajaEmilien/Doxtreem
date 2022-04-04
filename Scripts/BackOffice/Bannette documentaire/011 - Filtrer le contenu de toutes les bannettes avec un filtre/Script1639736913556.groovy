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

if(WebUI.click(findTestObject('Administration/button_Filtrer_Global'), FailureHandling.OPTIONAL)==true) {
//WebUI.delay(2)

/*****************************************Choisir le filtre*************************************/

String [] ChoixFiltre = ["FAC : Code Fournisseur","FAC : Nom Fournisseur","FAC: Date facture min"]
for (int i = 0; i<ChoixFiltre.length ; i++) {
	switch(ChoixFiltre[i]) {
		case "FAC : Code Fournisseur" :
		  id = " //*[@id='inboxes-global-global-filters-container']/md-content//md-switch[@aria-label='"+ChoixFiltre[i]+"']"
		  break
		case "FAC : Nom Fournisseur" :
		   id = " //*[@id='inboxes-global-global-filters-container']/md-content//md-switch[@aria-label='"+ChoixFiltre[i]+"']"
		   break
		case "FAC: Date facture min" :
		   id = " //*[@id='inboxes-global-global-filters-container']/md-content//md-switch[@aria-label='"+ChoixFiltre[i]+"']"
		   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): id]), FailureHandling.STOP_ON_FAILURE)
		   idimput = "//*[@id='inboxes-global-global-filters-container']/md-content//input[starts-with(@id,'input_')]"
		   WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/titLe', [('index'): idimput]),"28/09/2021")
		   break
		default :
		 Console.println("Ne fait rien ")
		 break
		 
	}
	}
	
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_FiltrerGlobal'), FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(5)

	/************************************Réinitialisation du filtre*********************************/
	
	WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-icon_MenuGlobal'))
	
	WebUI.click(findTestObject('Administration/button_Filtrer_Global'), FailureHandling.STOP_ON_FAILURE)
	//WebUI.delay(2)
	WebUI.doubleClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_ReinitialiserGlobal'), FailureHandling.STOP_ON_FAILURE)
}else Console.println("Le bouton Filtre globale n'est pas activé ")
