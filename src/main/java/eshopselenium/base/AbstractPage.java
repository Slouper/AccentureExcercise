package eshopselenium.base;

import eshopselenium.factory.DriverPoolManager;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
  private WebDriver driver;

  protected WebDriver getDriver() {
    if (driver == null) {
      driver = DriverPoolManager.provideDriver();
    }

    return driver;
  }

}
