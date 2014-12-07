package presentation.FinancialReceiptui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.BkTransPO;
import po.ItemPO;
import presentation.FinancialReceiptui.FinReceiptPane.SubPanel;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

public class CashReceiptPane {
	static private JFrame frame;
	private JPanel panel;
	private JTable table;
//	private JTextField textNum;
	private JTextField textOperator;
//	ArrayList<BkTransPO> bankList;
	PublicTableModel tableModel;
	FinReceiptController controller;
	SubPanel bankPane;
	JButton btnRight;
	JButton btnCancel; 
	JButton btnAdd;
	JButton btnDel; 
	JLabel labelTotal;
	double total;
	JComboBox comboBox;
	private Font font=new Font("宋体",Font.PLAIN,18);
	private Font font2=new Font("宋体",Font.PLAIN,14);
	private SubPanel itemPanel;
	public CashReceiptPane(){
		itemPanel=new SubPanel();
		initialize();
		//FIXME
		frame.setVisible(true);
	}
	public void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//不显示编号
//		JLabel label1 = new JLabel("编号");
//		label1.setFont(font);
//		label1.setBounds(90, 44, 54, 20);
//		panel.add(label1);
		
//		textNum = new JTextField();
//		textNum.setFont(new Font("宋体", Font.PLAIN, 14));
//		textNum.setText("SKD-20140507-99999");
//		textNum.setBounds(155, 41, 150, 25);
//		panel.add(textNum);
//		textNum.setColumns(10);
//		textNum.setEditable(false);
		//FIXME,操作员获得
		JLabel label2 = new JLabel("操作员");
		label2.setFont(font);
		label2.setBounds(90, 93, 54, 20);
		panel.add(label2);
		
		textOperator = new JTextField();
		textOperator.setFont(font2);
		textOperator.setBounds(155, 91, 150, 25);
		panel.add(textOperator);
		textOperator.setColumns(10);
		textOperator.setEditable(false);
		

		JLabel label3 = new JLabel("银行账户:");
		label3.setFont(font);
		label3.setBounds(90, 140, 100, 20);
		panel.add(label3);
		
		//FIXEME,银行账户获得
		String[] temp=null;
//		try {
//			temp = controller.getBank();
//		} catch (Exception e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
//			e1.printStackTrace();
//		}
		temp=new String[]{"银行账户1","银行账户2"};
		
		comboBox = new JComboBox(temp);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		comboBox.setBounds(200, 137, 100, 25);
		panel.add(comboBox);
		
		JLabel label4 = new JLabel("条目清单");
		label4.setFont(font);
		label4.setBounds(174, 232, 80, 15);
		panel.add(label4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 280, 350, 150);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.ITEM);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel label5 = new JLabel("总额");
		label5.setFont(font);
		label5.setBounds(230, 446, 200, 20);
		panel.add(label5);
		
		labelTotal = new JLabel("");
		labelTotal.setFont(font);
		labelTotal.setBounds(280, 446, 200, 20);
		panel.add(labelTotal);
		
		btnRight = new JButton("确定");
		btnRight.setFont(font);
		btnRight.setBounds(180, 510, 80, 30);
		panel.add(btnRight);
		
		btnCancel = new JButton("取消");
		btnCancel.setFont(font);
		btnCancel.setBounds(310, 510, 80, 30);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.clearBank();
				controller.clearItem();
				frame.dispose();
			}
		});
		
		btnAdd = new JButton("添加");
		btnAdd.setFont(font2);
		btnAdd.setBounds(40, 440, 70, 30);
		panel.add(btnAdd);
		btnAdd.addActionListener(new AddItem());
		
		btnDel = new JButton("删除");
		btnDel.setFont(font2);
		btnDel.setBounds(120, 440, 70, 30);
		panel.add(btnDel);
	}
	public void creatCash(){
		
	}
	public static void main(String[] args){
		CashReceiptPane temp=new CashReceiptPane();
	}
	public class AddItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			itemPanel.visit(true);
		}
		
	}
	public class DelItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class SubPanel{
		ItemPO item;
		JFrame frame;
		JTextField textItem;
		JTextField textBalance;
		JTextField textRemark;
		JPanel panel;
		JButton button;
		JButton button_1;
		public SubPanel(){
			initialize();
		}
		public void initialize(){
			frame=new JFrame();
			frame.setBounds(100,100,350,250);
			frame.setLocationRelativeTo(null);
			
			panel = new JPanel();
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel label = new JLabel("条目");
			label.setFont(font);
			label.setBounds(10, 10, 72, 26);
			panel.add(label);
			
			JLabel label_1 = new JLabel("金额");
			label_1.setFont(font);
			label_1.setBounds(10, 51, 72, 26);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("备注");
			label_2.setFont(font);
			label_2.setBounds(144, 97, 72, 26);
			panel.add(label_2);
			
			textItem = new JTextField();
			textItem.setColumns(10);
			textItem.setBounds(90, 10, 124, 26);
			panel.add(textItem);
			
			textBalance = new JTextField();
			textBalance.setColumns(10);
			textBalance.setBounds(90, 54, 124, 26);
			panel.add(textBalance);
			
			textRemark = new JTextField();
			textRemark.setColumns(10);
			textRemark.setBounds(10, 133, 314, 26);
			panel.add(textRemark);
			
			button = new JButton("确定");
			button.setFont(font);
			button.setBounds(144, 169, 72, 33);
			panel.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					item=new ItemPO(textItem.getText(),
							Double.valueOf(textBalance.getText()),textRemark.getText());
					controller.addItem(item);
					tableModel.addRow(item);
				}
				
			});
			button_1 = new JButton("取消");
			button_1.setFont(font);
			button_1.setBounds(237, 169, 72, 33);
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
				}
			});
			panel.add(button_1);
		}
		public void visit(boolean temp){
			frame.setVisible(temp);
		}
	}
}
