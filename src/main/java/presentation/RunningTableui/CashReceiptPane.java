package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.RunningTablebl.RunTableController;
import po.CashPO;
import po.DealState;
import po.ItemPO;
import po.ReceiptState;
import po.ReceiptType;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

public class CashReceiptPane {
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JTextField textNum;
	private JTextField textType;
	private JTextField textDate;
	private JTextField textOperator;
	private JTextField textBank;
	private JTextField textState;
	private JButton btnCancel;
	private JLabel labelTotal;
	
	private PublicTableModel tableModel;
	private CashPO receipt;
	private RunTableController controller;
	
	public CashReceiptPane(){
		initialize();
	}
	public CashReceiptPane(RunTableController controller,CashPO receipt){
		this();
		this.receipt=receipt;
		this.controller=controller;
		credit();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("编号:");
		label.setBounds(90, 40, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("类型:");
		label_1.setBounds(90, 70, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("日期:");
		label_2.setBounds(90, 100, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("操作员:");
		label_3.setBounds(90, 130, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("银行账户:");
		label_4.setBounds(90, 160, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("审批状态:");
		label_5.setBounds(90, 190, 54, 15);
		panel.add(label_5);
		
		JLabel label_7 = new JLabel("条目清单");
		label_7.setBounds(180, 250, 54, 15);
		panel.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 283, 366, 154);
		panel.add(scrollPane);
		//TODO
		tableModel=new PublicTableModel(ModelType.ITEM);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel label_8 = new JLabel("总额:");
		label_8.setBounds(225, 444, 54, 15);
		panel.add(label_8);
		
		labelTotal = new JLabel("3120");
		labelTotal.setBounds(256, 444, 150, 15);
		panel.add(labelTotal);
		
		textNum = new JTextField();
		textNum.setBounds(145, 37, 200, 21);
		panel.add(textNum);
		textNum.setColumns(10);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(145, 67, 200, 21);
		panel.add(textType);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(145, 97, 200, 21);
		panel.add(textDate);
		
		textOperator = new JTextField();
		textOperator.setColumns(10);
		textOperator.setBounds(145, 127, 200, 21);
		panel.add(textOperator);
		
		textBank = new JTextField();
		textBank.setColumns(10);
		textBank.setBounds(145, 157, 200, 21);
		panel.add(textBank);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(145, 187, 200, 21);
		panel.add(textState);
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(319, 493, 60, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
			
		});
		
		textNum.setEditable(false);
		textType.setEditable(false);
		textDate.setEditable(false);
		textOperator.setEditable(false);
		textBank.setEditable(false);
		textState.setEditable(false);
	}
	public void visit(boolean temp){
		frame.setVisible(temp);
	}
	public void setReceipt(CashPO receipt){
		this.receipt=receipt;
	}
	public void set(CashPO receipt){
		this.receipt=receipt;
		textNum.setText(receipt.number);
		textType.setText(ReceiptType.getName(receipt.type));
		textDate.setText(receipt.time);
		textOperator.setText(receipt.operator);
		textBank.setText(receipt.bank);
		textState.setText(ReceiptState.getName(receipt.statement));
		tableModel.update(receipt.itemList);
		labelTotal.setText(String.valueOf(receipt.total));
	}	
	public void query(){
		btnCancel.setText("关闭");
	}
	public void credit(){
		//TODO
		ItemPO[] temp=receipt.itemList;
		for(int i=0;i<temp.length;i++){
			Double temp1=temp[i].getAmount();
			temp[i].setAmount(-temp1);
		}
		receipt.total=-receipt.total;
		
		set(receipt);
		JButton button = new JButton("提交");
		button.setBounds(219, 493, 60, 23);
		panel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CreditNote(receipt);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
	}
	
}
