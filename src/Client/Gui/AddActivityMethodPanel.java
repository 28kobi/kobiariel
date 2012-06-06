package Client.Gui;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.Message.MessageCreateNewActivityType;
import Server.Message.MessageCreateNewActivityTypeReplay;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Client.Gui.MyJPanel.PanelType;
import Client.Logic.ClientIF;



public class AddActivityMethodPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private String str;
	private activitytype activity;
	private int UpdateAnswer;
    private	JLabel lblActivityName;
    private	JLabel  lblInsertActivityName;
    private	JLabel  lblAddActivityMethod;
    private JButton btnCreate;
    private JTextField textFieldActivityName;
    private ArrayList<activitytype> activitytype =null;
    
	
	
	public AddActivityMethodPanel(ClientIF client) {
		super(PanelType.ADD_ACTIVITY_TYPE_PANEL, client);
		
			lblAddActivityMethod = new JLabel();
			lblAddActivityMethod.setBounds(643, 13, -46, 10);
			add(lblAddActivityMethod);
			
			str = getClient().getUser().toString();
			
		
		setLayout(null);
		
		init();
	}
	
	  public void initLabels(){
	
		    lblActivityName = new JLabel("Activity Name:");
		    lblActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
		    lblActivityName.setBounds(0, 165, 115, 25);
			add(lblActivityName);
		
			}
	  
	    public void initTextField(){
	    	
	    	textFieldActivityName = new JTextField();
	    	textFieldActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
	    	textFieldActivityName.setBounds(113, 165, 243, 25);
	    	add(textFieldActivityName);
	    	textFieldActivityName.setColumns(10);
	    	
	    }

	    public void initArray(){
	    	
	    	activitytype = new ArrayList<activitytype>();
			getClient().sendMsgToServer(new MessageGetAllAactivityType());
			MessageGetAllAactivityTypeReplay rep= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
			activitytype = rep.getArray();
			
	    }
	    public  int checkvalid(int x){
	    	int i=0;
	    	int flag=1;
	    	while(i<activitytype.size()){
	    		if(activitytype.get(i).getActivityName().equalsIgnoreCase(textFieldActivityName.getText())){
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
	 	   btnCreate = new JButton("Create New Activity Type");
	 	   btnCreate.setForeground(Color.BLUE);
	 	   btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
	 	   btnCreate.addActionListener(new ActionListener() {
	 	   	public void actionPerformed(ActionEvent e) {
	 	   		String msg;
	 	   		int fromCreate=1;
	 	   		int nameisgood;
	 	   		nameisgood=checkvalid(fromCreate);
	 	   		if(nameisgood==1){
	 	   			if(!textFieldActivityName.getText().toString().equals("")){
	 		
	 	   				activity=new activitytype ();
	 	   				activity.setActivityName(textFieldActivityName.getText());
	 	   				activity.setActivityId(1);
	 	   				getClient().sendMsgToServer(new MessageCreateNewActivityType(activity));
	 	   				MessageCreateNewActivityTypeReplay rep= (MessageCreateNewActivityTypeReplay)getClient().getMessageFromServer();
	 	   				
	 	   				
	 	   				if(rep.getint()==1){
	 	   					msg="New Activity type Has Been Created";
	 	   					popUp(msg);
	 	   					getClient().swapFromBack(pushPanel());
	 	   					
	 	   					
	 	   				}
	 	   				else {
	 	   					
	 	   					msg="there was a problem adding activity type , try again";
	 	   					
	 	   					popUp(msg);
 				
	 	   					getClient().swapFromBack(pushPanel());
	 	   					
	 	   				}
	 	   				
	 	   			}	
	 	   			else { 
	 	   				msg="Please Fill the activity name";
	 	   				popUp(msg);
	 	   			}
	 			
	 	   		}	 		
	 	   	} });
	 	   btnCreate.setBounds(113, 208, 243, 30);
	 		add(btnCreate);
	 		
	 		 lblInsertActivityName = new JLabel("ADD ACTIVITY METHOD :");
	 		 lblInsertActivityName.setFont(new Font("Arial", Font.PLAIN, 20));
	 		lblInsertActivityName.setBounds(0, 68, 252, 30);
	 		add(lblInsertActivityName);
	 		
	    }
		    
	   public void init(){
		   
		   initTextField();
		   initLabels();
		   initButton();
		   initArray();
		   
	   }
	   
		 
		private void popUp(String msg){
			JOptionPane.showMessageDialog((Component) getClient(),msg);
				
			return ;
		}
		
	@Override
	public MyJPanel pushPanel() {
		return new AddActivityMethodPanel(getClient());
	}
}



