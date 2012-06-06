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
import java.awt.Font;


public class EditAthletePanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User Athlete;
	private JComboBox ChooseAthlete;
	private ArrayList<User> allAthleteArray =null;
    private	JLabel lblChooseAthlete;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
  
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
  
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
    private JButton btnUpdate;
    private ArrayList<User> userarray =null;

    private JLabel lblNewLabel_1;

    private String Usernam;

    
	
	
	public EditAthletePanel(ClientIF client) {
		super(PanelType.EDIT_ATHLETE_PANEL, client);
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
		allAthleteArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(getClient().getUser().getIdUser()));
		MessageGetAllAthleteByCoachIdReplay rep= (MessageGetAllAthleteByCoachIdReplay) getClient().getMessageFromServer();
		allAthleteArray = rep.getArray();
		
		userarray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllusers());
		MessageGetAllusersReplay rep3= (MessageGetAllusersReplay)getClient().getMessageFromServer();
		userarray = rep3.getUserArray();
	}
	
	
	public void initComboBoxs()
	{
		ChooseAthlete =new JComboBox();
		ChooseAthlete.setBackground(Color.WHITE);
		ChooseAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseAthlete.setBounds(142, 85, 200, 25);
		add(ChooseAthlete);
		ChooseAthlete.setEnabled(true);
	}
	
	
    public void initLabels(){
		
    lblChooseAthlete = new JLabel("Choose Athlete:");
    lblChooseAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
    lblChooseAthlete.setBounds(23, 86, 109, 25);
	add(lblChooseAthlete);
	
    lblNewLabel = new JLabel("First Name:");
    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	lblNewLabel.setBounds(23, 120, 92, 25);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name:");
    lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblLastName.setBounds(23, 155, 92, 25);
	add(lblLastName);
	

	

  
	
	


	lblPhoneNumber = new JLabel("Phone Number:");
	lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPhoneNumber.setBounds(23, 261, 109, 25);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address:");
	lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
	lblAddress.setBounds(23, 297, 75, 25);
	add(lblAddress);
		
	}
    
    
    public void initTextField(){
    	
    	textFieldFirstName = new JTextField();
    	textFieldFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldFirstName.setBounds(142, 120, 200, 25);
    	add(textFieldFirstName);
    	textFieldFirstName.setColumns(10);
    	

    	textFieldLastName = new JTextField();
    	textFieldLastName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldLastName.setBounds(142, 155, 200, 25);
    	add(textFieldLastName);
    	textFieldLastName.setColumns(10);
    	

    


    	
    	textFieldPhoneNumber = new JTextField();
    	textFieldPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPhoneNumber.setBounds(142, 261, 200, 25);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldAddress.setBounds(142, 297, 200, 82);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    	
    }
    
    
    
   public void initButton(){
	   btnUpdate = new JButton("Update");
	   btnUpdate.setForeground(Color.BLUE);
	   btnUpdate.setFont(new Font("Arial", Font.PLAIN, 15));
	   btnUpdate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String msg;
	   		
	  	   			if(!ChooseAthlete.getSelectedItem().equals("Choose..")){
	   	   			
	   				Athlete.setFirstName(textFieldFirstName.getText());
	   				Athlete.setLastName(textFieldLastName.getText());
	   				
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
	   	});
		btnUpdate.setBounds(197, 446, 89, 30);
		add(btnUpdate);
		
		lblNewLabel_1 = new JLabel("Edit Athlete Details:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 32, 205, 30);
		add(lblNewLabel_1);
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
		
			Usernam=Athlete.getUserName();
		
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



