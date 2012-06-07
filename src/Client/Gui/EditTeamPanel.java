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
import java.awt.Font;
import java.awt.Color;


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
	private JLabel lblTeamDetail;
	
	
	
	
	
	 public EditTeamPanel(ClientIF client) {
         super(PanelType.EDIT_TEAM_PANEL, client);
         setLayout(null);
         BufferedImage myPic;
         try {
                 myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
                 
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
		ChooseCoachCombo.setBackground(Color.WHITE);
		ChooseCoachCombo.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseCoachCombo.setBounds(207, 229, 174, 25);
		add(ChooseCoachCombo);
		
		ChooseTeamCombo = new JComboBox();
		ChooseTeamCombo.setBackground(Color.WHITE);
		ChooseTeamCombo.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseTeamCombo.setBounds(207, 105, 174, 25);
		add(ChooseTeamCombo);
	}
	
	
	 public void initLabels(){
		 
		lblChooseTeam = new JLabel("Choose Team : ");
		lblChooseTeam.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseTeam.setBounds(53, 105, 128, 25);
		add(lblChooseTeam);
		
		lblTeamName = new JLabel("Team Name:");
		lblTeamName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTeamName.setBounds(53, 141, 128, 25);
		add(lblTeamName);
		
		lblCoachName = new JLabel("Coach Name:");
		lblCoachName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCoachName.setBounds(53, 177, 128, 25);
		add(lblCoachName);
	 
	 }
	 public void initTextField(){
		 

			TeamName = new JTextField();
			TeamName.setFont(new Font("Arial", Font.PLAIN, 15));
			TeamName.setBounds(206, 141, 175, 25);
			add(TeamName);
			TeamName.setColumns(10);
			
			CoachName = new JTextField();
			CoachName.setFont(new Font("Arial", Font.PLAIN, 15));
			CoachName.setBounds(207, 177, 174, 25);
			add(CoachName);
			CoachName.setColumns(10);
		 
		 
	 }
	 
	 
	 public void initRadio(){
		 
		 rdbtnChangeCoach = new JRadioButton("Change Coach To:");
		 rdbtnChangeCoach.setFont(new Font("Arial", Font.PLAIN, 15));
		 rdbtnChangeCoach.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtnChangeCoach.isSelected()){
		 			 ChooseCoachCombo.setEnabled(true);
		 			 ChooseCoachCombo.addActionListener(new CoachListener());
		 	
		 		}
		 		else
		 			{
		 			ChooseCoachCombo.setEnabled(false);
		 			
		 			
		 			if(!ChooseTeamCombo.getSelectedItem().toString().equals("Choose..")){
		 				
		 			
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
		 		
		 			
		 	 	}
		 });
		 rdbtnChangeCoach.setBounds(38, 229, 163, 25);
		 add(rdbtnChangeCoach);
		 
		 
	 }
	 public void initButton(){
			   btnUpdate = new JButton("Update");
			   btnUpdate.setForeground(Color.BLUE);
			   btnUpdate.setFont(new Font("Arial", Font.PLAIN, 15));
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
		    		
			   		
		    		if(!ChooseTeamCombo.getSelectedItem().toString().equals("Choose..")){
		    			
		    			if(rdbtnChangeCoach.isSelected()){
		    				if(!ChooseCoachCombo.getSelectedItem().toString().equals("Choose..")){
		    					team.setCoachId(coach.getIdUser());
		    					team.setTeamName(TeamName.getText());
		    				}
		    			}
		    				getClient().sendMsgToServer(new MessageUpdateTeam(team));
		    				MessageUpdateTeamReplay rep= (MessageUpdateTeamReplay) getClient().getMessageFromServer();
		    				
		    				
		    				if(rep.getBoolean()==true){
		    					popUp("Update Team Success");
		    					getClient().swapFromBack(pushPanel()); 					
		    					}
		    				else popUp("Update Team fail");
		    			}    			
		    		
		    		else popUp("choose team...");
		    		}		   			
		    	}
			   });
			   btnUpdate.setBounds(191, 397, 89, 25);
				  add(btnUpdate);
				  btnUpdate.setEnabled(false);
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
			  
			  lblTeamDetail = new JLabel("Team Detail:");
			  lblTeamDetail.setFont(new Font("Arial", Font.PLAIN, 20));
			  lblTeamDetail.setBounds(71, 56, 121, 30);
			  add(lblTeamDetail);
			  
			 
			  
			  for (int i=0; i<=allTeamArray.size(); i++)
				{
					if (i==0) ChooseTeamCombo.addItem("Choose..");
					else ChooseTeamCombo.addItem(allTeamArray.get(i-1));
					}
			  ChooseTeamCombo.addActionListener(new TeamListener());

	    }
	 private class TeamListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(!ChooseTeamCombo.getSelectedItem().toString().equals("Choose..")){
						team=(Team)ChooseTeamCombo.getSelectedItem();
						TeamName.setText(team.getTeamName());
						SelectedCoachId= team.getCoachId();
						
						
						
						getClient().sendMsgToServer(new MessageGetUserByUserId(SelectedCoachId));
						MessageGetUserByUserIdReplay rep = (MessageGetUserByUserIdReplay) getClient().getMessageFromServer();
						CoachNameStr=rep.getCoach().getFirstName()+" "+rep.getCoach().getLastName();
						CoachName.setText(CoachNameStr);
						 btnUpdate.setEnabled(true);
						
					}
				else{
					popUp("choose team...");
					
				}
						
							
					
				}
			
			}
	 private class CoachListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(!ChooseCoachCombo.getSelectedItem().toString().equals("Choose..")){
					
				
				coach=(User)ChooseCoachCombo.getSelectedItem();
				CoachNameStr2=coach.getFirstName()+" "+coach.getLastName();
				CoachName.setText(CoachNameStr2);
				}
				
				
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



