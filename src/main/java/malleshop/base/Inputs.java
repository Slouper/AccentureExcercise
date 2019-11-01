package malleshop.base;

import static java.lang.String.format;

import java.util.logging.Logger;
import malleshop.utils.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Inputs {
  private static final Logger LOG = Logger.getLogger(Inputs.class.getName());
  private AbstractPage ownerPage;
  private Actions actions;

  Inputs(AbstractPage ownerPage) {
    this.ownerPage = ownerPage;
    actions = new Actions(ownerPage.getDriver());
  }

  public void setValue(By input, String value) {
    LOG.info(format("     setValue() into [%s]", input));
    ExceptionUtils.preventException(() -> {
      WebElement inputElement = ownerPage.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(input));
      actions.moveToElement(inputElement);
      inputElement.sendKeys(value);
    });
  }
}
