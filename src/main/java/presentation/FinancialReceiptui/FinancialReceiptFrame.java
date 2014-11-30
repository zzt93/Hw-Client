package presentation.FinancialReceiptui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class FinancialReceiptFrame {
	private JPanel panel;
	private JTable table;
	public FinancialReceiptFrame(){
		initialize();
	};
	public void initialize(){
		panel = new JPanel();
		panel.setBounds(0, 100, 800, 500);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("付款单");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(50, 90, 130, 40);
		panel.add(btnNewButton);
		
		JButton button = new JButton("收款单");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(50, 170, 130, 40);
		panel.add(button);
		
		JButton button_1 = new JButton("现金费用单");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(50, 250, 130, 40);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 60, 475, 320);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("单据情况");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(435, 15, 80, 40);
		panel.add(label);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("宋体",Font.PLAIN,14));
		table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,14));
		scrollPane.setViewportView(table);
		table.setModel(new FinReceiptTableModel());
	}

	public JPanel getPanel(){
		return panel;
	}
	public class FinReceiptTableModel extends AbstractTableModel{
		public String[] columnNames={"日期","类型","总额","审批状况","处理状况"};
		public Object[][] data=new Object[10][5];
		public int getRowCount() {
			return data.length;
		}
		public int getColumnCount() {
			return columnNames.length;
		}
		public String getColumnName(int i){
			return columnNames[i];
		}
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
		
	}
}
