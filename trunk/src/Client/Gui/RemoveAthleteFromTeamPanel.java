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
import Server.Message.MessageAssignAthleteToTeam;
import Server.Message.MessageAssignAthleteToTeamReplay;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllUnTeamedAthlete;
import Server.Message.MessageGetAllUnTeamedAthleteReplay;
import Server.Message.MessageRemoveAthleteFromTeam;
import Server.Message.MessageRemoveAthleteFromTeamReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;


public class RemoveAthleteFromTeamPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User athlete;
	private Team team;
    private JButton btnCreate;
    private ArrayList<Team> allTeamArray =null;
    private ArrayList<User> allAthleteArray =null;
    private JComboBox ChooseTeamCombo;
    private JComboBox ChooseAtleteCombo;
    private JLabel lblChooseTeam;
    private JLabel lblChooseAthlete;
    private  JButton btnAddAthleteTo;
	
    
    
	
	
	public RemoveAthleteFromTeamPanel(ClientIF client) {
		super(PanelType.REMOVE_ATHLETE_FROM_TEAM_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblRemoveAthlete = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblRemoveAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
			lblRemoveAthlete.setBounds(149, 11, 340, 46);
			add(lblRemoveAthlete);
			
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
			getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(getClient().getUser().getIdUser()));
			MessageGetAllAthleteByCoachIdReplay rep2= (MessageGetAllAthleteByCoachIdReplay)getClient().getMessageFromServer();
			allAthleteArray = rep2.getArray();
			
		}



	public void initComboBoxs()
	{
		
		ChooseTeamCombo = new JComboBox();
		ChooseTeamCombo.setBackground(Color.WHITE);
		ChooseTeamCombo.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseTeamCombo.setBounds(142, 113, 174, 25);
		add(ChooseTeamCombo);
		
		ChooseAtleteCombo = new JComboBox();
		ChooseAtleteCombo.setBackground(Color.WHITE);
		ChooseAtleteCombo.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseAtleteCombo.setBounds(142, 149, 174, 25);
		add(ChooseAtleteCombo);
		
		JLabel lblNewLabel = new JLabel("Remove Athlete From Team:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 41, 262, 30);
		add(lblNewLabel);
		
	   
	}


	public void initbtn()
	{
		 btnAddAthleteTo = new JButton("Remove Athlete");
		 btnAddAthleteTo.setForeground(Color.BLUE);
		 btnAddAthleteTo.setFont(new Font("Arial", Font.PLAIN, 15));
			btnAddAthleteTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg;
					if((!(ChooseTeamCombo.getSelectedIndex()==0))&&(!(ChooseAtleteCombo.getSelectedIndex()==0))){
						team = (Team)ChooseTeamCombo.getSelectedItem();
						athlete=(User)ChooseAtleteCombo.getSelectedItem();
						
						getClient().sendMsgToServer(new MessageRemoveAthleteFromTeam(athlete.getIdUser()));
						MessageRemoveAthleteFromTeamReplay rep3= (MessageRemoveAthleteFromTeamReplay)getClient().getMessageFromServer();
		   			
		   				if(rep3.getsuccssed()==1){
		   						msg="Athlete Has Been removed form the team";
								popUp(msg);
								getClient().swapFromBack(pushPanel());
		   						}
		   			}
		   		   else { 
		   				msg="Please choose team and athlete";
		   				popUp(msg);
		    	     }		
				}
			});
			btnAddAthleteTo.setBounds(142, 244, 145, 45);
			add(btnAddAthleteTo);
			
	}
	public void initLabels(){
		
		lblChooseTeam = new JLabel("Choose Team:");
		lblChooseTeam.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseTeam.setBounds(23, 113, 109, 25);
		add(lblChooseTeam);
			
		lblChooseAthlete = new JLabel("Choose Athlete:");
		lblChooseAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseAthlete.setBounds(23, 149, 109, 25);
		add(lblChooseAthlete);
		
		}
	    
	   
	    
	  
		   
		  public void init()
	    {
			  initLabels();
			  initbtn();
			  initArrays();
			  initComboBoxs();
			  
			  
			  
			  
			  for (int i=0; i<=allTeamArray.size(); i++)
				{
					if (i==0) ChooseTeamCombo.addItem("Choose..");
					else ChooseTeamCombo.addItem(allTeamArray.get(i-1));
					}
			  
			  for (int i=0; i<=allAthleteArray.size(); i++)
				{
					if (i==0) ChooseAtleteCombo.addItem("Choose..");
					else ChooseAtleteCombo.addItem(allAthleteArray.get(i-1));
					}
			
	    }
	
		
	
	
	private void popUp(String msg){
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new RemoveAthleteFromTeamPanel(getClient());
	}
}



