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

import org.openqa.selenium.WebElement
import java.util.List
import java.util.Collections

WebUI.callTestCase(findTestCase('Test Cases/autentikasi/LoginSuccessfully.groovy'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/product-management/sorting'))

WebUI.click(findTestObject('Object Repository/product-management/z to a'))

List<String> actualProductName = []
for (int i = 0; i<6; i++) {
	String productName = WebUI.getText(findTestObject("Object Repository/product-management/list-all-product", [('index') : i]))
    actualProductName.add(productName)
	}

	List<String> expectedProductName = new ArrayList<>(actualProductName)
	expectedProductName.sort(Collections.reverseOrder())
	
	// Verifikasi hasil
	WebUI.verifyEqual(actualProductName, expectedProductName)
	
	// Tutup browser
	WebUI.closeBrowser()