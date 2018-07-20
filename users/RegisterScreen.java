package users;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JFrame {
	JLabel strongweaklbl = new JLabel("");
	private JPanel contentPane;
	private JTextField useridtxt;
	private JPasswordField pwdtxt;
	private JPasswordField passwordField2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//					RegisterScreen frame = new RegisterScreen();
//					frame.setVisible(true);
//				
//	}

	/**
	 * Create the frame.
	 */
	public RegisterScreen() {
		setResizable(false);
		setTitle("Register Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(25, 31, 74, 16);
		contentPane.add(lblUserid);
		
		useridtxt = new JTextField();
		useridtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					pwdtxt.requestFocus();
				}
			}
		});
		useridtxt.setBounds(125, 26, 167, 26);
		contentPane.add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 69, 61, 16);
		contentPane.add(lblPassword);
		
		pwdtxt = new JPasswordField();
		pwdtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				strongWeakPwdCheck();
			}
		});
		pwdtxt.setBounds(125, 64, 167, 26);
		contentPane.add(pwdtxt);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(125, 113, 167, 26);
		contentPane.add(passwordField2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(6, 118, 141, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(25, 167, 61, 16);
		contentPane.add(lblGender);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnMale = new JRadioButton("Male");
		bg.add(rdbtnMale);
		rdbtnMale.setBounds(117, 163, 74, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		bg.add(rdbtnFemale);
		rdbtnFemale.setBounds(217, 163, 141, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(25, 214, 61, 16);
		contentPane.add(lblCity);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Delhi");
		comboBox.addItem("Mumbai");
		comboBox.setBounds(131, 210, 141, 27);
		contentPane.add(comboBox);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRegister();
			}
		});
		btnRegister.setBounds(19, 347, 117, 29);
		contentPane.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(131, 347, 117, 29);
		contentPane.add(btnReset);
		
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(25, 260, 99, 16);
		contentPane.add(lblStreetAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(141, 260, 167, 75);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(141, 249, 174, 99);
		contentPane.add(scrollPane);
		
		
		strongweaklbl.setBounds(117, 90, 131, 16);
		contentPane.add(strongweaklbl);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(289, 29, 14, 16);
		contentPane.add(lblNewLabel);
	}
	private void doRegister(){
		String userid = useridtxt.getText();
	String pwd = pwdtxt.getText();
	
	
	// Fill All the Values in Object
	UserDTO userDTO = new UserDTO();
	userDTO.setUserid(userid);
	userDTO.setPassword(pwd);
	
	String city = null;
	userDTO.setCity(city);
	String streetAddress = null;
	userDTO.setStreetAddress(streetAddress);
	String message=null;
	try {
		message = UserFileOperations.objectWrite(userDTO);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, "Some Problem Occur During Register Operation....");
	}
	JOptionPane.showMessageDialog(this, message);
}
	private void strongWeakPwdCheck(){
		String data = pwdtxt.getText();
		if(data.length()<5){
			strongweaklbl.setForeground(Color.RED);
			strongweaklbl.setText("Weak");
		}
		else
			if(data.length()>=5 && data.length()<=10){
				strongweaklbl.setForeground(Color.YELLOW);
				strongweaklbl.setText("Average");
			}	
			else
				if(data.length()>10 ){
					strongweaklbl.setForeground(Color.GREEN);
					strongweaklbl.setText("STRONG");
				}	
	}
}
