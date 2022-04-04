import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.support.ui.Select as Select
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows



WebUI.callTestCase(findTestCase('Tools/Accès a la page Banettes'), [:], FailureHandling.STOP_ON_FAILURE)

def entet

/**************************************Trouver la bannette GED*************************************/
for (int i = 1; ; i++) {
    aydy = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Bannette_cible', [('index') : i]), 
        'aria-label', FailureHandling.STOP_ON_FAILURE)

    println(aydy)

    if (aydy == 'GED') {
        entet = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Ettendu_icon', [('index') : i]), 
            'id', FailureHandling.STOP_ON_FAILURE)

        break
    }
}

/*****************************************Trouver le bouton Afficher les filtres******************************************/
for (int i = 1; ; i++) {
    if (i >= 4) {
        CustomKeywords.'utils.utilsFail.customlaunchFail'('Bouton Afficher les filtres introuvable')
    }
    
    tous = (((('//*[@id="' + entet) + '"]/section[1]/section[3]/button[') + i) + ']')
	

    if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index') : tous]), 
        'aria-label', FailureHandling.STOP_ON_FAILURE) == 'Afficher les filtres') {
        WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index') : tous]), 
            FailureHandling.STOP_ON_FAILURE)

        break
    }
}

/**************************************Choisir le filtre****************************************************/
fyltre = (('//*[@id="' + entet) + '"]/section[2]/md-content/article/md-switch')

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index') : fyltre]), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Filtrer'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

/***********************************Réinitialisation du filtre********************************************/
for (int i = 1; ; i++) {
    if (i >= 4) {
        CustomKeywords.'utils.utilsFail.customlaunchFail'('Bouton Afficher les filtres introuvable')
    }
    
    tous = (((('//*[@id="' + entet) + '"]/section[1]/section[3]/button[') + i) + ']')

    if (WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index') : tous]), 
        'aria-label', FailureHandling.STOP_ON_FAILURE) == 'Afficher les filtres') {
        WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/ettendu_button', [('index') : tous]), 
            FailureHandling.STOP_ON_FAILURE)

        break
    }
}

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/button_Reinitialiser'), FailureHandling.STOP_ON_FAILURE)



