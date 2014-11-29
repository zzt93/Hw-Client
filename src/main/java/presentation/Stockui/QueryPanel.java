package presentation.Stockui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class QueryPanel {
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JPanel panel;

	public QueryPanel(){
		initialize();
	}
	public void initialize(){
		
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panel=new JPanel();
		frame.add(panel);
		panel.setBounds(0, 0, 750, 500);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(142, 10, 370, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setBounds(541, 10, 90, 30);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 68, 660, 360);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseClick());
		table.setFillsViewportHeight(true);
		table.setModel(new MyTableModel());
		scrollPane.setViewportView(table);
		
		//frame.setVisible(true);
	}
	public JPanel getPanel(){
		return panel;
	}
	private class MyTableModel extends AbstractTableModel{
		String[] name={"单据编号","类型","仓库","操作员","总额","备注"};
		Object[][] data=new Object[10][6];
		public MyTableModel(){};
		public MyTableModel(Object[][] data){
			this.data=data;
		}
		public int getRowCount() {
			return data.length;
		}
		public int getColumnCount() {
			return name.length;
		}
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
		public String getColumnName(int k){
			return name[k];
		}
		
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getClickCount()>=2){
				int i=table.getSelectedRow();
				if(i==0){
					System.out.println("啦啦啦");
					SaleAndStockReceipt SASR=new SaleAndStockReceipt();
				}
			}
		}
	}
	public static void main(String[] args){
		QueryPanel panel=new QueryPanel();
	}
	
}
