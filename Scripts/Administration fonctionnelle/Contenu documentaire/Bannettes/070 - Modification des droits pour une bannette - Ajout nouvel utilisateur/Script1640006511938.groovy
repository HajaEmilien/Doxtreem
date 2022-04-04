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
import org.apache.commons.lang3.ArrayUtils;

void AccesModificationDroitUser() {
	WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes/Modifier les droits pour la bannette courante'),
		60)
	WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes/Modifier les droits pour la bannette courante'),
		60)
	if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/Modifier les droits pour la bannette courante'),FailureHandling.OPTIONAL)) {
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Modifier les droits pour la bannette courante'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		if (WebUI.verifyTextNotPresent("Ajouter des droits aux utilisateurs", false, FailureHandling.OPTIONAL)) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button Modifier les droits pour la bannette courante est inaccessible ou grisé')
		}
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button Modifier les droits pour la bannette courante est inaccessible ou grisé')
	}
}


user = "E2E_User"
WebUI.callTestCase(findTestCase('Tools/Creer un utilisateur'), ['user':user], FailureHandling.STOP_ON_FAILURE)

if (CustomKeywords.'utils.Bannettes.VerificationBannette'(GlobalVariable.Bannette)== false ) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('La bannette est introuvable ou non encore créée')
}
CustomKeywords.'utils.Bannettes.ClickResultRechercheBannette'(GlobalVariable.Bannette)
AccesModificationDroitUser()

if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Ajouter des droits aux utilisateurs/champ_Ajouter un utilisateur'))) {
	WebUI.setText(findTestObject('Page_Doxtreem - Ajouter des droits aux utilisateurs/champ_Ajouter un utilisateur'), user,	FailureHandling.STOP_ON_FAILURE)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/Repeat_container'), 120)
	String[] tablo = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/Repeat_container') , FailureHandling.STOP_ON_FAILURE).split('\n')
	println tablo
	
	if (tablo.any(){it.equals('Votre recherche n\'a retourné aucun résultat')}) {
		println('Utilisateur encore à créer !!!')
		WebUI.refresh()
		
		WebUI.callTestCase(findTestCase('Tools/Creer un utilisateur'), [:], FailureHandling.OPTIONAL)
		WebUI.switchToDefaultContent()
		WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)
	   if (CustomKeywords.'utils.Bannettes.VerificationBannette'(GlobalVariable.Bannette)== false ) {
		 CustomKeywords.'utils.utilsFail.customlaunchFail'('La bannette est introuvable ou non encore créée')
	   }
	   CustomKeywords.'utils.Bannettes.ClickResultRechercheBannette'(GlobalVariable.Bannette)
		AccesModificationDroitUser()
		result2 = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/liste_utilisateur'),'aria-owns', FailureHandling.STOP_ON_FAILURE)
	
		println(result2)
		WebUI.setText(findTestObject('Page_Doxtreem - Ajouter des droits aux utilisateurs/champ_Ajouter un utilisateur'), 'E2E_User', FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/item_trouver', [('index') : result2]), FailureHandling.STOP_ON_FAILURE)
		
	} else {
		int numero = ArrayUtils.indexOf(tablo, user) + 1
		nIndex = "/html/body/md-virtual-repeat-container[5]/div/div[2]/ul/li[" + numero + "]"
		WebUI.click(findTestObject('Object Repository/Xpath',['index': nIndex]))
	}
	
//    result = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/liste_utilisateur'), 
//        'aria-owns', FailureHandling.STOP_ON_FAILURE)
//
//    println(result)
//
//    WebUI.setText(findTestObject('Page_Doxtreem - Ajouter des droits aux utilisateurs/champ_Ajouter un utilisateur'), 'E2E_User', 
//        FailureHandling.STOP_ON_FAILURE)
//
//    WebUI.delay(5)
//try {
//	boolean testTextPresent = WebUI.verifyTextNotPresent('Votre recherche n\'a retourné aucun résultat', false, FailureHandling.OPTIONAL)
//    if (testTextPresent==false) {
//        WebUI.refresh()
//
//        WebUI.callTestCase(findTestCase('Tools/Creer un utilisateur'), [:], FailureHandling.OPTIONAL)
//		WebUI.switchToDefaultContent()
//		WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)
//       if (CustomKeywords.'utils.Bannettes.VerificationBannette'(GlobalVariable.Bannette)== false ) {
//	     CustomKeywords.'utils.utilsFail.customlaunchFail'('La bannette est introuvable ou non encore créée')
//       }
//	   CustomKeywords.'utils.Bannettes.ClickResultRechercheBannette'(GlobalVariable.Bannette)
//        AccesModificationDroitUser()
//		result2 = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/liste_utilisateur'),
//			'aria-owns', FailureHandling.STOP_ON_FAILURE)
//	
//		println(result2)
//        WebUI.setText(findTestObject('Page_Doxtreem - Ajouter des droits aux utilisateurs/champ_Ajouter un utilisateur'), 
//            'E2E_User', FailureHandling.STOP_ON_FAILURE)
//
//        WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/item_trouver', [('index') : result2]),
//        FailureHandling.STOP_ON_FAILURE)
//    } 
//	if(testTextPresent==true) {
//		WebUI.delay(5)
//		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/item_trouver', [('index') : result]),
//			FailureHandling.STOP_ON_FAILURE)
//    }   
//}
//catch (Exception e) { } 
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ Ajouter un utilisateur de la page Ajouter des droits aux utilisateurs est inaccessible')
}

/**************************************************cocher les options******************************************************/
for (int i = 1; ; i++) {
    if (i >= 4) {
        break
    }
    
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Ajouter des droits aux utilisateurs/case_cocher', [('index') : i]), 
        FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/button_Valider_ajout_droit_user_bannette'))) {
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/button_Valider_ajout_droit_user_bannette'), FailureHandling.STOP_ON_FAILURE)
    WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Pop-up Confirmation'), 120)
	WebUI.delay(5)
    WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Pop-up Confirmation'), FailureHandling.STOP_ON_FAILURE)
} else {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Validation de l\'ajout Utilisateur échoué !!!')
}
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Message_de_confirmation'), 10)
AccesModificationDroitUser()

result = WebUI.getText(findTestObject('tablo_utilisateur_bannette'), FailureHandling.STOP_ON_FAILURE).split('\n')
nIndex = result.toList().indexOf(user)

WebUI.click(findTestObject('Object Repository/liste_utilisateur_bannette',['numLine':(nIndex + 1)]))
WebUI.waitForElementClickable(findTestObject('Object Repository/liste_utilisateur_bannette-DeleteUser',['numLine':(nIndex + 1)]), 120)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/liste_utilisateur_bannette-DeleteUser',['numLine':(nIndex + 1)]))
//int num = 1
//for (element in result) {
//	if (element == user) {
//		WebUI.click(findTestObject('Object Repository/liste_utilisateur_bannette',['numLine':num]))
//		WebUI.waitForElementClickable(findTestObject('Object Repository/liste_utilisateur_bannette-DeleteUser',['numLine':num]), 120)
//		WebUI.click(findTestObject('Object Repository/liste_utilisateur_bannette-DeleteUser',['numLine':num]))
//		break
//	}
//	num++
//}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/button_Valider_ajout_droit_user_bannette'),
	FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Pop-up Confirmation'), 120)
WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Pop-up Confirmation'), FailureHandling.STOP_ON_FAILURE)

//RetourAdmnistrationFonctionnelle()
// //CustomKeywords.'utils.Bannettes.SuppressionBannette'(bannette)



