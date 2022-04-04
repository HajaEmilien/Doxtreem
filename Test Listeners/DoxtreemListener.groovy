import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.context.TestSuiteContext.*

class DoxtreemListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println "**************** BEFORE TEST CASE :  *********************"
		println "TEST CASE ID : "+testCaseContext.getTestCaseId()
		println "TEST CASE VARIABLES : "+testCaseContext.getTestCaseVariables()
		println "****************                      *********************"
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println "**************** AFTER TEST CASE  *********************"
		println "TEST CASE FINISH : "+testCaseContext.getTestCaseId()
		println  "STATUS : "+testCaseContext.getTestCaseStatus()
		println "****************              *********************"
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println "*************** BEFORE TEST SUITE : ******************************"
		println "TEST SUITE ID : "+ testSuiteContext.getTestSuiteId()
		if (testSuiteContext.getTestSuiteId()!= "Test Suites/Identity Access Management") {
		WebUI.callTestCase(findTestCase('Tools/Connect'), [:], FailureHandling.OPTIONAL)
		}
		int Count 
		List listTestSuiteIDAvecBannette = [
			"Test Suites/Bannette documentaire",
			"Test Suites/Bannette personnelles",
			"Test Suites/Capture",
			"Test Suites/Corbeille",
			"Test Suites/Ecran Explorer",
			"Test Suites/Recherche",
			"Test Suites/Visionneuse de document"
		]
		
		for( item in listTestSuiteIDAvecBannette){
			if (testSuiteContext.getTestSuiteId().contains(item)){
				Count++
			}
		}
		
		if (Count>=1) {
			if ( CustomKeywords.'utils.Bannettes.VerificationBannette'(GlobalVariable.Bannette)) {
				CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
				CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
			}
			else if (CustomKeywords.'utils.TestFile.FindTextFile'(GlobalVariable.filePath2,"true")){
				println " la bannette est en cours de creation par un autre test suite , veuillez patienter!!!!!!"
				WebUI.delay(240)
				if(CustomKeywords.'utils.TestFile.FindText'(GlobalVariable.filePath2,"Creation Bannette Terminée")) {
				WebUI.refresh()
				WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
				CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
				CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
				}
			
			} else CustomKeywords.'utils.Bannettes.CreationBannette'(GlobalVariable.Bannette)
			
		}
		println "****************          *********************"
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println "*************** AFTER TEST SUITE : ******************************"
		CustomKeywords.'utils.TestFile.Writefile'(GlobalVariable.filePath1,testSuiteContext.getTestSuiteId())
		int RowCout = CustomKeywords.'utils.TestFile.countTestSuiteFile'(GlobalVariable.filePath1)
		if (testSuiteContext.getTestSuiteId()== "Test Suites/Identity Access Management" && testSuiteContext.getStatus()=="COMPLETE") {
			WebUI.closeBrowser()
	     }
		if (RowCout == 14) {
			CustomKeywords.'utils.Bannettes.SuppressionBannette'(GlobalVariable.Bannette)
			CustomKeywords.'utils.Corbeille.AccesderPageCorbeille'()
			WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'perso'], FailureHandling.OPTIONAL)
			WebUI.callTestCase(findTestCase('Tools/Vider la corbeille'), ['corbeille':'admin'], FailureHandling.OPTIONAL)
			WebUI.callTestCase(findTestCase('Tools/Deconnect'), [:], FailureHandling.OPTIONAL)
			WebUI.closeBrowser()
			CustomKeywords.'utils.TestFile.DeleteFile'(GlobalVariable.filePath1)
			CustomKeywords.'utils.TestFile.DeleteFile'(GlobalVariable.filePath2)
		} else if (testSuiteContext.getTestSuiteId()!= "Test Suites/Identity Access Management" && testSuiteContext.getStatus() == "COMPLETE") {
			WebUI.callTestCase(findTestCase('Tools/Deconnect'), [:], FailureHandling.OPTIONAL)
			WebUI.closeBrowser()
			} 
			println "TEST SUITE ID : "+testSuiteContext.getTestSuiteId()
			println "TEST SUITE STATUS : "+testSuiteContext.getStatus()
		    
	}
}