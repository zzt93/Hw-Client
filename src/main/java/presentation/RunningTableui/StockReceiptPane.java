package presentation.RunningTableui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import po.ReceiptState;
import po.ReceiptType;
import po.StockReceiptPO;
import presentation.mainui.PublicTableModel;

public class StockReceiptPane {
	
	private JFrame frame;
	private JTextField textNum;
	private JTextField textClient;
	private JTextField textType;
	private JTextField textRepository;
	private JTextField textDate;
	private JTextField textOperator;
	private JTextField textState;
	private JTextField textComment;
	private JPanel panel;
	private JButton btnCancel;
	private JLabel labelTotal;
	
	private PublicTableModel tableModel;
	private StockReceiptPO receipt;
	
	public StockReceiptPane(){
		initialize();
	}
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label_8 = new JLabel("供应商:");
		label_8.setBounds(90, 65, 54, 15);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("仓库:");
		label_9.setBounds(270, 65, 54, 15);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("操作员:");
		label_10.setBounds(414, 30, 54, 15);
		panel.add(label_10);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 210, 600, 220);
		panel.add(scrollPane);
		
		
		JTable table = new JTable();
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
		
		textRepository = new JTextField();
		textRepository.setColumns(10);
		textRepository.setBounds(301, 62, 100, 21);
		panel.add(textRepository);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(301, 102, 100, 21);
		panel.add(textDate);
		
		textOperator = new JTextField();
		textOperator.setColumns(10);
		textOperator.setBounds(470, 27, 100, 21);
		panel.add(textOperator);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(527, 102, 100, 21);
		panel.add(textState);
		
		textComment = new JTextField();
		textComment.setColumns(10);
		textComment.setBounds(135, 142, 500, 21);
		panel.add(textComment);
		
		labelTotal = new JLabel();
		labelTotal.setBounds(470, 444, 200, 15);
		panel.add(labelTotal);
		
		textNum.setEditable(false);
		textClient.setEditable(false);
		textType.setEditable(false);
//		textAllowance.setEditable(false);
		textDate.setEditable(false);
		textRepository.setEditable(false);
//		textCoupon.setEditable(false);
		textOperator.setEditable(false);
		textState.setEditable(false);
//		textActualValue.setEditable(false);
		textComment.setEditable(false);
//		textSalesman.setEditable(false);
		
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(547, 491, 60, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
//		JButton button_1 = new JButton("确定");
//		button_1.setBounds(439, 491, 60, 23);
//		panel.add(button_1);
		
	}
	public void visit(boolean temp){
		frame.setVisible(temp);
	}
	public void set(StockReceiptPO receipt){
		this.receipt=receipt;
		textNum.setText(receipt.receipt_id);
		textClient.setText(receipt.getClient());
		textType.setText(ReceiptType.getName(receipt.type));
		textRepository.setText(receipt.getRepository());
		textDate.setText(receipt.time);
		textComment.setText(receipt.getComment());
		textOperator.setText(receipt.getOperator());
		textState.setText(ReceiptState.getName(receipt.state));

		
		labelTotal.setText(receipt.getTotalValue().toString());
		tableModel.update(receipt.getProductList());
	}
	public void query(){
		btnCancel.setText("关闭");
	}
}
