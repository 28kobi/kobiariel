package Client.Logic;

import java.io.IOException;

import Client.Gui.ClientFrame;

/**
 * Initialize client thread  start client panel
 * @author Baglam Dev
 *
 */
public class Client {
	public static void main(String[] args){
		ClientFrame frame = new ClientFrame();
		try {
			frame.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
