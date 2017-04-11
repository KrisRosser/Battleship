package quadcitydjs;


public class Location {
    public enum Type {SHIP, EMPTY} 
	public enum State {CLEAR, HIT}
	private boolean ship;
	private boolean fired;
    private int row;
	private int col;
	
    public Location() {
		ship = false;
		fired = false;
	}
        
    public void reset() {
		ship = false;
		fired = false;
	}
    
    public boolean hasShip() { 			//does this location contain a iece of a ship
        return ship;
    }
    
    public void setShip(boolean t) { 	//use this to tell location a piece of a ship is placed
		ship = t;
    }
	
	public boolean isHit() {			//use this to place hit icon
		return ship && fired;
	}
	
	public boolean isMiss() {			//use this to place miss icon
		return !ship && fired;
	}
	
	public void fireOn(){				//this location is fired upon, use this before calling isHit()
		fired = true;
	}
	
	public boolean wasFiredOn() {		//use this to see if they have clicked on this location before
		return fired;
	}
	
	public void setRow(int r){			//let's this location store a referance to its row on grid
		row = r;
	}
	public void setCol(int c){			//let's this location store a referance to its row on grid
		col = c;
	}
	public int getRow(){				//use for comparing a location with location stored in ship to find out which ship was hit
		return row;
	}
	public int getCol(){				//use for comparing a location with location stored in ship to find out which ship was hit
		return col;
	}
}
