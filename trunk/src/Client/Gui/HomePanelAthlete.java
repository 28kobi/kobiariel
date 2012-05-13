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

public class HomePanelAthlete extends MyJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String str;
	public HomePanelAthlete(ClientIF client) {
		super(PanelType.HOME_PANEL_ATHLETE, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblHomePanelAthlete = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblHomePanelAthlete.setBounds(12, 13, 585, 99);
			add(lblHomePanelAthlete);
			
			str = getClient().getUser().toString();
			JTextPane txtpnHello = new JTextPane();
			txtpnHello.setForeground(Color.GRAY);
			txtpnHello.setFont(new Font("High Tower Text", Font.PLAIN, 50));
			txtpnHello.setText("Hello "+str+"\r\n     welcome to\r\nTraining System.\r\n\r\n    ");
			txtpnHello.setBounds(123, 133, 448, 349);
			add(txtpnHello);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
	}

	@Override
	public MyJPanel pushPanel() {
		return new HomePanelAthlete(getClient());
	}
	
}
