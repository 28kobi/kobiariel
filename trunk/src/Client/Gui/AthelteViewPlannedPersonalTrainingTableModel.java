package Client.Gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import Server.DataBase.*;

public class AthelteViewPlannedPersonalTrainingTableModel extends AbstractTableModel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private activitytypeQuery activitytypeQuery=new activitytypeQuery();
	private activitytype activitytype=new activitytype();
	private trainingtypeQuery trainingtypeQuery=new trainingtypeQuery();
	private trainingtype trainingtype=new trainingtype();
	
 
	 ////////////// Table 1 view all Planned training
	
	Vector<String[]> cache; // will hold String[] objects . . .
	int colCount=8;
	

	String[] headers = {"TrainingId", "ActivityType", "TrainingType", "Time", "Details", "Duration", "Distance", "Date"};									
									
	public AthelteViewPlannedPersonalTrainingTableModel() {
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
  
  public void setArray(ArrayList<plannedpersonaltraining> array) {
	  cache.removeAllElements();
	  for (int i=0; i<array.size(); i++) addToArray(array.get(i));
	  fireTableChanged(null);
  }
  
  public void addToArray(plannedpersonaltraining plannedpersonaltraining) {
	  String[] record = new String[colCount];
	  record[0] = Integer.toString(plannedpersonaltraining.getTrainingId());
	 
	  try {
		activitytype=activitytypeQuery.getactivitytypeById((plannedpersonaltraining.getActivityid()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	  record[1] =activitytype.getActivityName();
	  try {
		trainingtype=trainingtypeQuery.getatrainingtypeById(((plannedpersonaltraining.getTrainingId())));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  record[2] = trainingtype.gettrainingName();
	  record[3] = plannedpersonaltraining.getTime();
	  record[4] = plannedpersonaltraining.getDetails();
	  record[5] = plannedpersonaltraining.getDuration();
	  record[6] = plannedpersonaltraining.getDistance();
	  record[7] = plannedpersonaltraining.getDate();
	  cache.addElement(record);
  }
  
  
 
 
}