package quadcitydjs;

import org.junit.*;
import static org.junit.Assert.*;

public class LocationTest {
    
    @Before
    public final void setUp() {

    }
    
    @Test
    public final void testDefaultConstructor() {
		Location loc = new Location();
		assertFalse(loc.hasShip());
		assertFalse(loc.isHit());
		assertFalse(loc.wasFiredOn());
    }    
}













