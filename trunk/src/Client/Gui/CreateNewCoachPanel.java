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
import Server.DataBase.User;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllusers;
import Server.Message.MessageGetAllusersReplay;
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
import java.awt.Font;


public class CreateNewCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User coach;
	private boolean UpdateAnswer;
	private ArrayList<User> userarray =null;
    private	JLabel lblChooseCoach;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
    private	JLabel lblUserName;
    private	JLabel lblPassword;
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private JButton btnCreate;
    private JLabel lblNewLabelAnswer;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
   
    private  JButton btnCheckExiting;
    private JLabel lblNewLabel_1;
    private JLabel lblPleaseFill;
	
	
	public CreateNewCoachPanel(ClientIF client) {
		super(PanelType.CREATE_NEW_COACH_PANEL, client);
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
	
	
    public void initLabels(){
		
   
    lblNewLabel = new JLabel("First Name(*):");
    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	lblNewLabel.setBounds(23, 120, 92, 14);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name(*):");
    lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblLastName.setBounds(23, 155, 92, 14);
	add(lblLastName);
	
	
    lblUserName = new JLabel("User Name(*):");
    lblUserName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblUserName.setBounds(23, 190, 99, 14);
	add(lblUserName);
	
	
	
	lblPassword = new JLabel("Password(*):");
	lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPassword.setBounds(23, 225, 92, 14);
	add(lblPassword);
	
	lblPhoneNumber = new JLabel("Phone Number(*):");
	lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPhoneNumber.setBounds(23,260, 119, 14);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address(*):");
	lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
	lblAddress.setBounds(23, 295, 92, 14);
	add(lblAddress);
		
	}
    
    
    public void initTextField(){
    	
    	textFieldFirstName = new JTextField();
    	textFieldFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldFirstName.setBounds(144, 115, 200, 25);
    	add(textFieldFirstName);
    	textFieldFirstName.setColumns(10);
    	

    	textFieldLastName = new JTextField();
    	textFieldLastName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldLastName.setBounds(144, 150, 200, 25);
    	add(textFieldLastName);
    	textFieldLastName.setColumns(10);
    	
    	textFieldUserName = new JTextField();
    	textFieldUserName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldUserName.setBounds(144, 185, 200, 25);
    	add(textFieldUserName);
    	textFieldUserName.setColumns(10);
    	
    	textFieldPassword = new JTextField();
    	textFieldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPassword.setBounds(144, 220, 200, 25);
    	add(textFieldPassword);
    	textFieldPassword.setColumns(10);
    	
    	textFieldPhoneNumber = new JTextField();
    	textFieldPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPhoneNumber.setBounds(144, 255, 200, 25);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldAddress.setBounds(144, 290, 200, 25);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    	
    }
    
    public  int checkvalid(int x){
    	int i=0;
    	int flag=1;
    	String msg;
    	if(textFieldUserName.getText().equals("")){
    		popUp("user name field is empty");
				flag=2;
				return flag;
    	}
    		
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
  public void initArray(){
    	
	  	userarray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllusers());
		MessageGetAllusersReplay rep= (MessageGetAllusersReplay)getClient().getMessageFromServer();
		userarray = rep.getUserArray();
		
    	
    	
    	
    }
   public void initButton(){
	   btnCreate = new JButton("Create New Coach");
	   btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
	   btnCreate.setForeground(Color.BLUE);
	   btnCreate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String msg;
	   		int i=1 , privilge=0 ,online=0;
	   		int fromCreate=1;
	   		int nameisgood=0;
	   		nameisgood=checkvalid(fromCreate);
	   		if(nameisgood==1){
	   			if(!textFieldFirstName.getText().isEmpty()&&!textFieldLastName.getText().isEmpty()&&!textFieldUserName.getText().isEmpty()&&!textFieldPassword.getText().isEmpty()&&!textFieldPhoneNumber.getText().isEmpty()&&!textFieldAddress.getText().isEmpty()){
		
	   				coach=new User (i,textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUserName.getText(),textFieldPassword.getText(),privilge,textFieldPhoneNumber.getText(),textFieldAddress.getText(),online);
	   		
	   				getClient().sendMsgToServer(new MessageCreateNewCoach(coach));
	   				MessageCreateNewCoachReplay rep= (MessageCreateNewCoachReplay)getClient().getMessageFromServer();
			
	   		
	   				if(rep.getBoolean()==1){
	   					msg="Coach Has Been Created";
				
	   					popUp(msg);
				
	   					getClient().swapFromBack(pushPanel());
	   				
				
	   				}
			
	   				else lblNewLabelAnswer.setText("Update coach fail");
	   			}	
	   			
	   			
	   			
	   			else{
	   			msg="Please Fill All Field.";
	   			popUp(msg);
	   			}
			
	   		}
	   		
	   		
	   	
	   	} });
	   btnCreate.setBounds(119, 390, 201, 30);
		add(btnCreate);
		
		lblPleaseFill = new JLabel("(*) Please Fill All Field.");
		lblPleaseFill.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPleaseFill.setBounds(23, 354, 152, 25);
		add(lblPleaseFill);
		
		btnCheckExiting = new JButton("Check Availability");
		btnCheckExiting.setForeground(Color.BLUE);
		btnCheckExiting.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCheckExiting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fromValid=0;
			    checkvalid(fromValid);
				 
			}
		});
		btnCheckExiting.setBounds(368, 187, 152, 30);
		add(btnCheckExiting);
		
		lblNewLabel_1 = new JLabel("Create New Coach:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 60, 243, 30);
		add(lblNewLabel_1);
   }
    
	  public void init()
    {
		  initArray();
		  initLabels();
		  initTextField();
		  initButton();
		
    }

	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new CreateNewCoachPanel(getClient());
	}
}



