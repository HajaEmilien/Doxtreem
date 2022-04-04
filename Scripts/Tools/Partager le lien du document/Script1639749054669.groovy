import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Toolkit;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent as DataFlavor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import java.awt.datatransfer.*
import java.awt.datatransfer.DataFlavor;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.lang.StringEscapeUtils;

//nomFichier = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/nomFichier'))

WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/btn_Partager'))

String url = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/input_URL'), 'value')
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ESCAPE))
WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf_closeViewer'))

WebUI.executeJavaScript('window.open();', [])
WebUI.switchToWindowIndex(1)
WebUI.navigateToUrl(url)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf'), 240)
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/nomFichier')) && WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/nomFichier')) == 'E2E_Document_PDC') {
	WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Recherche/visionneuse-pdf_closeViewer'))
	WebUI.closeWindowIndex(0)
	WebUI.switchToDefaultContent()
} else {
	CustomKeywords.'utils.utilsFail.customlaunchFail'('Le fichier affiché n\'est pas le bon !!!')
}
