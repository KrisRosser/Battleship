package quadcitydjs;
import java.util.*;

/* I am thnking that this class will handle the GUI much like minesweeper. I also believe that we should use
the enable option should be used to distinguish between the two players. Maybe add a player_enable and AI_enable. I also think this class
should house the code for the AI as well. I am also kinda thinking about using the observable even though I really do not want to.*/
/*public class Battleship extends JFrame implements ActionListener, Observable {
	
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
	private JLabel ships;
	private boolean enabled;
	
	public Battleship() {
		this(10,10);
	}
	
	public Battleship() {
		gridAI = new Grid(height, width, true);
		gridAI.addObserver(this);
		JPanel gridAIPanel = new JPanel();
		gridAIPanel.setLayout(new GridLayout(height, width));
		tile = new JLabel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				AI_tile[i][j] = new JLabel();
				AI_tile[i][j] = setName("cell:" + i + ":" + j);
				AI_tile[i][j].setPreferredSize(new Dimension(50,50));
				AI_tile[i][j].setHorizontalAlignment(0);
				AI_tile[i][j].setBorder(Borderfactory.createRaisedBevelBored());
				add(tile[i][j]);
				tile[i][j].addMouseListener(this);
				gridAIPanel.add(tile[i][j]);
			}
		}
	}
	
	public void placeFleet() {
		Random random = new Random();
		
		
	}
	
}*/