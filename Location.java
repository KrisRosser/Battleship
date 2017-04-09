
public class Location {
    public enum Type {SHIP, EMPTY} 
	private Type type;
    public int row;
	public int col;
	public boolean hit;
	public boolean miss;
	
    public Location() {
		this.type = Type.EMPTY;
		this.hit = false;
		this.miss = false;
	}
        
    public void reset() {
		this.type = Type.EMPTY;
		this.hit = false;
		this.miss = false;
	}
    
    public Type getType() { 
        return type;
    }
    
    public void setType(Type t) { 
		this.type = t;
    }
	
	public boolean getHit() {
		
		return hit;
		
	}
	
	public void setHit(boolean t){
		
		this.hit = t;
		
	}
	
	public boolean getMiss() {
		
		return miss;
		
	}
	
	public void setMiss(boolean t){
		
		this.miss = t;
		
	}
	public void setRow(int r){
		row = r;
	}
	public void setCol(int c){
		col = c;
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
}
