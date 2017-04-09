public class Grid extends Observable {
    public enum Result {NONE, WIN, LOSE};
    
    private Location[][] location;
    private Ship[] ship;
    private Random random;
	
	  public Grid() {
		this(10,10);
    }
    
    public Grid(int width, int height) {
		this(width,height,ship, new Random());
    }
	
	 public Grid(int width, int height, Random random) {
		this.random = random;
        location = new Location[height][width];                    
        for(int i = 0; i < getHeight(); i++){
            for(int j = 0; j < getWidth(); j++){
                location[i][j] = new Location();                
            }
        }
		createFleet();
    }
	
	private boolean isLegalIndex(int row, int col) {
		return ((row >= 0 && row < getHeight())&& (col >= 0 && col < getWidth()));
    }
	
	public createFleet(){
		ship[0] = new ship();
		ship[0].setShipType(CARRIER);
		ship[1] = new ship();
		ship[1].setShipType(BATTLESHIP);
		ship[2] = new ship();
		ship[2].setShipType(CRUISER);
		ship[3] = new ship();
		ship[3].setShipType(SUBMARINE);
		ship[4] = new ship();
		ship[4].setShipType(DESTROYER);
	}	
	public int getWidth() {
        return location[0].length;
    }
    
    public int getHeight() {
        return location.length;
    }
    
    public int getMines() {
        return mines;
    }