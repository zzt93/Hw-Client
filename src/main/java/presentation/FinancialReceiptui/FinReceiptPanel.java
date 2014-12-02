package presentation.FinancialReceiptui;

import java.awt.BorderLayout;
import java.awt.Font;
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
import presentation.BankManageui.BankPanel;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;
import vo.PayVO;
import vo.RecVO;

public class FinReceiptPanel {
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
	ClientUtilityImpl clientController;
	
	public FinReceiptPanel(){
		initialize();
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
//		label1.setFont(new Font("宋体", Font.PLAIN, 18));
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
		label2.setFont(new Font("宋体", Font.PLAIN, 18));
		label2.setBounds(90, 93, 54, 20);
		panel.add(label2);
		
		textOperator = new JTextField();
		textOperator.setFont(new Font("宋体", Font.PLAIN, 14));
		textOperator.setBounds(155, 91, 150, 25);
		panel.add(textOperator);
		textOperator.setColumns(10);
		textOperator.setEditable(false);
		
		//客户获得
		List<ClientPO> clientList=null;
		try {
			clientController=new ClientUtilityImpl();
			try {
				clientList=clientController.queryClient(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				frame.dispose();
				return;
			}
		} catch (RemoteException e1) {
			JOptionPane.showMessageDialog(null, "服务器出问题啦");
			e1.printStackTrace();
			System.exit(0);
		} catch (NotBoundException e1) {
			JOptionPane.showMessageDialog(null, "服务器出问题啦");
			e1.printStackTrace();
			System.exit(0);
		}

		JLabel label3 = new JLabel("客户");
		label3.setFont(new Font("宋体", Font.PLAIN, 18));
		label3.setBounds(90, 140, 54, 20);
		panel.add(label3);
		
		String[] temp=new String[clientList.size()];
		for(int i=0;i<temp.length;i++){
			temp[i]=clientList.get(i).getName();
		}
		
		comboBox = new JComboBox(temp);
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
		
		labelTotal = new JLabel("");
		labelTotal.setFont(new Font("宋体", Font.PLAIN, 18));
		labelTotal.setBounds(280, 446, 200, 20);
		panel.add(labelTotal);
		
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
		controller=new FinReceiptController();
		bankPane=new SubPanel();
		bankPane.transfer();
		btnAdd.addActionListener(new AddBank());
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PayVO pay=new PayVO((String)comboBox.getSelectedItem(),
						textOperator.getText(),total);
				try {
					controller.creditPay(pay);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
		});
		btnDel.addActionListener(new DeleteBank());
		frame.setTitle("付款单");
		frame.setVisible(true);
	}
	public void creatRec(){
		controller=new FinReceiptController();
		bankPane=new SubPanel();
		bankPane.transfer();
		btnAdd.addActionListener(new AddBank());
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RecVO receive=new RecVO((String)comboBox.getSelectedItem(),
						textOperator.getText(),total);
				try {
					controller.creditRec(receive);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
		});
		btnDel.addActionListener(new DeleteBank());
		frame.setTitle("收款单");
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
			bankPane.visit();
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
			String[] temp=null;
//			BankController bankController=new BankController();
//			try {
//				BankVO[] vo=bankController.search(null);
//				temp=new String[vo.length];
//				for(int i=0;i<temp.length;i++){
//					temp[i]=vo[i].name;
//				}
//			} catch (Exception e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage());
//				return ;
//			}
			temp=new String[]{"银行账户1","银行账户2","银行账户3"};
			//FIXME,获得银行列表
			comboBox=new JComboBox(temp);
			comboBox.setBounds(90,13,100,25);
			panel.add(comboBox);
			
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					bankTrans=new BkTransPO((String)comboBox.getSelectedItem()
					,Double.valueOf(balance.getText()),remark.getText());
					tableModel.addRow(bankTrans);
					total=controller.addBank(bankTrans);
					labelTotal.setText(String.valueOf(total));
					balance.setText(null);
//					remark.setText(null);
					frame.setVisible(false);
				}
			});
		}
		public void visit(){
			frame.setVisible(true);
		}
	}
}
