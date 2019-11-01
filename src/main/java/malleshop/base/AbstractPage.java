package malleshop.base;

import malleshop.factory.DriverPoolManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
  private static final int EXPLICIT_WAIT_SEC = 30;

  private WebDriver driver;
  private WebDriverWait wait;
  private Buttons buttons;
  private Inputs inputs;

  public WebDriver getDriver() {
    if (driver == null) {
      driver = DriverPoolManager.provideDriver();
    }
    return driver;
  }

  WebDriverWait getWebDriverWait() {
    if (wait == null) {
      wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT_SEC);
    }
    return wait;
  }

  protected Buttons buttons() {
    if (buttons == null) {
      buttons = new Buttons(this);
    }
    return buttons;
  }

  protected Inputs inputs() {
    if (inputs == null) {
      inputs = new Inputs(this);
    }
    return inputs;
  }

}
