package Server.logic;

import javax.swing.JPanel;

public abstract class ServerPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum panelType{ 	HOME_PANEL, 
							USER_PANEL,
							CLASS_PANEL,
							COURSE_PANEL};
	
	private panelType type = null;
	
	private ServerFrame frame = null;
	
	public ServerPanel(panelType type, ServerFrame frame){
		super();
		this.type = type;
		this.frame = frame;
	}
	
	public panelType getType(){
		return type;
	}
	
	public ServerFrame getServerFrame(){
		return frame;
	}

}
