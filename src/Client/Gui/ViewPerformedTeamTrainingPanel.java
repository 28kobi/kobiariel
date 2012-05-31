

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
	
	public ViewPerformedTeamTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PERFORMED_TEAM_TRAINING_PANEL, client);
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
			lblTraining.setBounds(191, 222, 90, 20);
			add(lblTraining);
			
			chooseAthlete = new JLabel("choose athlete:");
			chooseAthlete.setBounds(6,38, 117, 20);
			add(chooseAthlete);
			
			lblDate = new JLabel("date:");
			lblDate.setBounds(383, 222, 88, 26);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("time:");
			lblTime_1.setBounds(6, 263, 37, 25);
			add(lblTime_1);
						
			lblDetails_1 = new JLabel("details:");
			lblDetails_1.setBounds(159, 268, 46, 14);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("duration:");
			lblDuration_1.setBounds(451, 259, 53, 23);
			add(lblDuration_1);
			
			lblDistance_1 = new JLabel("distance:");
			lblDistance_1.setBounds(522, 222, 71, 20);
			add(lblDistance_1);
			
			lblActivityName1 = new JLabel("activity name:");
		    lblActivityName1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblActivityName1.setBackground(Color.WHITE);
			lblActivityName1.setBounds(6,422, 109, 24);
			add( lblActivityName1);
			
			lblTime_11 = new JLabel("time:");
			lblTime_11.setBounds(6, 463, 37, 25);
			add(lblTime_11);
			
			lblTraining1 = new JLabel("training name:");
			lblTraining1.setBounds(191, 422, 90, 20);
			add(lblTraining1);
			
			lblDetails_11 = new JLabel("details:");
			lblDetails_11.setBounds(159, 468, 46, 14);
			add(lblDetails_11);
			
			lblDate1 = new JLabel("date:");
			lblDate1.setBounds(383, 422, 88, 26);
			add(lblDate1);
			
			lblDistance_11 = new JLabel("distance:");
			lblDistance_11.setBounds(522, 422, 71, 20);
			add(lblDistance_11);
			
			lblDuration_11 = new JLabel("duration:");
			lblDuration_11.setBounds(451, 459, 53, 23);
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
		textPaneDuration.setBounds(532, 263, 88, 26);
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
		textPaneDetails.setBounds(215, 261, 226, 26);
		textPaneDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDetails.setBackground(Color.lightGray);
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(53, 261, 88, 26);
		textPaneTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTime.setBackground(Color.lightGray);
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneActivity.setBounds(93, 219, 88, 26);
		textPaneActivity.setBackground(Color.lightGray);
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(274, 219, 88, 26);
		textPaneTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTraining.setBackground(Color.lightGray);
		add(textPaneTraining);
		
		
		textPaneTraining1 = new JTextPane();
		textPaneTraining1.setBounds(274, 419, 88, 26);
		textPaneTraining1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTraining1.setBackground(Color.lightGray);
		add(textPaneTraining1);
		
		textPaneActivity1 = new JTextPane();
		textPaneActivity1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneActivity1.setBounds(93, 419, 88, 26);
		textPaneActivity1.setBackground(Color.lightGray);
		add(textPaneActivity1);
		
		textPaneDate1 = new JTextPane();
		textPaneDate1.setBounds(420, 419, 97, 20);
		textPaneDate1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDate1.setBackground(Color.lightGray);
		add(textPaneDate1);
		
		
		
		textPaneTime1 = new JTextPane();
		textPaneTime1.setBounds(53, 461, 88, 26);
		textPaneTime1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTime1.setBackground(Color.lightGray);
		add(textPaneTime1);
		
		textPaneDetails1 = new JTextPane();
		textPaneDetails1.setBounds(215, 461, 226, 26);
		textPaneDetails1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDetails1.setBackground(Color.lightGray);
		add(textPaneDetails1);
		
		textPaneDuration1 = new JTextPane();
		textPaneDuration1.setBounds(532, 463, 88, 26);
		textPaneDuration1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDuration1.setBackground(Color.lightGray);
		add(textPaneDuration1);
		
		textPaneDistance1 = new JTextPane();
		textPaneDistance1.setBounds(590, 419, 71, 20);
		textPaneDistance1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDistance1.setBackground(Color.lightGray);
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
			
			btnW = new JButton("observe details");
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						
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
						
						
					}
				});
			
			
			btnW.setBounds(302, 81, 153, 23);
			add(btnW);
			
			
			btnNewButton = new JButton("click to watch the original planned training:");
			btnNewButton.setBounds(115, 362, 450, 23);
			add(btnNewButton);
			btnNewButton.setEnabled(false);
			
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
							
							
							
							
							
						
							
							
						
						
					
						
						/*	textPaneTraining1.setVisible(false);
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
							
							*/
							
						
						
						
						
						
						
						
					
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



