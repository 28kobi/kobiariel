package Client.Gui;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Client.Logic.ClientIF;
import Server.DataBase.Team;
import Server.DataBase.User;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeam;
import Server.Message.MessageGetAllTeamReplay;
import Server.Message.MessageGetUserByUserId;
import Server.Message.MessageGetUserByUserIdReplay;
import Server.Message.MessageUpdateTeam;
import Server.Message.MessageUpdateTeamReplay;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class EditTeamPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;


	protected static final JTextField ChooseUserCombo = null;
	
	
	private Team team;
	private User coach;
	private String selectedteam;
	private String TeamNameStr;
	private String CoachNameStr;
	private String CoachNameStr2;
	private int SelectedCoachId;
	private ArrayList<User> allCoachArray =null;
	private ArrayList<Team> allTeamArray =null;
	private JComboBox ChooseTeamCombo;
	private JComboBox ChooseCoachCombo;
	private JTextField TeamName;
	private JTextField CoachName;
	private JLabel lblEditTeam;
	private JLabel lblChooseTeam;
	private JLabel lblTeamName;
	private JLabel lblCoachName;
	private JRadioButton rdbtnChangeCoach;
	private JButton btnUpdate;
	
	
	
	
	
	 public EditTeamPanel(ClientIF client) {
         super(PanelType.EDIT_TEAM_PANEL, client);
         setLayout(null);
         BufferedImage myPic;
         try {
                 myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
         
                 JLabel lblAddClass = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
                 lblAddClass.setBounds(478, 13, 259, 99);
                 add(lblAddClass);
                 
                 getClient().getUser().toString();
         
         } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
      
         
         init();
 }
	
	public void initArrays(){
		
		allCoachArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllCoach());
		MessageGetAllCoachReplay rep= (MessageGetAllCoachReplay)getClient().getMessageFromServer();
		allCoachArray = rep.getArray();
		

		allTeamArray = new ArrayList<Team>();
		getClient().sendMsgToServer(new MessageGetAllTeam());
		MessageGetAllTeamReplay rep1= (MessageGetAllTeamReplay)getClient().getMessageFromServer();
		allTeamArray = rep1.getArray();
		
	}
	
	
	public void initComboBoxs()
	{
		ChooseCoachCombo = new JComboBox();
		ChooseCoachCombo.setBounds(191, 230, 174, 20);
		add(ChooseCoachCombo);
		
		ChooseTeamCombo = new JComboBox();
		ChooseTeamCombo.setBounds(191, 65, 174, 20);
		add(ChooseTeamCombo);
	}
	
	
	 public void initLabels(){
		 
		lblChooseTeam = new JLabel("Choose Team : ");
		lblChooseTeam.setBounds(53, 68, 128, 14);
		add(lblChooseTeam);
		
		lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(53, 133, 128, 14);
		add(lblTeamName);
		
		lblCoachName = new JLabel("Coach Name:");
		lblCoachName.setBounds(53, 177, 128, 14);
		add(lblCoachName);
	 
	 }
	 public void initTextField(){
		 

			TeamName = new JTextField();
			TeamName.setBounds(190, 130, 175, 20);
			add(TeamName);
			TeamName.setColumns(10);
			
			CoachName = new JTextField();
			CoachName.setBounds(191, 174, 174, 20);
			add(CoachName);
			CoachName.setColumns(10);
		 
		 
	 }
	 
	 
	 public void initRadio(){
		 
		 rdbtnChangeCoach = new JRadioButton("Change Coach To:");
		 rdbtnChangeCoach.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtnChangeCoach.isSelected()){
		 			 ChooseCoachCombo.setEnabled(true);
		 			 ChooseCoachCombo.addActionListener(new CoachListener());
		 	
		 		}
		 		else
		 			{
		 			ChooseCoachCombo.setEnabled(false);
		 			
		 			
		 			
		 			 selectedteam = (String)ChooseTeamCombo.getSelectedItem();
					 int i=0;
						while(!allTeamArray.get(i).getTeamName().equals(selectedteam))i++;
						TeamNameStr= allTeamArray.get(i).getTeamName();
						TeamName.setText(TeamNameStr);
						SelectedCoachId= allTeamArray.get(i).getCoachId();
						
						
						getClient().sendMsgToServer(new MessageGetUserByUserId(SelectedCoachId));
						MessageGetUserByUserIdReplay rep = (MessageGetUserByUserIdReplay) getClient().getMessageFromServer();
						CoachNameStr=rep.getCoach().getFirstName()+" "+rep.getCoach().getLastName();
						CoachName.setText(CoachNameStr);
						
	
		 			
		 			}
		 		
		 			
		 	 	}
		 });
		 rdbtnChangeCoach.setBounds(38, 229, 128, 23);
		 add(rdbtnChangeCoach);
		 
		 
	 }
	 public void initButton(){
			   btnUpdate = new JButton("Update");
			   btnUpdate.addActionListener(new ActionListener() {
			   	public void actionPerformed(ActionEvent e) {
			   		int i=0;
		    		int flag=0;
		    		while(i<allTeamArray.size()){
		    			if((allTeamArray.get(i).getTeamName().equals(TeamName.getText()))&&!(TeamName.getText().equals(team.getTeamName()))){
		    				popUp("Name already exists");
		    				flag=1;
		    				break;
		    				}	 
		    			i++;
		    		}
		    		if(flag==0){
		    		
			   		
			   		
			   		team.setTeamName(TeamName.getText());
			   		if(rdbtnChangeCoach.isSelected())
			   		team.setCoachId(coach.getIdUser());
			   		
			   		getClient().sendMsgToServer(new MessageUpdateTeam(team));
			   		MessageUpdateTeamReplay rep= (MessageUpdateTeamReplay) getClient().getMessageFromServer();
					
			   		
					if(rep.getBoolean()==true){
						
						popUp("Update Team Success");
						
						getClient().swapFromBack(pushPanel());
						
						
					}
					
					else popUp("Update Team fail");
							
		    		}
		    		
			   			   		
			   	}
			   });
			   btnUpdate.setBounds(191, 397, 89, 23);
				  add(btnUpdate);
		   }
		 
	
	 
	 
	
	 public void  init()
	    {
		 initArrays();
		 initComboBoxs();
		 initLabels();
		 initTextField();
		 initRadio();
		 initButton();
			  
			  
			  for (int i=0; i<=allCoachArray.size(); i++)
				{
					if (i==0) ChooseCoachCombo.addItem("Choose..");
					else ChooseCoachCombo.addItem(allCoachArray.get(i-1));
					}
			  ChooseCoachCombo.setEnabled(false);
			  
			 
			  
			  for (int i=0; i<=allTeamArray.size(); i++)
				{
					if (i==0) ChooseTeamCombo.addItem("Choose..");
					else ChooseTeamCombo.addItem(allTeamArray.get(i-1));
					}
			  ChooseTeamCombo.addActionListener(new TeamListener());

	    }
	 private class TeamListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				 team=(Team)ChooseTeamCombo.getSelectedItem();
					TeamName.setText(team.getTeamName());
					SelectedCoachId= team.getCoachId();
					
					
					
					getClient().sendMsgToServer(new MessageGetUserByUserId(SelectedCoachId));
					MessageGetUserByUserIdReplay rep = (MessageGetUserByUserIdReplay) getClient().getMessageFromServer();
					CoachNameStr=rep.getCoach().getFirstName()+" "+rep.getCoach().getLastName();
					CoachName.setText(CoachNameStr);
					
					
						
					
				}
			
				
			
			}
	 private class CoachListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				coach=(User)ChooseCoachCombo.getSelectedItem();
				CoachNameStr2=coach.getFirstName()+" "+coach.getLastName();
				CoachName.setText(CoachNameStr2);
				
			}
				
			}
	
		
	
	private void popUp(String str){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),str);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new EditTeamPanel(getClient());
	}
}



