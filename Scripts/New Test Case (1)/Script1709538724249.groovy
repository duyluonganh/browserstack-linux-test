import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory2

import io.appium.java_client.AppiumDriver


Mobile.comment('Story: Verify correct alarm message')

Mobile.comment('Given that user has started an application')

'Get full directory\'s path of android application'
//def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())
def appPath = 'bs://sample.app'
setDriverSystemProperty('Remote', 'remoteWebDriverUrl', 'https://duyluong_jMx25Y:FiKovXrr6NqbPYCdHbfu@hub-cloud.browserstack.com/wd/hub')
//RunConfiguration.setDriverPreferencesProperty('Remote', 'build', 'LocalBuild-' + System.getenv('USER'))
RunConfiguration.setDriverPreferencesProperty('Remote', 'build', 'LocalBuild-' + 'zj-test')
RunConfiguration.setDriverPreferencesProperty('Remote', 'platformName', 'Android')
RunConfiguration.setDriverPreferencesProperty('Remote', 'deviceName', 'Samsung Galaxy S22 Ultra')
RunConfiguration.setDriverPreferencesProperty('Remote', 'platformVersion', '12.0')


AppiumDriver driver = MobileDriverFactory2.startMobileDriver(appPath, false)
MobileDriverFactory.setDriver(driver)

Mobile.closeApplication()

public void setDriverSystemProperty(String driverType, String propName, Object propVal) {
    Map<String, Object> executionSetting = (Map<String, Object>) RunConfiguration.localExecutionSettingMapStorage.get()
    Map<String, Object> executionProps = (Map<String, Object>) executionSetting.get(RunConfiguration.EXECUTION_PROPERTY)
    Map<String, Object> driverProps = (Map<String, Object>) executionProps.get(RunConfiguration.EXECUTION_DRIVER_PROPERTY)
    //          Map<String, Object> driverProps = (Map<String, Object>) RunConfiguration.getExecutionProperties().get(RunConfiguration.EXECUTION_DRIVER_PROPERTY)
    Map<String, Object> SystemProps =  (Map<String, Object>) driverProps.get(RunConfiguration.EXECUTION_SYSTEM_PROPERTY)
    Map<String, Object> props = SystemProps.get(driverType)
    if (props != null) {
        props.put(propName, propVal)
    }
    RunConfiguration.setExecutionSetting(executionSetting)
}
