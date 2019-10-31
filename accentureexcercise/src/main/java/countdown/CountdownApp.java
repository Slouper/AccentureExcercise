package countdown;

import java.util.logging.Logger;

public class CountdownApp {
  private static final Logger LOG = Logger.getLogger(CountdownApp.class.getName());

  public static void main(String[] args) {
    countDown();
  }

  private static void countDown() {
    int i = 100;
    while (i >= 1) {
      if (i % 5 == 0 && i % 3 == 0) {
        LOG.info("Testing");
      } else if (i % 5 == 0) {
        LOG.info("Agile");
      } else if (i % 3 == 0) {
        LOG.info("Software");
      } else {
        LOG.info(String.valueOf(i));
      }
      i--;
    }
  }
}
