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



//WebUI.callTestCase(findTestCase('Tools/Creer un document'), ['nomdoc':'E2E_Document_PDC'], FailureHandling.STOP_ON_FAILURE)

void RenomemrDoc (String nom) {
	
	//def Content = "/html/body/div[10]"
	
	
	//WebUI.delay(2)
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'),120)
	
	//WebUI.rightClick(findTestObject('Object Repository/Page_Doxtreem - Explorateur/div_documentImporté'))
	
	WebUI.delay(5)
	
	 def tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
	
	int num = 0
	for (int index = 0; index <= tablo.size()-1; index +=5){
		num ++
		if (tablo[index]=="E2E_Document_PDC_1.pdf" || tablo[index]=="E2E_Document_renamed"  ){
			WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]), 10, FailureHandling.STOP_ON_FAILURE)
			WebUI.rightClick(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':num]))
			
		}
	}
	
	
	
   // def	idContent = WebUI.getAttribute(findTestObject('Object Repository/Xpath',['index':Content] ) , 'id', FailureHandling.OPTIONAL)
	
   // Console.println(idContent)
	//WebUI.delay(2)
   /* def	XpathMenuContectuel = "//*[@id='"+idContent+"']/md-menu-content"
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Xpath',['index':XpathMenuContectuel] ),30)*/
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_Renomer'), FailureHandling.STOP_ON_FAILURE)
	
   
	WebUI.clearText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/imput_Renomer'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Explorateur/imput_Renomer') , nom , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Btn_save_Renomer'))
	
	WebUI.delay(5)
	
	WebUI.verifyTextPresent(nom, false, FailureHandling.STOP_ON_FAILURE)
		
}


RenomemrDoc ("E2E_Document_renamed")

RenomemrDoc ("E2E_Document_PDC_1.pdf")

////def bannette = GlobalVariable.Bannette

//CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)

//WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':GlobalVariable.Dossier ], FailureHandling.STOP_ON_FAILURE)



