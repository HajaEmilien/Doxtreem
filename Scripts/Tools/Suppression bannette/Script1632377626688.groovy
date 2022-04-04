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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


//WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Resultat recherche'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'),
	120)
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'), 
    120)

if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'))) {
	//WebUI.delay(2)
	 WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'), FailureHandling.STOP_ON_FAILURE)
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button  Supprimer la bannette courante est inaccessible ou grisé')
}
WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_Validation_Suppression'), 120)
if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_Validation_Suppression'))==true) {
        WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_Validation_Suppression'), 
                FailureHandling.STOP_ON_FAILURE)
}else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Button_Validation_Suppression inacessible')
    

/***************************Vérification texte affiché au milieu du panneau principal*************************/

/*if (!(WebUI.verifyTextPresent('Veuillez sélectionner une bannette ou en créer une nouvelle', false))) {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('le texte : Veuillez sélectionner une bannette ou en créer une nouvelle ne s\'affiche pas sur le panneau principal')
}*/

/*********************************************Retour à la page Administration fonctionnelle************************************************************/

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Administration/button_retour')) == true) {
            WebUI.click(findTestObject('Object Repository/Administration/button_retour'))
        } else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Button_retour inaccessible')
    
 
	
	
	




