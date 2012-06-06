package Client.Gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import Client.Logic.ClientIF;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TopBar extends MyJPanel  {
	
	/**
	 * top bar menu  display the name of the user in the system 
	 * and give him the option to go back and next ...
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnBack;
	JButton btnNext;
	Stack<MyJPanel> backStack;
	Stack<MyJPanel> nextStack;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblName;
	private JButton btnNewButton;
	
	public TopBar(ClientIF client){
		super(PanelType.TOPBAR_PANEL, client);
		backStack = new Stack<MyJPanel>();
		nextStack = new Stack<MyJPanel>();
		setForeground(Color.WHITE);
		this.setBackground(Color.BLACK);
		setBorder(new EmptyBorder(20, 5, 5, 5));
		
		btnBack = new JButton("back");
		btnBack.setEnabled(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextStack.push(getClient().getMainPanel());
				btnNext.setEnabled(true);
				getClient().swapFromBack(backStack.pop().pushPanel());
				if (backStack.isEmpty()) btnBack.setEnabled(false);
				
			}
		});
		setLayout(new GridLayout(0, 8, 0, 0));
		btnBack.setBorder(UIManager.getBorder("DesktopIcon.border"));
		add(btnBack);
		
		btnNext = new JButton("next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backStack.push(getClient().getMainPanel());
				btnBack.setEnabled(true);
				getClient().swapFromBack(nextStack.pop().pushPanel());
				if (nextStack.isEmpty()) btnNext.setEnabled(false);
			}
		});
		btnNext.setBorder(UIManager.getBorder("DesktopIcon.border"));
		add(btnNext);
		
		lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setForeground(Color.ORANGE);
		add(lblName);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (popUp()==0){
					getClient().logoutBtn();
					btnNewButton.setEnabled(false);
				}
			}
		});
		setLayout(new GridLayout(0, 8, 0, 0));
		btnNewButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		add(btnNewButton);
	}
	
	private int popUp(){
		Object[] options = {"Continue", "Cancel"};
		int n = JOptionPane.showOptionDialog((Component) getClient(),
				"Are you sure you want to logout? ",
						"Goodbye",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,
						options,
						options[1]);
		return n;
	}
	
	public void reset(){
		backStack.removeAllElements();
		nextStack.removeAllElements();
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnNewButton.setEnabled(true);
	}
	
	public void setName(String str){
		lblName.setText(str);
	}

	@Override
	public MyJPanel pushPanel() {
		return null;
	}
}
