package Client.Gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import Server.DataBase.User;


import Client.Gui.HomePanelAdmin;
import Client.Gui.JLinkButton;
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
	public void initAdmin(){	
		removeAll();
		JLinkButton home = new JLinkButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new HomePanelAdmin(clientFrame));
			}
		});
		
		this.add(home);
		JLinkButton EditCoach = new JLinkButton("Edit Coach");
		EditCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new EditCoachPanel(clientFrame));
			}
		});
		JLinkButton CreateNewCoach = new JLinkButton("Create New Coach");
		CreateNewCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new CreateNewCoachPanel(clientFrame));
			}
		});
		JLinkButton EditTeam = new JLinkButton("Edit Team");
		EditTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new EditTeamPanel(clientFrame));
			}
		});
		JLinkButton CreateNewTeam = new JLinkButton("Create New Team");
		CreateNewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new CreateNewTeamPanel(clientFrame));
			}
		});
		JLinkButton AddTrainingMethod = new JLinkButton("Add Training Method");
		AddTrainingMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AddTrainingMethodPanel(clientFrame));
			}
		});
		JLinkButton RemoveTrainingMethod = new JLinkButton("Remove Training Method");
		RemoveTrainingMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new RemoveTrainingMethodPanel(clientFrame));
			}
		});
	this.add(EditCoach);
	this.add(CreateNewCoach);
	this.add(EditTeam);
	this.add(CreateNewTeam);
	this.add(AddTrainingMethod);
	this.add(RemoveTrainingMethod);
	
	
	clientFrame.setVisible();
}
	
	public void clearSideBar(){
		this.removeAll();
		clientFrame.setVisible();
	}
	
	
	
	

}
