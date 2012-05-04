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
		/*
		this.add(home);
		JLinkButton addClass = new JLinkButton("Add Class");
		addClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AddClassPanel(clientFrame));
			}
		});
		JLinkButton assignStudentToClass = new JLinkButton("Assign Student to Class");
		assignStudentToClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AssignStudentToClassPanel(clientFrame));
			}
		});
		JLinkButton changeTeacher = new JLinkButton("Change Teacher");
		changeTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new ChangeTeacherPanel(clientFrame));
			}
		});
		JLinkButton openSemster = new JLinkButton("Open Semster");
		openSemster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new OpenSemesterPanel(clientFrame));
			}
		});
		JLinkButton removeStudentFromCourse = new JLinkButton("Remove Student From Course");
		removeStudentFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new RemoveStudentFromCoursePanel(clientFrame));
			}
		});
		JLinkButton assignStudentToCourse = new JLinkButton("Assign Student to Course");
		assignStudentToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AssignStudentToCoursePanel(clientFrame));
			}
		});
	this.add(addClass);
	this.add(assignStudentToClass);
	this.add(changeTeacher);
	this.add(openSemster);
	this.add(removeStudentFromCourse);
	this.add(assignStudentToCourse);
	
	*/
	clientFrame.setVisible();
}
	
	public void clearSideBar(){
		this.removeAll();
		clientFrame.setVisible();
	}
	
	
	
	

}
