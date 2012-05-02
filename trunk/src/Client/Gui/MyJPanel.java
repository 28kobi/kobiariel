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
		ADD_CLASS_PANEL,
		ADD_COURSE_PANEL,
		ADD_TASK_PANEL,
		ASSIGN_CLASS_TO_COURSE_PANEL,
		ASSIGN_STUDENT_TO_CLASS_PANEL,
		GET_SUBMITTED_TASK_PANEL,
		CHANGE_TEACHER_PANEL,
		OPEN_SEMESTER_PANEL,
		HOME_PANEL_SECRATERY,
		ASSIGN_STUDENT_TO_COURSE_PANEL,
		REMOVE_STUDENT_FROM_COURSE_PANEL,
		HOME_PANEL_TEACHER,
		TOPBAR_PANEL,
		GRADE_TASK_PANEL,
		ASSESMENT_FORM,
		GET_TASK,
		HOME_PANEL_STUDENT,
		HOME_PANEL_MANAGER,
		MANAGER_VIEW_INFO,
		REQUEST_PANEL,
		REPORTS_PANEL,
		BLOCK_PARENTS_PANEL,
		PERSONAL_FILE_PANEL,
		HOME_PANEL_PARENT,
		PERSONAL_FILE_PANEL_PARENT
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
