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

public class LogInPanel extends MyJPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField userName;
	JPasswordField password;
	JButton btnSubmit;
	JLabel lblNewLabel;
	private JLabel lblLogo;
	
	
	public LogInPanel( ClientIF client) {
		super(PanelType.LOGIN_PANEL, client);
		setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(187, 140, 134, 20);
		add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(187, 186, 134, 20);
		add(password);
		password.setColumns(10);
		
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("images"+ File.separator+"login.jpg"));
		
			JLabel lblLogin = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblLogin.setBounds(29, 0, 306, 127);
			add(lblLogin);
		
			BufferedImage myPic2 = ImageIO.read(new File("images"+ File.separator+"baglama_logo_v1.png"));
			lblLogo = new JLabel(new ImageIcon(myPic2), JLabel.CENTER);
			lblLogo.setBounds(651, 413, 208, 113);
			add(lblLogo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(50, 143, 82, 14);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 189, 82, 14);
		add(lblPassword);
		
		btnSubmit = new JButton("Submit");
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
		btnSubmit.setBounds(232, 241, 89, 23);
		add(btnSubmit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(50, 274, 668, 104);
		add(lblNewLabel);
		
		
		
	}
	
	


	@Override
	public MyJPanel pushPanel() {
		return new LogInPanel(getClient());
	}
}
