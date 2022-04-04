import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




String user = "E2E_User"
WebUI.callTestCase(findTestCase('Tools/Creer un utilisateur'), ['user':user], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Tools/Suppression utilisateurs'), ['user':user], FailureHandling.OPTIONAL)

