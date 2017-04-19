/*
package quadcitydjs;

import org.junit.*;
import static org.junit.Assert.*;

public class GridTest {
    
    @Before
    public final void setUp() {

    }
    
    @Test
    public final void testDefaultConstructor() {
		Grid grid = new Grid();
		assertEquals(10, grid.getHeight());
		assertEquals(10, grid.getWidth());
    }
	
	@Test
    public final void testAIConstructor() {
		boolean ai = true;
		int sCheck = 0;
		Grid grid = new Grid(10, 10, ai);
		assertEquals(10, grid.getHeight());
		assertEquals(10, grid.getWidth());
		for(int i=0; i<10;i++){
			for(int j=0; j<10; j++){
				if(grid.getLocation(i, j).hasShip()){	
					sCheck++;
				}
			}
		}
		assertEquals(17, sCheck);
	}
		
	@Test
    public final void testIsLegalIndex() {
		Grid grid = new Grid();
		assertTrue(grid.isLegalIndex(2,4));
		assertFalse(grid.isLegalIndex(12,4));
		assertFalse(grid.isLegalIndex(2,14));
    }
	
	@Test
	public final void testCreateFleet() {
		Ship[] ship = new Ship[5];
		int[] numb = {2,3,3,4,5};
		ship[4] = new Ship(Ship.ShipType.CARRIER);
		ship[3] = new Ship(Ship.ShipType.BATTLESHIP);
		ship[2] = new Ship(Ship.ShipType.CRUISER);
		ship[1] = new Ship(Ship.ShipType.SUBMARINE);
		ship[0] = new Ship(Ship.ShipType.DESTROYER);
		for(int i=0;i<ship.length;i++){
			assertEquals(numb[i], ship[i].getHealth());
		}
    }
    
	@Test
    public final void testSetShipLocation() {
		int sCheck = 0;
		Grid grid = new Grid();
		Ship carrier = new Ship(Ship.ShipType.CARRIER);
		Ship destroyer = new Ship(Ship.ShipType.DESTROYER);
		carrier.setVertical(true);
		destroyer.setVertical(false);
		grid.setShipLocation(4,0,carrier);
		for(int i=4; i<9; i++){
			assertTrue(grid.getLocation(i,0).hasShip());
		}
		grid.setShipLocation(9,0,carrier);
		grid.setShipLocation(0,9,destroyer);
		grid.setShipLocation(0,8,destroyer);
		for(int i=0; i<10;i++){
			for(int j=0; j<10; j++){
				if(grid.getLocation(i, j).hasShip()){	
					sCheck++;
				}
			}
		}
		assertEquals(7, sCheck);
	}
	
}
*/












