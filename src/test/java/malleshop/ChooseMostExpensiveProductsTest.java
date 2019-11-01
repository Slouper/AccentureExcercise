package malleshop;

import static malleshop.utils.WaitingUtils.hardWait;

import malleshop.base.AbstractTest;
import malleshop.pageobject.DashboardPage;
import malleshop.pageobject.ProductListPage;
import malleshop.pageobject.initpage.InitPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ChooseMostExpensiveProductsTest extends AbstractTest {
  private static final String BASE_URL = "https://mall.cz";

  @BeforeMethod
  public void navigateToBaseUrl() {
    new InitPage().getDriver().get(BASE_URL);
  }

  @Test(dataProvider = "getTestData", description = "Search product, sort found products by price from the most expensive and add two first to the cart.")
  public void chooseMostExpensiveProducts_WhenListOfProductsIsOpen(int countOfProductsAddedToCart, String searchedProductName) {

    DashboardPage dashboardPage = new DashboardPage();
    dashboardPage.setSearchInput(searchedProductName);

    ProductListPage productListPage = new ProductListPage();
    productListPage.clickOnSortingByHighestPrice()
        .addProductsToCart(countOfProductsAddedToCart);

    // Hard wait use only to see result on the screen.
    hardWait(10000);
  }

  @DataProvider
  private Object[][] getTestData() {
    return new Object[][]{{2, "Samsung Galaxy A40"}};
  }
}
