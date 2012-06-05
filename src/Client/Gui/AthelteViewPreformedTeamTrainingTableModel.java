package Client.Gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Server.DataBase.*;

public class AthelteViewPreformedTeamTrainingTableModel extends AbstractTableModel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private activitytypeQuery activitytypeQuery=new activitytypeQuery();
	private activitytype activitytype=new activitytype();
	private trainingtypeQuery trainingtypeQuery=new trainingtypeQuery();
	private trainingtype trainingtype=new trainingtype();
 
	 ////////////// Table 1 view all Team preformed training
	
	Vector<String[]> cache; // will hold String[] objects . . .
	int colCount=8;
	

	String[] headers = {"TrainingId", "ActivityType", "TrainingType", "Time", "Details", "Duration", "Distance", "Date"};									

	public AthelteViewPreformedTeamTrainingTableModel() {
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
  
  public void setArray(ArrayList<PreformedTeamTraining> array) {
	  cache.removeAllElements();
	  for (int i=0; i<array.size(); i++) addToArray(array.get(i));
	  fireTableChanged(null);
  }
  
  public void addToArray(PreformedTeamTraining PreformedTeamTraining) {
	  String[] record = new String[colCount];
	  record[0] = Integer.toString(PreformedTeamTraining.getTrainingId());
	  try {
		activitytype=activitytypeQuery.getactivitytypeById((PreformedTeamTraining.getActivityid()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	  record[1] =activitytype.getActivityName();
	  try {
		trainingtype=trainingtypeQuery.getatrainingtypeById(((PreformedTeamTraining.getTrainingTypeId())));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  record[2] = trainingtype.gettrainingName();
	  record[3] = PreformedTeamTraining.getTime();
	  record[4] = PreformedTeamTraining.getDetails();
	  record[5] = PreformedTeamTraining.getDuration();
	  record[6] = PreformedTeamTraining.getDistance();
	  record[7] = PreformedTeamTraining.getDate();
	  cache.addElement(record);
  }
  
  
 
 
}