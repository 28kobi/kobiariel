package Server.logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//  import Server.DataBase.UserQuery;
import Server.logic.ServerModel;
/**********************************************
 * 
 **** 
 ******          
 ********
 *********/
public class ServerFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TopBar topBar;
	private ServerPanel panel;
	private ServerModel server=null;
	
	public ServerFrame(){
		super();
	}
/**
 * 
 */
	public void init(){
		
		setTitle("Training - Server");
		this.setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		this.setContentPane(contentPane);
		setResizable(false);
		setLocation(new Point(200, 100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initTopBar();
		/* try {
			UserQuery uq = new UserQuery();
			uq.resetOnline();
			swap(getHomePanel());
		} catch (java.lang.Throwable t) {
			swap(new PanelSettings(this));
		}    */
		swap(getHomePanel());
		initConnection();
	}
	/**
	 * 	initTopBar
	 */
	private void initTopBar(){
		topBar = new TopBar();
		contentPane.add(topBar, BorderLayout.NORTH);
	}
	
	private void initConnection(){
		server=new ServerModel(5555, panel);
		 try 
		    {
			 server.listen(); //Start listening for connections
		    } 
		    catch (Exception ex) 
		    {
		      System.out.println("ERROR - Could not listen for clients!");
		    }
	}
	
	private ServerPanel getHomePanel(){
		return new PanelHome(this);
	}
	
	public void swap(ServerPanel newPanel){
		if (panel!=null) contentPane.remove(panel);
		panel = newPanel;
		contentPane.add(panel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	
}
		
		
		
		
		
		
		
		
		

