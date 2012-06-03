
package Client.Gui;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



import Client.Logic.ClientIF;
import Server.DataBase.Info;
import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.statistic;
import Server.DataBase.statisticQuery;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetStatisticByAthleteId;
import Server.Message.MessageGetStatisticByAthleteIdReplay;
import Server.Message.MessageGetStatisticBytrainingId;
import Server.Message.MessageGetStatisticBytrainingIdReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jfree.ui.RefineryUtilities;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class coachViewStatisticPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private plannedteamtraining plannedteamtraining;
	private User Athlete;
	private Team team1;
	private JComboBox comboBoxTeams;
	private JComboBox comboBoxAthlete;
	
	private JRadioButton rdbtnTeamTraining;
	private JButton btnViewStatistic;
	private JRadioButton rdbtnPersonalTraining;
	private BarChart  bar;
	private TeamBarChart teamBar;
	private ArrayList <String> colu;
	private statistic statisticQ=null;
	private JComboBox comboBoxTraining;
	private JLabel lblChooseTraining ;
	
	public coachViewStatisticPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_STATISTIC_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblStatistic = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblStatistic.setBounds(511, 7, 49, 47);
			add(lblStatistic);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
		public void initArrays(){
			
		       
			allTeamArray = new ArrayList<Team>();
			getClient().sendMsgToServer(new MessageGetAllTeamByCoachId(getClient().getUser().getIdUser()));
			MessageGetAllTeamByCoachReplay rep1= (MessageGetAllTeamByCoachReplay)getClient().getMessageFromServer();
			allTeamArray = rep1.getArray();
			
			allAthleteArray = new ArrayList<User>();
			getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(client.getUser().getIdUser()));
			MessageGetAllAthleteByCoachIdReplay rep2= (MessageGetAllAthleteByCoachIdReplay)getClient().getMessageFromServer();
			allAthleteArray = rep2.getArray();
		}
	
		public void initLabel(){
			lblChooseTraining = new JLabel("choose training:");
			lblChooseTraining.setBounds(6, 85, 138, 17);
			add(lblChooseTraining);
			lblChooseTraining.setVisible(false);

			
		}
		
	
		 public void initJRadioButton(){
				
			    rdbtnTeamTraining = new JRadioButton("team statistic");
			    rdbtnTeamTraining.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    			if(rdbtnTeamTraining.isSelected()){
			    				comboBoxTraining.setVisible(true);
			    				lblChooseTraining.setVisible(true);
			    				comboBoxTeams.setEnabled(true);
			    				comboBoxAthlete.setEnabled(false);
			    				if(rdbtnPersonalTraining.isSelected()){
			    					rdbtnPersonalTraining.doClick();
			    				
			    				}
			    				comboBoxTeams.setEnabled(true);
			    			}
			    			else 
			    				comboBoxTeams.setEnabled(false);	
			    				
			    				
			    	}
			    });
				rdbtnTeamTraining.setBounds(6, 7, 138, 23);
				add(rdbtnTeamTraining);
				
				rdbtnPersonalTraining = new JRadioButton("athlete statistic");
				rdbtnPersonalTraining.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnPersonalTraining.isSelected()){
							comboBoxTraining.setVisible(false);
							comboBoxAthlete.setEnabled(true);
							comboBoxTeams.setEnabled(false);
		    				if(rdbtnTeamTraining.isSelected()){
		    					rdbtnTeamTraining.doClick();
		    				
		    				}
		    				comboBoxTeams.setEnabled(false);
		    			}
		    			else 
		    				comboBoxAthlete.setEnabled(false);
						
						
					}
				});
				if(rdbtnTeamTraining.isSelected())
					comboBoxTeams.setEnabled(true);
				else 
					comboBoxTeams.setEnabled(false);	

				rdbtnPersonalTraining.setBounds(6, 34, 138, 23);
				add(rdbtnPersonalTraining); 
				
				
				
		 }
		 public void  initBtn(){
		 btnViewStatistic = new JButton("view statistic");
				btnViewStatistic.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String msg;
						if(rdbtnPersonalTraining.isSelected()){
						
							if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){
							
									Athlete=(User)comboBoxAthlete.getSelectedItem();
									statisticQ = new statistic();
									getClient().sendMsgToServer(new MessageGetStatisticByAthleteId(Athlete.getIdUser()));
									MessageGetStatisticByAthleteIdReplay rep5= (MessageGetStatisticByAthleteIdReplay)getClient().getMessageFromServer();
									statisticQ = rep5.getStatisticQ();
									bar= new BarChart("statistic",statisticQ);
									bar.pack();
									RefineryUtilities.centerFrameOnScreen(bar);
									bar.setVisible(true);
							
								
								
							}
							else{
								msg="choose an athlete";
								popUp(msg);
							}
							
						}
					    if(rdbtnTeamTraining.isSelected()){
					    	
							if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){
								if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
									team1 = (Team)comboBoxTeams.getSelectedItem();
									plannedteamtraining=(plannedteamtraining)comboBoxTraining.getSelectedItem();
									statisticQ = new statistic();
									getClient().sendMsgToServer(new MessageGetStatisticBytrainingId(plannedteamtraining.getTrainingId(),team1.getTeamId()));
									MessageGetStatisticBytrainingIdReplay rep6= (MessageGetStatisticBytrainingIdReplay)getClient().getMessageFromServer();
									statisticQ = rep6.getStatisticQ();
									teamBar= new TeamBarChart("statistic",statisticQ);
									teamBar.pack();
									RefineryUtilities.centerFrameOnScreen(teamBar);
									teamBar.setVisible(true);	
								}
								else{
									msg="choose team training";
									popUp(msg);
								}
								
								
							}
							else{
								msg="choose team";
								popUp(msg);
							}
							
						} 
					    if(!rdbtnTeamTraining.isSelected()&&!rdbtnPersonalTraining.isSelected()){
					    	msg="choose what you want to see";
							popUp(msg);
					    	
					    	
					    }
					}
				});
				btnViewStatistic.setBounds(308, 21, 155, 23);
				add(btnViewStatistic);
				
				
			 
		 }
	public void  initComboBox(){
		
	    comboBoxTeams = new JComboBox();
	    
		comboBoxTeams.setBounds(175, 7, 117, 20);
		add(comboBoxTeams);
		comboBoxTeams.setEnabled(false);
		
		comboBoxAthlete = new JComboBox();
		
		comboBoxAthlete.setBounds(175,38, 117, 20);
		comboBoxAthlete.setEnabled(false);
		add(comboBoxAthlete);
		comboBoxAthlete.setEnabled(false);
		
		comboBoxTraining = new JComboBox();
		comboBoxTraining.setBounds(175,82, 117, 20);
		comboBoxTraining.setEnabled(false);
		add(comboBoxTraining);
		comboBoxTraining.setEnabled(false);
		comboBoxTraining.setVisible(false);
		
 }
		
	public void	init(){
			
		initLabel();
		initArrays();
		initComboBox();
		initJRadioButton();
		initBtn();
	
		comboBoxTraining.addItem("Choose..");
		 for (int i=0; i<=allTeamArray.size(); i++)
			{
				if (i==0) comboBoxTeams.addItem("Choose..");
				else comboBoxTeams.addItem(allTeamArray.get(i-1));
				}
		  
		  for (int i=0; i<=allAthleteArray.size(); i++)
			{
				if (i==0) comboBoxAthlete.addItem("Choose..");
				else comboBoxAthlete.addItem(allAthleteArray.get(i-1));
				}
		  comboBoxTeams.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){			
						allTeamTrainingArray = new ArrayList<plannedteamtraining>();
						team1 = (Team)comboBoxTeams.getSelectedItem();
					  	getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(team1.getTeamId()));
					  	MessageGetAllTeamTrainingByTeamIdReplay rep5= (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
						allTeamTrainingArray = rep5.getArray();
						comboBoxTraining.removeAllItems();
		    			
		    			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
		    				{
		    					if (i==0) comboBoxTraining.addItem("Choose..");
		    					else comboBoxTraining.addItem(allTeamTrainingArray.get(i-1));
		    					}
		    			 comboBoxTraining.setEnabled(true);
		    		}
		    		
					
		    	}
		    });
		 
					
		
		  
		}
	
	
	
   
    
    
    
    
  
			
		
	
	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new coachViewStatisticPanel(getClient());
	}
}



