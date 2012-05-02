package Client.Logic;


import java.awt.Component;
import java.io.IOException;

import javax.swing.JOptionPane;

import Client.Gui.ClientFrame;

import ocsf.client.AbstractClient;


/***
 * This class is responsible for the connection between the Client GUI to server.
 * It acts as a messenger between the two.
 */
public class ClientHandle extends AbstractClient {
		
	/**
	 * The Message itself that contains the information from client to server or vice versa.
	 */
	public Object message=null;
	
	private ClientFrame cf;
	
	/**
	 * The constructor connects to the server
	 * @param host - IP address of the Server
	 * @param port - Port number that the server is listening
	 * @throws IOException
	 */
	public ClientHandle(String host,int port, ClientFrame cf) throws IOException
	{
		super(host,port);
		this.cf = cf;
		openConnection();
		
	}
	

	/**
	 * This method is on always for waiting to get an Object message 
	 * and when it happens , it makes a notification to the other methods 
	 * that are waiting for the specific Object. 
	 * There for , this method must be synchronized 
	 * @param msg - The message from server
	 */
	@Override
	public synchronized void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub
		while (msg==null)
			try {
				wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.message=msg;
			notifyAll();

					try {
			openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	/**
	 * This method is responsible for sending the message to the server .
	 *@param msg - the message that is going to be sent to server
	 */
	public  void HandleMessageFromGUI(Object msg)
	{
		try {
			sendToServer(msg);
		} catch (IOException e) {
			connectionException(e);
		}
	}
	
	
	
	/**
	 * Method waits for a message to be arrived. When the method handleMessageFromServer gets a message
	 * it wakes this method and then this method delivers the necessary message.
	 * @return a message from the server
	 * @throws IOException
	 */
	public synchronized Object GetMessage() throws IOException
	{
		try {
			wait();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Object msg = this.message;
		this.message = null;
		return msg;
	}
	
	
	/**
	 * This method is responsible for recovering messages .
	 * @return message
	 */
	public synchronized Object SpecialGetMessage()
	{
		return this.message;
	}
	
	protected void connectionException(Exception exception) {
		Object[] options = {"Continue"};
		int n = JOptionPane.showOptionDialog(cf,
				"Sorry for the inconvenience but there is a problem with the server please try again later ",
						"ERROR",
						JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE,
						null,
						options,
						options);
		cf.logoutError();
	}
}
