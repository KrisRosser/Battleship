package quadcitydjs;

import java.util.*;
import java.awt.Point;

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
		
		//if(ai){
			Random random = new Random();
			for(int i=0; i < ship.length; i++){
				boolean bool = random.nextBoolean();
				if(bool) ship[i].setVertical(false);
				else ship[i].setVertical(true);
			}
			while(shipCount > 0){
				setShipLocation(random.nextInt(10), random.nextInt(10), ship[shipCount-1]);
			}
		//}
			
			
    }
	
	public Location getLocation(int row, int col) {
        return location[row][col];		
	}	
	
	public boolean isLegalIndex(int row, int col) {
		return ((row >= 0 && row < getHeight())&& (col >= 0 && col < getWidth()));
    }
	
	public void createFleet(){
		ship = new Ship[5];
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
		Point[] locs = new Point[location.length];
        int dx = 0;
        int dy = 0;
        if(s.getVertical()) dy = 1;
        else dx = 1;
        for(int i = 0; i < locs.length; i++) {
            locs[i] = new Point(row + i*dy, col + i*dx);
            if(!isLegalIndex(locs[i].x, locs[i].y)) return;
			if(getLocation(locs[i].x, locs[i].y).hasShip()) return;
        }
        for(int i = 0; i < locs.length; i++){
		location[i] = this.location[locs[i].x][locs[i].y];
            location[i].setShip(true);
        }
        s.setLocation(location);
        shipCount--;
		
	}
	public boolean isEmpty(int row, int col) {
        return (!getLocation(row, col).hasShip());
    }
	
	public boolean isShip(int row, int col) {
        return (getLocation(row, col).hasShip());
    }
	
	public boolean isHit(int row, int col) {
        return (getLocation(row, col).isHit());			
    }
	
	public boolean isMiss(int row, int col){
		return (getLocation(row, col).isMiss());
	}
	public Ship[] getShipArray(){
		return ship;
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
	public Point findLocation(Location loc){
		Point p = new Point();
		for(int i = 0; i < getHeight(); i++){
			for(int j = 0; j < getWidth(); j++){
			if(location[i][j] == loc){
				p.x = i;
				p.y = j;
				return p;
			}
			}			
		}
		return p;
	}	
}