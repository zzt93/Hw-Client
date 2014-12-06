package presentation.RepoUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Goods_receipt_table_model extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Goods_receipt_table_model(Object[][] data, Object[] col) {
		super(data, col);
	}
	public Goods_receipt_table_model(Vector<?> data, Vector<?> col){
		super(data, col);
	}
	
	Class<?>[] types = new Class[] { java.lang.String.class,
			java.lang.String.class, java.lang.Integer.class };
	boolean[] canEdit = new boolean[] { false, false, false };

	public Class<?> getColumnClass(int columnIndex) {
		return types[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}

	

}
