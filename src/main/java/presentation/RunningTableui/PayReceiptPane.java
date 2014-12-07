package presentation.RunningTableui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import po.DealState;
import po.RecPO;
import po.ReceiptState;
import po.ReceiptType;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

public class PayReceiptPane {
	private JFrame frame;
	private JTable table;
	private JTextField textNum;
	private JTextField textType;
	private JTextField textDate;
	private JTextField textOperator;
	private JTextField textClient;
	private JTextField textState;
	private JTextField textDeal;
	private JLabel labelTotal;
	private PublicTableModel tableModel;
	
	public PayReceiptPane(){
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
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
		
		JLabel label_4 = new JLabel("客户:");
		label_4.setBounds(90, 160, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("审批状态:");
		label_5.setBounds(90, 190, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("处理状态:");
		label_6.setBounds(90, 220, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("转账列表");
		label_7.setBounds(180, 250, 54, 15);
		panel.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 283, 366, 154);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.BANK);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel label_8 = new JLabel("总额:");
		label_8.setBounds(225, 444, 54, 15);
		panel.add(label_8);
		
		labelTotal = new JLabel();
		labelTotal.setBounds(256, 444, 150, 15);
		panel.add(labelTotal);
		
		JButton button = new JButton("确定");
		button.setBounds(219, 493, 60, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(319, 493, 60, 23);
		panel.add(button_1);
		
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
		
		textClient = new JTextField();
		textClient.setColumns(10);
		textClient.setBounds(145, 157, 200, 21);
		panel.add(textClient);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(145, 187, 200, 21);
		panel.add(textState);
		
		textDeal = new JTextField();
		textDeal.setColumns(10);
		textDeal.setBounds(145, 217, 200, 21);
		panel.add(textDeal);
		
	}
	public void set(RecPO receipt){
		textNum.setText(receipt.number);
		textType.setText(ReceiptType.getName(receipt.type));
		textDate.setText(receipt.time);
		textOperator.setText(receipt.operator);
		textClient.setText(receipt.client);
		textState.setText(ReceiptState.getName(receipt.statement));
		textDeal.setText(DealState.getName(receipt.dealState));
		tableModel.update(receipt.bankList);
		labelTotal.setText(String.valueOf(receipt.total));
		
	}
	public void approve(){
		
	}
	public void query(){
		
	}
	public void credit(){
		
	}
}
