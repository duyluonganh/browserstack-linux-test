import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory2
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI





WebDriver driver = DriverFactory2.openWebDriver()
DriverFactory.changeWebDriver(driver)

WebUI.closeBrowser()

