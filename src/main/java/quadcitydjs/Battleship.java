package quadcitydjs;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Point;


public class Battleship extends JPanel implements ActionListener {
	
	
	private Grid grid;
	private Grid gridAI;
	private JButton[][] AI_button;
	private JLabel[][] button;
	private int shipCount;
	private int ships;
	private int AI_ships;
	private int player_win;
	private int AI_win;
	private boolean player_enabled;
	private boolean AI_enabled;
	private JLabel shipLabel_1;
	private JLabel shipLabel_2;
	private JLabel text;
	
	public Battleship() {
		this(10,10);
	}
	
	public Battleship(int height, int width) {
		player_win = 0;
		AI_win = 0;
		player_enabled = true;
		AI_enabled = false;
		gridAI = new Grid(height, width, true);
		JPanel gridAIPanel = new JPanel();
		gridAIPanel.setLayout(new GridLayout(height, width));
		AI_button = new JButton[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				AI_button[i][j] = new JButton();
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
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(height, width));
		button = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				button[i][j] = new JLabel();
				button[i][j].setName("cell:" + i + ":" + j);
				button[i][j].setPreferredSize(new Dimension(50,50));
				button[i][j].setHorizontalAlignment(0);
				button[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(button[i][j]);
				gridPanel.add(button[i][j]);
			}
		}
		setShipIcons();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(new JLabel("<== AI"));
		ships = 5;
		shipLabel_1 = new JLabel("");
		panel.add(shipLabel_1);
		shipLabel_1.setName("ships_1");
		panel.add(new JLabel("Player ==> "));
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new GridLayout(1,3));
		shipLabel_2 = new JLabel("Message Field");
		messagePanel.add(shipLabel_2);
		shipLabel_2.setName("ships_2");
		JLabel blank = new JLabel();
		messagePanel.add(blank);
		text = new JLabel("Message Field");
		messagePanel.add(text);
		setLayout(new BorderLayout(3, 2));
		add(gridAIPanel, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);
		add(gridPanel, BorderLayout.EAST);
		add(messagePanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {
	if(player_enabled){
		JButton button_temp = new JButton();
		button_temp = (JButton)event.getSource();
		Point p = findSourceIndex(event);
		if(gridAI.isEmpty(p.x, p.y)) {
			gridAI.isMiss(p.x, p.y);
			AI_button[p.x][p.y].setText("M");
			AI_button[p.x][p.y].setEnabled(false);
			text.setText("Player fired and missed!");
			player_enabled = false;
			getResult();
			AI();
		}
		if(gridAI.isShip(p.x, p.y)) {
			gridAI.isHit(p.x, p.y);
			AI_button[p.x][p.y].setText("X");
			AI_button[p.x][p.y].setEnabled(false);
			text.setText("Player fired and hit a ship!");
			player_enabled = false;
			player_win++;
			getResult();
			AI();
		}
	}
	}
	 private Point findSourceIndex(ActionEvent event) {
		Point p = new Point();
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
				button[x][y].setText("M");
				button[x][y].setEnabled(false);
				shipLabel_2.setText("AI fired and missed!");
				getResult();
				player_enabled = true;
			}
			if(grid.isShip(x, y)) {
				grid.isHit(x, y);
				button[x][y].setText("X");
				button[x][y].setEnabled(false);
				AI_win++;
				shipLabel_2.setText("AI fired and it was a hit!");
				getResult();
				player_enabled = true;
			}
		}
		else{
			AI();
		}	
	}
	private void getResult(){
		if(player_win == 17){
			JOptionPane pane = new JOptionPane();
			JOptionPane.showMessageDialog(null, "You Won!");
		}
		else if(AI_win == 17){
			JOptionPane pane = new JOptionPane();
			JOptionPane.showMessageDialog(null, "You Lost!");	
		}	
	}	
	public void setShipIcons(){
		int shipIcon;
		Ship[] ship = grid.getShipArray();
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < ship[i].getHealth(); j++){
				Location[] location = ship[i].getLocation();
				shipIcon = 5;
				if(ship[i].getShipType() == Ship.ShipType.CARRIER){
					int r = location[j].getRow();
					int c = location[j].getCol();
					button[r][c].setText("C" + j);
				}
				if(ship[i].getShipType() == Ship.ShipType.BATTLESHIP){
					int r = location[j].getRow();
					int c = location[j].getCol();
					button[r][c].setText("B" + j);
				}
				if(ship[i].getShipType() == Ship.ShipType.CRUISER){
					int r = location[j].getRow();
					int c = location[j].getCol();
					button[r][c].setText("CR" + j);
				}	
				if(ship[i].getShipType() == Ship.ShipType.SUBMARINE){
					int r = location[j].getRow();
					int c = location[j].getCol();
					button[r][c].setText("S" + j);
				}	
				if(ship[i].getShipType() == Ship.ShipType.DESTROYER){
					int r = location[j].getRow();
					int c = location[j].getCol();
					button[r][c].setText("D" + j);
				}	
			}
		}	
	}
	
	
	
	
}