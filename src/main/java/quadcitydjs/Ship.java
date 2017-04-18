package quadcitydjs;

public class Ship{
	public int health;
	public Location[] location;						
	public enum ShipType {CARRIER, BATTLESHIP, CRUISER, SUBMARINE, DESTROYER};	
	public ShipType shipType;
	public boolean vertical;
	
	
	public Ship(ShipType t){										// create ship and tell it what type it is
		shipType = t;
		this.setHealth();
	}
	
	public void setLocation(Location[] location){					//when you place the ship, tell it the locations it is on
		this.location = location;
	}	
	public Location[] getLocation(){
		return location;
	}	
	public void setHealth(){										// sets number of hits ship can take based on its size
		if(shipType == ShipType.CARRIER)health = 5;
		else if (shipType == ShipType.BATTLESHIP)health = 4;
		else if (shipType == ShipType.CRUISER)health = 3;
		else if(shipType == ShipType.SUBMARINE)health = 3;
		else health = 2;
	}
	
	public int getHealth(){											//use this to find out how many hits are "left" on the ship
		return this.health;
	}
	
	public void takesHit(){											//use this to let a ship know it took a hit and lower its health
		this.health--;
	}
	
	public void setShipType(ShipType t){							//set or change ship type
		
		this.shipType = t;
		
	}
	
	public ShipType getShipType(){									//find out what type of ship it is
		
		return shipType;
		
	}
	
	public void setVertical(boolean t){								//use this to set whether ship is vertically placed or horizontally placed
		
		this.vertical = t;
		
	}
	
	public boolean getVertical(){									//use this to ASK whether ship is vertically placed or horizontally placed	
		
		return vertical;
		
	}
}	