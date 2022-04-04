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

for (int second = 0; ; second++) {
	if (second >= 1) {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ recherche n\'est pas disponible')
	}
	
	try {
		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'))) {
			break
		}
	}
	catch (Exception e) {
	}
	
	Thread.sleep(1000)
}

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/bouton_plus'))

	println('Bouton plus cliqué')
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur sur le clic du bouton plus')
}

//Vérifier que le  champ pour la recherche avancée s'affiche
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche_avancee'), FailureHandling.OPTIONAL)) {
	//clic sur l'onglet "REQUÊTE"
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_Requete'))
}

if (!WebUI.verifyTextPresent('FROM ecm:document', false, FailureHandling.OPTIONAL)) {
				if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_champ'))) {
					
					WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_champ'), "SELECT * FROM ecm:document")
				}
}
WebUI.delay(3)
//cliquer sur le bouton TESTER et récupérer le résultat de la requête
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Tester'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Tester'))
	
	WebUI.delay(3)

} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "TESTER" n\'est pas activé !')
}

nbResultat = (WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_resultat'))).replaceAll('[^0-9]', '')
println(nbResultat)

if (nbResultat.toInteger() > 0){
	//clic sur le bouton RECHERCHER
	if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Rechercher'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/onglet_requete_button_Rechercher'))
	} else {
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "RECHERCHER" n\'est pas activé !')
	}
	
	////WebUI.delay(10)
	//récuperer le résultat de la recherche
	nbRecherche = 0
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'), FailureHandling.OPTIONAL)) {
			resultat = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Recherche/affichage_resultat'))
			println resultat
			if (resultat.contains('\n')){
				resultat = resultat.split('\n')[0]
				println resultat
			}
			if (resultat != ""){
				if (resultat.contains('/')){
					println resultat
					nbRecherche = (resultat.split('/')[1]).replaceAll('[^0-9]', '')
					println(nbRecherche)
				} else {
					nbRecherche = (resultat.replaceAll('[^0-9]', ''))
				}
			} else {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Résultat vide !!!')
			}
	
			if (nbRecherche.toInteger() == nbResultat.toInteger()){
				println('RESULTAT OK !!!')
				
			}
			else{
				println('RESULTAT DIFFERENT !!!')
			}
	} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Erreur lors de l\'affichage de la recherche')
	}
		
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Recherche infructueuse, vérifier le critère !!')
}