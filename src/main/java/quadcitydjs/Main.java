package quadcitydjs;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		Battleship board = null;
        if(args.length == 0) {
            board = new Battleship();
        }
        else if(args.length == 2) {
            board = new Battleship(Integer.parseInt(args[0]),
                                    Integer.parseInt(args[1]));
        }
        if(board == null) {
            System.out.println("You must either specify all of width/height/mines or none (default 8/8/10).");
        }
        else {
            JFrame win = new JFrame("Battleship");
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.add(board);
            win.pack();
            win.setVisible(true);
        }
	}
	
}