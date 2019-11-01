package malleshop.base;

import static java.lang.String.format;

import java.util.logging.Logger;
import malleshop.utils.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Buttons {
  private static final Logger LOG = Logger.getLogger(Buttons.class.getName());
  private AbstractPage ownerPage;
  private Actions actions;

  Buttons(AbstractPage ownerPage) {
    this.ownerPage = ownerPage;
    actions = new Actions(ownerPage.getDriver());
  }

  public void performClick(By button) {
    LOG.info(format("     performClick() on [%s]", button));
    ExceptionUtils.preventException(() -> {
      WebElement buttonElement = ownerPage.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(button));
      actions.moveToElement(buttonElement);
      buttonElement.click();
    });
  }
}
