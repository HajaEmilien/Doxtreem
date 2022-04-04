import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys




String nomRole = "E2E_Role"
WebUI.callTestCase(findTestCase('Tools/Creer un rôle'), ['nomRole':nomRole], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression role'), ['nomRole':nomRole], FailureHandling.OPTIONAL)
WebUI.switchToDefaultContent()


