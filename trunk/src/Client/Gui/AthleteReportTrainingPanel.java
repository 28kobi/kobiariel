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


public class AthleteReportTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;

	
   
    
	
	
	public AthleteReportTrainingPanel(ClientIF client) {
		super(PanelType.ATHLETE_REPORT_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPlannedTrainging = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPlannedTrainging.setBounds(149, 11, 340, 46);
			add(lblPlannedTrainging);
			
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
		return new AthleteReportTrainingPanel(getClient());
	}
}



