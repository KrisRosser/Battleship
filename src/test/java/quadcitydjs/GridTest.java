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
				if(grid.getLocation(i, j).hasShip())	sCheck++;
			}
		}
		System.out.println("Rosser"+ ("" + sCheck));
		assertEquals(17, sCheck);
		
	}
	
    
}













