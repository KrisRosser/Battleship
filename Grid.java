public class Grid extends Observable {
    public enum Result {NONE, WIN, LOSE};
    
    private Location[][] location;
    private Ship[] ship;
    private Random random;
	
	  public Grid() {
		this(8,8,10);
    }
    
    public Grid(int width, int height, Ship[] ship) {
		this(width,height,ship, new Random());
    }
	
	 public Grid(int width, int height, Ship[] ship, Random random) {
		this.random = random;
        this.ship = ship;
        location = new Location[height][width];                    
        for(int i = 0; i < getHeight(); i++){
            for(int j = 0; j < getWidth(); j++){
                location[i][j] = new Location();                
            }
        }
    }