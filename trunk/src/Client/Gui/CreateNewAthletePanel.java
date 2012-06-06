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
import Server.DataBase.Team;
import Server.DataBase.User;
import Server.Message.MessageAssignAthleteToTeam;
import Server.Message.MessageAssignAthleteToTeamReplay;
import Server.Message.MessageCreateNewAthlete;
import Server.Message.MessageCreateNewAthleteReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeam;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamReplay;
import Server.Message.MessageGetAllusers;
import Server.Message.MessageGetAllusersReplay;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;



public class CreateNewAthletePanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User athlete;
	private Team team;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
    private	JLabel lblUserName;
    private	JLabel lblPassword;
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private JButton btnCreate;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
    private ArrayList<Team> allTeamArray =null;
    private JComboBox ChooseTeamCombo;
    private JLabel lblChooseTeam;
    
    private ArrayList<User> userarray =null;
    private JLabel lblNewLabel_1;
	
	public CreateNewAthletePanel(ClientIF client) {
		super(PanelType.CREATE_NEW_ATHLETE_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
			
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
		
		userarray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllusers());
		MessageGetAllusersReplay rep= (MessageGetAllusersReplay)getClient().getMessageFromServer();
		userarray = rep.getUserArray();
	}


public  int checkvalid(int x){
	int i=0;
	int flag=1;
	while(i<userarray.size()){
		if(userarray.get(i).getUserName().equals(textFieldUserName.getText())){
			popUp("Name already exists");
			flag=0;
			break;
			}	 
		i++;
	}
	if(flag==1&&x==0)
		popUp("The name is good");
	
	return flag;
}
public void initComboBoxs()
{
	
	ChooseTeamCombo = new JComboBox();
	ChooseTeamCombo.setFont(new Font("Arial", Font.PLAIN, 15));
	ChooseTeamCombo.setBackground(Color.WHITE);
	ChooseTeamCombo.setBounds(155, 83, 174, 25);
	add(ChooseTeamCombo);
	
	lblNewLabel_1 = new JLabel("Create New Athlete:");
	lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
	lblNewLabel_1.setBounds(25, 35, 202, 30);
	add(lblNewLabel_1);
	
	
}
public void initLabels(){
		
   
    lblNewLabel = new JLabel("First Name(*):");
    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	lblNewLabel.setBounds(23, 120, 92, 25);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name(*):");
    lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblLastName.setBounds(23, 155, 204, 25);
	add(lblLastName);
	
	
    lblUserName = new JLabel("User Name(*):");
    lblUserName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblUserName.setBounds(23, 190, 204, 25);
	add(lblUserName);
	
	
	
	lblPassword = new JLabel("Password(*):");
	lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPassword.setBounds(23, 225, 92, 25);
	add(lblPassword);
	
	lblPhoneNumber = new JLabel("Phone Number(*):");
	lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPhoneNumber.setBounds(23,260, 204, 25);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address(*):");
	lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
	lblAddress.setBounds(23, 295, 92, 25);
	add(lblAddress);
	
	lblChooseTeam = new JLabel("Choose Team:");
	lblChooseTeam.setFont(new Font("Arial", Font.PLAIN, 15));
	lblChooseTeam.setBounds(23, 85, 104, 25);
	add(lblChooseTeam);
		
	}
    
    
    public void initTextField(){
    	
    	textFieldFirstName = new JTextField();
    	textFieldFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldFirstName.setBounds(155, 118, 174, 25);
    	add(textFieldFirstName);
    	textFieldFirstName.setColumns(10);
    	

    	textFieldLastName = new JTextField();
    	textFieldLastName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldLastName.setBounds(155, 155, 174, 25);
    	add(textFieldLastName);
    	textFieldLastName.setColumns(10);
    	
    	textFieldUserName = new JTextField();
    	textFieldUserName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldUserName.setBounds(155, 190, 174, 25);
    	add(textFieldUserName);
    	textFieldUserName.setColumns(10);
    	
    	textFieldPassword = new JTextField();
    	textFieldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPassword.setBounds(155, 225, 174, 25);
    	add(textFieldPassword);
    	textFieldPassword.setColumns(10);
    	
    	textFieldPhoneNumber = new JTextField();
    	textFieldPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPhoneNumber.setBounds(155, 260, 174, 25);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldAddress.setBounds(155, 295, 174, 25);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    
    	
    
    }
    
    
    
   public void initButton(){
	   btnCreate = new JButton("Create New Athlete");
	   btnCreate.setForeground(Color.BLUE);
	   btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
	   btnCreate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String msg;
	   		int fromCreate=1;
	   		int nameisgood;
	   		nameisgood=checkvalid(fromCreate);
	   		if(nameisgood==1){
	   			if(!(ChooseTeamCombo.getSelectedIndex()==0)){
	   				team = (Team)ChooseTeamCombo.getSelectedItem();
	   				String selected="Choose..";
	   				int i=1 , privilge=2 ,online=0;
	   				
	   				if((!textFieldFirstName.getText().isEmpty()&&!textFieldLastName.getText().isEmpty()&&!textFieldUserName.getText().isEmpty()&&!textFieldPassword.getText().isEmpty()&&!textFieldPhoneNumber.getText().isEmpty()&&!textFieldAddress.getText().isEmpty())){
	   					
	   					athlete=new User (i,textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUserName.getText(),textFieldPassword.getText(),privilge,textFieldPhoneNumber.getText(),textFieldAddress.getText(),online);
	   					
	   					
	   					getClient().sendMsgToServer(new MessageCreateNewAthlete(athlete));
	   					MessageCreateNewAthleteReplay rep= (MessageCreateNewAthleteReplay)getClient().getMessageFromServer();
	   					
	   					getClient().sendMsgToServer(new MessageAssignAthleteToTeam(rep.getAthelteId(),team.getTeamId()));
	   					MessageAssignAthleteToTeamReplay rep3= (MessageAssignAthleteToTeamReplay)getClient().getMessageFromServer();
	   					
	   					if(rep.getAthelteId()!=0&&rep3.getsuccssed()==1){
	   						msg="Athlete Has Been Created and assign to your team";
	   						
	   						popUp(msg);
	   						
	   						getClient().swapFromBack(pushPanel());
	   						
	   					}
	   				}
	   				else { 
	   					msg="Please Fill All Field";
	   					popUp(msg);
	   				}
	   				
	   			}
	   			else { 
	   				msg="Please choose team";
	   				popUp(msg);
	   			}
	   		}	
	   			
	   		} });
	   btnCreate.setBounds(119, 390, 201, 30);
		add(btnCreate);
		
		JLabel lblPleaseFill = new JLabel("(*) Please Fill All Field.");
		lblPleaseFill.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPleaseFill.setBounds(23, 354, 204, 25);
		add(lblPleaseFill);
   }
    
	  public void init()
    {
		  initLabels();
		  initTextField();
		  initButton();
		  initArrays();
		  initComboBoxs();
		  
		  
		  
		  
		  for (int i=0; i<=allTeamArray.size(); i++)
			{
				if (i==0) ChooseTeamCombo.addItem("Choose..");
				else ChooseTeamCombo.addItem(allTeamArray.get(i-1));
				}
		  
		
    }

	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new CreateNewAthletePanel(getClient());
	}
}



