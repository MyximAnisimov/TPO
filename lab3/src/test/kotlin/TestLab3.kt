import io.github.bonigarcia.wdm.WebDriverManager
import org.example.*
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.lang.System.getProperty
import java.time.Duration
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.test.assertTrue


class TestLab3 {
    private lateinit var chromeDriver: ChromeDriver
    private lateinit var firefoxDriver: FirefoxDriver
    private val props: Properties = Properties()

    init {
        javaClass.classLoader.getResourceAsStream("local.properties").use { input ->
            props.load(input)
        }
    }

    @BeforeEach
    fun setUp() {
        WebDriverManager.chromedriver().setup()
        chromeDriver = ChromeDriver()
        WebDriverManager.firefoxdriver().setup()
        firefoxDriver = FirefoxDriver()
    }

    @Test
    fun test1() {
        testTransitPagesAuto(chromeDriver)
        testTransitPagesAuto(firefoxDriver)
    }

    @Test
    fun test2() {
        testTransitPagesByClick(chromeDriver)
        testTransitPagesByClick(firefoxDriver)
    }

    @Test
    fun test3() {
        testOpenNewTab(chromeDriver)
        testOpenNewTab(firefoxDriver)
    }

    @Test
    fun test4() {
        findPNGByLink(chromeDriver)
        findPNGByLink(firefoxDriver)
    }

    @Test
    fun test5() {
        checkDownloading(chromeDriver)
        checkDownloading(firefoxDriver)
    }

    @AfterEach
    fun tearDown() {
        chromeDriver.quit()
        firefoxDriver.quit()
    }

    private fun testTransitPagesAuto(driver: WebDriver) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        driver.get("http://www.angely-sveta.ru/")
        Assertions.assertEquals("http://www.angely-sveta.ru/", driver.currentUrl);

        wait.until(ExpectedConditions.urlToBe("http://www.angely-sveta.ru/russian/default_2_ru.htm"))
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_2_ru.htm", driver.currentUrl)

        wait.until(ExpectedConditions.urlToBe("http://www.angely-sveta.ru/russian/default_14_ru.htm"))
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_14_ru.htm", driver.currentUrl)

        wait.until(ExpectedConditions.urlToBe("http://www.angely-sveta.ru/russian/default_ru.htm"))
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_ru.htm", driver.currentUrl)
    }

    private fun testTransitPagesByClick(driver: WebDriver){
        driver.get("http://www.angely-sveta.ru/")
        var page = driver.findElement(Links.linkNextPage)
        page.click()
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_2_ru.htm", driver.currentUrl)
        page = driver.findElement(Links.linkNextPage)
        page.click()
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_14_ru.htm", driver.currentUrl)
        page = driver.findElement(Links.linkNextPage)
        page.click()
        Assertions.assertEquals("http://www.angely-sveta.ru/russian/default_ru.htm", driver.currentUrl)
    }

    private fun testOpenNewTab(driver: WebDriver) {
        driver.get("http://www.angely-sveta.ru/russian/default_ru.htm")
        var tabsBefore = driver.windowHandles.size
        driver.switchTo().frame(driver.findElement(Frames.leftSideBar))
        var link = driver.findElement(Links.linkOnNewTabEng)
        link.click()
        tabsBefore++
        Assertions.assertEquals(tabsBefore, driver.windowHandles.size)
        link = driver.findElement(Links.linkOnNewTabCz)
        link.click()
        tabsBefore++
        Assertions.assertEquals(tabsBefore, driver.windowHandles.size)
        link = driver.findElement(Links.linkOnNewTabDe)
        link.click()
        tabsBefore++
        Assertions.assertEquals(tabsBefore, driver.windowHandles.size)
    }

    private fun findPNGByLink(driver: WebDriver) {
        driver.get("http://www.angely-sveta.ru/russian/default_ru.htm")
        driver.switchTo().frame(driver.findElement(Frames.leftSideBar))
        val link = driver.findElement(Links.linkPng)
        link.click()
        driver.switchTo().defaultContent()
        driver.switchTo().frame(driver.findElement(Frames.rightSideBar))
        try {
            val element = driver.findElement(Pngs.pngHumanHeart)
            assertTrue(element.isDisplayed, "Элемент не найден или не отображается")
        }
        catch(e : Exception) {
            Assertions.fail()
        }
    }

    private fun checkDownloading(driver: WebDriver) {
        driver.get("http://www.angely-sveta.ru/russian/default_ru.htm")
        driver.switchTo().frame(driver.findElement(Frames.leftSideBar))
        val link = driver.findElement(Links.linkVideos)
        link.click()
        driver.switchTo().defaultContent()
        driver.switchTo().frame(driver.findElement(Frames.rightSideBar))
        val element = driver.findElement(Links.linkOnDownloadPps)
        element.click()

        WebDriverWait(driver, Duration.ofSeconds(1)).until { true }
        Assertions.assertTrue(File(props.getProperty("downloads.path"), "10_roses.pps.crdownload").exists())
    }
}