package Steps;

import Util.DriveManager;
import Util.TestProperties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void setUp(){
        WebDriver driver = DriveManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(properties.getProperty("app.url"));
    }

    @After
    public void tearDown(){
        DriveManager.quitDriver();
    }
}
