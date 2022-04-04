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

/****************Accèder au menu de droite**************************************************/
attribute = ['Actualiser','Afficher les filtres','Passer toutes les bannettes en mode étendu','Passer toutes les bannettes en mode normal','Modifier la taille des bannettes']
for (i in attribute) {
		
		try {
				if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))) {
					
					switch (i) {
						case 'Afficher les filtres':
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						//WebUI.delay(2)
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						break
						case 'Modifier la taille des bannettes':
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						//WebUI.delay(2)
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						//WebUI.delay(2)
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						break
						default:
						WebUI.focus(findTestObject('Object Repository/Page_Doxtreem - Bannettes vues des traitements/Bouton_menu'))
						WebUI.click(findTestObject('Administration/Lien', [('titre') : i]), FailureHandling.STOP_ON_FAILURE)
						break
						}
					
				}
		}
		catch (Exception e) {
		}

		Thread.sleep(1000)
	}
		


