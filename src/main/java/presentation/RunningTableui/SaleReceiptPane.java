package presentation.RunningTableui;

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
import po.CashPO;
import po.ProductsReceipt;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import po.SaleReceiptPO;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

public class SaleReceiptPane {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField textNum;
	private JTextField textClient;
	private JTextField textType;
	private JTextField textAllowance;
	private JTextField textRepository;
	private JTextField textDate;
	private JTextField textCoupon;
	private JTextField textOperator;
	private JTextField textState;
	private JTextField textActualValue;
	private JTextField textComment;
	private JTextField textSalesman;
	private JButton btnCancel;
	private JTable table;
	private JLabel labelTotal;
	
	private PublicTableModel tableModel;
	private SaleReceiptPO receipt;
	private RunTableController controller;
	private List<ReceiptPO> approveList;
	
	public SaleReceiptPane(){
		initialize();
	}
	public SaleReceiptPane(RunTableController controller ,SaleReceiptPO receipt){
		this();
		this.controller=controller;
		this.receipt=receipt;
		credit();
		visit(true);
	}
	public SaleReceiptPane(List<ReceiptPO> approveList,SaleReceiptPO receipt){
		this.approveList=approveList;
		this.receipt=receipt;
		initialize();
		set(receipt);
		approve();
		visit(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label_8 = new JLabel("销售商:");
		label_8.setBounds(90, 65, 54, 15);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("仓库:");
		label_9.setBounds(270, 65, 54, 15);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("操作员:");
		label_10.setBounds(414, 30, 54, 15);
		panel.add(label_10);
		
		JLabel label_12 = new JLabel("业务员:");
		label_12.setBounds(470, 65, 54, 15);
		panel.add(label_12);
		
		JLabel label = new JLabel("类型:");
		label.setBounds(90, 105, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("日期:");
		label_1.setBounds(270, 105, 54, 15);
		panel.add(label_1);
		
		JLabel label_11 = new JLabel("备注:");
		label_11.setBounds(90, 145, 54, 15);
		panel.add(label_11);
		
		JLabel label_2 = new JLabel("总额:");
		label_2.setBounds(439, 444, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("折让:");
		label_3.setBounds(90, 185, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("代金券:");
		label_4.setBounds(270, 185, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("折让后总额:");
		label_5.setBounds(470, 185, 80, 15);
		panel.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 210, 600, 220);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.PRODUCTS);
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		frame.getContentPane().add(panel);
		
		JLabel label_6 = new JLabel("编号:");
		label_6.setBounds(90, 30, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("审批状态:");
		label_7.setBounds(470, 105, 54, 15);
		panel.add(label_7);
		
		textNum = new JTextField();
		textNum.setBounds(135, 27, 200, 21);
		panel.add(textNum);
		textNum.setColumns(10);
		
		textClient = new JTextField();
		textClient.setBounds(135, 62, 100, 21);
		panel.add(textClient);
		textClient.setColumns(10);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(135, 102, 100, 21);
		panel.add(textType);
		
		textAllowance = new JTextField();
		textAllowance.setColumns(10);
		textAllowance.setBounds(135, 182, 100, 21);
		panel.add(textAllowance);
		
		textRepository = new JTextField();
		textRepository.setColumns(10);
		textRepository.setBounds(301, 62, 100, 21);
		panel.add(textRepository);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(301, 102, 100, 21);
		panel.add(textDate);
		
		textCoupon = new JTextField();
		textCoupon.setColumns(10);
		textCoupon.setBounds(318, 182, 100, 21);
		panel.add(textCoupon);
		
		textOperator = new JTextField();
		textOperator.setColumns(10);
		textOperator.setBounds(470, 27, 100, 21);
		panel.add(textOperator);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(527, 102, 100, 21);
		panel.add(textState);
		
		textActualValue = new JTextField();
		textActualValue.setColumns(10);
		textActualValue.setBounds(540, 182, 100, 21);
		panel.add(textActualValue);
		
		textComment = new JTextField();
		textComment.setColumns(10);
		textComment.setBounds(135, 142, 500, 21);
		panel.add(textComment);
		
		textSalesman = new JTextField();
		textSalesman.setBounds(527, 62, 100, 21);
		panel.add(textSalesman);
		textSalesman.setColumns(10);
		
		labelTotal = new JLabel("12450");
		labelTotal.setBounds(470, 444, 200, 15);
		panel.add(labelTotal);
		
		textNum.setEditable(false);
		textClient.setEditable(false);
		textType.setEditable(false);
		textAllowance.setEditable(false);
		textDate.setEditable(false);
		textRepository.setEditable(false);
		textCoupon.setEditable(false);
		textOperator.setEditable(false);
		textState.setEditable(false);
		textActualValue.setEditable(false);
		textComment.setEditable(false);
		textSalesman.setEditable(false);
		
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(547, 491, 60, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//FIXME,关闭还是不可见？
			}
			
		});
		
//		JButton button_1 = new JButton("确定");
//		button_1.setBounds(439, 491, 60, 23);
//		panel.add(button_1);
	}
	public void visit(boolean temp){
		frame.setVisible(temp);
	}
	public void set(SaleReceiptPO receipt){
		this.receipt=receipt;
		textNum.setText(receipt.number);
		textClient.setText(receipt.getClient());
		textType.setText(ReceiptType.getName(receipt.type));
		textRepository.setText(receipt.getRepository());
		textDate.setText(receipt.time);
		textComment.setText(receipt.getComment());
		textOperator.setText(receipt.getOperator());
		textState.setText(ReceiptState.getName(receipt.statement));
		
		textSalesman.setText(receipt.getSalesman());
		textAllowance.setText(receipt.getAllowance().toString());
		textCoupon.setText(receipt.getCoupon().toString());
		textActualValue.setText(receipt.getActualValue().toString());
		
		labelTotal.setText(receipt.getTotalValue().toString());
		tableModel.update(receipt.getProductList());
		
	}
	public void query(){
		btnCancel.setText("关闭");
	}
	public void credit(){
		List<ProductsReceipt> temp=receipt.getProductList();
		ProductsReceipt temp1;
		for(int i=0;i<temp.size();i++){
			temp1=temp.get(i);
			temp1.setNumber(-temp1.getNumber());
		}
		receipt.setTotalValue(receipt.getTotalValue().negate());
		receipt.setActualValue(receipt.getActualValue().negate());
		receipt.setActualValue(receipt.getAllowance().negate());
		receipt.setCoupon(receipt.getCoupon().negate());
		
		set(receipt);
		
		JButton button_1 = new JButton("提交");
		button_1.setBounds(439, 491, 60, 23);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CreditNote(receipt);
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
		button.setBounds(439, 491, 60, 23);
		panel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					receipt.statement=ReceiptState.approve;
					approveList.add(receipt);
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
	
	}
}
