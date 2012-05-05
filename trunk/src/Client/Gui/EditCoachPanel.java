package Client.Gui;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Client.Logic.ClientIF;
import Server.DataBase.User;
import Server.Message.MessageGetAllCoach;
import Server.Message.MessageGetAllCoachReplay;
import javax.swing.JComboBox;


public class EditCoachPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private User coach;
	private JComboBox ChooseCoach;
	private ArrayList<User> allCoachArray =null;
    private	JLabel lblChooseCoach;
	
	
	public EditCoachPanel(ClientIF client) {
		super(PanelType.EDIT_COACH_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblEditCoach = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblEditCoach.setBounds(149, 11, 340, 46);
			add(lblEditCoach);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   init();
	   
	}
	
	public void initArrays(){
		allCoachArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllCoach());
		MessageGetAllCoachReplay rep= (MessageGetAllCoachReplay) getClient().getMessageFromServer();
		allCoachArray = rep.getArray();
	}
	public void initComboBoxs()
	{
	    ChooseCoach =new JComboBox();
		ChooseCoach.setBounds(119, 68, 109, 20);
		add(ChooseCoach);
		ChooseCoach.setEnabled(true);
	}
    public void initLabels(){
		
    lblChooseCoach = new JLabel("Choose Coach:");
	lblChooseCoach.setBounds(23, 67, 109, 23);
	add(lblChooseCoach);
	}
	  public void init()
    {
		  initArrays();
		  initComboBoxs();
		  initLabels();
		
		for (int i=0; i<=allCoachArray.size(); i++)
		{
			if (i==0) ChooseCoach.addItem("Choose..");
			else ChooseCoach.addItem(allCoachArray.get(i-1).getFirstName());
	     }
		ChooseCoach.addActionListener(new CoachListener());
    }

	
	private class CoachListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			coach=(User)ChooseCoach.getSelectedItem();
		}
	
	}

	@Override
	public MyJPanel pushPanel() {
		return new EditCoachPanel(getClient());
	}
}



