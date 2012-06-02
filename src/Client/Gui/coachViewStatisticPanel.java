
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
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class coachViewStatisticPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private User Athlete;
	private Team team1;
	private JComboBox comboBoxTeams;
	private JComboBox comboBoxAthlete;
	private JRadioButton rdbtnTeamTraining;
	private JRadioButton rdbtnPersonalTraining;
	private JComboBox comboBoxTraining;
	
	public coachViewStatisticPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_STATISTIC_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblStatistic = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblStatistic.setBounds(149, 11, 340, 46);
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
			

			
		}
		 public void initJRadioButton(){
				
			    rdbtnTeamTraining = new JRadioButton("team statistic");
			    rdbtnTeamTraining.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    			if(rdbtnTeamTraining.isSelected()){
			    				comboBoxTeams.setEnabled(true);
			    				comboBoxAthlete.setEnabled(false);
			    				if(rdbtnPersonalTraining.isSelected()){
			    					rdbtnPersonalTraining.doClick();
			    					comboBoxTraining.setEnabled(false);
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
							comboBoxAthlete.setEnabled(true);
							comboBoxTeams.setEnabled(false);
		    				if(rdbtnTeamTraining.isSelected()){
		    					rdbtnTeamTraining.doClick();
		    					comboBoxTraining.setEnabled(false);
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
	
	public void  initComboBox(){
		comboBoxTraining = new JComboBox();
		comboBoxTraining.setBounds(175,81, 117, 20);
		comboBoxTraining.setEnabled(false);
		add(comboBoxTraining);
		comboBoxTraining.setEnabled(false);
		
	    comboBoxTeams = new JComboBox();
	    
		comboBoxTeams.setBounds(175, 7, 117, 20);
		add(comboBoxTeams);
		comboBoxTeams.setEnabled(false);
		
		comboBoxAthlete = new JComboBox();
		comboBoxAthlete.setBounds(175,38, 117, 20);
		comboBoxAthlete.setEnabled(false);
		add(comboBoxAthlete);
		comboBoxAthlete.setEnabled(false);
		
		
 }
		
	public void	init(){
			
		initLabel();
		initArrays();
		initComboBox();
		initJRadioButton();
		}
	
	
	
   
    
    
    
    
  
			
		
	
	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new RemoveAthleteFromTeamPanel(getClient());
	}
}



