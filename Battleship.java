/* I am thnking that this class will handle the GUI much like minesweeper. I also believe that we should use
the enable option should be used to distinguish between the two players. Maybe add a player_enable and AI_enable. I also think this class
should house the code for the AI as well. I am also kinda thinking about using the observable even though I really do not want to.*/
public class Battleship extends JFrame implements ActionListener, Observable {
	
	private final ImageIcon CARRIER_ICON = new ImageIcon(getClass().getClassLoader().getResource("carrier.png"));
    private final ImageIcon BATTLESHIP_ICON = new ImageIcon(getClass().getClassLoader().getResource("battleship.png"));
	private final ImageIcon CRUISER_ICON = new ImageIcon(getClass().getClassLoader().getResource("cruiser.png"));
    private final ImageIcon SUBMARINE_ICON = new ImageIcon(getClass().getClassLoader().getResource("submarine.png"));
	private final ImageIcon DESTROYER_ICON = new ImageIcon(getClass().getClassLoader().getResource("destroyer.png"));
	
	private Grid grid;
}
