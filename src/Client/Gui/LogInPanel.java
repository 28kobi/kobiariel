package Client.Gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Server.Message.MessageLogin;
import Server.Message.MessageLoginReplay;

import java.awt.Color;

import Client.Logic.ClientIF;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

public class LogInPanel extends MyJPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField userName;
	JPasswordField password;
	JButton btnSubmit;
	JLabel lblNewLabel;
	
	
	public LogInPanel( ClientIF client) {
		super(PanelType.LOGIN_PANEL, client);
		setLayout(null);
		
		userName = new JTextField();
		userName.setFont(new Font("Arial", Font.PLAIN, 15));
		userName.setBounds(187, 140, 134, 25);
		add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(187, 186, 134, 25);
		add(password);
		password.setColumns(10);
		
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"login.jpg"));
		
			BufferedImage myPic2 = ImageIO.read(new File("image"+ File.separator+"logo_isoa.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUserName.setBounds(50, 143, 82, 25);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(50, 189, 82, 14);
		add(lblPassword);
		
		btnSubmit = new JButton("Login");
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					getClient().initcon();
					@SuppressWarnings("deprecation")
					MessageLogin msg = new MessageLogin(userName.getText(), password.getText());
					getClient().sendMsgToServer(msg);
					MessageLoginReplay replay = (MessageLoginReplay) getClient().getMessageFromServer();
					if (replay.isPass()) {
						System.out.print("pass login");
						getClient().login(replay.getUser());
					}
					else {
						System.out.println("fail login");
						lblNewLabel.setText(replay.getMsg());
					}
				} catch (IOException e) {
					lblNewLabel.setText("Server not found");
				}
			}
		});
		btnSubmit.setBounds(212, 242, 89, 30);
		add(btnSubmit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(50, 275, 668, 104);
		add(lblNewLabel);
		
		
		
	}
	
	


	@Override
	public MyJPanel pushPanel() {
		return new LogInPanel(getClient());
	}
}
