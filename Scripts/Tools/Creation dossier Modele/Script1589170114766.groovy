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


////
/********************************acceder a administration fonctionnelle**********************/
for (int second = 0; ; second++) {
	if (second >= 1) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Boutton Administration introuvable ou inaccessible')

		break
	}
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Administration/btn_Administration'))) {
			break
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}

WebUI.click(findTestObject('Object Repository/Administration/btn_Administration'))

/********************Eventuel message erreur****************************************************/
//if (WebUI.verifyTextPresent('Attention', false, FailureHandling.OPTIONAL)) {
//    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_Oui_PDCM_changement_page'),
//        FailureHandling.OPTIONAL)
//
//    ////WebUI.delay(10)
//}

/************************************selectionner Administration fonctionnelle*********************/
for (int second = 0; ; second++) {
	if (second >= 1) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Boutton Administration fonctionnelle non cliquable')

		break
	}
	
	try {
		if (WebUI.verifyElementClickable(findTestObject('Administration/span_Administration fonctionnelle'))) {
			break
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}

WebUI.click(findTestObject('Administration/span_Administration fonctionnelle'))

/********************Eventuel message erreur****************************************************/
//if (WebUI.verifyTextPresent('Attention', false, FailureHandling.OPTIONAL)) {
//    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_Oui_PDCM_changement_page'),
//        FailureHandling.OPTIONAL)
//
//    ////WebUI.delay(10)
//}

/******************************Acceder a la gestion des bannettes******************************/
for (int second = 0; ; second++) {
	if (second >= 1) {
		break
	}
	
	try {
		if (!WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Bannettes' , ('An') : 'Inboxes'], FailureHandling.OPTIONAL)) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Bannettes" n\'est pas visible sur la page')
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}


/********************Eventuel message erreur****************************************************/
//if (WebUI.verifyTextPresent('Attention', false, FailureHandling.OPTIONAL)) {
//    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_Oui_PDCM_changement_page'),
//        FailureHandling.OPTIONAL)
//
//    ////WebUI.delay(10)
//}

/******************************Est-ce que la bannette existe déjà******************************/
/*for (int second = 0; ; second++) {
	if (second >= 2) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('le Button créer une nouvelle bannette inactif ou inaccessible')

		break
	}
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/button_Creer une nouvelle bannette'))) {
			break
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}*/

WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ_Rechercher'), GlobalVariable.Bannette + Keys.chord(
		Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
String resultat = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-list_Bannette'))

if (resultat==""){
//	if (!(WebUI.verifyMatch(resultat, 'Test_([0-9]{13})', true, FailureHandling.OPTIONAL))) {
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes/button_Creer une nouvelle bannette'))
	
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Champ nom de la bannette non cliquable ou grisé')
	
				break
			}
			
			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'))) {
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
		
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'), FailureHandling.STOP_ON_FAILURE)
		
		GlobalVariable.nomBannette = 	GlobalVariable.Bannette //'Test_' + new Date().time
		
		WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'), GlobalVariable.nomBannette)
	
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ Description de la bannette est inaccessible ou grisé')
	
				break
			}
			
			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'))) {
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
		
	//    WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'), FailureHandling.STOP_ON_FAILURE)
	
	//    WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'), 'TSTHOM' +
	//        Keys.chord(Keys.TAB, 'b'), FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'), 'TSTHOM', FailureHandling.STOP_ON_FAILURE)
	
	
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Liste Type de bannette'), FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-option_Bannette documentaire'), FailureHandling.STOP_ON_FAILURE)
		
	//	WebUI.setText(findTestObject('Page_Doxtreem - Bannettes/Tags de la bannette'), 'HOM' + Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
	
		/***********Creation dossier possible*********************/
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Champ_creation_dossier_possible'), FailureHandling.STOP_ON_FAILURE)
	
		if (!(WebUI.verifyTextPresent('Nouveau dossier', false, FailureHandling.OPTIONAL))) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Veuillez creer le PDCM avant de creer un dossier')
		}
	
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-option_Nouveau dossier'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-option_Nouveau dossier'), Keys.chord(Keys.ESCAPE))
	
		/***********************creer une requette specifique pour le dossier a creer******************************/
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button Ajouter requete est non clickable ou griser')
	
				break
			}
			
			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button Ajouter une requte'))) {
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
		
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button Ajouter une requte'), FailureHandling.STOP_ON_FAILURE)
	
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ Veuillez écrire votre requete est inaccessible')
	
				break
			}
			
			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Veuillez ecrire votre requete'))) {
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
	
		WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Veuillez ecrire votre requete'), 'select cf.*, nvlt:fn_documentsmanager:get_secondary_types(cf.cmis:objectId, 0) AS ecm:secondaryTypes from ecm:caseFile as cf where ecm:category in ({{rootcategories}}) AND cf.cmis:objectTypeId = \'ecm:caseFile\'',
			FailureHandling.STOP_ON_FAILURE)
	
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Button Vérifier la requete est inacessible ou griser')
	
				break
			}
			
			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_VRIFIER LA REQUTE'))) {
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
	
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_VRIFIER LA REQUTE'), FailureHandling.STOP_ON_FAILURE)
	
		if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Enregistrer'))) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Enregistrer'), FailureHandling.STOP_ON_FAILURE)
		} else {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Button Enregistrer est inaccessible ou griser')
		}
		
		boolean Prsent = false
	
		if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_Sauvegarder'))) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_Sauvegarder'), FailureHandling.STOP_ON_FAILURE)
	
			WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'),
				60)
	
			Prsent = WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Button_supprimer la bannette'))
		} else {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Sauvegarder introuvable ou non affiché')
		}
		
		assert Prsent == true
	
		/************Acceder a la page bannette********************/
		for (int second = 0; ; second++) {
			if (second >= 1) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton Bannettes du menu lateral n\'est pas disponible')
			}
			
			try {
				if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))) {
					WebUI.click(findTestObject('Page_Doxtreem - Bannettes/md-icon_Vues-documentaires'))
					break
				}
			}
			catch (Exception e) {
			}
			
			Thread.sleep(1000)
		}
		
		WebUI.delay(5)
		
		if(WebUI.getText(findTestObject('Page_Doxtreem - Bannettes/Contenu_bannette')).contains(GlobalVariable.nomBannette)){
			println('CONTINUE ...')
		} else {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Bannette non créé !!!')
		}
//	}
} else {

	tabResultat = resultat.split('\n')

	GlobalVariable.nomBannette = tabResultat[tabResultat.size()-1]
	println('Bannette déjà créée : ' + GlobalVariable.nomBannette)
}	
//    for (int second = 0; ; second++) {
//        if (second >= 1) {
//            CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Bannette_Tag_Test Homologation n\'est pas accessible')
//        }
//
//        try {
//            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Bannette_Tag_Test Homologation'))) {
//                break
//            }
//        }
//        catch (Exception e) {
//        }
//
//        Thread.sleep(1000)
//    }
