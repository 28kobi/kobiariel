package Server.logic;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class TopBar extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnBack;
	JButton btnNext;
	
	public TopBar(){
		super();
		setForeground(Color.WHITE);
		this.setBackground(Color.BLACK);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnBack = new JButton("back");
		btnBack.setBorder(UIManager.getBorder("DesktopIcon.border"));
		add(btnBack);
		
		btnNext = new JButton("next");
		btnNext.setHorizontalAlignment(SwingConstants.LEFT);
		btnNext.setBorder(UIManager.getBorder("DesktopIcon.border"));
		add(btnNext);
	}
}
