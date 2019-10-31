package eshopselenium.base;

import eshopselenium.factory.DriverPoolManager;
import org.testng.annotations.AfterSuite;

public abstract class AbstractTest {

  @AfterSuite
  public void quitAllDrivers() {
    DriverPoolManager.quitAllSilently();
  }

}
