package quadcitydjs;

import java.util.*;

public class Grid extends Observable {
    public enum Result {NONE, WIN, LOSE};
    
    private Location[][] location;
    private Ship[] ship;
	private int shipCount;
	private int shipSunk;
	
	public Grid() {
		this(10,10);
    }
        
	public Grid(int width, int height) {
		this(width, height, false);
    }
	
	public Grid(int width, int height, boolean ai) {
		location = new Location[height][width];
		shipSunk = 0;
        for(int i = 0; i < getHeight(); i++){
            for(int j = 0; j < getWidth(); j++){
                location[i][j] = new Location();
				location[i][j].setRow(i);
				location[i][j].setCol(j);
            }
        }
		createFleet();
		this.shipCount = 5;
		
		if(ai){
			Random random = new Random();
			for(int i=0; i < ship.length; i++){
				boolean bool = random.nextBoolean();
				if(bool) ship[i].setVertical(false);
				else ship[i].setVertical(true);
			}
			while(shipCount > 0){
				setShipLocation(random.nextInt(10), random.nextInt(10), ship[shipCount-1]);
			}
		}
    }
	
	public Location getLocation(int row, int col) {
        return location[row][col];		
	}	
	
	private boolean isLegalIndex(int row, int col) {
		return ((row >= 0 && row < getHeight())&& (col >= 0 && col < getWidth()));
    }
	
	public void createFleet(){
		ship[0] = new Ship(Ship.ShipType.CARRIER);
		ship[1] = new Ship(Ship.ShipType.BATTLESHIP);
		ship[2] = new Ship(Ship.ShipType.CRUISER);
		ship[3] = new Ship(Ship.ShipType.SUBMARINE);
		ship[4] = new Ship(Ship.ShipType.DESTROYER);
	}	
	public int getWidth() {
        return location[0].length;
    }
    
    public int getHeight() {
        return location.length;
    }
    
    public void setShipLocation(int row, int col, Ship s){
		Location[] location = new Location[s.getHealth()];
		if(isLegalIndex(row,col)){
			if(s.getVertical()){
				for(int i = 0; i < s.getHealth(); i++){
					if(isLegalIndex(row+i,col)){
						location[i] = getLocation(row+i,col);
					}
					if(location.length == s.getHealth()){
						for(int j = 0; j < s.getHealth(); j++){
							getLocation(row+j, col).setShip(true);
						}
						s.setLocation(location);
						shipCount--;
					}
				}
			}
			else{
				for(int i = 0; i < s.getHealth(); i++){
					if(isLegalIndex(row,col+i)){
						location[i] = getLocation(row,col+i);
					}
					if(location.length == s.getHealth()){
						for(int j = 0; j < s.getHealth(); j++){
							getLocation(row, col+j).setShip(true);
						}
						s.setLocation(location);
						shipCount--;
					}
				}
			}
		}
		
	}
	private boolean isEmpty(int row, int col) {
        return (!getLocation(row, col).hasShip());
    }
	
	private boolean isShip(int row, int col) {
        return (getLocation(row, col).hasShip());
    }
	
	public boolean isHit(int row, int col) {
        return (getLocation(row, col).isHit());			
    }
	
	public boolean isMiss(int row, int col){
		return (getLocation(row, col).isMiss());
	}
	
	public void shipHit(Ship s){
		s.takesHit();
		if(s.getHealth()==0){
			shipSunk++;
		}
	}
	
	public Result getResult(){
		if(shipSunk == 5){
			return Result.LOSE;
		}
		else{
			return Result.NONE;
		}
		
	}	
	
}