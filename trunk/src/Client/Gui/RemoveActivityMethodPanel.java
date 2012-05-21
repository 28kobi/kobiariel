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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import Client.Gui.MyJPanel.PanelType;
import Client.Logic.ClientIF;
import javax.swing.JComboBox;
import javax.swing.JButton;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageRemoveAactivityType;
import Server.Message.MessageRemoveAactivityTypeReplay;
import Server.DataBase.activitytype;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RemoveActivityMethodPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private String str;
	private JComboBox comboBoxActivityType;
	private JButton btnRemove;
	private JLabel lblChooseActivity;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private  activitytype activity;
	
	
	
	public RemoveActivityMethodPanel(ClientIF client) {
		super(PanelType.REMOVE_ACTIVITY_TYPE_PANEL, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblRemoveActivityMethod = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblRemoveActivityMethod.setBounds(561, 13, 36, 21);
			add(lblRemoveActivityMethod);
			
			str = getClient().getUser().toString();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		init();
		
	}

 public void initLabels(){
	 
	    lblChooseActivity = new JLabel("Choose the Activity type you like to remove: ");
		lblChooseActivity.setBounds(28, 134, 234, 21);
		add(lblChooseActivity);
							 
	 }
 
 public void initComboBox(){
	 

		comboBoxActivityType = new JComboBox();
		comboBoxActivityType.setBounds(215, 174, 130, 20);
		add(comboBoxActivityType);
			
}
 public void initbutton(){
		
	    btnRemove = new JButton("Remove");
	    btnRemove.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String msg;
	    		int index;
	    		if(!comboBoxActivityType.getSelectedItem().toString().equals("Choose..")){
	    			activity=(activitytype)comboBoxActivityType.getSelectedItem();
	    			index=comboBoxActivityType.getSelectedIndex();
	    			getClient().sendMsgToServer(new MessageRemoveAactivityType(activity));
	    			MessageRemoveAactivityTypeReplay rep4= (MessageRemoveAactivityTypeReplay)getClient().getMessageFromServer();
	    			if(rep4.getSeccsses()==1){
	    				msg="activity has been removed";
	 	   				popUp(msg);
	 	   				pushPanel();
	 	   				getClient().swapFromBack(pushPanel());
	 	   				
	 	   				
	    				}
	    			
	    		}
	    		else{
	    			msg="choose activity name";
 	   				popUp(msg);
	    			
	    		}
	    	}
	    });
		btnRemove.setBounds(256, 292, 89, 23);
		add(btnRemove);
	 
	 
 }
 public void initArrays(){
		
		allAactivityTypeArray = new ArrayList<activitytype>();
		getClient().sendMsgToServer(new MessageGetAllAactivityType());
		MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
		allAactivityTypeArray = rep3.getArray();
		
	}
	
 
 public void init(){
	 initLabels();
	 initComboBox();
	 initbutton();
	 initArrays();
	 
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
		return new RemoveActivityMethodPanel(getClient());
	}
}



