package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogicservice.Approveblservice.Approve_List_BLservice;
import po.CashPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import po.RepoReceiptPO;

public class RepoReceiptPane {
	private JFrame frame;
	private JTextField textNum;
	private JTextField textType;
	private JTextField textDate;
	private JTextField textGoodsID;
	private JTextField textActualNum;
	private JTextField textState;
	private JTextField textOperator;
	private JTextField textReport;
	private JTextField textStatisticNum;
	private JButton btnCancel;
	private JPanel panel;
	
	private List<ReceiptPO> approveList;
	private RepoReceiptPO receipt;
	private JTable approveTable;
	public RepoReceiptPane(){
		initialize();
	}
	public RepoReceiptPane(JTable approveTable,List<ReceiptPO> approveList,RepoReceiptPO receipt){
		this.approveTable=approveTable;
		this.approveList=approveList;
		this.receipt=receipt;
		initialize();
		set(receipt);
		approve();
		visit(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("单据编号:");
		label.setBounds(30, 20, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("单据类型:");
		label_1.setBounds(30, 50, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("操作员:");
		label_2.setBounds(267, 80, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("日期:");
		label_3.setBounds(30, 80, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("审批状态:");
		label_4.setBounds(257, 50, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("商品编号:");
		label_5.setBounds(30, 110, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("实际库存数量:");
		label_6.setBounds(30, 140, 80, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("系统库存数量:");
		label_7.setBounds(234, 140, 80, 15);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("报溢/报损:");
		label_8.setBounds(251, 110, 60, 15);
		panel.add(label_8);
		
		textNum = new JTextField();
		textNum.setBounds(94, 17, 200, 21);
		panel.add(textNum);
		textNum.setColumns(10);
		
		textType = new JTextField();
		textType.setBounds(94, 47, 100, 21);
		panel.add(textType);
		textType.setColumns(10);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(94, 77, 100, 21);
		panel.add(textDate);
		
		textGoodsID = new JTextField();
		textGoodsID.setColumns(10);
		textGoodsID.setBounds(94, 107, 100, 21);
		panel.add(textGoodsID);
		
		textActualNum = new JTextField();
		textActualNum.setColumns(10);
		textActualNum.setBounds(120, 137, 100, 21);
		panel.add(textActualNum);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(321, 47, 100, 21);
		panel.add(textState);
		
		textOperator = new JTextField();
		textOperator.setColumns(10);
		textOperator.setBounds(321, 77, 100, 21);
		panel.add(textOperator);
		
		textReport = new JTextField();
		textReport.setColumns(10);
		textReport.setBounds(321, 107, 100, 21);
		panel.add(textReport);
		
		textStatisticNum = new JTextField();
		textStatisticNum.setColumns(10);
		textStatisticNum.setBounds(321, 137, 100, 21);
		panel.add(textStatisticNum);
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(321, 201, 60, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		textNum.setEditable(false);
		textType.setEditable(false);
		textDate.setEditable(false);
		textGoodsID.setEditable(false);
		textActualNum.setEditable(false);
		textState.setEditable(false);
		textReport.setEditable(false);
		textStatisticNum.setEditable(false);
		textOperator.setEditable(false);
//		JButton btnRight = new JButton("确定");
//		btnRight.setBounds(234, 201, 60, 23);
//		panel.add(btnRight);
	}
	public void query(){
		btnCancel.setText("关闭");
	}
	public void set(RepoReceiptPO receipt){
		this.receipt=receipt;
		int actualNum=receipt.getaNum();
		int statisticNum=receipt.getcNum();
		textNum.setText(receipt.number);
		textType.setText(ReceiptType.getName(receipt.type));
		textDate.setText(receipt.time);
		textGoodsID.setText(receipt.getGoods_id());
		textActualNum.setText(String.valueOf(actualNum));
		textState.setText(ReceiptState.getName(receipt.statement));
		textReport.setText(String.valueOf(actualNum-statisticNum));
		textStatisticNum.setText(String.valueOf(statisticNum));
	}
	public void approve(){
		JButton button = new JButton("审批");
		button.setBounds(234, 201, 60, 23);
		panel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					receipt.statement=ReceiptState.approve;
					approveList.add(receipt);
					instead();
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton button1=new JButton("不通过");
		button1.setBounds(134,201,80,23);
		panel.add(button1);
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					receipt.statement=ReceiptState.disapprove;
					approveList.add(receipt);
					instead();
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
			}
			
		});
	}
	public void instead(){//对审批单据的table进行即时更新
		int row=approveTable.getSelectedRow();
		DefaultTableModel model=(DefaultTableModel) approveTable.getModel();
		Object data[]=new Object[4];
		data[0]=receipt.number;
		data[1]=ReceiptType.getName(receipt.type);
		data[2]=receipt.time;
		data[3]=ReceiptState.getName(receipt.statement);
		model.removeRow(row);
		model.insertRow(row,data);
	}
	public void visit(boolean temp){
		frame.setVisible(temp);
	}
}
