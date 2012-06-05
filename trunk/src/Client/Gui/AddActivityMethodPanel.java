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
    private JButton btnCreate;
    private JTextField textFieldActivityName;
    private ArrayList<activitytype> activitytype =null;
    
	
	
	public AddActivityMethodPanel(ClientIF client) {
		super(PanelType.ADD_ACTIVITY_TYPE_PANEL, client);
		
			JLabel lblAddActivityMethod = new JLabel();
			lblAddActivityMethod.setBounds(643, 13, -46, 10);
			add(lblAddActivityMethod);
			
			str = getClient().getUser().toString();
			
		
		setLayout(null);
		
		init();
	}
	
	  public void initLabels(){
			
		   
		    lblActivityName = new JLabel("Activity Name:");
		    lblActivityName.setBounds(0, 120, 115, 14);
			add(lblActivityName);
		
			}
	  
	    public void initTextField(){
	    	
	    	textFieldActivityName = new JTextField();
	    	textFieldActivityName.setBounds(96, 120, 224, 20);
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
	    		if(activitytype.get(i).getActivityName().equals(textFieldActivityName.getText())){
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
	 	   btnCreate = new JButton("CREATE NEW ACTIVITY TYPE ");
	 	   btnCreate.addActionListener(new ActionListener() {
	 	   	public void actionPerformed(ActionEvent e) {
	 	   		String msg;
	 	   		int fromCreate=1;
	 	   		int nameisgood;
	 	   		nameisgood=checkvalid(fromCreate);
	 	   		if(nameisgood==1){
	 	   			if(!textFieldActivityName.getText().isEmpty()){
	 		
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
	 	   btnCreate.setBounds(96, 213, 224, 23);
	 		add(btnCreate);
	 		
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



