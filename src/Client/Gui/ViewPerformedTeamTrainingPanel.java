

package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Client.Logic.ClientIF;
import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.PreformedTeamTraining;
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
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllPreformedTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetPlannedTeamTrainingByTrainingId;
import Server.Message.MessageGetPlannedTeamTrainingByTrainingIdReplay;
import Server.Message.MessageGetPlannedTrainingByTrainingId;
import Server.Message.MessageGetPlannedTrainingByTrainingIdReplay;
import javax.swing.UIManager;


public class ViewPerformedTeamTrainingPanel extends MyJPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining teamTraining;
	private plannedteamtraining updatedTraining;
	private ArrayList<PreformedTeamTraining> allPrefoemedTrainingArray =null;
	private plannedteamtraining teamPlannedTraining;
	private PreformedTeamTraining AthletTraining;
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
	private JLabel lblTraining;
	private JLabel lblDate;
	private JLabel lblTime_1 ;
	private JLabel lblDetails_1;
	private JLabel lblDistance_1 ;
	private JLabel chooseAthlete ;
	private JLabel lblDuration_1;
	private JTextPane textPaneActivity;
	private JTextPane textPaneTraining;
	private JTextPane textPaneDate ;
	private JTextPane textPaneTime;
	private JTextPane textPaneDetails;
	private JTextPane textPaneDuration;
	private JTextPane textPaneDistance ;
	
		
	private JLabel lblActivityName1;
	private JLabel lblTime_11 ;
	private JLabel lblTraining1;
	private JLabel lblDate1;
	private JLabel lblDetails_11;
	private JLabel lblDistance_11 ;
	private JLabel lblDuration_11;
	private JTextPane textPaneTraining1;
	private JTextPane textPaneActivity1;
	private JTextPane textPaneDate1 ;
	private JTextPane textPaneTime1;
	private JTextPane textPaneDetails1;
	private JTextPane textPaneDuration1;
	private JTextPane textPaneDistance1 ;
	private JButton btnNewButton;
	private JLabel lblViewPreformedTeam;
	private JLabel lblNewLabel;
	
	public ViewPerformedTeamTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PERFORMED_TEAM_TRAINING_PANEL, client);
		setLayout(null);
			
		
		

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
			

			lblChooseTraining = new JLabel("ChooseTraining By Dates:");
			lblChooseTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblChooseTraining.setBounds(6, 128, 181, 25);
			add(lblChooseTraining);
			
			lblActivityName = new JLabel("Activity Name:");
			lblActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 222, 109, 25);
			add(lblActivityName);
			
			lblTraining = new JLabel("Training Name:");
			lblTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTraining.setBounds(215, 222, 104, 25);
			add(lblTraining);
			
			chooseAthlete = new JLabel("Choose Athlete:");
			chooseAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
			chooseAthlete.setBounds(6,94, 117, 25);
			add(chooseAthlete);
			
			lblDate = new JLabel("Date:");
			lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDate.setBounds(465, 222, 46, 25);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("Time:");
			lblTime_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime_1.setBounds(6, 263, 77, 25);
			add(lblTime_1);
						
			lblDetails_1 = new JLabel("Details:");
			lblDetails_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails_1.setBounds(6, 299, 77, 25);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("Duration:");
			lblDuration_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration_1.setBounds(213, 263, 79, 25);
			add(lblDuration_1);
			
			lblDistance_1 = new JLabel("Distance:");
			lblDistance_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance_1.setBounds(465, 258, 71, 25);
			add(lblDistance_1);
			
			lblActivityName1 = new JLabel("Activity Name:");
		    lblActivityName1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityName1.setBackground(Color.WHITE);
			lblActivityName1.setBounds(6,422, 100, 24);
			add( lblActivityName1);
			
			lblTime_11 = new JLabel("Time:");
			lblTime_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime_11.setBounds(245, 422, 37, 25);
			add(lblTime_11);
			
			lblTraining1 = new JLabel("Training Name:");
			lblTraining1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTraining1.setBounds(6, 465, 101, 20);
			add(lblTraining1);
			
			lblDetails_11 = new JLabel("Details:");
			lblDetails_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails_11.setBounds(245, 463, 57, 25);
			add(lblDetails_11);
			
			lblDate1 = new JLabel("Date:");
			lblDate1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDate1.setBounds(402, 422, 46, 25);
			add(lblDate1);
			
			lblDistance_11 = new JLabel("Distance:");
			lblDistance_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance_11.setBounds(565, 424, 71, 20);
			add(lblDistance_11);
			
			lblDuration_11 = new JLabel("Duration:");
			lblDuration_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration_11.setBounds(565, 464, 71, 23);
			add(lblDuration_11);
								
			lblActivityName1.setVisible(false);
			lblTime_11.setVisible(false);
			lblTraining1.setVisible(false);
			lblDetails_11.setVisible(false);
			lblDate1.setVisible(false);
			lblDistance_11.setVisible(false);
			lblDuration_11.setVisible(false);
				
		}
	public void initTextPane(){
		textPaneDuration = new JTextPane();
		textPaneDuration.setBounds(329, 263, 126, 25);
		textPaneDuration.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDuration.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDuration);
		
		textPaneDistance = new JTextPane();
		textPaneDistance.setBounds(543, 263, 118, 25);
		textPaneDistance.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDistance.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDistance);
		
		textPaneDate = new JTextPane();
		textPaneDate.setBounds(543, 222, 118, 25);
		textPaneDate.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDate.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDate);
		
		textPaneDetails = new JTextPane();
		textPaneDetails.setBounds(101, 299, 226, 25);
		textPaneDetails.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDetails.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(103, 263, 100, 25);
		textPaneTime.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTime.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneActivity.setBounds(103, 222, 102, 25);
		textPaneActivity.setBackground(UIManager.getColor("Button.background"));
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(329, 222, 126, 25);
		textPaneTraining.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTraining.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTraining);
		
		
		textPaneTraining1 = new JTextPane();
		textPaneTraining1.setBounds(115, 462, 120, 26);
		textPaneTraining1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTraining1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTraining1);
		
		textPaneActivity1 = new JTextPane();
		textPaneActivity1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneActivity1.setBounds(115, 422, 120, 26);
		textPaneActivity1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneActivity1);
		
		textPaneDate1 = new JTextPane();
		textPaneDate1.setBounds(446, 422, 109, 25);
		textPaneDate1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDate1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDate1);
		
		
		
		textPaneTime1 = new JTextPane();
		textPaneTime1.setBounds(292, 420, 100, 26);
		textPaneTime1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTime1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTime1);
		
		textPaneDetails1 = new JTextPane();
		textPaneDetails1.setBounds(292, 462, 263, 26);
		textPaneDetails1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDetails1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDetails1);
		
		textPaneDuration1 = new JTextPane();
		textPaneDuration1.setBounds(646, 463, 71, 26);
		textPaneDuration1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDuration1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDuration1);
		
		textPaneDistance1 = new JTextPane();
		textPaneDistance1.setBounds(646, 422, 71, 25);
		textPaneDistance1.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDistance1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDistance1);
		
		
		textPaneTraining1.setVisible(false);
		textPaneActivity1.setVisible(false);
		textPaneDate1.setVisible(false);
		textPaneTime1.setVisible(false);
		textPaneDetails1.setVisible(false);
		textPaneDuration1.setVisible(false);
		textPaneDistance1.setVisible(false);
		
		
	}
	
		
	
		public void initBtn(){
			
			btnW = new JButton("View Details");
			btnW.setForeground(Color.BLUE);
			btnW.setFont(new Font("Arial", Font.PLAIN, 15));
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						String msg;
						if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){
							if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
													
								AthletTraining=(PreformedTeamTraining)comboBoxTraining.getSelectedItem();
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
								
							 
							  
							    btnNewButton.setEnabled(true);
								}
							else{
								msg="choose training ";
								popUp(msg);	
									
								}
							
						}
						else{
							msg="choose athlete ";
							popUp(msg);	
								
							}
						
					}
				});
			
			
			btnW.setBounds(337, 92, 153, 63);
			add(btnW);
			
			
			btnNewButton = new JButton("Click To Watch The Original Planned Training:");
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
			btnNewButton.setBounds(115, 355, 450, 37);
			add(btnNewButton);
			btnNewButton.setEnabled(false);
			
		}
		
		
		 public void initComboBox(){
		
				comboBoxTraining = new JComboBox();
				comboBoxTraining.setBackground(Color.WHITE);
				comboBoxTraining.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxTraining.setBounds(210,130, 117, 25);
				comboBoxTraining.setEnabled(false);
				add(comboBoxTraining);
				comboBoxTraining.setEnabled(false);
				
				comboBoxAthlete = new JComboBox();
				comboBoxAthlete.setBackground(Color.WHITE);
				comboBoxAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxAthlete.setBounds(210,94, 117, 25);
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
		    comboBoxTraining.addItem("Choose..");
		    
		    lblViewPreformedTeam = new JLabel("View Preformed Team Training:");
		    lblViewPreformedTeam.setFont(new Font("Arial", Font.PLAIN, 20));
		    lblViewPreformedTeam.setBounds(10, 47, 309, 30);
		    add(lblViewPreformedTeam);
		    
		    lblNewLabel = new JLabel("Preformed Team Training Details:");
		    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    lblNewLabel.setBounds(10, 184, 317, 30);
		    add(lblNewLabel);
			
			  for (int j=0; j<=allAthleteArray.size(); j++)
				{
					if (j==0) comboBoxAthlete.addItem("Choose..");
					else comboBoxAthlete.addItem(allAthleteArray.get(j-1));
					}
			  
		
			  comboBoxAthlete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						btnNewButton.setEnabled(false);
						textPaneActivity.setText("");
						textPaneTraining.setText("");
						textPaneDate.setText("");
						textPaneTime.setText("");
						textPaneDetails.setText("");
						textPaneDuration.setText("");
						textPaneDistance.setText("");

						textPaneTraining1.setVisible(false);
						textPaneActivity1.setVisible(false);
						textPaneDate1.setVisible(false);
						textPaneTime1.setVisible(false);
						textPaneDetails1.setVisible(false);
						textPaneDuration1.setVisible(false);
						textPaneDistance1.setVisible(false);
						lblActivityName1.setVisible(false);
						lblTime_11.setVisible(false);
						lblTraining1.setVisible(false);
						lblDetails_11.setVisible(false);
						lblDate1.setVisible(false);
						lblDistance_11.setVisible(false);
						lblDuration_11.setVisible(false);
						
						
						
						if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){			
							allPrefoemedTrainingArray = new ArrayList<PreformedTeamTraining>();
				
							Athlete = (User) comboBoxAthlete.getSelectedItem();
							
						  	getClient().sendMsgToServer(new MessageGetAllPreformedTeamTrainingByAtleteId(Athlete.getIdUser()));
						  	MessageGetAllPreformedTeamTrainingByAtleteIdReplay rep6= (MessageGetAllPreformedTeamTrainingByAtleteIdReplay)getClient().getMessageFromServer();
						  	allPrefoemedTrainingArray = rep6.getPreformedTeamTraining1();
						  	comboBoxTraining.removeAllItems();
			    			 for (int i=0; i<=allPrefoemedTrainingArray.size(); i++)
			    				{
			    					if (i==0) comboBoxTraining.addItem("Choose..");
			    					else comboBoxTraining.addItem(allPrefoemedTrainingArray.get(i-1));
			    					}
			    			 comboBoxTraining.setEnabled(true);
			    		}
			    		
						
					
					}
				});
			  
			  btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 
							String acticity=null;
							String trainingtype=null;
							int id=AthletTraining.getTrainingId();
							
							teamPlannedTraining = new plannedteamtraining();
							getClient().sendMsgToServer(new MessageGetPlannedTeamTrainingByTrainingId(id));
							MessageGetPlannedTeamTrainingByTrainingIdReplay rep11= (MessageGetPlannedTeamTrainingByTrainingIdReplay) getClient().getMessageFromServer();
							teamPlannedTraining = rep11.getPlannedteamtraining();
							teamPlannedTraining.getActivityid();
							
							
							for (int i=0; i<allAactivityTypeArray.size(); i++)
							{
								if  (allAactivityTypeArray.get(i).getActivityId()==teamPlannedTraining.getActivityid())
									acticity=allAactivityTypeArray.get(i).getActivityName();
							}
							alltrainingTypeArray = new ArrayList<trainingtype>();
							getClient().sendMsgToServer(new MessageGetAllTrainingType(teamPlannedTraining.getActivityid()));
							MessageGetAllTrainingTypeReplay rep5= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
						
							alltrainingTypeArray = rep5.getArray();
							for (int j=0; j<alltrainingTypeArray.size(); j++)
								{
								if  (alltrainingTypeArray.get(j).getTrainingId()==teamPlannedTraining.getTrainingTypeId())
									trainingtype=alltrainingTypeArray.get(j).gettrainingName();
								
								}
							
							
							textPaneTraining1.setVisible(true);
							textPaneTraining1.setText(trainingtype);
							textPaneActivity1.setVisible(true);
							textPaneActivity1.setText(acticity);
							textPaneDate1.setVisible(true);
							textPaneDate1.setText(teamPlannedTraining.getDate());
							textPaneTime1.setVisible(true);
							textPaneTime1.setText(teamPlannedTraining.getTime());
							textPaneDetails1.setVisible(true);
							textPaneDetails1.setText(teamPlannedTraining.getDetails());
							textPaneDuration1.setVisible(true);
							textPaneDuration1.setText(teamPlannedTraining.getDuration());
							textPaneDistance1.setVisible(true);
							textPaneDistance1.setText(teamPlannedTraining.getDistance());
							lblActivityName1.setVisible(true);
							lblTime_11.setVisible(true);
							lblTraining1.setVisible(true);
							lblDetails_11.setVisible(true);
							lblDate1.setVisible(true);
							lblDistance_11.setVisible(true);
							lblDuration_11.setVisible(true);
											
					}
				});
			
		}
		
		private void popUp(String msg){
			
			JOptionPane.showMessageDialog((Component) getClient(),msg);
				
			return ;
		}
		

	@Override
	public MyJPanel pushPanel() {
		return new ViewPerformedTeamTrainingPanel(getClient());
	}
}



