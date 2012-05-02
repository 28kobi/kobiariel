package Server.logic;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Server.logic.SqlAdapter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSettings extends ServerPanel {
	
	private static final long serialVersionUID = 1L;
	private QueryTableModel qtm= null;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * 
	 * @param frame
	 */
	public PanelSettings(ServerFrame frame) {
		super(panelType.USER_PANEL, frame);
		setLayout(null);
		
		JLabel lblUser = new JLabel("user:");
		lblUser.setBounds(38, 52, 46, 14);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(38, 96, 78, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(104, 49, 113, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 93, 114, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlAdapter.setUsername(textField.getText());
				SqlAdapter.setPassword(textField_1.getText());
				getServerFrame().swap(new PanelHome(getServerFrame()));
			}
		});
		btnConnect.setBounds(128, 136, 89, 23);
		add(btnConnect);
		init();
	}

	private void init(){
		qtm = new QueryTableModel();
		
	}
	
	public void updateTableOnline(String userName){
		int i = 0;
		String name = (String) qtm.getValueAt(i, 1);
		while ( !name.equals(userName)){
			i++;
			name = (String) qtm.getValueAt(i, 1);
		}
		qtm.setValueAt(i, 4, "1");	
	}
	
	public void updateTableOffline(String userName){
		int i = 0;
		String name = (String) qtm.getValueAt(i, 1);
		while ( !name.equals(userName)){
			i++;
			name = (String) qtm.getValueAt(i, 1);
		}
		qtm.setValueAt(i, 4, "0");
		
	}
}
