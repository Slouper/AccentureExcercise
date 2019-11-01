package malleshop.base;

import malleshop.factory.DriverPoolManager;
import org.testng.annotations.AfterSuite;

@SuppressWarnings("squid:S1610" /* TestNG does not work for interfaces */)
public abstract class AbstractTest {

  @AfterSuite
  public void quitAllDrivers() {
    DriverPoolManager.quitAllSilently();
  }

}
