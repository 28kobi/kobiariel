
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
import Server.Message.MessageGetAllPreformedTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetPlannedTrainingByTrainingId;
import Server.Message.MessageGetPlannedTrainingByTrainingIdReplay;
import javax.swing.UIManager;


public class ViewPerformedTrainingPanel extends MyJPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining teamTraining;
	private plannedteamtraining updatedTraining;
	private ArrayList<PreformedPersonalTraining> allPrefoemedTrainingArray =null;
	private plannedpersonaltraining AthletPlannedTraining;
	private PreformedPersonalTraining AthletTraining;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private JRadioButton rdbtnPersonalTraining;
	private JLabel lblChooseTraining;
	private User Athlete;
	private Team team1;
	private activitytype activityType;
	private JComboBox comboBoxAthlete;
	private JComboBox comboBoxTraining;
	private JRadioButton rdbtnWacthTheOriginal;
	private JButton btnW ;
	private JLabel lblActivityName;
	private JLabel lblisPlanned;
	private JLabel lblTraining;
	private JLabel lblDate;
	private JLabel lblTime_1 ;
	private JLabel lblDetails_1;
	private JLabel lblDistance_1 ;
	private JLabel chooseAthlete ;
	private JLabel lblDuration_1;
	private JTextPane textPaneActivity;
	private JTextPane textisPlanned;
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

	
	
	public ViewPerformedTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PERFORMED_TRAINING_PANEL, client);
		setLayout(null);
		
		
			JLabel lblPlannedTraining = new JLabel();
			lblPlannedTraining.setFont(new Font("Arial", Font.PLAIN, 15));
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
			

			lblChooseTraining = new JLabel("Choose Training By Dates:");
			lblChooseTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblChooseTraining.setBounds(12, 97, 178, 25);
			add(lblChooseTraining);
			
			lblActivityName = new JLabel("Activity Name:");
			lblActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 222, 109, 25);
			add(lblActivityName);
			
			lblTraining = new JLabel("Training Name:");
			lblTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTraining.setBounds(6, 259, 109, 25);
			add(lblTraining);
			
			lblisPlanned = new JLabel("Is This Planned Training:");
			lblisPlanned.setFont(new Font("Arial", Font.PLAIN, 15));
			lblisPlanned.setBounds(6, 320, 199, 25);
			add(lblisPlanned);
			
			chooseAthlete = new JLabel("Choose Athlete:");
			chooseAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
			chooseAthlete.setBounds(12,64, 117, 25);
			add(chooseAthlete);
			
			lblDate = new JLabel("Date:");
			lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDate.setBounds(417, 222, 46, 25);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("Time:");
			lblTime_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime_1.setBounds(235, 222, 51, 25);
			add(lblTime_1);
						
			lblDetails_1 = new JLabel("Details:");
			lblDetails_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails_1.setBounds(235, 259, 62, 25);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("Duration:");
			lblDuration_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration_1.setBounds(565, 259, 71, 25);
			add(lblDuration_1);
			
			lblDistance_1 = new JLabel("Distance:");
			lblDistance_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance_1.setBounds(565, 222, 71, 25);
			add(lblDistance_1);
			
			lblActivityName1 = new JLabel("Activity Name:");
		    lblActivityName1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityName1.setBackground(Color.WHITE);
			lblActivityName1.setBounds(6,422, 109, 25);
			add( lblActivityName1);
			
			lblTime_11 = new JLabel("Time:");
			lblTime_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime_11.setBounds(246, 422, 37, 25);
			add(lblTime_11);
			
			lblTraining1 = new JLabel("Training Name:");
			lblTraining1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTraining1.setBounds(6, 458, 109, 25);
			add(lblTraining1);
			
			lblDetails_11 = new JLabel("Details:");
			lblDetails_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails_11.setBounds(246, 463, 62, 25);
			add(lblDetails_11);
			
			lblDate1 = new JLabel("Date:");
			lblDate1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDate1.setBounds(425, 422, 46, 25);
			add(lblDate1);
			
			lblDistance_11 = new JLabel("Distance:");
			lblDistance_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance_11.setBounds(565, 422, 71, 25);
			add(lblDistance_11);
			
			lblDuration_11 = new JLabel("Duration:");
			lblDuration_11.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration_11.setBounds(565, 463, 71, 25);
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
		textPaneDuration.setBounds(654, 259, 88, 25);
		textPaneDuration.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDuration.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDuration);
		
		textPaneDistance = new JTextPane();
		textPaneDistance.setBounds(654, 222, 88, 25);
		textPaneDistance.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDistance.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDistance);
		
		textPaneDate = new JTextPane();
		textPaneDate.setBounds(467, 222, 77, 25);
		textPaneDate.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDate.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDate);
		
		textPaneDetails = new JTextPane();
		textPaneDetails.setBounds(296, 259, 248, 25);
		textPaneDetails.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDetails.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(307, 222, 88, 25);
		textPaneTime.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneTime.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneActivity.setBounds(117, 222, 88, 25);
		textPaneActivity.setBackground(UIManager.getColor("Button.background"));
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(117, 259, 88, 25);
		textPaneTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneTraining.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTraining);
		
		textisPlanned = new JTextPane();
		textisPlanned.setBounds(215, 320, 126, 25);
		textisPlanned.setFont(new Font("Arial", Font.PLAIN, 15));
		textisPlanned.setBackground(UIManager.getColor("Button.background"));
		add(textisPlanned);
		
		textPaneTraining1 = new JTextPane();
		textPaneTraining1.setBounds(117, 458, 88, 25);
		textPaneTraining1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneTraining1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTraining1);
		
		textPaneActivity1 = new JTextPane();
		textPaneActivity1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneActivity1.setBounds(117, 422, 88, 25);
		textPaneActivity1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneActivity1);
		
		textPaneDate1 = new JTextPane();
		textPaneDate1.setBounds(467, 422, 88, 25);
		textPaneDate1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDate1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDate1);
		
		
		
		textPaneTime1 = new JTextPane();
		textPaneTime1.setBounds(307, 422, 88, 25);
		textPaneTime1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneTime1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneTime1);
		
		textPaneDetails1 = new JTextPane();
		textPaneDetails1.setBounds(307, 463, 248, 25);
		textPaneDetails1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDetails1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDetails1);
		
		textPaneDuration1 = new JTextPane();
		textPaneDuration1.setBounds(646, 463, 96, 25);
		textPaneDuration1.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneDuration1.setBackground(UIManager.getColor("Button.background"));
		add(textPaneDuration1);
		
		textPaneDistance1 = new JTextPane();
		textPaneDistance1.setBounds(646, 422, 96, 25);
		textPaneDistance1.setFont(new Font("Arial", Font.PLAIN, 15));
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
	public void initradioBtn(){
		rdbtnWacthTheOriginal = new JRadioButton("Watch The Original Planned Training:");
		rdbtnWacthTheOriginal.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnWacthTheOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnWacthTheOriginal.isSelected()){
					String acticity=null;
					String trainingtype=null;
					int id=AthletTraining.getTrainingId();
					
					AthletPlannedTraining = new plannedpersonaltraining();
					getClient().sendMsgToServer(new MessageGetPlannedTrainingByTrainingId(id));
					MessageGetPlannedTrainingByTrainingIdReplay rep10= (MessageGetPlannedTrainingByTrainingIdReplay) getClient().getMessageFromServer();
					AthletPlannedTraining = rep10.getPlannedpersonaltraining();
					AthletPlannedTraining.getActivityid();
					
					
					for (int i=0; i<allAactivityTypeArray.size(); i++)
					{
						if  (allAactivityTypeArray.get(i).getActivityId()==AthletPlannedTraining.getActivityid())
							acticity=allAactivityTypeArray.get(i).getActivityName();
					}
					alltrainingTypeArray = new ArrayList<trainingtype>();
					getClient().sendMsgToServer(new MessageGetAllTrainingType(AthletPlannedTraining.getActivityid()));
					MessageGetAllTrainingTypeReplay rep5= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
				
					alltrainingTypeArray = rep5.getArray();
					for (int j=0; j<alltrainingTypeArray.size(); j++)
						{
						if  (alltrainingTypeArray.get(j).getTrainingId()==AthletPlannedTraining.getTrainingTypeId())
							trainingtype=alltrainingTypeArray.get(j).gettrainingName();
						
						}
					
					
					textPaneTraining1.setVisible(true);
					textPaneTraining1.setText(trainingtype);
					textPaneActivity1.setVisible(true);
					textPaneActivity1.setText(acticity);
					textPaneDate1.setVisible(true);
					textPaneDate1.setText(AthletPlannedTraining.getDate());
					textPaneTime1.setVisible(true);
					textPaneTime1.setText(AthletPlannedTraining.getTime());
					textPaneDetails1.setVisible(true);
					textPaneDetails1.setText(AthletPlannedTraining.getDetails());
					textPaneDuration1.setVisible(true);
					textPaneDuration1.setText(AthletPlannedTraining.getDuration());
					textPaneDistance1.setVisible(true);
					textPaneDistance1.setText(AthletPlannedTraining.getDistance());
					lblActivityName1.setVisible(true);
					lblTime_11.setVisible(true);
					lblTraining1.setVisible(true);
					lblDetails_11.setVisible(true);
					lblDate1.setVisible(true);
					lblDistance_11.setVisible(true);
					lblDuration_11.setVisible(true);
					
					
					
					
					
				
					
					
				}
				
				if(!rdbtnWacthTheOriginal.isSelected()){
				
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
					
					
					
				}
				
				
			}
		});
		rdbtnWacthTheOriginal.setBounds(378, 319, 283, 25);
		add(rdbtnWacthTheOriginal);
		rdbtnWacthTheOriginal.setEnabled(false);
		
		
		
		
	}
		
	
		public void initBtn(){
			
			btnW = new JButton("View Details");
			btnW.setForeground(Color.BLUE);
			btnW.setFont(new Font("Arial", Font.PLAIN, 15));
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rdbtnWacthTheOriginal.isSelected())
						rdbtnWacthTheOriginal.doClick();
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
					
					String msg;
					rdbtnWacthTheOriginal.setEnabled(false);
					if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){
					
							if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
													
								AthletTraining=(PreformedPersonalTraining)comboBoxTraining.getSelectedItem();
								String activityName=null,trainingName=null,time,duration,distance,details;
								String date;
								String isplaned;
								
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
								isplaned =AthletTraining.getIsplanned();
								time=AthletTraining.getTime();
								duration=AthletTraining.getDuration();
								distance=AthletTraining.getDistance();
								details=AthletTraining.getDetails();
								if(isplaned.equals("true")){
									textisPlanned.setText("Yes");
									rdbtnWacthTheOriginal.setEnabled(true);
									}
								if(isplaned.equals("flase")){
									textisPlanned.setText("no");
									rdbtnWacthTheOriginal.setEnabled(false);
									}
								textPaneActivity.setText(activityName);
								textPaneTraining.setText(trainingName);
								textPaneDuration.setText(duration);
								textPaneDistance.setText(distance);
								textPaneDate.setText(date);
								textPaneDetails.setText(details);
								textPaneTime.setText(time);
								
							   
								}
							else{
								msg="choose training";
								popUp(msg);
								
							}
						}
					else{
						msg="choose athlete";
						popUp(msg);
					}
					}
				});
			
			
			btnW.setBounds(351, 64, 153, 58);
			add(btnW);
		}
		
		
		 public void initComboBox(){
		
				comboBoxTraining = new JComboBox();
				comboBoxTraining.setBackground(Color.WHITE);
				comboBoxTraining.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxTraining.setBounds(200,97, 141, 25);
				comboBoxTraining.setEnabled(false);
				add(comboBoxTraining);
				comboBoxTraining.setEnabled(false);
				
				comboBoxAthlete = new JComboBox();
				comboBoxAthlete.setBackground(Color.WHITE);
				comboBoxAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxAthlete.setBounds(200,64, 141, 25);
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
		    initradioBtn();
		    comboBoxTraining.addItem("Choose..");
			  for (int j=0; j<=allAthleteArray.size(); j++)
				{
					if (j==0) comboBoxAthlete.addItem("Choose..");
					else comboBoxAthlete.addItem(allAthleteArray.get(j-1));
					}
			  
		
			  comboBoxAthlete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						textPaneActivity.setText("");
						textisPlanned.setText("");
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
							allPrefoemedTrainingArray = new ArrayList<PreformedPersonalTraining>();
				
							Athlete = (User) comboBoxAthlete.getSelectedItem();
							
						  	getClient().sendMsgToServer(new MessageGetAllPreformedTrainingByAtleteId(Athlete.getIdUser()));
						  	MessageGetAllPreformedTrainingByAtleteIdReplay rep6= (MessageGetAllPreformedTrainingByAtleteIdReplay)getClient().getMessageFromServer();
						  	allPrefoemedTrainingArray = rep6.getPreformedPersonalArray();
						  	comboBoxTraining.removeAllItems();
						  	comboBoxTraining.validate();
			    			 for (int i=0; i<=allPrefoemedTrainingArray.size(); i++)
			    				{
			    					if (i==0) comboBoxTraining.addItem("Choose..");
			    					else comboBoxTraining.addItem(allPrefoemedTrainingArray.get(i-1));
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



