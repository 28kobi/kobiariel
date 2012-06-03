
package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import Server.DataBase.*;
import Server.GUI.MyJTable;
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllPreformedTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTrainingByAtleteIdReplay;
import Client.Logic.ClientIF;


public class AthleteViewPerformedTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private AthelteViewPreformedTeamTrainingTableModel stm;
	private AthelteViewPreformedPersonalTrainingTableModel stm2;
	private MyJTable table;
	private MyJTable table2;
	private ArrayList<PreformedTeamTraining> AllPreformedTeamTraining1=null ;
	private ArrayList<PreformedPersonalTraining> AllPreformedPersonalTraining=null ;
	private int id;
	private JLabel lblListOfAll;
	private JLabel lblPersonalTraining;
   
    
	
	
	public AthleteViewPerformedTrainingPanel(ClientIF client) {
		super(PanelType.ATHLETE_VIEW_PERFORMED_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPerformedTraining = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPerformedTraining.setBounds(149, 11, 340, 46);
			add(lblPerformedTraining);
			
	
			id= getClient().getUser().getIdUser();

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
		
	}	
	public void initLables(){
	 lblListOfAll = new JLabel("PREFORMED TEAM TRAINING:");
		lblListOfAll.setBounds(10, 115, 315, 14);
		add(lblListOfAll);
		
		 lblPersonalTraining = new JLabel("PREFORMED PERSONAL TRAINING:");
		lblPersonalTraining.setBounds(10, 288, 285, 14);
		add(lblPersonalTraining);
	}
		public void initArrays(){
			
			AllPreformedTeamTraining1 = new ArrayList<PreformedTeamTraining>();
			getClient().sendMsgToServer(new MessageGetAllPreformedTeamTrainingByAtleteId(id));
			MessageGetAllPreformedTeamTrainingByAtleteIdReplay mgapttba = (MessageGetAllPreformedTeamTrainingByAtleteIdReplay)getClient().getMessageFromServer();
			AllPreformedTeamTraining1 = mgapttba.getPreformedTeamTraining1();
			
			
			AllPreformedPersonalTraining = new ArrayList<PreformedPersonalTraining>();
			getClient().sendMsgToServer(new MessageGetAllPreformedTrainingByAtleteId(id));
			MessageGetAllPreformedTrainingByAtleteIdReplay mgapttba1 = (MessageGetAllPreformedTrainingByAtleteIdReplay)getClient().getMessageFromServer();
			AllPreformedPersonalTraining = mgapttba1.getPreformedPersonalArray();
		}
		
		
		
		public void initTables(){
			stm = new AthelteViewPreformedTeamTrainingTableModel();		
			stm.setArray(AllPreformedTeamTraining1);
			table = new MyJTable(stm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(10, 140, 671, 120);
		add(table);
			
		stm2 = new AthelteViewPreformedPersonalTrainingTableModel();		
		stm2.setArray(AllPreformedPersonalTraining);
		table2 = new MyJTable(stm2);
	table2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	table2.setBounds(10, 325, 772, 120);
	add(table2);
	
	
		
	}
		
		public void init() 
		{
			
			initArrays();
			initTables();
			initLables();
		}	
			
		

  

	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		
			return new AthleteViewPerformedTrainingPanel(getClient());
	
	}
}



