package presentation.GoosTypeui;

import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Object[][] rowData;

	private String[] columnNames;
	
	public MyTableModel() {
		// TODO Auto-generated constructor stub
		rowData = new Object[][]{{"0", "1"},{"3", "2"}};
		columnNames = new String[]{"test", "..."};
	}

	public String getColumnName(int col) {
		return columnNames[col].toString();
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int row, int col) {
		return rowData[row][col];
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {

		rowData[row][col] = value;
		fireTableCellUpdated(row, col);
		System.out.println("table model set value");
	}

}
