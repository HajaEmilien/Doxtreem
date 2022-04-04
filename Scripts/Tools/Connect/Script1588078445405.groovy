import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.*


//println System.getProperty('os.name')
//java.net.InetAddress i = java.net.InetAddress.getLocalHost();
//String convertedToString = String.valueOf(i);
//String[] splitTable =  convertedToString.split("/")             
//println i
println DriverFactory.getExecutedBrowser().getProperties()
println DriverFactory.getExecutedBrowser().getName()

if(DriverFactory.getExecutedBrowser().getName()=="HEADLESS_DRIVER")
{  
	String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
	def downloadFile = downloadFilepath.replace("/", "\\")
	System.setProperty("webdriver.chrome.driver",  DriverFactory.getChromeDriverPath())
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
	chromePrefs.put("download.prompt_for_download", false)
	chromePrefs.put("download.default_directory", downloadFile)
	ChromeOptions options = new ChromeOptions()
	options.addArguments("--headless","--incognito","--disable-gpu", "--window-size=1920,1280","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage")
	options.setExperimentalOption("prefs", chromePrefs)
	WebDriver driver = new ChromeDriver(options)
	DriverFactory.changeWebDriver(driver)
	
	//convertedToString = "Selenium Automation Script run by Local Host Name/IP Address: " + i+ "\n";
}
else 
{
	String downloadFilepath = RunConfiguration.getProjectDir() + "\\Test Data"
	def downloadFile = downloadFilepath.replace("/", "\\")
	System.setProperty("webdriver.chrome.driver",  DriverFactory.getChromeDriverPath())
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
	chromePrefs.put("download.prompt_for_download", false)
	chromePrefs.put("download.default_directory", downloadFile)
	ChromeOptions options = new ChromeOptions()
	options.addArguments("--incognito","--start-maximized")
	options.setExperimentalOption("prefs", chromePrefs )
	WebDriver driver = new ChromeDriver(options)	
	DriverFactory.changeWebDriver(driver)
}


WebUI.deleteAllCookies()
println('Size ' +  WebUI.getViewportWidth() + 'x' + WebUI.getViewportHeight())

println(GlobalVariable.URL)

if (!WebUI.verifyLinksAccessible([GlobalVariable.URL], FailureHandling.OPTIONAL)) {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('L\'URL ' + GlobalVariable.URL +  ' est inaccessible')
}

WebUI.navigateToUrl(GlobalVariable.URL)
WebUI.waitForPageLoad(80000)
String CurrentURL = WebUI.getUrl()
if (CurrentURL.contains("backOffice")) {
	println "User déjà connecté"
}else {
WebUI.setText(findTestObject('Page_Connexion/UserName'), GlobalVariable.USERNAME)
WebUI.setText(findTestObject('Page_Connexion/Password'), GlobalVariable.PASSWORD)
WebUI.click(findTestObject('Page_Connexion/ButtonConnexion'))
WebUI.waitForPageLoad(80000)
WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
boolean errorConnected = true;

try {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Explorateur/Button_rechercher_barre_horizontale'))) {
	errorConnected = false
	}
}
catch (Exception e) {
}

if (errorConnected){
	try {
		//Mot de passe ou identifiant incorrect
		if (WebUI.verifyElementVisible(findTestObject('Page_Connexion/ErrorConnexion'))) {
			CustomKeywords.'utils.utilsFail.customlaunchFail'('Login ou mot de passe incorrect')
		}
	}
	catch (Exception e) {
	}
	
	/*
	try {
		//Vérification pour la première connexion.
		if (WebUI.verifyElementVisible(findTestObject('Page_WSO2 Identity Server/input_Toujours autoriser_scope-approval'))) {
			WebUI.click(findTestObject('Page_WSO2 Identity Server/input_Toujours autoriser_scope-approval'))
			WebUI.click(findTestObject('Page_WSO2 Identity Server/span_Tout slectionner_cr'))
			WebUI.click(findTestObject('Page_WSO2 Identity Server/input_Politique de confidentialit_approve'))
		}
	}
	catch (Exception e) {
	}*/
		
}


WebUI.waitForPageLoad(80000)

WebUI.focus(findTestObject('Object Repository/Page_WSO2 Identity Server/md-icon_Profil'))

String info = WebUI.getAttribute(findTestObject('Object Repository/Page_WSO2 Identity Server/tooltips'), 'aria-label')
info = info.substring(info.indexOf('(')+1,info.indexOf(')'))

if (info.contains('@')) {
	println(info)
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le mail de l\'utilisateur n\'est pas valide !!! ==> ' + info)
}

if ((WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Recherche/champ_recherche'), 'placeholder'))!='Rechercher') {
	WebUI.callTestCase(findTestCase('Test Cases/Tools/Changement_Langue_FR'), [:], FailureHandling.OPTIONAL)
}
//WebUI.callTestCase(findTestCase('Test Cases/Tools/Accepter les CGU'), [:],FailureHandling.OPTIONAL)
}