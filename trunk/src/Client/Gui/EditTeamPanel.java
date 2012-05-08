package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Client.Logic.ClientIF;
import Server.DataBase.Team;
import Server.DataBase.TeamQuery;
import Server.DataBase.User;
import Server.DataBase.UserQuery;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeam;
import Server.Message.MessageGetAllTeamReplay;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class EditTeamPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> allCoachArray =null;
	private ArrayList<Team> allTeamArray =null;
	private JTextField TeamName;
	private JTextField CoachName;
	private JLabel lblEditTeam;
	private JLabel lblChooseTeam;
	private JComboBox ChooseTeamCombo;
	private JComboBox ChooseCoachCombo;
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
		ChooseCoachCombo.setBounds(176, 273, 174, 20);
		add(ChooseCoachCombo);
		
		ChooseTeamCombo = new JComboBox();
		ChooseTeamCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}});
		ChooseTeamCombo.setBounds(176, 68, 175, 20);
		add(ChooseTeamCombo);
	}
	
	
	 public void initLabels(){
		 
		lblChooseTeam = new JLabel("Choose Team : ");
		lblChooseTeam.setBounds(53, 68, 128, 14);
		add(lblChooseTeam);
		
		lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(53, 133, 94, 14);
		add(lblTeamName);
		
		lblCoachName = new JLabel("Coach Name:");
		lblCoachName.setBounds(53, 177, 74, 14);
		add(lblCoachName);
	 
	 }
	 public void initTextField(){
		 

			TeamName = new JTextField();
			TeamName.setBounds(176, 130, 175, 20);
			add(TeamName);
			TeamName.setColumns(10);
			
			CoachName = new JTextField();
			CoachName.setBounds(176, 174, 174, 20);
			add(CoachName);
			CoachName.setColumns(10);
		 
		 
	 }
	 
	 
	 public void initRadio(){
		 
		 rdbtnChangeCoach = new JRadioButton("Change Coach");
		 rdbtnChangeCoach.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtnChangeCoach.isSelected())
		 			 ChooseCoachCombo.setEnabled(true);
		 		else ChooseCoachCombo.setEnabled(false);
		 			
		 	 	}
		 });
		 rdbtnChangeCoach.setBounds(38, 229, 109, 23);
		 add(rdbtnChangeCoach);
		 
		 
	 }
	 public void initButton(){
		 btnUpdate = new JButton("Update");
		  btnUpdate.setBounds(176, 399, 89, 23);
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
					else ChooseTeamCombo.addItem(allTeamArray.get(i-1).getTeamName());
					}

	    }
	
	
	
	private void popUp(){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),"All Coach Details  Updates");
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new EditTeamPanel(getClient());
	}
}



