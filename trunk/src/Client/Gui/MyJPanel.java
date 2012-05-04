package Client.Gui;

import java.awt.Color;
import javax.swing.JPanel;

import Client.Logic.ClientIF;

public abstract class MyJPanel extends JPanel {
	
	/**
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
		
		
		
		
		
		
		
		
		
		
		
	}

	public MyJPanel(PanelType type, ClientIF client){
		super();
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
