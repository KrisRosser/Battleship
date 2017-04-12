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

	@Test
    public final void testGetShip() {
		Location loc = new Location();
		assertFalse(loc.hasShip());
		loc.setShip(true);
		assertTrue(loc.hasShip());
    }
    
	@Test
    public final void testIsHit() {
		Location loc = new Location();
		loc.setShip(true);
		loc.fireOn();
		assertTrue(loc.isHit());
    }
	
	@Test
    public final void testIsMiss() {
		Location loc = new Location();
		loc.fireOn();
		assertTrue(loc.isMiss());
    }
	
	@Test
    public final void testWasFiredOn() {
		Location loc = new Location();
		loc.fireOn();
		assertTrue(loc.wasFiredOn());
    }
	
	@Test
    public final void testRowAndCol() {
		Location loc = new Location();
		loc.setRow(6);
		loc.setCol(4);
		assertEquals(6, loc.getRow());
		assertEquals(4, loc.getCol());
    }
}













