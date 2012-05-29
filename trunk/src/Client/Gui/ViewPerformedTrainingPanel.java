
package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;

import Client.Logic.ClientIF;


public class ViewPerformedTrainingPanel extends MyJPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining teamTraining;
	private plannedteamtraining updatedTraining;
	private plannedpersonaltraining updatedTraining1;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private plannedpersonaltraining AthletTraining;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private JRadioButton rdbtnPersonalTraining;
	private JLabel lblChooseTraining;
	private User Athlete;
	private Team team1;
	private activitytype activityType;
	private JComboBox comboBoxAthlete;
	private JComboBox comboBoxTraining;
	
	private JButton btnW ;
	private JLabel lblActivityName;
	private JTextPane textPaneActivity;
	private JLabel lblTraining;
	private JTextPane textPaneTraining;
	private JLabel lblDate;
	private JTextPane textPaneDate ;
	private JLabel lblTime_1 ;
	private JTextPane textPaneTime;
	private JLabel lblDetails_1;
	private JTextPane textPaneDetails;
	private JLabel lblDuration_1;
	private JTextPane textPaneDuration;
	private JLabel lblDistance_1 ;
	private JLabel chooseAthlete; ;
	private JTextPane textPaneDistance ;

	
	
	public ViewPerformedTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PERFORMED_TRAINING_PANEL, client);
		setLayout(null);
		
		
			JLabel lblPlannedTraining = new JLabel();
			lblPlannedTraining.setBounds(417, 7, 138, 56);
			add(lblPlannedTraining);
			
		
		

		   init();
		}
		
		
		
		public void initArrays(){
			
		       
			
			allAthleteArray = new ArrayList<User>();
			getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(client.getUser().getIdUser()));
			MessageGetAllAthleteByCoachIdReplay rep2= (MessageGetAllAthleteByCoachIdReplay)getClient().getMessageFromServer();
			allAthleteArray = rep2.getArray();
			
			allAactivityTypeArray = new ArrayList<activitytype>();
			getClient().sendMsgToServer(new MessageGetAllAactivityType());
			MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
			allAactivityTypeArray = rep3.getArray();
		
		}
		public void initLabel(){
			

			lblChooseTraining = new JLabel("choose training by dates:");
			lblChooseTraining.setBounds(6, 85, 153, 14);
			add(lblChooseTraining);
			
			lblActivityName = new JLabel("activity name:");
			lblActivityName.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 222, 109, 24);
			add(lblActivityName);
			
			
			
			lblTraining = new JLabel("training name:");
			lblTraining.setBounds(190, 222, 90, 20);
			add(lblTraining);
			
			
			
			chooseAthlete = new JLabel("choose athlete:");
			chooseAthlete.setBounds(6,38, 117, 20);
			add(chooseAthlete);
			
			lblDate = new JLabel("date:");
			lblDate.setBounds(383, 222, 78, 24);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("time:");
			lblTime_1.setBounds(6, 263, 37, 25);
			add(lblTime_1);
			
			
			
			lblDetails_1 = new JLabel("details:");
			lblDetails_1.setBounds(150, 263, 46, 14);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("duration:");
			lblDuration_1.setBounds(314, 263, 53, 23);
			add(lblDuration_1);
			
			
			lblDistance_1 = new JLabel("distance:");
			lblDistance_1.setBounds(522, 222, 71, 20);
			add(lblDistance_1);
			
			
		}
	public void initTextPane(){
		textPaneDuration = new JTextPane();
		textPaneDuration.setBounds(391, 261, 87, 20);
		textPaneDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDuration.setBackground(Color.lightGray);
		add(textPaneDuration);
		
		textPaneDistance = new JTextPane();
		textPaneDistance.setBounds(590, 219, 71, 20);
		textPaneDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDistance.setBackground(Color.lightGray);
		add(textPaneDistance);
		
		textPaneDate = new JTextPane();
		textPaneDate.setBounds(420, 219, 97, 20);
		textPaneDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDate.setBackground(Color.lightGray);
		add(textPaneDate);
		
		textPaneDetails = new JTextPane();
		textPaneDetails.setBounds(196, 261, 63, 20);
		textPaneDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDetails.setBackground(Color.lightGray);
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(53, 261, 53, 24);
		textPaneTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTime.setBackground(Color.lightGray);
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneActivity.setBounds(93, 219, 88, 26);
		textPaneActivity.setBackground(Color.lightGray);
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(274, 219, 89, 20);
		textPaneTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTraining.setBackground(Color.lightGray);
		add(textPaneTraining);
		
		
		
		
	}
		
	
		public void initBtn(){
			
			btnW = new JButton("observe details");
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						
							if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
								
								AthletTraining=(plannedpersonaltraining)comboBoxTraining.getSelectedItem();
								String activityName=null,trainingName=null,time,duration,distance,details;
								String date;
								for (int i=0; i<allAactivityTypeArray.size(); i++)
								{
									if  (allAactivityTypeArray.get(i).getActivityId()==AthletTraining.getActivityid())
										activityName=allAactivityTypeArray.get(i).getActivityName();
								}
								alltrainingTypeArray = new ArrayList<trainingtype>();
								getClient().sendMsgToServer(new MessageGetAllTrainingType(AthletTraining.getActivityid()));
								MessageGetAllTrainingTypeReplay rep5= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
							
								alltrainingTypeArray = rep5.getArray();
								for (int j=0; j<alltrainingTypeArray.size(); j++)
									{
									if  (alltrainingTypeArray.get(j).getTrainingId()==AthletTraining.getTrainingTypeId())
										trainingName=alltrainingTypeArray.get(j).gettrainingName();
									
									}
								date=AthletTraining.getDate();
								time=AthletTraining.getTime();
								duration=AthletTraining.getDuration();
								distance=AthletTraining.getDistance();
								details=AthletTraining.getDetails();
								textPaneActivity.setText(activityName);
								textPaneTraining.setText(trainingName);
								textPaneDuration.setText(duration);
								textPaneDistance.setText(distance);
								textPaneDate.setText(date);
								textPaneDetails.setText(details);
								textPaneTime.setText(time);
							
								}
						
						
					}
				});
			
			
			btnW.setBounds(302, 81, 153, 23);
			add(btnW);
		}
		
		
		 public void initComboBox(){
		
				comboBoxTraining = new JComboBox();
				comboBoxTraining.setBounds(175,82, 117, 20);
				comboBoxTraining.setEnabled(false);
				add(comboBoxTraining);
				comboBoxTraining.setEnabled(false);
				
				comboBoxAthlete = new JComboBox();
				comboBoxAthlete.setBounds(175,38, 117, 20);
				comboBoxAthlete.setEnabled(false);
				add(comboBoxAthlete);
				comboBoxAthlete.setEnabled(true);
				
				
		 }
		 
		 
		
		public void init(){
			
			initComboBox();
			initArrays();
			initBtn();
			initLabel();
		    initTextPane();
			
			
			  for (int j=0; j<=allAthleteArray.size(); j++)
				{
					if (j==0) comboBoxAthlete.addItem("Choose..");
					else comboBoxAthlete.addItem(allAthleteArray.get(j-1));
					}
			  
		
			  comboBoxAthlete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){			
							allPersonalTrainingArray = new ArrayList<plannedpersonaltraining>();
				
							Athlete = (User) comboBoxAthlete.getSelectedItem();
							
						  	getClient().sendMsgToServer(new MessageGetAllPersonalTrainingByAtleteId(Athlete.getIdUser()));
						  	MessageGetAllPersonalTrainingByAtleteIdReplay rep6= (MessageGetAllPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
						  	allPersonalTrainingArray = rep6.getPersonalTrainingArray();
						  	comboBoxTraining.removeAllItems();
			    			 for (int i=0; i<=allPersonalTrainingArray.size(); i++)
			    				{
			    					if (i==0) comboBoxTraining.addItem("Choose..");
			    					else comboBoxTraining.addItem(allPersonalTrainingArray.get(i-1));
			    					}
			    			 comboBoxTraining.setEnabled(true);
			    		}
			    		
						
					
					}
				});
			  
			  
			
		}
		
		private void popUp(String msg){
			
			JOptionPane.showMessageDialog((Component) getClient(),msg);
				
			return ;
		}
		

	@Override
	public MyJPanel pushPanel() {
		return new ViewPerformedTrainingPanel(getClient());
	}
}



