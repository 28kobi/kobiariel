package Client.Gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Server.DataBase.User;
import Server.logic.Message;
import Server.Message.MessageLogout;

import Client.Gui.MyJPanel;
import Client.Gui.MyJPanel.PanelType;
import Client.Gui.SideBar;
import Client.Gui.TopBar;
import Client.Logic.ClientHandle;
import Client.Logic.ClientIF;

public class ClientFrame extends JFrame implements ClientIF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final public static String DEFAULT_HOST = "localhost";
	final public static int DEFAULT_PORT = 5555;
	
	private User user = null;
	private ClientHandle client;
	private JPanel contentPane;
	private TopBar topBar;
	private SideBar sideBar;
	private MyJPanel panel = null;
	
	public ClientFrame(){
		super();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (popUp()==0) {
					logout();
					System.exit(1);
				}
				
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
	}
	
	private int popUp(){
		Object[] options = {"Continue", "Cancel"};
		int n = JOptionPane.showOptionDialog(this,
				"Are you sure you want to exit? ",
						"Why so soon?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,
						options,
						options[1]);
		return n;
	}
	
	public void swap(MyJPanel newPanel){
		if (panel!=null){
			contentPane.remove(panel);
			topBar.backStack.push(panel);
			topBar.btnBack.setEnabled(true);
			topBar.btnNext.setEnabled(false);
			topBar.nextStack.removeAllElements();
		}
		panel = newPanel;
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.revalidate();
	}
	
	
	public void swapFromBack(MyJPanel newPanel){
		contentPane.remove(panel);
		panel = newPanel;
		contentPane.add(panel, BorderLayout.CENTER);
		panel.revalidate();
	}
	
	public void init() throws IOException{
		
		this.setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		this.setContentPane(contentPane);
		setTitle("Training - Client");
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocation(new Point(200, 100));
		initTopBar();
		initSideBar();
		setVisible(true);
		swap(getFristPanel());
	}
	
	public void initcon() throws IOException{
		initConnection(DEFAULT_HOST, DEFAULT_PORT );
	}
	
	public void initConnection(String host, int port) throws IOException{
			client = new ClientHandle(host, port, this);
		
	}
	
	private void initTopBar(){
		topBar = new TopBar(this);
		contentPane.add(topBar, BorderLayout.NORTH);
	}
	
	private void initSideBar(){
		sideBar = new SideBar(this, null);
		contentPane.add(sideBar, BorderLayout.WEST);
	}
	
	private MyJPanel getFristPanel() throws IOException{
		return new LogInPanel( this);
	}
	
	public void sendMsgToServer(Message msg){
			client.HandleMessageFromGUI(msg);
	}
	
	public Message getMessageFromServer(){
		try {
			return (Message) client.GetMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void login(User user){
		this.user = user;
		topBar.setName(user.toString());
		sideBar.setUser(user);
		switch(user.getPrivilge())
		{
		case 0:
			sideBar.initAdmin();
			swap(new HomePanelAdmin(this));
			break;
		case 1:
			sideBar.initCoach();
			swap(new HomePanelCoach(this));
			break;
		case 2:
			sideBar.initAtlete();
			swap(new HomePanelAthlete(this));
			break;
		
		
		}
		topBar.reset();
	}
	
	public void logout(){
		if (user!=null)
			sendMsgToServer(new MessageLogout(user));
	}
	
	public void logoutBtn(){
		sendMsgToServer(new MessageLogout(user));
		topBar.setName("");
		topBar.reset();
		sideBar.clearSideBar();
		sideBar.initLogin();
		try {
			swapFromBack(getFristPanel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logoutError(){
		topBar.setName("");
		topBar.reset();
		sideBar.clearSideBar();
		sideBar.initLogin();
		try {
			swapFromBack(getFristPanel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setVisible(){
		setVisible(true);
	}
	
	public User getUser(){
		return user;
	}
	
	
	@Override
	public MyJPanel getMainPanel() {
		return panel;
	}
}
