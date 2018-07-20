package game_intro;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class GameFrame extends JFrame implements GameConstants {
	 Logger logger = Logger.getLogger(GameFrame.class);
	public GameFrame(){
		 logger.debug("Inside GameFrame constructor");
		setSize(GAME_WIDTH,GAME_HEIGHT);
		Board board = new Board();
		add(board);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Dragon Ballz 2017");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		 
		new GameFrame();
     
	}

}