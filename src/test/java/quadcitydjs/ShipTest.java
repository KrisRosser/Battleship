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
	
	@Test
	public final void testHit() {
		Ship d = new Ship(Ship.ShipType.DESTROYER);
		d.takesHit();
		assertEquals(1, d.getHealth());
    }
	
	@Test
	public final void testGetShipType() {
		Ship d = new Ship(Ship.ShipType.DESTROYER);
		d.takesHit();
		assertEquals(Ship.ShipType.DESTROYER, d.getShipType());
    }
	
	@Test
	public final void testSetVertical() {
		Ship d = new Ship(Ship.ShipType.DESTROYER);
		d.setVertical(true);
		assertTrue(d.getVertical());
		d.setVertical(false);
		assertFalse(d.getVertical());
    }
	@Test
    public final void testCruiserConstructor() {
		Ship d = new Ship(Ship.ShipType.CRUISER);
		assertEquals(3, d.getHealth());
    }
}













