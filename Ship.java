public class Ship{
	public int health;
	public Location[] location;						
	public enum ShipType {CARRIER, BATTLESHIP, CRUISER, SUBMARINE, DESTROYER};	
	public ShipType shipType;
	public boolean vertical;
	
	
	public Ship(ShipType t){
		shipType = t;
		this.setHealth();
	}
	
	public void setLocation(Location[] location){
		this.location = location;
	}	
	public void setHealth(){
		if(shipType == ShipType.CARRIER)health = 5;
		else if (shipType == ShipType.BATTLESHIP)health = 4;
		else if (shipType == ShipType.CRUISER)health = 3;
		else if(shipType == ShipType.SUBMARINE)health = 3;
		else health = 2;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void takesHit(){
		this.health--;
	}
	
	public void setShipType(ShipType t){
		
		this.shipType = t;
		
	}
	
	public ShipType getShipType(){
		
		return shipType;
		
	}
	
	public void setVertical(boolean t){
		
		this.vertical = t;
		
	}
	
	public boolean getVertical(){
		
		return vertical;
		
	}
}	