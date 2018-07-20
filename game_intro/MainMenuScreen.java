package game_intro;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import users.LoginScreen;
import users.RegisterScreen;

public class MainMenuScreen extends JFrame {
public static JMenu mnGames = new JMenu("Games");
private boolean isTitlePresent;
	private JPanel contentPane;
	private Timer timer;
private String title ="                                                                                                  ";
StringBuffer sb = new StringBuffer();
public void prepareTitle(){
	if(this.getTitle().trim().length()>0&& !isTitlePresent){
		title +=this.getTitle();
		isTitlePresent = true;
		this.setTitle(title);
		sb.append(title);
	}
}
public void doTitleAnimation(){
	timer= new Timer(100,(e)->{
		if(isTitlePresent){
			char singleChar=title.charAt(0);
		  sb.append(singleChar);
		  sb.deleteCharAt(0);
		  //System.out.println("["+sb+"]");
		  this.setTitle(sb.toString());
		}
	});
	timer.start();
}
	
	public MainMenuScreen() {
		setTitle("Gaming Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(MainMenuScreen.class.getResource("/game_intro/thumb-1920-564835.jpg")));
		lblNewLabel.setBounds(0, 0, 1362, 684);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadLoginScreen();
			}
		});
		mntmLogin.setIcon(new ImageIcon(MainMenuScreen.class.getResource("login.png")));
		mnFile.add(mntmLogin);
		mnFile.addSeparator();
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRegisterScreen();
			}
		});
		mntmRegister.setIcon(new ImageIcon(MainMenuScreen.class.getResource("register.png")));
		mnFile.add(mntmRegister);
		mnFile.addSeparator();
		
//		JMenu mnGames = new JMenu("Games");
		mnGames.setEnabled(false);
		mnGames.setIcon(new ImageIcon(MainMenuScreen.class.getResource("game.png")));
		mnFile.add(mnGames);
		mnFile.addSeparator();
		JMenuItem mntmMario = new JMenuItem("DRAGON BALL  Z");
		mntmMario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			callDragon();
			}
		});
		mnGames.add(mntmMario);
		mnGames.addSeparator();
		JMenuItem mntmDave = new JMenuItem("Dave ");
		mnGames.add(mntmDave);
		mnGames.addSeparator();
		mnFile.addSeparator();
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit(0);
			}

			private void exit(int i) {
				System.exit(0);
				
			}
		});
		mntmExit.setIcon(new ImageIcon(MainMenuScreen.class.getResource("exit.png")));
		mnFile.add(mntmExit);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	private void callDragon(){
		GameFrame obj = new GameFrame();
		//obj.setVisible(true);
	}
	private void loadLoginScreen(){
		LoginScreen loginScreen = new LoginScreen(this);
		loginScreen.setVisible(true);
	}
	private void loadRegisterScreen(){
		RegisterScreen registerScreen = new RegisterScreen();
		registerScreen.setVisible(true);
	}
}