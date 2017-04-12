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

	/*@Test
    public final void testAIConstructor() {
		boolean ai = true;
		Grid grid = new Grid(10, 10, ai);
		assertEquals(10, grid.getHeight());
		assertEquals(10, grid.getWidth());
    }*/
    
}













