
package Client.Gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Server.DataBase.*;

public class AthelteViewPreformedPersonalTrainingTableModel extends AbstractTableModel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private activitytypeQuery activitytypeQuery=new activitytypeQuery();
	private activitytype activitytype=new activitytype();
	private trainingtypeQuery trainingtypeQuery1=new trainingtypeQuery();
	private trainingtype trainingtype1=new trainingtype();
 
	
	
	 Vector<String[]> cache; // will hold String[] objects . . .
	 int colCount=10;


	
  ////////////// Table 2 view all personal preformed training
   
	
	 String[] headers = {"PreformedId","IsPlanned","TrainingId", "ActivityType", "TrainingType", "Time", "Details", "Duration", "Distance", "Date"};									
	
	public AthelteViewPreformedPersonalTrainingTableModel() {
	
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

public void setArray(ArrayList<PreformedPersonalTraining> array) {
	  cache.removeAllElements();
	  for (int i=0; i<array.size(); i++) addToArray(array.get(i));
	  fireTableChanged(null);
}

public void addToArray(PreformedPersonalTraining PreformedPersonalTraining) {
	
	  String[] record = new String[colCount];
	  record[0] = Integer.toString(PreformedPersonalTraining.getPreformedId());
	  record[1] = PreformedPersonalTraining.getIsplanned();
	  record[2] = Integer.toString(PreformedPersonalTraining.getTrainingId());
	  
	  try {
		activitytype=activitytypeQuery.getactivitytypeById((PreformedPersonalTraining.getActivityid()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	  record[3] =activitytype.getActivityName();
	  try {
		  trainingtype1=trainingtypeQuery1.getatrainingtypeById(((PreformedPersonalTraining.getTrainingTypeId())));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  record[4] = trainingtype1.gettrainingName();
	  
	  record[5] = PreformedPersonalTraining.getTime();
	  record[6] = PreformedPersonalTraining.getDetails();
	  record[7] = PreformedPersonalTraining.getDuration();
	  record[8] = PreformedPersonalTraining.getDistance();
	  record[9] = PreformedPersonalTraining.getDate();
	 
	 
	  cache.addElement(record);
}

 
}