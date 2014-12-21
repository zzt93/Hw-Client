package presentation.BankManageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.BankManagebl.BankController;
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
	BankController controller;
	private Font font=new Font("宋体",Font.PLAIN,18);
//	private Font font2=new Font("宋体",Font.PLAIN,14);
	public BankPanel(BankVO vo,BankController controller){
		this.controller=controller;
		bank=vo;
		initialize();
	}
	public BankPanel(BankController controller){
		this.controller=controller;
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
		button.setFont(font);
		button.setBounds(144, 169, 72, 33);
		panel.add(button);
		
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
	public void add(){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
//FXIEME,底层	
				if(name.getText().equals("")){
					JOptionPane.showMessageDialog(null, "账户名称不能为空");
					return;
				}
				if(balance.getText().equals("")){
					JOptionPane.showMessageDialog(null, "账户金额不能为空");
					return;
				}
				try{
					bank=new BankVO(name.getText(),
							Double.valueOf(balance.getText()),remark.getText());
				}catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(null, "账户金额应为数字");
					e2.printStackTrace();
					return;
				}
				try {
					controller.add(bank);
					JOptionPane.showMessageDialog(null,"添加成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}

				
			}
		});

	}
	public void modify(){
		remark.setText(bank.remark);
		name.setText(bank.name);
		name.setEditable(false);
		try{
			balance.setText(String.valueOf(bank.balance));
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "账户金额应为数字");
			e.printStackTrace();
		}
		balance.setEditable(false);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				JOptionPane.showMessageDialog(null,"修改成功");
//				frame.dispose();
				//FIXME,底层
				try {
					bank.remark = remark.getText();
					controller.modify(bank);
					JOptionPane.showMessageDialog(null,"修改成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

	}
	public void visit(){
		frame.setVisible(true);
	}

	public static void main(String[] args){
//		BankPanel pane=new BankPanel();
	}
}
