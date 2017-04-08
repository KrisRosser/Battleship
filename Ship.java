public class Ship{
	public int health;
	public Location[] location;
	
	public Ship(){
		health = 0;
	}	
	public void setLocation(Location[] location){
		this.location = location;
	}	
	public void setHealth(){
		health = location.size;
	}	
}	