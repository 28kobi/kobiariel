package Client.Gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import Server.DataBase.User;

import Client.Logic.ClientIF;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClientIF clientFrame;
	private User user;
	
	
	public void setUser(User user) {
		this.user = user;
	}

	public SideBar(ClientIF clientFrame, User user) {
		this.clientFrame = clientFrame;
		this.user = user;
		setBorder(new EmptyBorder(5, 10, 5, 30));
		setBackground(Color.cyan);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initLogin();
	}
	
	public void initLogin(){
		JLinkButton login = new JLinkButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new LogInPanel(clientFrame));
			}
		});
		this.add(login);
		JLinkButton loginSettings = new JLinkButton("Settings");
		loginSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new LoginSettingsPanel(clientFrame));
			}
		});
		this.add(loginSettings);
	}
	
	public void clearSideBar(){
		this.removeAll();
		clientFrame.setVisible();
	}
	
	
	
	

}
