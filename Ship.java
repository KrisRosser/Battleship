public class Ship{
	public int health;
	public Location[] location;						
	public enum ShipType {CARRIER, BATTLESHIP, CRUISER, SUBMARINE, DESTROYER};	
	public ShipType shipType;
	
	public Ship(){
		health = 0;
	}	
	
	public Ship(Location[] l, ShipType t){
		
		health = l.size;
		location = l;
		shipType = t;
		
	}
	
	public void setLocation(Location[] location){
		this.location = location;
	}	
	public void setHealth(){
		health = location.size;
	}

	public void setShipType(ShipType t){
		
		this.shipType = t;
		
	}
	
	public ShipType getShipType(){
		
		return shipType;
		
	}
}	