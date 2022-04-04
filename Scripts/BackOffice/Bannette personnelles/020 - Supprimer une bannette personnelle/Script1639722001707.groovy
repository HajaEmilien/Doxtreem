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
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.*
	
        CustomKeywords.'utils.Bannettes.AccèsDossierDepuisBannette'(GlobalVariable.Dossier,GlobalVariable.Bannette)
		WebUI.waitForElementPresent(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier'), 10, FailureHandling.STOP_ON_FAILURE)


  
		  /************************************************Séléctionner le premier  document***********************************************/


			def tabloTow = []
			tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('Ko'))
			
			tablo.eachWithIndex { it, i ->
				if (it.toString().contains('pdf')) {
							tabloTow.add(i)
				}
			}
		    
		  WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':(tabloTow[0]+1)]), 120, FailureHandling.OPTIONAL)
		
					WebUI.rightClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':(tabloTow[0]+1)]))
					//WebUI.delay(2)
					
	/*************************************************Ajout du document dans une bannette perso*****************************************/
					
						if  (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 10]), FailureHandling.OPTIONAL)) {
							WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 10]))
							
						}else {
							WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 11]))
						}
						
					
					
									
		
		if  (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 11]), FailureHandling.OPTIONAL)) {
			   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 11]))
			   
		   }else {
			   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 12]))
		   }
		
		CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Page_Doxtreem - Bannettes Personnelles', 'Créer_BannettePersonnelle')
		
		
		  
		  
		 
		   WebUI.delay(3)
		  
		
		/*  TestObject MyTestObject1 = findTestObject('Object Repository/Page_Doxtreem - Recherche/Nom de la bannette')
		   claie = WebUI.getAttribute(MyTestObject1, "for")
		   WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/input_Nom de la bannette_inboxTitle',['aid':claie]), "Personnelle_E2E")*/
		   for( int i =10 ; i<=12;i++) {
			   input = "/html/body/div["+i+"]/md-dialog//input[starts-with(@id,'input_')]"
			   WebUI.setText(findTestObject('Object Repository/Xpath',['index':input]), "Personnelle_E2E", FailureHandling.OPTIONAL)
			   if(WebUI.verifyTextPresent("Personnelle_E2E", false, FailureHandling.OPTIONAL)) {
				   break
				   }
			   }
		   
		
		   WebUI.delay(3)
		    if  (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_Crer la bannette'), FailureHandling.OPTIONAL)) {
		  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/label_Crer la bannette'))
		  WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Recherche/msg_confirmation'), 60)
		   WebUI.refresh()
		    }
		  
		 /************************************************ Séléctionner le second document	 *******************************************/
						
		  WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':(tabloTow[1]+1)]), 120, FailureHandling.OPTIONAL)
		  WebUI.rightClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':(tabloTow[1]+1)]))
		  
			  if  (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 10]), FailureHandling.OPTIONAL)) {
				  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 10]))
				  
			  }else {
				  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_retirer', ['index': 11]))
			  }
			  
		 
		   
		   if  (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 11]), FailureHandling.OPTIONAL)) {
			   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 11]))
			   
		   }else {
			   WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/Ajouter_A_uneBannette', ['index': 12]))
		   }
		  
		  CustomKeywords.'utilsFindElement.chercheElement.Selectionner'('Page_Doxtreem - Bannettes Personnelles', 'Ajouter_A_uneBExistante')
		  
		 /******************************************* * Ajout du second document dans la bannette perso	 *********************************/  
												  
		CustomKeywords.'utilsFindElement.chercheElement.cliqueElement'('Page_Doxtreem - Bannettes Personnelles', 'NewBannettePerson')
												 



/****************************************Accéder à la page des bannettes**************************************************/

CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()


/**************************************Trouver la bannette Personnelle_E2E *************************************/
/*tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Tablo_explorer')).split('([0-9]*) / ([0-9]*)')
def entet
def num
tablo.eachWithIndex { it,i ->
	if (it.toString().split('\n').any { it == 'Personnelle_E2E' }) {
		num = i+1 
		entet = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes Personnelles/id_cible', ["index":num]), 'id', FailureHandling.STOP_ON_FAILURE)
	}
}*/

def entet = CustomKeywords.'utils.Bannettes.ChercheIdBannette'('Personnelle_E2E')

button_delete = "//*[@id=\"" + entet + "\"]/section[1]/section[3]/button[2]/md-icon"

WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression bannette perso'), ['index':button_delete], FailureHandling.OPTIONAL)
