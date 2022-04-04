import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.entity.testsuite.RunConfigurationDescription
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.configuration.RunConfiguration

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath());

ChromeOptions options = new ChromeOptions();
options.addArguments("--headless","--disable-gpu", "--window-size=1920,1280","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
WebDriver driver = new ChromeDriver(options);

DriverFactory.changeWebDriver(driver);

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.setText(findTestObject('Page_Connexion/UserName'), GlobalVariable.USERNAME)
WebUI.setText(findTestObject('Page_Connexion/Password'), GlobalVariable.PASSWORD)
WebUI.click(findTestObject('Page_Connexion/ButtonConnexion'))
WebUI.waitForPageLoad(40000)

CustomKeywords.'utils.utilsFail.customlaunchFail'('test de fail')

WebUI.closeBrowser()

println('Connexion OK !!!')