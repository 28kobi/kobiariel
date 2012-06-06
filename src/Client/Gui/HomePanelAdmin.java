package Client.Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import Client.Logic.ClientIF;

public class HomePanelAdmin extends MyJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String str;
	public HomePanelAdmin(ClientIF client) {
		super(PanelType.HOME_PANEL_ADMIN, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MyJPanel pushPanel() {
		return new HomePanelAdmin(getClient());
	}
	
}
