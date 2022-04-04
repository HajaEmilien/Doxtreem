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

tablo = (WebUI.getText(findTestObject('Page_Doxtreem - Explorateur/tablo_ListDossier')).split('\n'))
println tablo
idSuppr = "//button[@id='removeElement']//md-icon[@role='img']"
//int num = 2
int i = 0
for (int index = 0; index <= tablo.size()-1; index +=5){
	i++
	if (tablo[index]== nomdosuppr ){
		if(WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':i]), 10, FailureHandling.OPTIONAL)==true){
			WebUI.click(findTestObject('Page_Doxtreem - Explorateur/dossier_cible',['num':i]), FailureHandling.OPTIONAL)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Xpath',['index':idSuppr]), 10, FailureHandling.OPTIONAL)
			WebUI.click(findTestObject('Object Repository/Xpath',['index':idSuppr]), FailureHandling.OPTIONAL)
		    WebUI.delay(5)
			WebUI.waitForElementClickable(findTestObject('Page_Doxtreem - Corbeille/btn-validerSuppr-doc'), 10, FailureHandling.OPTIONAL)
		    WebUI.delay(5)
			WebUI.click(findTestObject('Page_Doxtreem - Corbeille/btn-validerSuppr-doc'),FailureHandling.OPTIONAL)
		}
	}	
//	num --
}
