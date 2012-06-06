package Server.GUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;

public class MyJTable extends JPanel {
	/**
	 * the tables default
	 */
	private static final long serialVersionUID = 1L;
	private AbstractTableModel model;
	private JTable table;
	public int selectedRow;
	
	public MyJTable() {
		initializeUI();
    }
	
	public MyJTable(AbstractTableModel model) {
		this.model=model;
        initializeUI();
    }
	
	public void setModel(AbstractTableModel model){
		this.model=model;
		table.setModel(this.model);
	}

    private void initializeUI() {
        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(450, 150));

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }
       
    public JTable getTable() {
		return table;
	}

	public int getSelectedItem(){
    	return table.getSelectedRow();
    }
    
}


