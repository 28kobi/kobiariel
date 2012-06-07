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
import java.awt.Font;


public class EditCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User coach;
	private JComboBox ChooseCoach;
	private ArrayList<User> allCoachArray =null;
    private	JLabel lblChooseCoach;
    private	JLabel lblNewLabel;
    private	JLabel lblLastName;
    private	JLabel lblPrivilige;
    private	JLabel lblPhoneNumber;
    private	JLabel lblAddress;
    private	JLabel lblNewLabelAnswer;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldPrivilge;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldAddress;
    private JButton btnUpdate;
    private JLabel lblNewLabel_1;
   
    
	
	
	public EditCoachPanel(ClientIF client) {
		super(PanelType.EDIT_COACH_PANEL, client);
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
		allCoachArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllCoach());
		MessageGetAllCoachReplay rep= (MessageGetAllCoachReplay) getClient().getMessageFromServer();
		allCoachArray = rep.getArray();
	}
	
	
	public void initComboBoxs()
	{
	    ChooseCoach =new JComboBox();
	    ChooseCoach.setBackground(Color.WHITE);
	    ChooseCoach.setFont(new Font("Arial", Font.PLAIN, 15));
		ChooseCoach.setBounds(154, 69, 132, 25);
		add(ChooseCoach);
		ChooseCoach.setEnabled(true);
	}
	
	
    public void initLabels(){
		
    lblChooseCoach = new JLabel("Choose Coach:");
    lblChooseCoach.setFont(new Font("Arial", Font.PLAIN, 15));
	lblChooseCoach.setBounds(23, 67, 109, 25);
	add(lblChooseCoach);
	
    lblNewLabel = new JLabel("First Name:");
    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	lblNewLabel.setBounds(23, 120, 92, 25);
	add(lblNewLabel);
	
	
    lblLastName = new JLabel("Last Name:");
    lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
	lblLastName.setBounds(23, 155, 92, 25);
	add(lblLastName);
	



	lblPrivilige = new JLabel("Privilige:");
	lblPrivilige.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPrivilige.setBounds(23, 191, 92, 25);
	add(lblPrivilige);
	
	lblPhoneNumber = new JLabel("Phone Number:");
	lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
	lblPhoneNumber.setBounds(23, 227, 109, 25);
	add(lblPhoneNumber);
	
	lblAddress = new JLabel("Address:");
	lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
	lblAddress.setBounds(23, 263, 64, 25);
	add(lblAddress);
		
	}
    
    
    public void initTextField(){
    	
    	textFieldFirstName = new JTextField();
    	textFieldFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldFirstName.setBounds(141, 115, 200, 25);
    	add(textFieldFirstName);
    	textFieldFirstName.setColumns(10);
    	

    	textFieldLastName = new JTextField();
    	textFieldLastName.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldLastName.setBounds(141, 150, 200, 25);
    	add(textFieldLastName);
    	textFieldLastName.setColumns(10);
    	

    	
    	


    	textFieldPrivilge = new JTextField();
    	textFieldPrivilge.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPrivilge.setBounds(141, 191, 200, 25);
    	add(textFieldPrivilge);
    	textFieldPrivilge.setColumns(10);
    	
    	textFieldPhoneNumber = new JTextField();
    	textFieldPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldPhoneNumber.setBounds(141, 227, 200, 25);
    	add(textFieldPhoneNumber);
    	textFieldPhoneNumber.setColumns(10);
    	
    	textFieldAddress = new JTextField();
    	textFieldAddress.setFont(new Font("Arial", Font.PLAIN, 15));
    	textFieldAddress.setBounds(141, 263, 200, 74);
    	add(textFieldAddress);
    	textFieldAddress.setColumns(10);
    	
    }
    
    
    
   public void initButton(){
	   btnUpdate = new JButton("Update");
	   btnUpdate.setForeground(Color.BLUE);
	   btnUpdate.setFont(new Font("Arial", Font.PLAIN, 15));
	   btnUpdate.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		
	   			coach.setFirstName(textFieldFirstName.getText());
	   			coach.setLastName(textFieldLastName.getText());
	   			
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
		btnUpdate.setBounds(197, 373, 89, 40);
		add(btnUpdate);
		btnUpdate.setEnabled(false);
		
		lblNewLabel_1 = new JLabel("Edit Coach Panel:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 11, 188, 30);
		add(lblNewLabel_1);
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
			if(!ChooseCoach.getSelectedItem().equals("choose..")){
				coach=(User)ChooseCoach.getSelectedItem();
				textFieldFirstName.setText(coach.getFirstName());
				textFieldLastName.setText(coach.getLastName());
				textFieldPrivilge.setText(Integer.toString(coach.getPrivilge()));
				textFieldPhoneNumber.setText(coach.getPhoneNumber());
				textFieldAddress.setText(coach.getAddress());
				btnUpdate.setEnabled(true);
			}
			
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



