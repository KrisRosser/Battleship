
public class Location {
    public enum Type {SHIP, EMPTY, HIT, MISS};
    private Type type;
    
    public Location() {
		this.type = Type.EMPTY;
	}
        
    public void reset() {
		this.type = Type.EMPTY;
	}
    
    public Type getType() { 
        return type;
    }
    
    public void setType(Type t) { 
		this.type = t;
    }
}
