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
import javax.swing.JComboBox;


public class EditCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private String str;
	
	
	public EditCoachPanel(ClientIF client) {
		super(PanelType.EDIT_COACH_PANEL, client);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblEditCoach = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblEditCoach.setBounds(149, 11, 340, 46);
			add(lblEditCoach);
			
			str = getClient().getUser().toString();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		
		JLabel lblChooseCoach = new JLabel("Choose Coach:");
		lblChooseCoach.setBounds(23, 67, 109, 23);
		add(lblChooseCoach);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 68, 109, 20);
		add(comboBox);
	}

	@Override
	public MyJPanel pushPanel() {
		return new EditCoachPanel(getClient());
	}
}



