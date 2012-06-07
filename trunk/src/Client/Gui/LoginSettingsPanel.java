package Client.Gui;

import Client.Logic.ClientIF;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

public class LoginSettingsPanel extends MyJPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	public LoginSettingsPanel( ClientIF client) {
		super(PanelType.LOGIN_SETTING_PANEL, client);
		
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("images"+ File.separator+""));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Host:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(57, 74, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(121, 71, 139, 25);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(121, 106, 139, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPort.setBounds(57, 109, 46, 14);
		add(lblPort);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setForeground(Color.BLUE);
		btnConnect.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getClient().initConnection(textField.getText(), Integer.parseInt(textField_1.getText()));
					getClient().swap(new LogInPanel(getClient()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnConnect.setBounds(143, 175, 102, 30);
		add(btnConnect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyJPanel pushPanel() {
		return new LoginSettingsPanel(getClient());
	}
}
