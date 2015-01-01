package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RunningTablebl.RunTableController;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import po.CashPO;
import po.DealState;
import po.ItemPO;
import po.ReceiptPO;
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
	private JTextField textDeal;
	private JButton btnCancel;
	private JLabel labelTotal;
	
	private PublicTableModel tableModel;
	private CashPO receipt;
	private RunTableController controller;
	private PublicTableModel receiptModel;
	private int currentRow;
	private FinReceiptController finController;
	private List<ReceiptPO> approveList;
	private JTable approveTable;
	public CashReceiptPane(){
		initialize();
	}
	public CashReceiptPane(int row,PublicTableModel model){
		this();
		currentRow=row;
		receiptModel=model;
		try {
			finController=new FinReceiptController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现了问题");
			e.printStackTrace();
		}
	} 
	public CashReceiptPane(RunTableController controller,CashPO receipt){
		this();
		this.receipt=receipt;
		this.controller=controller;
		credit();
		visit(true);
	}
	public CashReceiptPane(JTable approveTable,List<ReceiptPO> approveList,CashPO receipt){
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
		
		JLabel label_6 = new JLabel("处理状态:");
		label_6.setBounds(90, 220, 54, 15);
		panel.add(label_6);
		
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
		
		labelTotal = new JLabel("");
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
		
		textDeal = new JTextField();
		textDeal.setColumns(10);
		textDeal.setBounds(145, 217, 200, 21);
		panel.add(textDeal);
		
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
		textDeal.setEditable(false);
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
		textDeal.setText(DealState.getName(receipt.dealState));
	}	
	public void query(){
		btnCancel.setText("关闭");
	}
	public void deal(){
		JButton button = new JButton("处理");
		button.setBounds(219, 493, 60, 23);
		panel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				receipt.dealState=DealState.DEAL;
				//FIXME
//				try {
//					finController.update(receipt);
//					
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage());
//					e1.printStackTrace();
//				}
				try {
					finController.update(receipt);
					receiptModel.insteadRow(currentRow, receipt);
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
	}
	public void credit(){
		//TODO
		List<ItemPO> temp=receipt.itemList;
		ItemPO temp1;
		for(int i=0;i<temp.size();i++){
			temp1=temp.get(i);
			temp1.setAmount(-temp1.getAmount());
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
					JOptionPane.showMessageDialog(null,"添加成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
	}
	public void approve(){
		JButton button = new JButton("审批");
		button.setBounds(219, 493, 60, 23);
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
		button1.setBounds(100,493,80,23);
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
}
