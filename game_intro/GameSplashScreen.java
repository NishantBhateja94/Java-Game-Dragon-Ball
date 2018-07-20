package game_intro;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import jaco.mp3.player.MP3Player;
public class GameSplashScreen extends JWindow {
	 Logger logger = Logger.getLogger(GameSplashScreen.class);
    JProgressBar progressBar = new JProgressBar();
	private JPanel contentPane;
	boolean isVisible ;
	Timer timer;
	int progressCount ;
	MP3Player mp3;
	private void playSound(){
		mp3 = new MP3Player(GameSplashScreen.class.getResource("song.mp3"));
		mp3.play();
	}
	
	private void doAnimation(){
		timer  = new Timer(150,(e)->{
			//titlelbl.setVisible(isVisible);
			isVisible = !isVisible;
			progressBar.setValue(progressCount);
			progressCount++;
			if(progressCount>100){
				timer.stop();
				GameSplashScreen.this.setVisible(false);
				GameSplashScreen.this.dispose();
				mp3.stop();
				MainMenuScreen menu = new MainMenuScreen();
				menu.setVisible(true);
			}
		});

		timer.start();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		           	GameSplashScreen frame = new GameSplashScreen();
					frame.setVisible(true);
					frame.playSound();
					frame.doAnimation();
				
	}
	static ImageIcon bg;
	private final JLabel lblNewLabel = new JLabel("Dragon Ball Z");
	static{
		bg = new ImageIcon(GameSplashScreen.class.getResource("dragon.png"));
	}

	public GameSplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logger.debug("Inside Splash Screen Constructor");
		setSize( 450, 395);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		progressBar.setBounds(16, 298, 411, 20);
		contentPane.add(progressBar);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(98, 345, 238, 26);
		
		contentPane.add(lblNewLabel);
		
		JLabel mainimage = new JLabel("");
		mainimage.setBorder(new LineBorder(Color.MAGENTA, 3));
		mainimage.setIcon(new ImageIcon(GameSplashScreen.class.getResource("/game_intro/Dragon.gif")));
		mainimage.setBounds(10, 0, 438, 280);
		contentPane.add(mainimage);
	}
}
