package Client.Gui;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Client.Logic.ClientIF;


public class ViewPlannedTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;

	
	
	public ViewPlannedTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PLLANED_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPlannedTraining = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPlannedTraining.setBounds(149, 11, 340, 46);
			add(lblPlannedTraining);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   
	}
	
	
  

	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new ViewPlannedTrainingPanel(getClient());
	}
}



