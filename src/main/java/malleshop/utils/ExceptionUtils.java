package malleshop.utils;

import static malleshop.utils.WaitingUtils.hardWait;

import org.openqa.selenium.WebDriverException;

public class ExceptionUtils {

  public static void preventException(PreventedAction action) {
    WebDriverException webDriverException = null;
    int countOfAttempts = 0;

    while (countOfAttempts < 5) {
      try {
        action.perform();
        return;
      } catch (WebDriverException e) {
        countOfAttempts++;
        webDriverException = e;
        hardWait(5000);
      }
    }
    throw new WebDriverException("'WebDriverException' thrown during action on/with element. See exception further:\n", webDriverException);
  }

  @FunctionalInterface
  public interface PreventedAction {
    void perform();
  }

}
