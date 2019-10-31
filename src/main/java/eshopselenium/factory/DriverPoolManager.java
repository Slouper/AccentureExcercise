package eshopselenium.factory;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPoolManager {

  private static final Logger LOG = Logger.getLogger(DriverPoolManager.class.getName());
  private static final HashMap<Object, WebDriver> driverPool = new HashMap<>();
  private static final int IMPLICIT_WAIT_SEC = 30;

  public static WebDriver provideDriver() {
    return provideDriverByThread(Thread.currentThread());
  }

  private static synchronized WebDriver provideDriverByThread(Object threadKey) {
    if (driverPool.containsKey(threadKey)) {
      return driverPool.get(threadKey);
    } else {
      WebDriver driver = new ChromeDriver();
      configureDriver(driver);
      driverPool.put(threadKey, driver);
      return driver;
    }
  }

  private static void configureDriver(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SEC * 1000L, TimeUnit.MILLISECONDS);
    driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  public static synchronized void quitAllSilently() {
    LOG.info(format("Quit all [%s] drivers silently.", driverPool.size()));
    driverPool.forEach((threadKey, driver) -> quitSilently(driver));
  }

  private static void quitSilently(WebDriver driver) {
    try {
      driver.quit();
    } catch (Exception ignored) {
      // ignored
    }
  }
}
