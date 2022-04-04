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
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

WebUI.callTestCase(findTestCase('Tools/Accès a Administration fonctionnelle'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.callTestCase(findTestCase('Tools/click_sur_Liens_Admnistration(Fonctionnelle_ou_technique)'), [('Fr') : 'Plan de classement modèle'
        , ('An') : 'Template filing plan'], FailureHandling.OPTIONAL) == false) {
    CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton "Plan de classement modèle" n\'est pas visible sur la page')
}

//WebUI.delay(2)
/***************************************Est-ce que le même PDCM existe déjà************************************/
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/menu_deroulante'), FailureHandling.OPTIONAL)

def clay

def nomb

for (int i = 1; ; i++) {
    if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/div_container', [('index') : i]), 
        'class', FailureHandling.STOP_ON_FAILURE).contains('md-active') == true) {
        clay = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/div_container', 
                [('index') : i]), FailureHandling.STOP_ON_FAILURE).split('\n')

        nomb = i

        break
    }
}

boolean reponse = false

def num = 1

for (def item : clay) {
    if (item.contains('01_E2E_RECETTE_')) {
        println(item)

        reponse = true

        break
    }
    
    num++
}

if (reponse == false) {
    /***************************************************creation new PCMD*********************************************/
   
            
        
            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Button_creer_plan_de_classement_modele'))) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Button_creer_plan_de_classement_modele'))
            } else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le bouton creer PCMD est inaccessible')
       
   
    
   

    /****Nom du PCMD***/
    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Champ_Nom du Plan de Classement'), 
        ('01_E2E_RECETTE_PDCM_' + new Date().time) + Keys.chord(Keys.ENTER))

    ////WebUI.delay(10)
    /*******************************Création dossier modele**************************************************/
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Dossier_Racine du pdcm'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_Ajouter_dossier_modele'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_Ajouter un dossier enfant'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/a_Nouveau dossier'))

    /*************************************Parametrage dossier nouvellement créée********************************************/
    def aydy

    for (int i = 1; ; i++) {
        if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                [('index') : i]), 'class', FailureHandling.STOP_ON_FAILURE).contains('md-active') == true) {
            aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                    [('index') : i]), 'id', FailureHandling.STOP_ON_FAILURE)

            break
        } else {
            println(WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                        [('index') : i]), 'class', FailureHandling.STOP_ON_FAILURE))

            println(i)
        }
    }
    
    idy = (('//*[@id="' + aydy) + '"]/div/ng-form/div[1]/md-input-container/input')

    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Champ_Nom_Parametrage_nouveau_dossier_modele', 
            [('index') : idy]), '01_E2E_Dossier')

    iady = (('//*[@id="' + aydy) + '"]/div/ng-form/div[4]/md-input-container/input')

    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Champ_Nom_Parametrage_nouveau_dossier_modele', 
            [('index') : iady]), 'E2E_Dossier')

    /*************************presauvegarder le dossier creer************************************************************************************/
    
            
      if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_PrEsauvegarder_ce_noeud'))) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_PrEsauvegarder_ce_noeud'))
            } else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button_PrEsauvegarder_ce_noeud est inaccessible')
    
    
   

    /******************************************************document enfant************************************************************/
    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Button_ajouter_document'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/button_Ajouter un document enfant'))

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Bannettes/Anouveau_document enfant'))

    /******************************************************parametrage document********************************************************/
    for (int i = 1; ; i++) {
        if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                [('index') : i]), 'class', FailureHandling.STOP_ON_FAILURE).contains('md-active') == true) {
            aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                    [('index') : i]), 'id', FailureHandling.STOP_ON_FAILURE)

            break
        } else {
            println(WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/md-tab-content', 
                        [('index') : i]), 'class', FailureHandling.STOP_ON_FAILURE))

            println(i)
        }
    }
    
    idy = (('//*[@id="' + aydy) + '"]/div/ng-form/div[1]/md-input-container/input')

    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Champ_Nom_Parametrage_nouveau_dossier_modele', 
            [('index') : idy]), '01_E2E_Document')

    iady = (('//*[@id="' + aydy) + '"]/div/ng-form/div[4]/md-input-container/input')

    WebUI.setText(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Champ_Nom_Parametrage_nouveau_dossier_modele', 
            [('index') : iady]), 'E2E_Document')

    /*************************presauvegarder le document creer************************************************************************************/
   
            
        
            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_PrEsauvegarder_ce_noeud'))) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_PrEsauvegarder_ce_noeud'))
				
            } else CustomKeywords.'utils.utilsFail.customlaunchFail'('Le button_PrEsauvegarder_ce_noeud est inaccessible')
        
    
   
    /*********************************************************Sauvegarde**************************************************************/
    
           
      
            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Button_Sauvegarder_barre_horizontale'))) {
				WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/Button_Sauvegarder_barre_horizontale'))
            } else  CustomKeywords.'utils.utilsFail.customlaunchFail'('Le Button_Sauvegarder_barre_horizontale est inaccessible')
      
    
    

    for (int second = 1; ; second++) {
        if (second >= 20) {
            break
        }
        
        if (WebUI.getAttribute(findTestObject('Object Repository/Administration/division', [('index') : second]), 'class', 
            FailureHandling.OPTIONAL) == 'md-dialog-container') {
            aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/contenu_dialog', 
                    [('index') : second]), 'aria-describedby', FailureHandling.STOP_ON_FAILURE)

            aidy = (('//*[@id="' + aydy) + '"]/md-input-container/input')

            WebUI.setText(findTestObject('Object Repository/Administration/commentaire_vesion', [('index') : aidy]), 'Katalon PDCM' + 
                Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

            break
        }
    }
    
    //WebUI.delay(30)
    /*********************************************Retour à la page Administration fonctionnelle************************************************************/
    for (int second = 0; ; second++) {
        if (second >= 2) {
            CustomKeywords.'utils.utilsFail.customlaunchFail'('Button_retour inaccessible')
        }
        
        try {
            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_retour'))) {
                WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/button_retour'))

                break
            }
        }
        catch (Exception e) {
        } 
        
        Thread.sleep(1000)
    }
    
    for (int second = 1; ; second++) {
        if (second >= 20) {
            break
        }
        
        if (WebUI.getAttribute(findTestObject('Object Repository/Administration/division', [('index') : second]), 'class', 
            FailureHandling.OPTIONAL) == 'md-dialog-container') {
            WebUI.click(findTestObject('Object Repository/Administration/button_oui', [('index') : second]), FailureHandling.STOP_ON_FAILURE)

            break
        }
    }
} else {
    WebUI.scrollToElement(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/item_select', [('index') : nomb
                , ('iter') : num]), 1, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Plan de classement modle/item_select', [('index') : nomb
                , ('iter') : num]), FailureHandling.STOP_ON_FAILURE)
}

