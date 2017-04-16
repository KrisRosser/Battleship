package quadcitydjs;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* I am thnking that this class will handle the GUI much like minesweeper. I also believe that we should use
the enable option should be used to distinguish between the two players. Maybe add a player_enable and AI_enable. I also think this class
should house the code for the AI as well. I am also kinda thinking about using the observable even though I really do not want to.*/
public class Battleship extends JPanel implements ActionListener, MouseListener, Observer {
	
	private final ImageIcon CARRIER_ICON = new ImageIcon(getClass().getClassLoader().getResource("carrier.png"));
    private final ImageIcon BATTLESHIP_ICON = new ImageIcon(getClass().getClassLoader().getResource("battleship.png"));
	private final ImageIcon CRUISER_ICON = new ImageIcon(getClass().getClassLoader().getResource("cruiser.png"));
    private final ImageIcon SUBMARINE_ICON = new ImageIcon(getClass().getClassLoader().getResource("submarine.png"));
	private final ImageIcon DESTROYER_ICON = new ImageIcon(getClass().getClassLoader().getResource("destroyer.png"));
	
	private Grid grid;
	private Grid gridAI;
	private JLabel[][] AI_tile;
	private JLabel[][] tile;
	private int shipCount;
	private int ships;
	private boolean enabled;
	private JLabel shipLabel_1;
	private JLabel shipLabel_2;
	
	public Battleship() {
		this(10,10);
	}
	
	public Battleship(int height, int width) {
		gridAI = new Grid(height, width, true);
		gridAI.addObserver(this);
		JPanel gridAIPanel = new JPanel();
		gridAIPanel.setLayout(new GridLayout(height, width));
		AI_tile = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				AI_tile[i][j] = new JLabel();
				AI_tile[i][j].setName("cell:" + i + ":" + j);
				AI_tile[i][j].setPreferredSize(new Dimension(50,50));
				AI_tile[i][j].setHorizontalAlignment(0);
				AI_tile[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(AI_tile[i][j]);
				AI_tile[i][j].addMouseListener(this);
				gridAIPanel.add(AI_tile[i][j]);
			}
		}
		grid = new Grid(height, width);
		grid.addObserver(this);
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(height, width));
		tile = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				tile[i][j] = new JLabel();
				tile[i][j].setName("cell:" + i + ":" + j);
				tile[i][j].setPreferredSize(new Dimension(50,50));
				tile[i][j].setHorizontalAlignment(0);
				tile[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(tile[i][j]);
				tile[i][j].addMouseListener(this);
				gridPanel.add(tile[i][j]);
			}
		}
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
	
	public void placeFleet() {
		Random random = new Random();
		
		
	}
	
	public void update(Observable o, Object arg) {
		
	}

	public void mouseClicked(MouseEvent event) {
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
	}
	
	public void mousePressed(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
	
}