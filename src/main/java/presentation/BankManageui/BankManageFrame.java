package presentation.BankManageui;

import businesslogic.BankManagebl.BankController;
import vo.BankVO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
<<<<<<< HEAD

import presentation.Saleui.ModelType;
import presentation.Saleui.PublicTableModel;
import vo.BankVO;
import businesslogic.BankManagebl.BankController;
=======
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> origin/master

public class BankManageFrame {
	private JTextField search,name,balance,remark;
	private JTable table;
	private JPanel panel;
	int currentRow=-1;
	private BankPanel bankPane;
	private BankController controller;
	private BankVO[] list; 
	private PublicTableModel tableModel;
	public BankManageFrame(){
		controller=new BankController();
		initialize();
	}
	private void initialize(){
		panel =new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500);
		
		JButton button = new JButton("增加");
		button.setBounds(50, 90, 130, 40);
		panel.add(button);
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new Add());
		
		JButton button_1 = new JButton("删除");
		button_1.setBounds(50, 150, 130, 40);
		panel.add(button_1);
		button_1.addActionListener(new Delete());
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("修改");
		button_2.setBounds(50, 210, 130, 40);
		panel.add(button_2);
		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		button_2.addActionListener(new Modify());
		
		JButton button_3 = new JButton("查找");
		button_3.setBounds(570, 15, 80, 30);
		panel.add(button_3);
		button_3.addActionListener(new Search());
		button_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("关键字");
		label.setBounds(280, 15, 60, 30);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		search = new JTextField();
		search.setBounds(340, 15, 190, 30);
		panel.add(search);
		search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 60, 475, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		tableModel=new PublicTableModel(ModelType.BANK);
		list=new BankVO[1];
		list[0]=new BankVO();
		tableModel.update(list);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setFont(new Font("宋体", Font.PLAIN, 14));
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		table.addMouseListener(new MouseClick());
//		TableColumn column=null;
//		for(int i=0;i<3;i++){
//			column=table.getColumnModel().getColumn(i);
//			if(i==2){
//				column.setPreferredWidth(275);
//			}else{
//				column.setPreferredWidth(100);
//			}
//		}
	}
//	private void add(){
//		final JFrame addFrame=new JFrame();
//		addFrame.setBounds(100,100,350,250);
//		
//		JPanel panel = new JPanel();
//		addFrame.getContentPane().add(panel);
//		panel.setLayout(null);
//		
//		JLabel label = new JLabel("账户名称");
//		label.setFont(new Font("宋体", Font.PLAIN, 18));
//		label.setBounds(10, 10, 72, 26);
//		panel.add(label);
//		
//		JLabel label_1 = new JLabel("初始金额");
//		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
//		label_1.setBounds(10, 51, 72, 26);
//		panel.add(label_1);
//		
//		JLabel label_2 = new JLabel("备注");
//		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
//		label_2.setBounds(144, 97, 72, 26);
//		panel.add(label_2);
//		
//		name = new JTextField();
//		name.setBounds(92, 13, 124, 26);
//		panel.add(name);
//		name.setColumns(10);
//		
//		balance = new JTextField();
//		balance.setColumns(10);
//		balance.setBounds(92, 54, 124, 26);
//		panel.add(balance);
//		
//		remark = new JTextField();
//		remark.setColumns(10);
//		remark.setBounds(10, 133, 314, 26);
//		panel.add(remark);
		
//		JButton button = new JButton("确定");
//		button.setFont(new Font("宋体", Font.PLAIN, 18));
//		button.setBounds(144, 169, 72, 33);
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				BankVO bank=new BankVO(name.getText(),
//						Double.valueOf(balance.getText()),remark.getText());
//				JOptionPane.showMessageDialog(null,"添加成功",null,
//						JOptionPane.INFORMATION_MESSAGE);
////				try {
////					controller.add(bank);
////					JOptionPane.showMessageDialog(null,"添加成功");
////					addFrame.dispose();
////				} catch (Exception e1) {
////					JOptionPane.showMessageDialog(null,e1.getMessage());
////				}
//				addFrame.dispose();
//				
//			}
//		});
//		panel.add(button);
//		
//		JButton button_1 = new JButton("取消");
//		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
//		button_1.setBounds(237, 169, 72, 33);
//		button_1.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				addFrame.dispose();
//			}
//		});
//		panel.add(button_1);
//		
//		addFrame.setVisible(true);
//	}
	public void updateTable(){
		
	}
	public JPanel getPanel(){
		return panel;
	}
//	public class BankTableModel extends AbstractTableModel{
//		private String[] columnNames={"账户名称","余额","备注"};
//		private Object[][] data;
//		public BankTableModel(){
//			data=new Object[10][3];
//			data[0][0]="测试账户1";
//			data[0][1]=3000;
//			data[0][2]="备注";
//		}
//		public BankTableModel(Object[][] data){
//			if(data[0].length!=3){
//				System.out.println("BankTableModel列数错误");
//				data=new Object[10][3];
//			}
//			this.data=data;
//		}
//		public int getColumnCount() {
//			return columnNames.length;
//		}
//		public String getColumnName(int k){
//			return columnNames[k];
//		}
//		public int getRowCount() {
//			return data.length;
//		}
//		public Object getValueAt(int row, int col) {
//			return data[row][col];
//		}
//	}
	public class Delete implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentRow<0){
				JOptionPane.showMessageDialog(null,"未选中银行账户","有点问题"
						,JOptionPane.ERROR_MESSAGE);
			}
			else{
				int i=JOptionPane.showConfirmDialog(null, "是否删除？");
				if(i==0){
					try {
						controller.delete(list[currentRow]);
						JOptionPane.showMessageDialog(null, "删除成功");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
//				
			}
		}
	}
	public class Modify implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentRow<0){
				JOptionPane.showMessageDialog(null,"未选中银行账户","有点问题"
						,JOptionPane.ERROR_MESSAGE);
			}
			else{
				bankPane=new BankPanel(list[currentRow]);
				bankPane.modify();
			}
		}
	}
	public class Add implements ActionListener{
		public void actionPerformed(ActionEvent e){
			bankPane=new BankPanel();
			bankPane.add();
		}
		
	}
	public class Search implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				list=controller.search(search.getText());
				tableModel.update(list);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			System.out.println(table.getSelectedRow());
			currentRow=table.getSelectedRow();//修改，删除的前置
		}
	}
}
