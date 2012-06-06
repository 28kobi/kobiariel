package Server.logic;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**********************************************
 * 
 * 
 **** 
 ******          home panel..
 ********
 *********/
public class PanelHome extends ServerPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel menuPanel = null;

	public PanelHome(ServerFrame frame) {
		super(panelType.HOME_PANEL, frame);
		init();
	}
	
	public void init(){
		setLayout(null);
		addMenuPanel();
	}
	/**
	 * 
	 */
	private void addMenuPanel(){
		menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel.setBounds(265, 220, 523, 275);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		JLinkButton settingsBtn = new JLinkButton("Settings");
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getServerFrame().swap(new PanelSettings(getServerFrame()));
			}
		});
		/**
		 * 
		 */
		menuPanel.add(settingsBtn);
		add(menuPanel);	
	}
	
	
}
