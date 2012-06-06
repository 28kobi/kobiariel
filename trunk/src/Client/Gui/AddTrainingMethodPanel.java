package Client.Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Server.DataBase.activitytype;
import Server.DataBase.trainingtype;
import Server.Message.MessageCreateNewTrainingType;
import Server.Message.MessageCreateNewTrainingTypeReplay;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;

import Client.Logic.ClientIF;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AddTrainingMethodPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private String str;
	private JComboBox comboBoxActivityType ;
	private JLabel lblChooseActivityConection;
	private activitytype activity;
	private trainingtype trainingType;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private JTextField textField;
	private ArrayList<trainingtype> trainingtype1 =null;
	private JLabel lblTrainingName;
	private JButton btnCreate;
	private JLabel lblAddTrainingMethod_1;
	private JLabel lblAddTrainingMethod;
	
	
	public AddTrainingMethodPanel(ClientIF client) {
		super(PanelType.ADD_TRAINING_METHOD_PANEL, client);
		
			 lblAddTrainingMethod = new JLabel();
			lblAddTrainingMethod.setBounds(487, 13, 110, 32);
			add(lblAddTrainingMethod);
			
			str = getClient().getUser().toString();
			
			
	
		setLayout(null);
		init();
	}
	
	
	   public  int checkvalid(int x){
	    	int i=0;
	    	int flag=1;
	    	while(i<trainingtype1.size()){
	    		if(trainingtype1.get(i).gettrainingName().equals(textField.getText())){
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
	    
	    
	public void initLbl(){
		

		lblTrainingName = new JLabel("Type name for training type:");
		lblTrainingName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTrainingName.setBounds(10, 121, 205, 25);
		add(lblTrainingName);

	    lblChooseActivityConection = new JLabel("Choose activity conection:");
	    lblChooseActivityConection.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseActivityConection.setBounds(10, 152, 191, 25);
		add(lblChooseActivityConection);
	}
	

	 public void initComboBox(){
		 
			comboBoxActivityType = new JComboBox();		
			comboBoxActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxActivityType.setBackground(Color.WHITE);
			comboBoxActivityType.setBounds(225, 154, 177, 25);
			add(comboBoxActivityType);
			
			
			
						
		
	 }
	 public void initTextField(){
		 
		 	textField = new JTextField();
		 	textField.setFont(new Font("Arial", Font.PLAIN, 15));
			textField.setBounds(225, 119, 177, 25);
			add(textField);
			textField.setColumns(10);
		 
	 }
	public void initbtn(){
			btnCreate= new JButton("Create training type");
			btnCreate.setForeground(Color.BLUE);
			btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String msg;
					int replay;
					if(!comboBoxActivityType.getSelectedItem().toString().equals("Choose..")) {
						activity=(activitytype)comboBoxActivityType.getSelectedItem();
						trainingtype1 = new ArrayList<trainingtype>();
						getClient().sendMsgToServer(new MessageGetAllTrainingType(activity.getActivityId()));
						MessageGetAllTrainingTypeReplay rep2= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
						trainingtype1 = rep2.getArray();
						int fromCreate=1;
			 	   		int nameisgood;
			 	   		nameisgood=checkvalid(fromCreate);
			 	   		if(nameisgood==1){
						
			 	   			if(!textField.getText().equals("")){
			 	   					trainingType = new trainingtype();
			 	   					trainingType.setActivityId(activity.getActivityId());
			 	   					trainingType.settrainingName(textField.getText());
			 	   				
			 	   					try {
			 	   							getClient().sendMsgToServer(new MessageCreateNewTrainingType(trainingType));
			 	   							MessageCreateNewTrainingTypeReplay rep= (MessageCreateNewTrainingTypeReplay)getClient().getMessageFromServer();
			 	   							replay=rep.getint();
			 	   							if(replay==1){
			 	   						
			 	   								msg=" training method added";
			 	   								popUp(msg);
			 	   							}
			 	   					}
			 	   					 catch (Exception e) {
			 	   						// 	TODO Auto-generated catch block
			 	   						e.printStackTrace();
			 	   					 }
			 	   					
			 	   				getClient().swapFromBack(pushPanel());
			 	   				
			 	   			}
			 	   			else{
			 	   				msg="you didnt gave name to the training method";
			 	   				popUp(msg);
			 	   			}
			 	   		
			 	   		}	
			 	   	
					}
					else{
		 	   			msg="you didnt choose any Activity Method";
		 	   			popUp(msg);
		 	   			}
				}
			});
			btnCreate.setBounds(195, 263, 177, 30);
			add(btnCreate);
			{
				lblAddTrainingMethod_1 = new JLabel("Add Training Method Panel:");
				lblAddTrainingMethod_1.setFont(new Font("Arial", Font.PLAIN, 20));
				lblAddTrainingMethod_1.setBounds(10, 52, 362, 24);
				add(lblAddTrainingMethod_1);
			}
		 
	 }
	 public void initArray(){
			       
			allAactivityTypeArray = new ArrayList<activitytype>();
			getClient().sendMsgToServer(new MessageGetAllAactivityType());
			MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
			allAactivityTypeArray = rep3.getArray();
			
			
		}
	 
	 public void init(){
		 initArray();
		 initLbl();
		 initTextField();
		 initComboBox();
		 initbtn();

		  for (int i=0; i<=allAactivityTypeArray.size(); i++)
			{
				if (i==0) comboBoxActivityType.addItem("Choose..");
				else comboBoxActivityType.addItem(allAactivityTypeArray.get(i-1));
				}
		 
	 }
	
	private void popUp(String msg){
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	@Override
	public MyJPanel pushPanel() {
		return new AddTrainingMethodPanel(getClient());
	}
}



