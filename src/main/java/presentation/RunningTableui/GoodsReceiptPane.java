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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.RunningTablebl.RunTableController;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.GoodsVO;

public class GoodsReceiptPane {

	private JFrame frame;
	private JTable table;
	private JTextField textNum;
	private JTextField textOperator;
	private JTextField textType;
	private JTextField textState;
	private JTextField textDate;
	private JPanel panel;
	private JButton btnCancel;
	private JLabel labelTotal;
	
	private GoodsReceiptPO receipt;
	private PublicTableModel tableModel;
	private RunTableController controller;
	private Approve_List_BLservice approveBL;
	public GoodsReceiptPane(){
		initialize();
	}
	public GoodsReceiptPane(RunTableController controller,GoodsReceiptPO receipt){
		this();
		this.receipt=receipt;
		this.controller=controller;
		credit();
		visit(true);
	}
	public GoodsReceiptPane(Approve_List_BLservice approveBL,GoodsReceiptPO receipt){
		this.approveBL=approveBL;
		this.receipt=receipt;
		initialize();
		set(receipt);
		approve();
		visit(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 150, 500, 140);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.GOODSRECEIPT);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		
		JLabel label = new JLabel("单据编号:");
		label.setBounds(50, 30, 54, 15);
		panel.add(label);
		
		textNum = new JTextField();
		textNum.setBounds(105, 27, 200, 21);
		panel.add(textNum);
		textNum.setColumns(10);
		
		JLabel label_1 = new JLabel("操作员:");
		label_1.setBounds(326, 30, 54, 15);
		panel.add(label_1);
		
		textOperator = new JTextField();
		textOperator.setBounds(373, 27, 100, 21);
		panel.add(textOperator);
		textOperator.setColumns(10);
		
		JLabel label_2 = new JLabel("单据类型:");
		label_2.setBounds(50, 60, 54, 15);
		panel.add(label_2);
		
		textType = new JTextField();
		textType.setBounds(105, 57, 100, 21);
		panel.add(textType);
		textType.setColumns(10);
		
		JLabel label_3 = new JLabel("审批状态:");
		label_3.setBounds(315, 60, 54, 15);
		panel.add(label_3);
		
		textState = new JTextField();
		textState.setBounds(373, 57, 100, 21);
		panel.add(textState);
		textState.setColumns(10);
		
		JLabel label_4 = new JLabel("日期:");
		label_4.setBounds(50, 90, 54, 15);
		panel.add(label_4);
		
		textDate = new JTextField();
		textDate.setBounds(105, 87, 100, 21);
		panel.add(textDate);
		textDate.setColumns(10);
		
		JLabel label_5 = new JLabel("赠送列表");
		label_5.setBounds(251, 127, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("总额:");
		label_6.setBounds(50, 300, 54, 15);
		panel.add(label_6);
		
		labelTotal = new JLabel("33200000");
		labelTotal.setBounds(81, 300, 100, 15);
		panel.add(labelTotal);
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(453, 318, 60, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
			
		});
		
		textNum.setEditable(false);
		textOperator.setEditable(false);
		textType.setEditable(false);
		textState.setEditable(false);
		textDate.setEditable(false);
		
	}
	public void query(){
		btnCancel.setText("关闭");
	}
	public void set(GoodsReceiptPO receipt){
		this.receipt=receipt;
		textNum.setText(receipt.number);
		textOperator.setText(receipt.getUser());
		textType.setText(ReceiptType.getName(receipt.type));
		textState.setText(ReceiptState.getName(receipt.statement));
		textDate.setText(receipt.time);
		
		labelTotal.setText(String.valueOf(receipt.getSumOfGifts()));
		tableModel.update(receipt.getGoods());
	}
	public void visit(boolean temp){
		frame.setVisible(temp);
	}
	public void credit(){
		List<GoodsVO> temp=receipt.getGoods();
		GoodsVO temp1;
		for(int i=0;i<temp.size();i++){
			temp1=temp.get(i);
			temp1.amount=-temp1.amount;
		}
		receipt.setSumOfGifts(-receipt.getSumOfGifts());
		
		set(receipt);
		JButton btnRight = new JButton("提交");
		btnRight.setBounds(355, 318, 60, 23);
		panel.add(btnRight);
		btnRight.addActionListener(new ActionListener(){
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
	public void approve(){
		JButton button = new JButton("审批");
		button.setBounds(355, 318, 60, 23);
		panel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ArrayList<ReceiptPO> temp=new ArrayList<ReceiptPO>();
				temp.add(receipt);
				try {
					approveBL.passList(temp);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
	
	}
}
