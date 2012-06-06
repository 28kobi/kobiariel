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
import java.sql.SQLException;
import java.awt.Font;

public class SideBar extends JPanel {
	
	/**
	 * containg all different buttons for all different user type , by clicking the buttons,
	 * the panel the user assked for will be set on screen.
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
		setBackground(Color.lightGray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initLogin();
	}
	
	public void initLogin(){
		JLinkButton login = new JLinkButton("Login");
		login.setLinkColor(Color.BLUE);
		login.setFont(new Font("Arial", Font.PLAIN, 15));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new LogInPanel(clientFrame));
			}
		});
		this.add(login);
		JLinkButton loginSettings = new JLinkButton("Settings");
		loginSettings.setText("Setting");
		loginSettings.setFont(new Font("Arial", Font.PLAIN, 15));
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
		JLinkButton AddActivityMethod = new JLinkButton("Add Activity Type");
		AddActivityMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AddActivityMethodPanel(clientFrame));
			}			
		});
		JLinkButton RemoveActivityMethod = new JLinkButton("Remove Activity Type");
		RemoveActivityMethod.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		clientFrame.swap(new RemoveActivityMethodPanel(clientFrame));
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
	
	this.add(CreateNewCoach);
	this.add(EditCoach);
	this.add(EditTeam);
	this.add(CreateNewTeam);
	this.add(AddActivityMethod);
	//this.add(RemoveActivityMethod);
	this.add(AddTrainingMethod);
	//this.add(RemoveTrainingMethod);
	clientFrame.setVisible();
}
	
	public void initCoach(){	
		removeAll();
		JLinkButton home = new JLinkButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new HomePanelCoach(clientFrame));
			}
		});
		this.add(home);
		JLinkButton createAthlete = new JLinkButton("Create New Athlete");
		createAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new CreateNewAthletePanel(clientFrame));
			}
		});
		JLinkButton addAthleteToTeam = new JLinkButton("Add Athlete To Team");
		addAthleteToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new AddAthleteToTeamPanel(clientFrame));
			}
		});
		JLinkButton EditAthleteInfo = new JLinkButton("Edit Athlete Info");
		EditAthleteInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new EditAthletePanel(clientFrame));
			}
		});
		JLinkButton RemoveAthleteFromTeam = new JLinkButton("Remove Athlete From Team");
		RemoveAthleteFromTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new RemoveAthleteFromTeamPanel(clientFrame));
			}
		});
		JLinkButton createNewTraining = new JLinkButton("Creat New Training");
		createNewTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new CreateNewTrainingPanel(clientFrame));
			}
		});
		JLinkButton EditTraingin = new JLinkButton("Edit Training");
		EditTraingin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new EditTrainingPanel(clientFrame));			
			}
		});
		JLinkButton CoachViewPlannedTraining = new JLinkButton("View Planned Training");
		CoachViewPlannedTraining.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			clientFrame.swap(new ViewPlannedTrainingPanel(clientFrame));
			}
		});
		JLinkButton ViewPerformedTraining = new JLinkButton("View Preformed Personal Training");
		ViewPerformedTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new ViewPerformedTrainingPanel(clientFrame));			
			}
		});
		JLinkButton ViewPerformedTeamTraining = new JLinkButton("View Preformed Team Training");
		ViewPerformedTeamTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new ViewPerformedTeamTrainingPanel(clientFrame));			
			}
		});
		JLinkButton ViewStatistic = new JLinkButton("View Statistic");
		ViewStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new coachViewStatisticPanel(clientFrame));			
			}
		});
		
		
	this.add(createAthlete);
	this.add(addAthleteToTeam);
	this.add(EditAthleteInfo);
	this.add(createNewTraining);
	this.add(EditAthleteInfo);
	this.add(EditTraingin);
	this.add(CoachViewPlannedTraining);
	this.add(ViewPerformedTraining);
	this.add(ViewPerformedTeamTraining);
	this.add(ViewStatistic);
	this.add(RemoveAthleteFromTeam);
	clientFrame.setVisible();
}
	
	public void initAtlete(){	
		removeAll();
		JLinkButton home = new JLinkButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientFrame.swap(new HomePanelAthlete(clientFrame));
			}
		});
		this.add(home);
		JLinkButton viewPlannedTraining = new JLinkButton("View Planned Training");
		viewPlannedTraining.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		clientFrame.swap(new AthleteViewPlannedTrainingPanel(clientFrame));
			}
		});
		JLinkButton viewPerformedTraining = new JLinkButton("View Preformed Training");
		viewPerformedTraining.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		clientFrame.swap(new AthleteViewPerformedTrainingPanel(clientFrame));
		
			}
		});
		JLinkButton ViewStatisticInfo = new JLinkButton("View Statistic Info");
		ViewStatisticInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		clientFrame.swap(new AthleteViewStatisticInfoPanel(clientFrame));
			}
		});
		JLinkButton ReportTraining = new JLinkButton("Report Training");
		ReportTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			clientFrame.swap(new AthleteReportTrainingPanel(clientFrame));
			}
		});
		
	this.add(viewPlannedTraining);
	this.add(viewPerformedTraining);
	this.add(ViewStatisticInfo);
	this.add(ReportTraining);
	
	clientFrame.setVisible();
}
	
	public void clearSideBar(){
		this.removeAll();
		clientFrame.setVisible();
	}
	
	
	
	

}
