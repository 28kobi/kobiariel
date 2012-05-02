package Client.Logic;

import java.io.IOException;

import Server.DataBase.User;
import Client.Gui.MyJPanel;
import Server.logic.Message;
/**
 * 
 * @author Baglama
 * 
 *
 */
public interface ClientIF {
/**
 * 
 * @param newPanel
 */
	public void swap(MyJPanel newPanel);
	/**
	 * 
	 * @param newPanel
	 */
	public void swapFromBack(MyJPanel newPanel);
	/**
	 * 
	 * @param msg
	 */
	public void sendMsgToServer(Message msg);
	/**
	 * 
	 * @return
	 */
	public Message getMessageFromServer();
	/**
	 * 
	 * @param user
	 */
	public void login(User user);
	/**
	 * 
	 */
	public void logoutBtn();
	/**
	 * 
	 * @param host
	 * @param port
	 * @throws IOException 
	 */
	public void initConnection(String host, int port) throws IOException;
	/**
	 * 
	 */
	public void setVisible();
	/**
	 * 
	 * @return
	 */
	public MyJPanel getMainPanel();
	
	public User getUser();
	/**
	 * 
	 */
	
	
	public void initcon() throws IOException;
	
}
