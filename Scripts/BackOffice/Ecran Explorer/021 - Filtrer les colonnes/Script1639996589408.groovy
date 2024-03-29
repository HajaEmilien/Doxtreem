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
import static org.junit.Assert.*
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject





 if (WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'), FailureHandling.OPTIONAL)) {
	 CustomKeywords.'utils.utilsFail.customlaunchFail'('l\'icone Taille_icon_folder n\'est pas visible sur la page')
        }
   
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'), 120)
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Explorateur_barre_verticale'))

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/md-icon_Voir_les_Infos'),FailureHandling.STOP_ON_FAILURE)){
	WebUI.click(findTestObject('Object Repository/En-tete-colonne'))
}else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Problème de chargement de la page !')
}


if (WebUI.verifyElementVisible(findTestObject('Object Repository/icon-tri'),FailureHandling.OPTIONAL)) {
	println('Colonne triée !!!')
	
}else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Colonne non triée !!!')
}
