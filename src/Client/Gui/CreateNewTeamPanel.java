
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
import Server.Message.MessageCreateNewTeam;
import Server.Message.MessageCreateNewTeamReplay;
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




public class CreateNewTeamPanel extends MyJPanel {
	
	
    private static final long serialVersionUID = 1L;
	
	private ArrayList<User> allCoachArray =null;
	private ArrayList<Team> allTeamArray =null;
	private Team team;
	private JTextField TeamName;
	private JTextField CoachName;
	private JLabel lblEditTeam;
	private JLabel lblChooseTeam;
	private JComboBox ChooseCoachCombo;
	private JLabel lblTeamName;
	private JLabel lblCoachName;
	private JRadioButton rdbtnChangeCoach;
	private JButton btnCreate;
	private JButton verifyavailabilty;
	private JLabel lblNewLabel;
	
	
	
	
	public CreateNewTeamPanel(ClientIF client) {
		super(PanelType.CREAT_NEW_TEAM_PANEL, client);
		setLayout(null);
		try{
        BufferedImage myPic;
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
	ChooseCoachCombo.setBounds(176, 174, 174, 25);
	add(ChooseCoachCombo);
	
	
}
	


public void initLabels(){
	
	lblTeamName = new JLabel("Team Name:");
	lblTeamName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblTeamName.setBounds(53, 133, 94, 25);
	add(lblTeamName);
	
	lblCoachName = new JLabel("Choose Coach:");
	lblCoachName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblCoachName.setBounds(53, 177, 114, 25);
	add(lblCoachName);

}

public void initTextField(){
	 

	TeamName = new JTextField();
	TeamName.setFont(new Font("Arial", Font.PLAIN, 15));
	TeamName.setBounds(176, 130, 175, 25);
	add(TeamName);
	TeamName.setColumns(10);
	
}

public  int checkvalid(int x){
	int i=0;
	int flag=1;
	while(i<allTeamArray.size()){
		if(allTeamArray.get(i).getTeamName().equals(TeamName.getText())){
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


public void initButton(){
		btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.BLUE);
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nameisgood;
				int fromCreate=1;
				int ifTeamAdded=0;
				String selected="Choose..";
				nameisgood=checkvalid(fromCreate);
				if((!(TeamName.getText().equals(""))&&!(ChooseCoachCombo.getSelectedItem().equals(selected)))){
					if(nameisgood==1){
					
						User coach = (User)ChooseCoachCombo.getSelectedItem();
						
						getClient().sendMsgToServer(new MessageCreateNewTeam(coach.getIdUser(),TeamName.getText()));
						MessageCreateNewTeamReplay rep= (MessageCreateNewTeamReplay)getClient().getMessageFromServer();
						ifTeamAdded = rep.getint();
						if(ifTeamAdded==1)
							popUp("new team created");
						else 
							popUp("team not added, try again");	
					}
				}
				else popUp("you didnt choose coach / fill team details");
								
				
			}
		});
		btnCreate.setBounds(208, 309, 101, 40);
		add(btnCreate);
		
	    verifyavailabilty = new JButton("Verify Availability");
	    verifyavailabilty.setForeground(Color.BLUE);
	    verifyavailabilty.setFont(new Font("Arial", Font.PLAIN, 15));
	    verifyavailabilty.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!TeamName.getText().equals("")){
	    		
	    		int fromValid=0;
	    		checkvalid(fromValid);
	    		}
	    		else {
	    			popUp("fill name field first");
	    			}
	    	}
	    });
		verifyavailabilty.setBounds(402, 129,150, 30);
		add(verifyavailabilty);
		
		lblNewLabel = new JLabel("Create New Team:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(54, 59, 189, 30);
		add(lblNewLabel);
	 
}



public void  init()
   {
	 initArrays();
	 initComboBoxs();
	 initLabels();
	 initTextField();
	 initButton();
	 
	 for (int i=0; i<=allCoachArray.size(); i++)
		{
			if (i==0) ChooseCoachCombo.addItem("Choose..");
			else ChooseCoachCombo.addItem(allCoachArray.get(i-1));
			}

   }
		



private void popUp(String msg){
	Object[] options = {"Ok"};
	JOptionPane.showMessageDialog((Component) getClient(),msg);
		
	return ;
}





	@Override
	public MyJPanel pushPanel() {
		return new CreateNewTeamPanel(getClient());
	}
}


