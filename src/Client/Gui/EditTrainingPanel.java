package Client.Gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;

import java.awt.event.ActionListener;
import Client.Logic.ClientIF;
import javax.swing.JButton;


public class EditTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxTeams;
	private JComboBox comboBoxAthlete;
	private JComboBox comboBoxTraining;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private JRadioButton rdbtnTeamTraining;
	private JRadioButton rdbtnPersonalTraining;
	private JLabel lblChooseTraining;
	private JButton btnBringTraining;
	private Team team1;
	
	
	public EditTrainingPanel(ClientIF client) {
		super(PanelType.EDIT_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPerformedTraining = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPerformedTraining.setBounds(477, 11, 12, 43);
			add(lblPerformedTraining);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   init();
	}
	
	public void inittable(){
		
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
		lblChooseTraining.setBounds(10, 78, 105, 14);
		add(lblChooseTraining);
		
		
	}
	public void initBtn(){
		btnBringTraining = new JButton("bring training");
		
		add(btnBringTraining);
		
	}
	 public void initJRadioButton(){
			
		    rdbtnTeamTraining = new JRadioButton("team training");
		    rdbtnTeamTraining.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    			if(rdbtnTeamTraining.isSelected()){
		    				comboBoxTeams.setEnabled(true);
		    				comboBoxAthlete.setEnabled(false);
		    				if(rdbtnPersonalTraining.isSelected())
		    					rdbtnPersonalTraining.doClick();
		    				comboBoxTeams.setEnabled(true);
		    			}
		    			else 
		    				comboBoxTeams.setEnabled(false);	
		    			
		    			
		    	}
		    });
			rdbtnTeamTraining.setBounds(6, 7, 109, 23);
			add(rdbtnTeamTraining);
			
			rdbtnPersonalTraining = new JRadioButton("personal training");
			rdbtnPersonalTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnPersonalTraining.isSelected()){
						comboBoxAthlete.setEnabled(true);
						comboBoxTeams.setEnabled(false);
	    				if(rdbtnTeamTraining.isSelected())
	    					rdbtnTeamTraining.doClick();
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

			rdbtnPersonalTraining.setBounds(6, 34, 109, 23);
			add(rdbtnPersonalTraining); 
			
			
	 }
	
	 public void initComboBox(){

			comboBoxTraining = new JComboBox();
			comboBoxTraining.setBounds(151,75, 117, 20);
			comboBoxTraining.setEnabled(false);
			add(comboBoxTraining);
			comboBoxTraining.setEnabled(false);
			
		    comboBoxTeams = new JComboBox();
			comboBoxTeams.setBounds(151, 7, 117, 20);
			add(comboBoxTeams);
			comboBoxTeams.setEnabled(false);
			
			comboBoxAthlete = new JComboBox();
			comboBoxAthlete.setBounds(151,38, 117, 20);
			comboBoxAthlete.setEnabled(false);
			add(comboBoxAthlete);
			comboBoxAthlete.setEnabled(false);
			
			
	 }
	public void init(){
		initComboBox();
		initArrays();
		initJRadioButton();
		initBtn();
		initLabel();
		 for (int i=0; i<=allTeamArray.size(); i++)
			{
				if (i==0) comboBoxTeams.addItem("Choose..");
				else comboBoxTeams.addItem(allTeamArray.get(i-1));
				}
		  
		  for (int j=0; j<=allAthleteArray.size(); j++)
			{
				if (j==0) comboBoxAthlete.addItem("Choose..");
				else comboBoxAthlete.addItem(allAthleteArray.get(j-1));
				}
		  btnBringTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){			
						allTeamTrainingArray = new ArrayList<plannedteamtraining>();
						team1 = (Team)comboBoxTeams.getSelectedItem();
					  	getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(team1.getTeamId()));
					  	MessageGetAllTeamTrainingByTeamIdReplay rep5= (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
						allTeamTrainingArray = rep5.getArray();
							
		    			
		    			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
		    				{
		    					if (i==0) comboBoxTraining.addItem("Choose..");
		    					else comboBoxTraining.addItem(allTeamTrainingArray.get(i-1));
		    					}
		    			 comboBoxTraining.setEnabled(true);
		    		}
		    		
					
				}
			});
			btnBringTraining.setBounds(278, 6, 117, 23);
	
	}
	
	private void popUp(String msg){
		
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new EditTrainingPanel(getClient());
	}
}



