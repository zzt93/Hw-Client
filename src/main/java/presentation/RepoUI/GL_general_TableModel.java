package presentation.RepoUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import po.GoodsModelPO;
import vo.GoodsModelVO;

public class GL_general_TableModel extends DefaultTableModel {

	/**
* 
*/
	private static final long serialVersionUID = 1L;

	ArrayList<Object[]> data;
	boolean isvo = true;

	public GL_general_TableModel(ArrayList<GoodsModelVO> modelVOs) {

		for (GoodsModelVO goodsModelVO : modelVOs) {
			Object[] t = new Object[] { goodsModelVO.getName(),
					goodsModelVO.getId(), goodsModelVO.getAmount(),
					goodsModelVO.getSignal() };
			data.add(t);
		}
//		addTableModelListener(this);
	}

	public void setData_vo(ArrayList<GoodsModelVO> modelVOs) {
		for (GoodsModelVO goodsModelVO : modelVOs) {
			Object[] t = new Object[] { goodsModelVO.getName(),
					goodsModelVO.getId(), goodsModelVO.getAmount(),
					goodsModelVO.getSignal() };
			data.add(t);
		}
		fireTableDataChanged();
	}
	
	public void addData(Object[] temp){
		data.add(temp);
		this.addRow(temp);
	}

	public GL_general_TableModel(HashMap<String, GoodsModelPO> modelPOs) {
		setData_po(modelPOs);
		isvo = false;
//		addTableModelListener(this);
	}

	public void setData_po(HashMap<String, GoodsModelPO> modelPOs) {

		for (GoodsModelPO goodsModelpo : modelPOs.values()) {
			Object[] t = new Object[] { goodsModelpo.getName(),
					goodsModelpo.getId(), goodsModelpo.getAmount(),
					goodsModelpo.getSignal() };
			data.add(t);
		}
		fireTableDataChanged();
	}

	private String[] columnNames = { "商品名称", "商品id", "数量", "警戒值" };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		if (isvo) {
			Object[] temp = data.get(row);
			return temp[col];
		} else {
			Object[] temp = data.get(row);
			return temp[col];
		}
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (isvo) {
			return false;
		} else {
			if (col == 1 && col == 2) {
				return false;
			} else {
				return true;
			}
		}
	}

	public void setValueAt(Object value, int row, int col) {
		if (MainFrame.DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to "
					+ value + " (an instance of " + value.getClass() + ")");
		}

		if (isvo) {
			assert (false);
		} else {
			if (col == 0 || col == 3) {
				data.get(row)[col] = value;
			}
		}
		fireTableCellUpdated(row, col);

		if (MainFrame.DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}

	private void printDebugData() {
		int numRows = getRowCount();
		int numCols = getColumnCount();

		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + data.get(i)[j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

//	@Override
	public void tableChanged(TableModelEvent e) {// check whether the change
													// is valid
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);
		System.out.println("------------------------------------------------------------------------");
		if (column == 0 && data != null) {// name is vaild

		} else if (column == 3 && data != null && (Integer) data >= 0) {// signal
																		// is
																		// valid

		} else {
			JOptionPane.showMessageDialog(MainFrame.frame, "Invalid change");
		}
	}
}
