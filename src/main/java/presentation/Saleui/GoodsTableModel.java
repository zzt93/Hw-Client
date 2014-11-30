package presentation.Saleui;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class GoodsTableModel extends AbstractTableModel{
	String[] name={"商品编号","商品名称","型号","数量","单价","金额","备注"};
	Object[][] data=new Object[10][7]; 

	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return name.length;
	}
	public String getColumnName(int k){
		return name[k];
	}
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return data[row][column];
	}
	public class a extends DefaultTableModel{
		
	}
}
