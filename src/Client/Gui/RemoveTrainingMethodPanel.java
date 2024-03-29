
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
import Client.Gui.MyJPanel.PanelType;
import Client.Logic.ClientIF;



public class RemoveTrainingMethodPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private String str;
	
	
	public RemoveTrainingMethodPanel(ClientIF client) {
		super(PanelType.REMOVE_TRAINING_METHOD_PANEL, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblAddClass = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblAddClass.setBounds(12, 13, 585, 99);
			add(lblAddClass);
			
			str = getClient().getUser().toString();
			JTextPane txtpnHello = new JTextPane();
			txtpnHello.setForeground(Color.GRAY);
			txtpnHello.setFont(new Font("Arial", Font.PLAIN, 20));
			txtpnHello.setText("Hello "+str+"\r\n     welcome to\r\nTraining System.\r\n\r\n     Manager ");
			txtpnHello.setBounds(119, 78, 448, 349);
			add(txtpnHello);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
	}

	@Override
	public MyJPanel pushPanel() {
		return new RemoveTrainingMethodPanel(getClient());
	}
	
}



