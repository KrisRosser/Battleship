package quadcitydjs;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* I am thnking that this class will handle the GUI much like minesweeper. I also believe that we should use
the enable option should be used to distinguish between the two players. Maybe add a player_enable and AI_enable. I also think this class
should house the code for the AI as well. I am also kinda thinking about using the observable even though I really do not want to.*/
public class Battleship extends JPanel implements ActionListener {
	
	private final ImageIcon CARRIER_ICON1 = new ImageIcon(getClass().getClassLoader().getResource("carrier1.png"));
	private final ImageIcon CARRIER_ICON2 = new ImageIcon(getClass().getClassLoader().getResource("carrier2.png"));
	private final ImageIcon CARRIER_ICON3 = new ImageIcon(getClass().getClassLoader().getResource("carrier3.png"));
	private final ImageIcon CARRIER_ICON4 = new ImageIcon(getClass().getClassLoader().getResource("carrier4.png"));
	private final ImageIcon CARRIER_ICON5 = new ImageIcon(getClass().getClassLoader().getResource("carrier5.png"));
    private final ImageIcon BATTLESHIP_ICON1 = new ImageIcon(getClass().getClassLoader().getResource("battleship1.png"));
	private final ImageIcon BATTLESHIP_ICON2 = new ImageIcon(getClass().getClassLoader().getResource("battleship2.png"));
	private final ImageIcon BATTLESHIP_ICON3 = new ImageIcon(getClass().getClassLoader().getResource("battleship3.png"));
	private final ImageIcon BATTLESHIP_ICON4 = new ImageIcon(getClass().getClassLoader().getResource("battleship4.png"));
	private final ImageIcon CRUISER_ICON1 = new ImageIcon(getClass().getClassLoader().getResource("cruiser1.png"));
	private final ImageIcon CRUISER_ICON2 = new ImageIcon(getClass().getClassLoader().getResource("cruiser2.png"));
	private final ImageIcon CRUISER_ICON3 = new ImageIcon(getClass().getClassLoader().getResource("cruiser3.png"));
    private final ImageIcon SUBMARINE_ICON1 = new ImageIcon(getClass().getClassLoader().getResource("submarine1.png"));
	private final ImageIcon SUBMARINE_ICON2 = new ImageIcon(getClass().getClassLoader().getResource("submarine2.png"));
	private final ImageIcon SUBMARINE_ICON3 = new ImageIcon(getClass().getClassLoader().getResource("submarine3.png"));
	private final ImageIcon DESTROYER_ICON1 = new ImageIcon(getClass().getClassLoader().getResource("destroyer1.png"));
	private final ImageIcon DESTROYER_ICON2 = new ImageIcon(getClass().getClassLoader().getResource("destroyer2.png"));
	
	private Grid grid;
	private Grid gridAI;
	private JButton[][] AI_button;
	private JButton[][] button;
	private int shipCount;
	private int ships;
	private boolean player_enabled;
	private boolean AI_enabled;
	private JLabel shipLabel_1;
	private JLabel shipLabel_2;
	
	public Battleship() {
		this(10,10);
	}
	
	public Battleship(int height, int width) {
		player_enabled = true;
		AI_enabled = false;
		gridAI = new Grid(height, width, true);
		JPanel gridAIPanel = new JPanel();
		gridAIPanel.setLayout(new GridLayout(height, width));
		AI_tile = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				AI_button[i][j] = new JLabel();
				AI_button[i][j].setName("cell:" + i + ":" + j);
				AI_button[i][j].setPreferredSize(new Dimension(50,50));
				AI_button[i][j].setHorizontalAlignment(0);
				AI_button[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(AI_button[i][j]);
				AI_button[i][j].addActionListener(this);
				gridAIPanel.add(AI_button[i][j]);
			}
		}
		grid = new Grid(height, width);
		grid.addObserver(this);
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(height, width));
		tile = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				button[i][j] = new JLabel();
				button[i][j].setName("cell:" + i + ":" + j);
				button[i][j].setPreferredSize(new Dimension(50,50));
				button[i][j].setHorizontalAlignment(0);
				button[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(button[i][j]);
				button[i][j].addActionListener(this);
				gridPanel.add(button[i][j]);
			}
		}
		setShipIcons();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		panel.add(new JLabel("Player 1: "));
		ships = 5;
		shipLabel_1 = new JLabel("" + ships);
		panel.add(shipLabel_1);
		shipLabel_1.setName("ships_1");
		/* button = new JButton("Restart");
		button.addActionListener(this);
		panel.add(button);
		*/
		panel.add(new JLabel("Player 2: "));
		shipLabel_2 = new JLabel();
		panel.add(shipLabel_2);
		shipLabel_2.setName("ships_2");
		setLayout(new BorderLayout(3, 1));
		add(gridAIPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(gridPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {
	if(player_enabled){
		JButton button_temp = new JButton();
		button_temp = event.getSource();
		Point p = findSourceIndex(event);
		if(grid_AI.isEmpty(p.x, p.y)) {
			grid_AI.isMiss(p.x, p.y);
			button_AI[p.x][p.y].setEnabled(false);
			player_enabled = false;
			AI();
		}
		if(grid_AI.isShip(p.x, p.y)) {
			grid_AI.isHit(p.x, p.y);
			button_AI[p.x][p.y].setEnabled(false);
			player_enabled = false;
			AI();
		}
	}
	}
	
	 private Point findSourceIndex(ActionEvent event) {
		Point p = event.getPoint();
		Component c = (Component)event.getSource();
		if(c.getName().startsWith("cell")){
			String s = c.getName();
			Scanner scanner = new Scanner(s);
			scanner.useDelimiter(":");
			scanner.next();
			p.x = scanner.nextInt();
			p.y = scanner.nextInt();
		}	
        return p;
    }

	public void AI() {
		Random random = new Random();
		int x = random.nextInt(10);
		int y = random.nextInt(10);
		if(button[x][y].isEnabled()) {
			if(grid.isEmpty(x, y)) {
				grid.isMiss(x, y);
				button[x][y].setEnabled(false);
				player_enabled = true;
				AI();
			}
			if(grid.isShip(x, y)) {
				grid.isHit(x, y);
				button[x][y].setEnabled(false);
				player_enabled = true;
				AI();
			}
		}
		else{
			AI();
		}	
	}
		public void setShipIcons(){
		int shipIcon;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < ship[i].getHealth(); j++){
				if(ship[i].getShipType() == Ship.ShipType.CARRIER){
					shipIcon = 5;
					Point p = Grid.findLocation(grid.ship[i].location[j]);
					if(ship[i].getShipType().getVertical()){
						
					}
					else{
						if(shipIcon == 5){
							button[p.x][p. y].setIcon(CARRIER_ICON1);
							shipIcon--;
						}	
						else if(shipIcon == 4){
							button[p.x][p.y].setIcon(CARRIER_ICON2);
							shipIcon--;
						}	
						else if(shipIcon == 3){
							button[p.x][p.y].setIcon(CARRIER_ICON3);
							shipIcon--;
						}
						else if(shipIcon == 2){
							button[p.x][p.y].setIcon(CARRIER_ICON4);
							shipIcon--;
						}	
						else {
							button[p.x][p.y].setIcon(CARRIER_ICON5);
						}	
					}
				}
				if(ship[i].getShipType() == Ship.ShipType.BATTLESHIP){
					shipIcon = 4;
					Point p = Grid.findLocation(grid.ship[i].location[j]);
					if(ship[i].getShipType().getVertical()){
						
					}
					else{
						if(shipIcon == 4){
							button[p.x][p. y].setIcon(BATTLESHIP_ICON1);
							shipIcon--;
						}	
						else if(shipIcon == 3){
							button[p.x][p.y].setIcon(BATTLESHIP_ICON2);
							shipIcon--;
						}	
						else if(shipIcon == 2){
							button[p.x][p.y].setIcon(BATTLESHIP_ICON3);
							shipIcon--;
						}
						else {
							button[p.x][p.y].setIcon(BATTLESHIP_ICON4);
						}	
					}
				}
				if(ship[i].getShipType() == Ship.ShipType.CRUISER){
					shipIcon = 3;
					Point p = Grid.findLocation(grid.ship[i].location[j]);
					if(ship[i].getShipType().getVertical()){
						
					}
					else{
						if(shipIcon == 3){
							button[p.x][p. y].setIcon(CRUISER_ICON1);
							shipIcon--;
						}	
						else if(shipIcon == 2){
							button[p.x][p.y].setIcon(CRUISER_ICON2);
							shipIcon--;
						}
						else {
							button[p.x][p.y].setIcon(CRUISER_ICON3);
						}
					}
				}
				if(ship[i].getShipType() == Ship.ShipType.SUBMARINE){
					shipIcon = 3;
					Point p = Grid.findLocation(grid.ship[i].location[j]);
					if(ship[i].getShipType().getVertical()){
						
					}
					else {
						if(shipIcon == 3){
							button[p.x][p. y].setIcon(SUBMARINE_ICON1);
							shipIcon--;
						}	
						else if(shipIcon == 2){
							button[p.x][p.y].setIcon(SUBMARINE_ICON2);
							shipIcon--;
						}
						else {
							button[p.x][p.y].setIcon(SUBMARINE_ICON3);
						}
					}
				}
				if(ship[i].getShipType() == Ship.ShipType.DESTROYER){
					shipIcon = 3;
					Point p = Grid.findLocation(grid.ship[i].location[j]);
					if(ship[i].getShipType().getVertical()){
						
					}
					else{
						if(shipIcon == 2){
							button[p.x][p. y].setIcon(DESTROYER_ICON1);
							shipIcon--;
						}	
						else {
							button[p.x][p.y].setIcon(DESTROYER_ICON2);
						}
					}
				}
			}
		}	
	}
	
	
	// make it rain ships, add icons to when ships are shot and shit, change icons of places that have ships, finish AI, set icons for player ships on ther side so they can know what the fuck is going on
}