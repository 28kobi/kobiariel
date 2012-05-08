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
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


public class EditCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User coach;
	private JComboBox ChooseCoach;
	private ArrayList<User> allCoachArray =null;
    private	JLabel lblChooseCoach;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
    private	JLabel lblUserName;
    private	JLabel lblPassword;
    private	JLabel lblPrivilige;
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private JButton btnUpdate;
    private JLabel lblNewLabelAnswer;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private JTextField textFieldPrivilge;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
   
    
	
	
	public EditCoachPanel(ClientIF client) {
		super(PanelType.EDIT_COACH_PANEL, client);
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
	
	
	public void initArrays(){
		allCoachArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllCoach());
		MessageGetAllCoachReplay rep= (MessageGetAllCoachReplay) getClient().getMessageFromServer();
		allCoachArray = rep.getArray();
	}
	
	
	public void initComboBoxs()
	{
	    ChooseCoach =new JComboBox();
		ChooseCoach.setBounds(119, 68, 109, 20);
		add(ChooseCoach);
		ChooseCoach.setEnabled(true);
	}
	
	
    public void initLabels(){
		
    lblChooseCoach = new JLabel("Choose Coach:");
	lblChooseCoach.setBounds(23, 67, 109, 23);
	add(lblChooseCoach);
	
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
	
	lblPrivilige = new JLabel("Privilige:");
	lblPrivilige.setBounds(23, 260, 92, 14);
	add(lblPrivilige);
	
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
    	
    	textFieldPrivilge = new JTextField();
    	textFieldPrivilge.setBounds(120, 260, 200, 20);
    	add(textFieldPrivilge);
    	textFieldPrivilge.setColumns(10);
    	
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
	   		coach.setFirstName(textFieldFirstName.getText());
	   		coach.setLastName(textFieldLastName.getText());
	   		coach.setUserName(textFieldUserName.getText());
	   		coach.setPassword(textFieldPassword.getText());
	   		coach.setAddress(textFieldAddress.getText());
	   		coach.setPrivilge(Integer.parseInt(textFieldPrivilge.getText()));
	   		coach.setPhoneNumber(textFieldPhoneNumber.getText());
	   		
	   		
	   		getClient().sendMsgToServer(new MessageUpdateCoach(coach));
	   		MessageUpdateCoachReplay rep= (MessageUpdateCoachReplay) getClient().getMessageFromServer();
			
	   		
			if(rep.getBoolean()==true){
				
				popUp();
				
				getClient().swapFromBack(pushPanel());
				
				
			}
			
			else lblNewLabelAnswer.setText("Update coach fail");
					
			
			
		
	   			   		
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
		
		for (int i=0; i<=allCoachArray.size(); i++)
		{
			if (i==0) ChooseCoach.addItem("Choose..");
			else ChooseCoach.addItem(allCoachArray.get(i-1));
			}
		ChooseCoach.addActionListener(new CoachListener());
    }

	
	private class CoachListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			coach=(User)ChooseCoach.getSelectedItem();
			textFieldFirstName.setText(coach.getFirstName());
			textFieldLastName.setText(coach.getLastName());
			textFieldUserName.setText(coach.getUserName());
			textFieldPassword.setText(coach.getPassword());
			textFieldPrivilge.setText(Integer.toString(coach.getPrivilge()));
			textFieldPhoneNumber.setText(coach.getPhoneNumber());
			textFieldAddress.setText(coach.getAddress());
			
			
		}
	
	}
	private void popUp(){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),"All Coach Details  Updates");
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new EditCoachPanel(getClient());
	}
}



