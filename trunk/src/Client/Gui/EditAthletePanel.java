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
import Server.DataBase.User;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllusers;
import Server.Message.MessageGetAllusersReplay;
import Server.Message.MessageUpdateAthlete;
import Server.Message.MessageUpdateAthleteReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


public class EditAthletePanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User Athlete;
	private JComboBox ChooseAthlete;
	private ArrayList<User> allAthleteArray =null;
    private	JLabel lblChooseAthlete;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
    private	JLabel lblUserName;
    private	JLabel lblPassword;
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private JLabel lblNewLabelAnswer;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
    private JButton btnUpdate;
    private ArrayList<User> userarray =null;
    
	
	
	public EditAthletePanel(ClientIF client) {
		super(PanelType.EDIT_ATHLETE_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblEditAthlete = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblEditAthlete.setBounds(149, 11, 340, 46);
			add(lblEditAthlete);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   init();
	   
	}
	
	
	public void initArrays(){
		allAthleteArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(getClient().getUser().getIdUser()));
		MessageGetAllAthleteByCoachIdReplay rep= (MessageGetAllAthleteByCoachIdReplay) getClient().getMessageFromServer();
		allAthleteArray = rep.getArray();
		
		userarray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllusers());
		MessageGetAllusersReplay rep3= (MessageGetAllusersReplay)getClient().getMessageFromServer();
		userarray = rep3.getUserArray();
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
		ChooseAthlete =new JComboBox();
		ChooseAthlete.setBounds(119, 68, 109, 20);
		add(ChooseAthlete);
		ChooseAthlete.setEnabled(true);
	}
	
	
    public void initLabels(){
		
    lblChooseAthlete = new JLabel("Choose Athlete:");
    lblChooseAthlete.setBounds(23, 67, 109, 23);
	add(lblChooseAthlete);
	
    lblNewLabel = new JLabel("First Name:");
	lblNewLabel.setBounds(23, 120, 71, 14);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name:");
	lblLastName.setBounds(23, 155, 64, 14);
	add(lblLastName);
	
	
    lblUserName = new JLabel("User Name:");
	lblUserName.setBounds(23, 190, 71, 14);
	add(lblUserName);
	
	
	
	lblPassword = new JLabel("Password:");
	lblPassword.setBounds(23, 225, 71, 14);
	add(lblPassword);
	
	
	
	lblPhoneNumber = new JLabel("Phone Number:");
	lblPhoneNumber.setBounds(23, 295, 92, 14);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address:");
	lblAddress.setBounds(23, 330, 64, 14);
	add(lblAddress);
	
	lblNewLabelAnswer = new JLabel("");
	lblNewLabelAnswer.setForeground(Color.blue);
	lblNewLabelAnswer.setBounds(300, 390,350, 23);
	add(lblNewLabelAnswer);
		
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
    	textFieldPhoneNumber.setBounds(120, 295, 200, 20);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setBounds(120, 330, 200, 20);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    	
    }
    
    
    
   public void initButton(){
	   btnUpdate = new JButton("Update");
	   btnUpdate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String msg;
	   		int fromCreate=1;
	   		int nameisgood;
	   		nameisgood=checkvalid(fromCreate);
	   		if(nameisgood==1){
	   			if(ChooseAthlete.getSelectedItem().equals("choose..")){
	   				
	   			
	   				Athlete.setFirstName(textFieldFirstName.getText());
	   				Athlete.setLastName(textFieldLastName.getText());
	   				Athlete.setUserName(textFieldUserName.getText());
	   				Athlete.setPassword(textFieldPassword.getText());
	   				Athlete.setAddress(textFieldAddress.getText());
	   				Athlete.setPhoneNumber(textFieldPhoneNumber.getText());
	   				
	   				
	   				getClient().sendMsgToServer(new MessageUpdateAthlete(Athlete));
	   				MessageUpdateAthleteReplay rep= (MessageUpdateAthleteReplay) getClient().getMessageFromServer();
	   				
	   				
	   				if(rep.getBoolean()==true){
	   					msg="athlete updated";
	   					popUp(msg);
	   					
	   					getClient().swapFromBack(pushPanel());
	   					
	   					
	   				}
	   			}
	   			else{
	   				
	   				msg="choose athlete";
   					popUp(msg);
	   			}
   			}	
	   			
	   			
	   			   			
	   		}
	   	});
		btnUpdate.setBounds(119, 390, 89, 23);
		add(btnUpdate);
   }
    
	  public void init()
    {
		  initArrays();
		  initComboBoxs();
		  initLabels();
		  initTextField();
		  initButton();
		
		for (int i=0; i<=allAthleteArray.size(); i++)
		{
			if (i==0) ChooseAthlete.addItem("Choose..");
			else ChooseAthlete.addItem(allAthleteArray.get(i-1));
			}
		ChooseAthlete.addActionListener(new AthleteListener());
    }

	
	private class AthleteListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Athlete=(User)ChooseAthlete.getSelectedItem();
			textFieldFirstName.setText(Athlete.getFirstName());
			textFieldLastName.setText(Athlete.getLastName());
			textFieldUserName.setText(Athlete.getUserName());
			textFieldPassword.setText(Athlete.getPassword());
			textFieldPhoneNumber.setText(Athlete.getPhoneNumber());
			textFieldAddress.setText(Athlete.getAddress());
			
			
		}
	
	}

	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	
	

	@Override
	public MyJPanel pushPanel() {
		return new EditAthletePanel(getClient());
	}
}



