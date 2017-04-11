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
    
    public boolean hasShip() { 
        return ship;
    }
    
    public void setShip(boolean t) { 
		ship = t;
    }
	
	public boolean isHit() {
		return ship && fired;
	}
	
	public boolean isMiss() {
		return !ship && fired;
	}
	
	public void fireOn(){
		fired = true;
	}
	
	public boolean wasFiredOn() {
		return fired;
	}
	
	public void setRow(int r){
		row = r;
	}
	public void setCol(int c){
		col = c;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
}
