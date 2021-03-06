package presentation.BankManageui;

import businesslogic.BankManagebl.BankController;
import presentation.RepoUI.MainFrame;
import vo.BankVO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import presentation.mainui.SalesmanUI;
import vo.BankVO;
import businesslogic.BankManagebl.BankController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BankManageFrame {
	private JTextField search,name,balance,remark;
	private JTable table;
	private JPanel panel;
	int currentRow=-1;
	private BankPanel bankPane;
	private BankController controller;
	private BankVO[] list; 
	private PublicTableModel tableModel;
	private Font font=new Font("宋体",Font.PLAIN,18);
	private Font font2=new Font("宋体",Font.PLAIN,14);
	public BankManageFrame(){
		try {
			controller=new BankController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现异常");
			e.printStackTrace();
			//System.exit(0);
		}
		initialize();
	}
	private void initialize(){
//		try {
//			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        MainFrame.look_and_feel();
		
		panel =new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500);
		
		JButton button = new JButton("增加");
		button.setBounds(50, 90, 130, 40);
		panel.add(button);
		button.setFont(font);
		button.addActionListener(new Add());
		
		JButton button_1 = new JButton("删除");
		button_1.setBounds(50, 150, 130, 40);
		panel.add(button_1);
		button_1.addActionListener(new Delete());
		button_1.setFont(font);
		
		JButton button_2 = new JButton("修改");
		button_2.setBounds(50, 210, 130, 40);
		panel.add(button_2);
		button_2.setFont(font);
		button_2.addActionListener(new Modify());
		
		JButton button_3 = new JButton("查找");
		button_3.setBounds(570, 15, 80, 30);
		panel.add(button_3);
		button_3.addActionListener(new Search());
		button_3.setFont(font);
		
		JLabel label = new JLabel("关键字");
		label.setBounds(280, 15, 60, 30);
		panel.add(label);
		label.setFont(font);
		
		search = new JTextField();
		search.setBounds(340, 15, 190, 30);
		panel.add(search);
		search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 60, 475, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		tableModel=new PublicTableModel(ModelType.BANK);
		//FIXME,TEST CODE
//		list=new BankVO[1];
//		list[0]=new BankVO();
//		tableModel.update(list);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setFont(font2);
		table.setFont(font2);
		table.addMouseListener(new MouseClick());
//FIXME,设置表头宽度
		TableColumn column=null;
		for(int i=0;i<3;i++){
			column=table.getColumnModel().getColumn(i);
			if(i==2){
				column.setPreferredWidth(275);
			}else{
				column.setPreferredWidth(100);
			}
		}
	}

	public void updateTable(){
		
	}
	public JPanel getPanel(){
		return panel;
	}
	public class Delete implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentRow<0){
				JOptionPane.showMessageDialog(null,"未选中银行账户","有点问题"
						,JOptionPane.ERROR_MESSAGE);
			}
			else{
				int i=JOptionPane.showConfirmDialog(null,"","是否删除？",JOptionPane.YES_NO_OPTION);
				if(i==0){
					try {
						BankVO temp=list[currentRow];
						if(temp.balance!=0){
							JOptionPane.showMessageDialog(null, "不可删除！");
						}else{
							controller.delete(temp);
							JOptionPane.showMessageDialog(null, "删除成功");
						}
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
				bankPane=new BankPanel(list[currentRow],controller);
				bankPane.modify();
				bankPane.visit();
			}
		}
	}
	public class Add implements ActionListener{
		public void actionPerformed(ActionEvent e){
			bankPane=new BankPanel(controller);
			bankPane.add();
			bankPane.visit();
		}
		
	}
	public class Search implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				String field=search.getText();
				if(field.equals("")){
					field=null;
				}
				list=controller.search(field);
				tableModel.update(list);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			currentRow=table.getSelectedRow();//修改，删除的前置
		}
	}
}
