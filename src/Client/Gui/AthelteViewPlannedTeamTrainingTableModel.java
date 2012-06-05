package Client.Gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import Server.DataBase.*;

public class AthelteViewPlannedTeamTrainingTableModel extends AbstractTableModel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private activitytypeQuery activitytypeQuery=new activitytypeQuery();
	private activitytype activitytype=new activitytype();
	private trainingtypeQuery trainingtypeQuery=new trainingtypeQuery();
	private trainingtype trainingtype=new trainingtype();
	private TeamQuery TeamQuery=new TeamQuery();
	private Team Team=new Team();
 
	 ////////////// Table 1 view all Planned training
	
	Vector<String[]> cache; // will hold String[] objects . . .
	int colCount=9;
	

	String[] headers = {"TrainingId","TeamName", "ActivityType", "TrainingType", "Time", "Details", "Duration", "Distance", "Date"};									
						
	public AthelteViewPlannedTeamTrainingTableModel() {
		cache = new Vector<String[]>();
		
	}

	public String getColumnName(int i) {
		return headers[i];
	}

	public int getColumnCount() {
		return colCount;
	}

	public int getRowCount() {
		return cache.size();
	}

	public Object getValueAt(int row, int col) {
		return ((String[]) cache.elementAt(row))[col];
	}
  
	public void setValueAt(int row, int col, String msg){
	  ((String[]) cache.elementAt(row))[col] = msg;
	 fireTableChanged(null);
  }
  
  public void setArray(ArrayList<plannedteamtraining> array) {
	  cache.removeAllElements();
	  for (int i=0; i<array.size(); i++) addToArray(array.get(i));
	  fireTableChanged(null);
  }
  
  public void addToArray(plannedteamtraining plannedteamtraining) {
	  String[] record = new String[colCount];
	  record[0] = Integer.toString(plannedteamtraining.getTrainingId());
	  try {
		  Team=TeamQuery.getTeamByTeamId((plannedteamtraining.getTeamId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
		  record[1] =Team.getTeamName();
	  try {
		activitytype=activitytypeQuery.getactivitytypeById((plannedteamtraining.getActivityid()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	  record[2] =activitytype.getActivityName();
	  try {
		trainingtype=trainingtypeQuery.getatrainingtypeById(((plannedteamtraining.getTrainingTypeId())));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  record[3] = trainingtype.gettrainingName();
	  record[4] = plannedteamtraining.getTime();
	  record[5] = plannedteamtraining.getDetails();
	  record[6] = plannedteamtraining.getDuration();
	  record[7] = plannedteamtraining.getDistance();
	  record[8] = plannedteamtraining.getDate();
	  cache.addElement(record);
  }


  
  
 
 
}