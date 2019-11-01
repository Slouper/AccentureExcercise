package malleshop.pageobject;

import static java.lang.String.format;

import java.util.List;
import malleshop.base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@SuppressWarnings("FieldCanBeLocal")
public class ProductListPage extends AbstractPage {

  private static By sortHighestPriceAnchor = By.xpath("//a[@data-sel='sort-highPrice']/parent::*");
  private static By productArticlesBy = By.xpath("//article[contains(@id,'list')]");

  private static String productArticleXpath = "//article[contains(@id,'list')][%s]";
  private static String addToCartButtonXpath = "//*[normalize-space(text())='Přidat do košíku']/ancestor::button[1]";

  public ProductListPage clickOnSortingByHighestPrice() {
    buttons().performClick(sortHighestPriceAnchor);
    return this;
  }

  public void addProductsToCart(int count) {
    List<WebElement> productArticles = getDriver().findElements(productArticlesBy);
    int countOfAddedProducts = 1;
    while (countOfAddedProducts <= productArticles.size()) {
      if (countOfAddedProducts <= count) {
        buttons().performClick(getAddToCartBy(countOfAddedProducts));
      } else {
        break;
      }
      countOfAddedProducts++;
    }
  }

  private By getAddToCartBy(int index) {
    return By.xpath(format(productArticleXpath, index) + addToCartButtonXpath);
  }

}
