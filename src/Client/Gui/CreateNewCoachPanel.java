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


public class CreateNewCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User coach;
	private boolean UpdateAnswer;
	
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
   
    
	
	
	public CreateNewCoachPanel(ClientIF client) {
		super(PanelType.CREATE_NEW_COACH_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblEditCoach = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblEditCoach.setBounds(149, 11, 340, 46);
			add(lblEditCoach);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   init();
	   
	}
	
	
    public void initLabels(){
		
   
    lblNewLabel = new JLabel("First Name(*):");
	lblNewLabel.setBounds(23, 120, 92, 14);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name(*):");
	lblLastName.setBounds(23, 155, 92, 14);
	add(lblLastName);
	
	
    lblUserName = new JLabel("User Name(*):");
	lblUserName.setBounds(23, 190, 92, 14);
	add(lblUserName);
	
	
	
	lblPassword = new JLabel("Password(*):");
	lblPassword.setBounds(23, 225, 92, 14);
	add(lblPassword);
	
	lblPhoneNumber = new JLabel("Phone Number(*):");
	lblPhoneNumber.setBounds(23,260, 92, 14);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address(*):");
	lblAddress.setBounds(23, 295, 92, 14);
	add(lblAddress);
		
	}
    
    
    public void initTextField(){
    	
    	textFieldFirstName = new JTextField();
    	textFieldFirstName.setBounds(120, 120, 200, 20);
    	add(textFieldFirstName);
    	textFieldFirstName.setColumns(10);
    	

    	textFieldLastName = new JTextField();
    	textFieldLastName.setBounds(120, 155, 200, 20);
    	add(textFieldLastName);
    	textFieldLastName.setColumns(10);
    	
    	textFieldUserName = new JTextField();
    	textFieldUserName.setBounds(120, 190, 200, 20);
    	add(textFieldUserName);
    	textFieldUserName.setColumns(10);
    	
    	textFieldPassword = new JTextField();
    	textFieldPassword.setBounds(120, 225, 200, 20);
    	add(textFieldPassword);
    	textFieldPassword.setColumns(10);
    	
    	textFieldPhoneNumber = new JTextField();
    	textFieldPhoneNumber.setBounds(120, 260, 200, 20);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setBounds(120, 295, 200, 20);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    	
    }
    
    
    
   public void initButton(){
	   btnCreate = new JButton("CREATE NEW COACH");
	   btnCreate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String msg;
	   		int i=1 , privilge=0 ,online=0;
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
	   		else { 
	   			msg="Please Fill All Field.";
	   			popUp(msg);
	   		}
			
		
	   			   		
	   	
	   	} });
	   btnCreate.setBounds(119, 390, 201, 23);
		add(btnCreate);
		
		JLabel lblPleaseFill = new JLabel("(*) Please Fill All Field.");
		lblPleaseFill.setBounds(23, 354, 119, 14);
		add(lblPleaseFill);
   }
    
	  public void init()
    {
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



