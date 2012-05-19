
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
import Server.Message.MessageCreateNewAthlete;
import Server.Message.MessageCreateNewAthleteReplay;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllUnTeamedAthlete;
import Server.Message.MessageGetAllUnTeamedAthleteReplay;
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


public class AddAthleteToTeamPanel extends MyJPanel {
	
	
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
	
	
	public AddAthleteToTeamPanel(ClientIF client) {
		super(PanelType.ADD_ATHLETE_TO_TEAM_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblEditAthlete = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblEditAthlete.setBounds(149, 11, 340, 46);
			add(lblEditAthlete);
			
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
		getClient().sendMsgToServer(new MessageGetAllUnTeamedAthlete());
		MessageGetAllUnTeamedAthleteReplay rep2= (MessageGetAllUnTeamedAthleteReplay)getClient().getMessageFromServer();
		allAthleteArray = rep2.getArray();
		
	}



public void initComboBoxs()
{
	
	ChooseTeamCombo = new JComboBox();
	ChooseTeamCombo.setBounds(120, 85, 174, 20);
	add(ChooseTeamCombo);
	
	ChooseAtleteCombo = new JComboBox();
	ChooseAtleteCombo.setBounds(120, 149, 174, 20);
	add(ChooseAtleteCombo);
	
   
}


public void initbtn()
{
	 btnAddAthleteTo = new JButton("Add athlete to team");
		btnAddAthleteTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg;
				if((!(ChooseTeamCombo.getSelectedIndex()==0))&&(!(ChooseAtleteCombo.getSelectedIndex()==0))){
					team = (Team)ChooseTeamCombo.getSelectedItem();
					athlete=(User)ChooseAtleteCombo.getSelectedItem();
					
					getClient().sendMsgToServer(new MessageAssignAthleteToTeam(athlete.getIdUser(),team.getTeamId()));
	   				MessageAssignAthleteToTeamReplay rep3= (MessageAssignAthleteToTeamReplay)getClient().getMessageFromServer();
	   			
	   				if(rep3.getsuccssed()==1){
	   						msg="Athlete Has Been assign to your team";
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
		btnAddAthleteTo.setBounds(120, 246, 174, 20);
		add(btnAddAthleteTo);
		
}
public void initLabels(){
	
	lblChooseTeam = new JLabel("choose team:");
	lblChooseTeam.setBounds(23, 85, 89, 14);
	add(lblChooseTeam);
		
	lblChooseAthlete = new JLabel("choose Athlete:");
	lblChooseAthlete.setBounds(23, 149, 89, 14);
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
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new AddAthleteToTeamPanel(getClient());
	}
}



