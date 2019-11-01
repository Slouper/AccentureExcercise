package malleshop.pageobject;

import malleshop.base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class DashboardPage extends AbstractPage {

  private By searchInputBy = By.id("form-sitesearch-input");

  public void setSearchInput(String productName) {
    inputs().setValue(searchInputBy, productName);
    getDriver().findElement(searchInputBy).sendKeys(Keys.ENTER);
  }

}
