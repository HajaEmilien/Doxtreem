package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class gestionOrdreBanettes {
	def utilsFailKyewords= new utilsFail()
	@Keyword
	void SelectionnerUneBannette(String Bannette) {
		/* vérification de la bannette */
		for (int second = 0; ; second++) {

			if (second >= 1) {
				utilsFailKyewords.customlaunchFail(''+Bannette+'non trouvé')
				break
			}

			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/'+Bannette+''))) {
					break
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000)
		}

		/*Selection de la bannette */
		WebUI.click(findTestObject('Page_Doxtreem - Bannettes/'+Bannette+''), FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	void SauvegarderOrdreBannette() {
		def	Prsent = WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/Button_Sauvegarder ordre personnaliser'),
				FailureHandling.OPTIONAL)

		if (Prsent == true) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Button_Sauvegarder ordre personnaliser'), FailureHandling.STOP_ON_FAILURE)
		} else {
			utilsFailKyewords.customlaunchFail('Button Sauvegarder l\'ordre personnalisé inactif ou grisé')
		}

		def	Sauvgrd = WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/Button_Sauvegarder'), FailureHandling.OPTIONAL)

		if (Sauvgrd == true) {
			WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Button_Sauvegarder'), FailureHandling.STOP_ON_FAILURE)
		} else {
			utilsFailKyewords.customlaunchFail('Button Sauvergarder inaccessible ou introuvable')
		}

		assert Sauvgrd == true
	}
	@Keyword
	void FaireDescendreBannette() {
		/*Faire descendre la première bannette */
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes/Button_Descendre'), 60)

		for (int second = 0; ; second++) {
			if (second >= 1) {
				utilsFailKyewords.customlaunchFail('Button Descendre inactif ou grisé')

				break
			}

			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/Button_Descendre'))) {
					break
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000)
		}

		WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Button_Descendre'))
	}
	@Keyword
	void FaireMonterBannette() {
		WebUI.waitForElementVisible(findTestObject('Page_Doxtreem - Bannettes/Button_Monter'), 60)

		for (int second = 0; ; second++) {
			if (second >= 1) {

				utilsFailKyewords.customlaunchFail('Button Monter inactif ou grisé')

				break
			}

			try {
				if (WebUI.verifyElementClickable(findTestObject('Page_Doxtreem - Bannettes/Button_Monter'))) {
					break
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000)
		}

		WebUI.click(findTestObject('Page_Doxtreem - Bannettes/Button_Monter'))
	}
}

