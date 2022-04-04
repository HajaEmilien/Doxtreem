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



 dernierePage = WebUI.getText(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/ValueLastPage')).split(' ')[1].toInteger()

  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/btn_Last_Page'))
  valuePageEncours = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), 'value')
  assertTrue(valuePageEncours.toInteger() == dernierePage)
  
  WebUI.delay(3)
  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/btn_PreviousPage'))
  valuePagePrevious = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), 'value')
  if (dernierePage >1) {
	  assertTrue(valuePagePrevious.toInteger() == valuePageEncours.toInteger()-1)
  } else {
	  assertTrue(valuePagePrevious.toInteger() == valuePageEncours.toInteger())
  }
  
  
  WebUI.delay(3)
  WebUI.click( findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/btn_FristPage'))
  valueFirstPage = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input') , 'value')
  assertTrue(valueFirstPage.toInteger() == 1)
  
  WebUI.delay(3)
  WebUI.click(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/btn_NextPage'))
  valueNextPage = WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), 'value')
  if (dernierePage >1) {
	  assertTrue(valueNextPage.toInteger() == 2)
  } else {
	  assertTrue(valueNextPage.toInteger() == 1)
  }  
  
  WebUI.delay(3)
  if (dernierePage >=5) {
	  WebUI.setMaskedText(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), '5')
	  WebUI.sendKeys(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), Keys.chord(Keys.ENTER))
	  assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Page_Doxtreem - Visionneuse de document/document_viewer_content_input'), 'value').toInteger() == 5)
  } else {
	  println('Le document affiché a moins de 5 pages !!!')
  }
  
// lastPage = '//*[@id="document-viewer-content"]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[2]'
// WebUI.click(findTestObject('Object Repository/Xpath',['index':lastPage]))
// 
// WebUI.delay(3)
// previousPage = '//*[@id="document-viewer-content"]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[2]'
// WebUI.click(findTestObject('Object Repository/Xpath',['index':previousPage]))
// 
// WebUI.delay(3)
// firstPage = '//*[@id="document-viewer-content"]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[1]'
// WebUI.click(findTestObject('Object Repository/Xpath',['index':firstPage]))
// 
// WebUI.delay(3)
// nextPage = '//*[@id="document-viewer-content"]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[1]'
// WebUI.click(findTestObject('Object Repository/Xpath',['index':nextPage]))
