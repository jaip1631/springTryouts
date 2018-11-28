import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by jaiprakash on 28/11/18
 */
public class ShipwreckControllerTest {

  @InjectMocks
  private ShipwreckController sc;

  @Mock
  private ShipwreckRepository shipwreckRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testShipwreckGet() {
    Shipwreck mockedShipwreck = new Shipwreck();
    mockedShipwreck.setId(1L);
    Mockito.when(shipwreckRepository.findOne(1L))
        .thenReturn(mockedShipwreck);

    Shipwreck shipwreck = sc.get(1);

    Mockito.verify(shipwreckRepository).findOne(1L);

    Assert.assertEquals(1L, shipwreck.getId().longValue());
  }
}
