package presentation.FinancialReceiptui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.BankManagebl.BankController;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.BkTransPO;
import po.ClientPO;
import po.ItemPO;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;
import vo.CashVO;
import vo.PayVO;
import vo.RecVO;

public class FinReceiptPane {
	static private JFrame frame;
	private JPanel panel;
	private JTable table;
//	private JTextField textNum;
	private JTextField textOperator;
//	ArrayList<BkTransPO> bankList;
	PublicTableModel tableModel;
	JButton btnRight;
	JButton btnCancel; 
	JButton btnAdd;
	JButton btnDel; 
	JLabel labelTotal;
	double total;
	JComboBox comboBox;
	private Font font=new Font("宋体",Font.PLAIN,18);
	private Font font2=new Font("宋体",Font.PLAIN,14);
//	ClientUtilityImpl clientController;
	JLabel label4;
	JLabel label3;
	JScrollPane scrollPane;

	FinReceiptController controller;
	SubPanel listPane;
	
	public FinReceiptPane(FinReceiptController controller){
		this.controller=controller;
		initialize();
	}
	public void ini(){//每次发起一次添加单据操作前执行,
		//comboBox有时是客户列表，有时是银行账户,
		if(comboBox!=null)
		panel.remove(comboBox);
		controller.clearBank();
		controller.clearItem();
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
		
		JLabel labelOperator;
		labelOperator = new JLabel("操作员:");
		labelOperator.setFont(font);
		labelOperator.setBounds(90, 93, 80, 20);
		panel.add(labelOperator);

		//操作员获得
		try {
			textOperator = new JTextField(controller.getOperator());
			textOperator.setFont(font2);
			textOperator.setBounds(155, 91, 150, 25);
			panel.add(textOperator);
			textOperator.setColumns(10);
			textOperator.setEditable(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		label3 = new JLabel("客户");
		label3.setFont(font);
		label3.setBounds(90, 140, 100, 20);
		panel.add(label3);
		
		label4 = new JLabel("转账列表");
		label4.setFont(font);
		label4.setBounds(174, 232, 80, 15);
		panel.add(label4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 280, 350, 150);
		panel.add(scrollPane);
		
//		tableModel=new PublicTableModel(ModelType.BANK);
//		table = new JTable(tableModel);
//		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("总额");
		label.setFont(font);
		label.setBounds(230, 446, 200, 20);
		panel.add(label);
		
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
				frame.setVisible(false);
			}
		});
		
		btnAdd = new JButton("添加");
		btnAdd.setFont(font2);
		btnAdd.setBounds(40, 440, 70, 30);
		panel.add(btnAdd);
		btnAdd.addActionListener(new Add());
		
		btnDel = new JButton("删除");
		btnDel.setFont(font2);
		btnDel.setBounds(120, 440, 70, 30);
		panel.add(btnDel);
		btnDel.addActionListener(new Delete());
	}
	private void bankIni(){
		label3.setText("客户");
		
		//客户获得
		String[] temp=null;
		try {
			temp = controller.getClient();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
//		temp=new String[]{"客户1","客户2"};
		
		comboBox = new JComboBox(temp);
		comboBox.setFont(font2);
		comboBox.setBounds(190, 137, 100, 25);
		panel.add(comboBox);
		
		tableModel=new PublicTableModel(ModelType.BANK);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		listPane=new SubPanel();
		listPane.transfer();
	}
	private void cashIni(){
		label3.setText("银行账户");
		label4.setText("条目清单");
		//FIXEME,银行获得
		String[] temp=null;
		try {
			temp = controller.getBank();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		tableModel = new PublicTableModel(ModelType.ITEM);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
//		temp=new String[]{"银行账户1","银行账户2"};
		
		comboBox = new JComboBox(temp);
		comboBox.setFont(font2);
		comboBox.setBounds(190, 137, 100, 25);
		panel.add(comboBox);
		
		listPane=new SubPanel();
		listPane.Cash();
	}
	public void creatPay(){
		ini();
		bankIni();
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem()==null){
					JOptionPane.showMessageDialog(null, "客户不能为空");
					return ;
				}
				if(tableModel.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "转账列表不能为空");
					return;
				}
				
				PayVO pay=new PayVO(
						(String)comboBox.getSelectedItem(),
						textOperator.getText(),
						total);

				try {
					controller.makePayment(pay);
					JOptionPane.showMessageDialog(null, "添加成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
		frame.setTitle("付款单");
		frame.setVisible(true);
	}
	public void creatCash(){
		ini();
		cashIni();
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()==null){
					JOptionPane.showMessageDialog(null, "银行账户不能为空");
					return ;
				}
				if(tableModel.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "条目清单不能为空");
					return;
				}
				CashVO cash=new CashVO(
						(String)comboBox.getSelectedItem(),
						textOperator.getText(),
						total);
				try {
					controller.makeCash(cash);
					JOptionPane.showMessageDialog(null, "添加成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
		
		frame.setTitle("现金费用单");
		frame.setVisible(true);
	}
	public void creatRec(){
		ini();
		bankIni();
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem()==null){
					JOptionPane.showMessageDialog(null, "客户不能为空");
					return ;
				}
				if(tableModel.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "转账列表不能为空");
					return;
				}
				
				RecVO receive=new RecVO(
						(String)comboBox.getSelectedItem(),
						textOperator.getText(),
						total);
				
				try {
					controller.makeReceive(receive);
					JOptionPane.showMessageDialog(null, "添加成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
			}
			
		});
		frame.setTitle("收款单");
		frame.setVisible(true);
	}
	public class Delete implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(table.getSelectedRow()<0){
				JOptionPane.showMessageDialog(null, "未选中账户");
			}else{

				switch(tableModel.type){
				case ITEM:
					total=controller.deleteItem(table.getSelectedRow());
					break;
				case BANK:
					total=controller.deleteBank(table.getSelectedRow());
					break;
				}
			
				tableModel.removeRow(table.getSelectedRow());
				
				labelTotal.setText(String.valueOf(total));
			}
			
		}
		
	}
	public class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			listPane.visit(true);
		}
		
	}

	public class SubPanel {
		BkTransPO bankTrans;
		JFrame frame;
		JComboBox comboBox;
		JTextField textItem;
		JTextField textAmount;
		JTextField textRemark;
		JPanel panel;
		JButton button;
		JButton button_1;
		JLabel label;
		ItemPO item;
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
			
			label = new JLabel("账户名称");
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
			
			textAmount = new JTextField();
			textAmount.setColumns(10);
			textAmount.setBounds(90, 54, 124, 26);
			panel.add(textAmount);
			
			textRemark = new JTextField();
			textRemark.setColumns(10);
			textRemark.setBounds(10, 133, 314, 26);
			panel.add(textRemark);
			
			button = new JButton("确定");
			button.setFont(font);
			button.setBounds(144, 169, 72, 33);
			panel.add(button);
			
			button_1 = new JButton("取消");
			button_1.setFont(font);
			button_1.setBounds(237, 169, 72, 33);
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.setVisible(false);
				}
			});
			panel.add(button_1);
			
		}
		public void transfer(){
			String[] temp=null;
			//获得银行列表
			try {
				temp = controller.getBank();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}

			
			comboBox=new JComboBox(temp);
			comboBox.setBounds(90,13,100,25);
			panel.add(comboBox);
			
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem()==null){
						JOptionPane.showMessageDialog(null, "银行账户不能为空");
						return;
					}
					if(textAmount.getText().equals("")){
						JOptionPane.showMessageDialog(null, "转账金额不能为空");
						return;
					}
					
					try{
						bankTrans=new BkTransPO(
								(String)comboBox.getSelectedItem(),
								Double.valueOf(textAmount.getText()),
								textRemark.getText());
					}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "账户金额应为数字");
						e2.printStackTrace();
						return;
					}
					tableModel.addRow(bankTrans);
					//FIXME
					total=controller.addBank(bankTrans);
					labelTotal.setText(String.valueOf(total));
					textAmount.setText(null);
					frame.setVisible(false);
				}
			});
		}
		public void Cash(){
			label.setText("条目");
			textItem=new JTextField();
			textItem.setBounds(90,13,100,25);
			textItem.setColumns(10);
			panel.add(textItem);
			
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(textItem.getText().equals("")){
						JOptionPane.showMessageDialog(null, "条目不能为空");
						return;
					}
					if(textAmount.getText().equals("")){
						JOptionPane.showMessageDialog(null, "金额不能为空");
						return;
					}
					try{
						item=new ItemPO(
								textItem.getText(),
								Double.valueOf(textAmount.getText()),
								textRemark.getText());
					}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "账户金额应为数字");
						e2.printStackTrace();
						return;
					}
					total=controller.addItem(item);
					labelTotal.setText(String.valueOf(total));
					tableModel.addRow(item);
					textAmount.setText(null);
					textRemark.setText(null);
					visit(false);
				}
			});
			
		}
		public void visit(boolean temp){
			frame.setVisible(temp);
		}
	}
}
