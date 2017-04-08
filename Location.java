
public class Location {
    public enum Type {SHIP, EMPTY} 
	private Type type;
    
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
	
	public boolean hasHit() {
		
		return hit;
		
	}
	
	public void setHit(boolean t){
		
		this.hit = t;
		
	}
	
	public boolean hasMiss() {
		
		return miss;
		
	}
	
	public void setHit(boolean t){
		
		this.miss = t;
		
	}
}
