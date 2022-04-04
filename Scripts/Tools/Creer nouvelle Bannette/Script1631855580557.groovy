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


            if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes/button_Creer une nouvelle bannette'))==false) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('le Button créer une nouvelle bannette inactif ou inaccessible')
       
            } else  WebUI.click(findTestObject('Page_Doxtreem - Bannettes/button_Creer une nouvelle bannette'))
    
			if (WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'), 240)) {
				
			} else {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le formulaire de création de bannette n\'est pas affiché en 240 secondes !!!')
			}
			
            if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'))==false) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Champ nom de la bannette non clickable ou grisé')
            } else { 
				WebUI.clearText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'))
				WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Champ - Nom de la bannette'), Bannette)
				}

      
            if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'))==false) {
				CustomKeywords.'utils.utilsFail.customlaunchFail'('Le champ Description de la bannette est inaccessible ou griser')
        }else WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Description de la bannette'), 'E2E Description de la bannette')

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes - Informations generales/Type bannette - List'), 
        FailureHandling.STOP_ON_FAILURE)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-option_Bannette documentaire'), 120)
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/md-option_Bannette documentaire'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Tags_name'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Tags_name'), 'E2E', FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(2)
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/tag_e2e'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Champ_creation_dossier_possible'), FailureHandling.STOP_ON_FAILURE)

    def aydy

    aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Bannettes/presentation'), 'id', FailureHandling.STOP_ON_FAILURE)

//    aidi = (('//*[@id="' + aydy) + '"]/md-select-menu/md-content/md-select-header/input')
	
    WebUI.delay(2)
	
    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Bannettes/ListeItem', [('id') : aydy]), 
        'E2E_Dossier',FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(2)
    WebUI.click(findTestObject('Page_Doxtreem - Bannettes/opt_E2E_Dossier'),FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('Page_Doxtreem - Bannettes/opt_E2E_Dossier'), Keys.chord(Keys.TAB), FailureHandling.STOP_ON_FAILURE)

    
    if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button Ajouter une requte'))==false) {
                
		CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button Ajouter requete est non clickable ou grisé')
				
    } else WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button Ajouter une requte'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5)

    WebUI.setText(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Veuillez ecrire votre requete'), 'select cf.*, nvlt:fn_documentsmanager:get_secondary_types(cf.cmis:objectId, 0) AS ecm:secondaryTypes from ecm:caseFile as cf where ecm:category in ({{rootcategories}}) AND cf.cmis:objectTypeId = \'ecm:caseFile\'', 
        FailureHandling.STOP_ON_FAILURE)

    

    if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_VRIFIER LA REQUTE'))==false) {
                CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Button Vérifier la requete est inacessible ou grisé')
            } else WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_VRIFIER LA REQUTE'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Button_Aide sur le langage CMIS'), FailureHandling.STOP_ON_FAILURE)
	
    WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Enregistrer'), 60)

    if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Enregistrer'))) {
        WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/Enregistrer'), FailureHandling.STOP_ON_FAILURE)
    } else {
        CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Button Enregistrer est inaccessible ou grisé')
    }
    
    WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_Sauvegarder'), 
        60)

    if (WebUI.verifyElementVisible(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_Sauvegarder'))) {
        WebUI.click(findTestObject('Page_Doxtreem - Bannettes - Informations generales/button_Sauvegarder'), FailureHandling.STOP_ON_FAILURE)

        /*if (WebUI.verifyElementClickable(findTestObject('Object Repository/Administration/button_retour'))==true) {
           WebUI.click(findTestObject('Object Repository/Administration/button_retour'))
        }else CustomKeywords.'utils.utilsFail.customlaunchFail'('Button_retour inaccessible')*/
		
		
    } else {
        CustomKeywords.'utils.utilsFail.customlaunchFail'('Button Sauvegarder introuvable ou non affiché')
    }

	
