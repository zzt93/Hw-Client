package presentation.BankManageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.BkTransPO;
import presentation.mainui.PublicTableModel;
import vo.BankVO;

public class BankPanel {
	BankVO bank;
	BkTransPO bankTrans;
	JFrame frame;
	JTextField name;
	JTextField balance;
	JTextField remark;
	JPanel panel;
	JButton button;
	JButton button_1;
	public BankPanel(BankVO vo){
		bank=vo;
		initialize();
	}
	public BankPanel(){
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
		
		name = new JTextField();
		name.setBounds(90, 13, 120, 26);
		panel.add(name);
		name.setColumns(10);
		
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
	public void add(){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankVO bank=new BankVO(name.getText(),
						Double.valueOf(balance.getText()),remark.getText());
				JOptionPane.showMessageDialog(null,"添加成功");
//				try {
//					controller.add(bank);
//					JOptionPane.showMessageDialog(null,"添加成功");
//					frame.dispose();
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null,e1.getMessage());
//				}
				frame.dispose();
				
			}
		});
		
		frame.setVisible(true);
	}
	public void modify(){
		remark.setText(bank.remark);
		name.setText(bank.name);
		name.setEditable(false);
		balance.setText(String.valueOf(bank.balance));
		balance.setEditable(false);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"修改成功");
//				try {
//					controller.modify(bank);
//					JOptionPane.showMessageDialog(null,"修改成功");
//					frame.dispose();
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null,e1.getMessage());
//				}
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}

	public static void main(String[] args){
		BankPanel pane=new BankPanel();
	}
}
