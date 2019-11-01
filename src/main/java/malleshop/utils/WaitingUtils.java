package malleshop.utils;

public class WaitingUtils {

  private WaitingUtils() {
    // Static class, constructor not used
  }

  public static void hardWait(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException ignored) {
      // ignored
    }
  }
}
