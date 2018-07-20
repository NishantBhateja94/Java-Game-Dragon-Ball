package users;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game_intro.MainMenuScreen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
 private MainMenuScreen mainScreenObject;

//	public static void main(String[] args) {
//
//		LoginScreen frame = new LoginScreen();
//		frame.setVisible(true);
//	}


	public LoginScreen(MainMenuScreen mainScreenObject) {
		this.mainScreenObject=mainScreenObject;
		setTitle("Login Screen");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblUserid.setBounds(45, 22, 91, 25);
		contentPane.add(lblUserid);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblPassword.setBounds(45, 75, 111, 25);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(153, 22, 179, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(153, 77, 179, 26);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
				//doLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("login.png")));
		btnLogin.setBounds(39, 109, 153, 48);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(LoginScreen.class.getResource("exit.png")));
		btnReset.setBounds(231, 109, 153, 48);
		contentPane.add(btnReset);
	}
	private void doLogin(){
		String userid = textField.getText();
		String password = passwordField.getText();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		String message = null;		

		try {
			message = UserFileOperations.objectRead(userDTO);
			if(message.startsWith("Welcome")){
				this.setVisible(false);
				this.dispose();
				MainMenuScreen.mnGames.setEnabled(true);
			}
			JOptionPane.showMessageDialog(this, message);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Some Problem Occur During Login");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Some Problem Occur During Login");
			//e.printStackTrace();
		}
	}
	void checkLogin(){
		String userid =textField.getText();
		String password = passwordField.getText();
		if(userid.equals(password)){
			JOptionPane.showMessageDialog(this, "Welcome " +userid);
			mainScreenObject.setTitle("Welcome"+userid);
			mainScreenObject.prepareTitle();
			mainScreenObject.doTitleAnimation();
			MainMenuScreen.mnGames.setEnabled(true);
			this.setVisible(false);
			this.dispose();
		}
		else{
			JOptionPane.showMessageDialog(this, "INVALID USER ID");
		}
	}
}

