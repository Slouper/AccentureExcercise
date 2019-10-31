package eshopselenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ChooseMostExpensiveProductsTest {

  @Test
  public void chooseMostExpensiveProducts_WhenListOfProductsIsOpen(int countOfMostExpensiveProducts) {

  }

  @DataProvider
  private Object[][] getTestData() {
    return new Object[][]{{2}};
  }
}
