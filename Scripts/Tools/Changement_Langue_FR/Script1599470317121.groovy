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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String lang =''

for (def second = 0; ; second++) {
	if (second >= 1) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Mon Profil n\'est pas disponible')
	}
	try {
		if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))) {
			WebUI.click(findTestObject('Page_WSO2 Identity Server/md-icon_Profil'))
			break;
		}
	}
	catch (Exception e) {
	}
	Thread.sleep(1000)
}

WebUI.waitForElementVisible(findTestObject('Page_WSO2 Identity Server/button_Langues'),60)

for (def second = 0; ; second++) {
	if (second >= 1) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Langues est inaccessible')
	}
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/button_Langues')))  {
			lang = WebUI.getText(findTestObject('Page_WSO2 Identity Server/button_Langues'))
			println(lang)
			break;
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}

switch (lang){
	case 'Langues' :
		println('Portail déjà en Français')
		WebUI.sendKeys(findTestObject('Page_WSO2 Identity Server/button_Langues'), Keys.chord(Keys.ESCAPE))
		break;
		
	case 'Languages' :
		println('Portail en Anglais')
		//Changement de langue EN en FR
		WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Langues'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(en)'), 120)
		WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(en)'))
		for (def second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'initialisation de l\'application a échouée')
			}
			
		try {
				if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche')))  {
					String placeholder = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 'placeholder')
					if(placeholder == 'Rechercher'){
						println('Changement de langue (de EN en FR) réussi !!!')
//						
						break;
					} else {
						CustomKeywords.'utils.utilsFail.customlaunchFail'('Le changement de langue a échoué !!!')
					}
				}
			}
			catch (Exception e) {
			}
		}
		break;
	case 'Lingue':
		println('Portail en Italien')
		//Changement de langue IT en FR
		WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Langues'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(it)'), 120)
		WebUI.click(findTestObject('Object Repository/Page_WSO2 Identity Server/button_Languages(it)'))
		//WebUI.click(toIT)
		for (def second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'initialisation de l\'application a échouée !!!')
			}
			
			try {
				if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))) {
					String placeholder = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 'placeholder')
					if(placeholder == 'Rechercher'){
						println('Changement de langue (de IT en FR) réussi !!!')
//						
						break;
					} else {
						CustomKeywords.'utils.utilsFail.customlaunchFail'('Le changement de langue a échoué !!!')
					}
				} 
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
		break;
}
