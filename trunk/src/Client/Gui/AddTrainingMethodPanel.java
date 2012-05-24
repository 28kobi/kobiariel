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
	
	private JLabel lblTrainingName;
	private JButton btnCreate;
	
	
	public AddTrainingMethodPanel(ClientIF client) {
		super(PanelType.ADD_TRAINING_METHOD_PANEL, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblAddTrainingMethod = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblAddTrainingMethod.setBounds(100, 13, 497, 32);
			add(lblAddTrainingMethod);
			
			str = getClient().getUser().toString();
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		init();
	}
	
	public void initLbl(){
		

		lblTrainingName = new JLabel("Type name for training type:");
		lblTrainingName.setBounds(10, 107, 162, 20);
		add(lblTrainingName);

	    lblChooseActivityConection = new JLabel("Choose Activity Conection:");
		lblChooseActivityConection.setBounds(10, 152, 191, 24);
		add(lblChooseActivityConection);
	}
	

	 public void initComboBox(){
		 
			comboBoxActivityType = new JComboBox();		
			comboBoxActivityType.setBounds(195, 154, 132, 20);
			add(comboBoxActivityType);
			
			
			
						
		
	 }
	 public void initTextField(){
		 
		 	textField = new JTextField();
			textField.setBounds(195, 107, 177, 24);
			add(textField);
			textField.setColumns(10);
		 
	 }
	public void initbtn(){
			btnCreate= new JButton("Create training type");
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String msg;
					int replay;
					if(!comboBoxActivityType.getSelectedItem().toString().equals("Choose..")) {
						if(!textField.getText().equals("")){
							activity=(activitytype)comboBoxActivityType.getSelectedItem();
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
					 			else{
									msg=" training method with the same name already existed";
					 				popUp(msg);
					           
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							getClient().swapFromBack(pushPanel());
				 			
						}
						else{
							msg="you didnt gave name to the training method";
			 				popUp(msg);
						    }
					}
					else{
						msg="you didnt choose any Activity Method";
		 				popUp(msg);
	 					}
						
					
					
				}
			});
			btnCreate.setBounds(195, 272, 138, 23);
			add(btnCreate);
		 
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



