import com.boot.controller.HomeController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jaiprakash on 28/11/18
 */

public class AppTest {

  @Test
  public void testHomeController() {
    HomeController homeController = new HomeController();
    Assert.assertEquals("Das Boot, reporting for duty!", homeController.home());
  }
}
