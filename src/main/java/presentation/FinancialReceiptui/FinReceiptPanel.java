package presentation.FinancialReceiptui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.BkTransPO;
import presentation.BankManageui.BankPanel;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;

public class FinReceiptPanel {
	static private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JTextField textNum;
	private JTextField textField;
//	ArrayList<BkTransPO> bankList;
	PublicTableModel tableModel;
	FinReceiptController controller;
	SubPanel bankPane;
	JButton btnRight;
	JButton btnCancel; 
	JButton btnAdd;
	JButton btnDel; 
	public FinReceiptPanel(){
		initialize();
		controller=new FinReceiptController();
	}
	public void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//FIXME,编号获得
		JLabel label1 = new JLabel("编号");
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(90, 44, 54, 20);
		panel.add(label1);
		
		textNum = new JTextField();
		textNum.setFont(new Font("宋体", Font.PLAIN, 14));
		textNum.setText("SKD-20140507-99999");
		textNum.setBounds(155, 41, 150, 25);
		panel.add(textNum);
		textNum.setColumns(10);
		textNum.setEditable(false);
		//FIXME,操作员获得
		JLabel label2 = new JLabel("操作员");
		label2.setFont(new Font("宋体", Font.PLAIN, 18));
		label2.setBounds(90, 93, 54, 20);
		panel.add(label2);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setBounds(155, 91, 150, 25);
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		//FIXME,客户获得
		JLabel label3 = new JLabel("客户");
		label3.setFont(new Font("宋体", Font.PLAIN, 18));
		label3.setBounds(90, 140, 54, 20);
		panel.add(label3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		comboBox.setBounds(155, 137, 100, 25);
		panel.add(comboBox);
		
		JLabel label4 = new JLabel("转账列表");
		label4.setFont(new Font("宋体", Font.PLAIN, 18));
		label4.setBounds(174, 232, 80, 15);
		panel.add(label4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 280, 350, 150);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.BANK);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel label5 = new JLabel("总额");
		label5.setFont(new Font("宋体", Font.PLAIN, 18));
		label5.setBounds(230, 446, 200, 20);
		panel.add(label5);
		
		btnRight = new JButton("确定");
		btnRight.setFont(new Font("宋体", Font.PLAIN, 18));
		btnRight.setBounds(180, 510, 80, 30);
		panel.add(btnRight);
		
		btnCancel = new JButton("取消");
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 18));
		btnCancel.setBounds(310, 510, 80, 30);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		btnAdd = new JButton("添加");
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 14));
		btnAdd.setBounds(40, 440, 70, 30);
		panel.add(btnAdd);
		
		btnDel = new JButton("删除");
		btnDel.setFont(new Font("宋体", Font.PLAIN, 14));
		btnDel.setBounds(120, 440, 70, 30);
		panel.add(btnDel);
	}
	public void creatPay(){
		btnAdd.addActionListener(new AddBank());
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//FIXME,数据转换成单据
			}
			
		});
		btnDel.addActionListener(new DeleteBank());
		frame.setVisible(true);
	}
	public class DeleteBank implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(table.getSelectedRow()<0){
				JOptionPane.showMessageDialog(null, "未选中账户");
			}else{
				//FIXME,tableModel,ArrayList是否一样动态调整？
				controller.deleteBank(table.getSelectedRow());
				tableModel.removeRow(table.getSelectedRow());
			}
			
		}
		
	}
	public class AddBank implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//FIXME,存疑，bankPane的初始化问题
			bankPane=new SubPanel();
			bankPane.transfer();
		}
		
	}
	public static void main(String[] args){
		FinReceiptPanel a=new FinReceiptPanel();
		a.creatPay();
	}
	public class SubPanel {
		BkTransPO bankTrans;
		JFrame frame;
		JComboBox comboBox;
		JTextField balance;
		JTextField remark;
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
			
			JLabel label = new JLabel("账户名称");
			label.setFont(new Font("宋体", Font.PLAIN, 18));
			label.setBounds(10, 10, 72, 26);
			panel.add(label);
			
			JLabel label_1 = new JLabel("金额");
			label_1.setFont(new Font("宋体", Font.PLAIN, 18));
			label_1.setBounds(10, 51, 72, 26);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("备注");
			label_2.setFont(new Font("宋体", Font.PLAIN, 18));
			label_2.setBounds(144, 97, 72, 26);
			panel.add(label_2);
			
			balance = new JTextField();
			balance.setColumns(10);
			balance.setBounds(90, 54, 124, 26);
			panel.add(balance);
			
			remark = new JTextField();
			remark.setColumns(10);
			remark.setBounds(10, 133, 314, 26);
			panel.add(remark);
			
			button = new JButton("确定");
			button.setFont(new Font("宋体", Font.PLAIN, 18));
			button.setBounds(144, 169, 72, 33);
			panel.add(button);
			
			button_1 = new JButton("取消");
			button_1.setFont(new Font("宋体", Font.PLAIN, 18));
			button_1.setBounds(237, 169, 72, 33);
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
				}
			});
			panel.add(button_1);
		}
		public void transfer(){
			//FIXME,获得银行列表
			comboBox=new JComboBox(new String[]{"银行账户1","银行账户2"});
			comboBox.setBounds(90,13,100,25);
			panel.add(comboBox);
			
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					bankTrans=new BkTransPO((String)comboBox.getSelectedItem()
					,Double.valueOf(balance.getText()),remark.getText());
					tableModel.addRow(bankTrans);
					controller.addBank(bankTrans);
//					balance.setText(null);
//					remark.setText(null);
					frame.dispose();
				}
			});
			frame.setVisible(true);
		}
	}
}
