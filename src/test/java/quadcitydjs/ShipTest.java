package quadcitydjs;

import org.junit.*;
import static org.junit.Assert.*;

public class ShipTest {
    
    @Before
    public final void setUp() {

    }
    
    @Test
    public final void testConstructor() {
		Ship d = new Ship(Ship.ShipType.DESTROYER);
		assertEquals(2, d.getHealth());
    }    
}













