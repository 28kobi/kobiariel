package Client.Gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Client.Logic.ClientIF;

public abstract class MyJPanel extends JPanel {
	
	/**
	 * myJPanel contain all panel type in the training system 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelType type;
	ClientIF client;
	
	public enum PanelType{
		LOGIN_PANEL,
		LOGIN_SETTING_PANEL,
		HOME_PANEL_ADMIN,
		TOPBAR_PANEL,
		EDIT_COACH_PANEL,
		CREATE_NEW_COACH_PANEL,
		EDIT_TEAM_PANEL,
		CREAT_NEW_TEAM_PANEL,
		ADD_TRAINING_METHOD_PANEL,
		REMOVE_TRAINING_METHOD_PANEL,
		HOME_PANEL_COACH,
		CREATE_NEW_ATHLETE_PANEL,
		ADD_ATHLETE_TO_TEAM_PANEL,
		EDIT_ATHLETE_PANEL,
		REMOVE_ATHLETE_FROM_TEAM_PANEL,
		HOME_PANEL_ATHLETE,		
		ATHLETE_VIEW_PLANNED_TRAINING_PANEL,
		ATHLETE_VIEW_PERFORMED_TRAINING_PANEL,
		ATHLETE_VIEW_STATISTIC_INFO,
		ATHLETE_REPORT_TRAINING_PANEL,
		CREAT_NEW_TRAINING_PANEL,
		EDIT_TRAINING_PANEL,
		COACH_VIEW_PLLANED_TRAINING_PANEL,
		COACH_VIEW_PERFORMED_TRAINING_PANEL,
		ADD_ACTIVITY_TYPE_PANEL,
		REMOVE_ACTIVITY_TYPE_PANEL,
		COACH_VIEW_PERFORMED_TEAM_TRAINING_PANEL,
		COACH_VIEW_STATISTIC_PANEL,
		
		
	}

	public MyJPanel(PanelType type, ClientIF client){
		super();
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"bg.jpg"));
		
			//JLabel lblbg = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
		//	lblbg.setBounds(149, 11, 340, 46);
			//add(lblbg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(Color.WHITE);
		this.type = type;
		this.client = client;
	}
	
	public ClientIF getClient(){
 		return client;
	}
	
	public PanelType getType(){
		return type;
	}
	
	public abstract MyJPanel pushPanel();
}
