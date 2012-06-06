package Server.GUI;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class QueryTableModel extends AbstractTableModel implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Vector<String[]> cache; // will hold String[] objects . . .

	int colCount;

	String[] headers;

	//Statement statement;

	String currentURL;

  public QueryTableModel() {
    cache = new Vector<String[]>();
   /* try {
    	SqlAdapter sql = new SqlAdapter();
		statement = sql.getConnection().createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
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

 
  public void setData(ResultSet rs) {
	    cache = new Vector<String[]>();
	    try {
	      ResultSetMetaData meta = rs.getMetaData();
	      colCount = meta.getColumnCount();

	      // Now we must rebuild the headers array with the new column names
	      headers = new String[colCount];
	      for (int h = 1; h <= colCount; h++) {
	        headers[h - 1] = meta.getColumnName(h);
	      }

	      // and file the cache with the records from our query. This would
	      // not be
	      // practical if we were expecting a few million records in response
	      // to our
	      // query, but we aren't, so we can do this.
	      while (rs.next()) {
	        String[] record = new String[colCount];
	        for (int i = 0; i < colCount; i++) {
	          record[i] = rs.getString(i + 1);
	        }
	        cache.addElement(record);
	      }
	      fireTableChanged(null); // notify everyone that we have a new table.
	    } catch (Exception e) {
	      cache = new Vector<String[]>(); // blank it out and keep going.
	      e.printStackTrace();
	    }
	  }
}