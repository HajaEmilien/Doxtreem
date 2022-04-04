package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import java.io.Writer
import java.io.BufferedWriter
import java.io.BufferedReader
import java.io.File
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import groovy.json.JsonOutput



//import MobileBuiltInKeywords as Mobile
//import WSBuiltInKeywords as WS
//import WebUiBuiltInKeywords as WebUI
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class TestFile {

	def filePath2 = RunConfiguration.getProjectDir() + '\\Test Data\\TestBannette.txt'
	@Keyword
	public UpgradTestBannetteInTrue() {

		PrintWriter myWriterTestSuite = new PrintWriter(new FileWriter(filePath2))
		myWriterTestSuite.println("true")
		println( "initialisation OK ")
		myWriterTestSuite.close()
	}

	@Keyword
	public Writefile (String filePath , String txt) {
		try {
			PrintWriter myWriterTestSuite = new PrintWriter(new FileWriter(RunConfiguration.getProjectDir()+filePath,true))

			if (FindTextFile(filePath,txt)) {
				println "le texte "+txt+" déjà présent dans le fichier "
			} else {
				myWriterTestSuite.println(txt)
				println( "Le Texte : "+txt+" a été ajouté dans le fichier ")
			}
			myWriterTestSuite.close()
		} catch (IOException e) {
			println("erreur lors de l'ecriture dans le fichier")
			e.printStackTrace()
		}
	}

	@Keyword
	public boolean FindTextFile (String filePath , String txt) {
		Scanner myReader = new Scanner(new File(RunConfiguration.getProjectDir()+filePath))
		while(myReader.hasNextLine())
		{
			String data = myReader.nextLine()
			if (data.contains(txt)){
				return true
			}
		}
		myReader.close()

	}

	@Keyword
	public int countTestSuiteFile(String filePath) {
		int rowCount
		List list = [
			"Test Suites/Administration fonctionnelle" ,
			"Test Suites/Administration technique" ,
			"Test Suites/Identity Access Management",
			"Test Suites/Bannette de traitements",
			"Test Suites/Bannette documentaire",
			"Test Suites/Bannette personnelles",
			"Test Suites/Capture",
			"Test Suites/Centre de distribution",
			"Test Suites/Corbeille",
			"Test Suites/Dashboard",
			"Test Suites/Ecran Explorer",
			"Test Suites/Recherche",
			"Test Suites/Visionneuse de document",
			"Test Suites/Workflow"
		]
		Scanner myReader = new Scanner(new File(RunConfiguration.getProjectDir()+filePath))
		while(myReader.hasNextLine())
		{

			String data = myReader.nextLine()
			println("Liste des Suites de test Terminés : "+data)
			for( item in list){
				if (data.contains(item)){
					rowCount++
				}
			}

		}
		myReader.close()
		return rowCount
	}

	@Keyword
	public void DeleteFile(String filePath) {
		File myObjct2 = new File (RunConfiguration.getProjectDir()+filePath)
		myObjct2.delete()

	}
}