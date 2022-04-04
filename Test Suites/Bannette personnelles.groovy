import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
/*def setBannette () {
	return  GlobalVariable.Bannette = "E2E_Bannette_Perso"
}*/
def setDossier () {
	return GlobalVariable.Dossier ="E2E_Dossier_Perso"
}
@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	// Put your code here.
	//WebUI.callTestCase(findTestCase('Tools/Connect'), [:], FailureHandling.STOP_ON_FAILURE)
	//CustomKeywords.'utils.Bannettes.CreationBannette'(setBannette())
	
	CustomKeywords.'utils.Bannettes.AjoutDossierDansBannette'(setDossier(),GlobalVariable.Bannette)
	CustomKeywords.'utils.Bannettes.AccèsDossierDepuisBannette'(setDossier(),GlobalVariable.Bannette)
	WebUI.callTestCase(findTestCase('Tools/Ajout plusieurs documents'),[:], FailureHandling.OPTIONAL)
	CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
	CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {
	// Put your code here.
	println "Supprimer le bannette à la fin des test case puis se deconnecté du site "
	//CustomKeywords.'utils.Bannettes.SuppressionBannette'(setBannette())
	WebUI.callTestCase(findTestCase('Test Cases/Tools/Suppression dossier'), ['Dossier':setDossier()], FailureHandling.STOP_ON_FAILURE)
	//WebUI.callTestCase(findTestCase('Tools/Deconnect'), [:], FailureHandling.OPTIONAL)
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = false) // Please change skipped to be false to activate this method.
def setupTestCase() {
    //setBannette()
	setDossier()
	
	
}
/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = false) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	// Put your code here.
	/*WebUI.refresh()
	
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Doxtreem_Load/LoadPage'), 80000 , FailureHandling.OPTIONAL)
	WebUI.deleteAllCookies()
	println "retourner à la page vue documentaire puis accéder dans la bannette : "+GlobalVariable.Bannette+" à la fin des tests"*/
	CustomKeywords.'utils.Bannettes.AccessVuDocumenytaire'()
	CustomKeywords.'utils.Bannettes.ClickTitreBannetteVueDocumentaire'(GlobalVariable.Bannette)
}
