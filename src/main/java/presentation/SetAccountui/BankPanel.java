package presentation.SetAccountui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.BankManagebl.BankController;
import businesslogic.SetAccountbl.AccountController;
import po.BkTransPO;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;

public class BankPanel {
	private JPanel panel;
	private JTable table;
	private PublicTableModel tableModel;
	public ArrayList<BankVO> bankList;
	private AccountController controller;
	private JButton btnDel;
	private JButton btnAdd;
	public BankPanel(AccountController controller){
		this.controller=controller;
		initialize();
	}
	public BankPanel(){
		initialize();
	}
	public JPanel getPanel(){
		return panel;
	}
	public void initialize(){
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		
		JLabel label = new JLabel("银行账户");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(338, 24, 100, 15);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 48, 639, 303);
		panel.add(scrollPane);
		
		tableModel = new PublicTableModel(ModelType.BANK);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("添加");
		btnAdd.setBounds(464, 387, 80, 30);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddBankPanel add=new AddBankPanel();
			}
			
		});
		
		btnDel = new JButton("删除");
		btnDel.setBounds(581, 387, 80, 30);
		panel.add(btnDel);
		btnDel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//TODO
			}
			
		});
	}
	public void checkBank(){
		try {
			tableModel.update(controller.checkBank());
			panel.remove(btnAdd);
			panel.remove(btnDel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	public class AddBankPanel{
		JFrame frame;
		JTextField name;
		JTextField balance;
		JTextField remark;
		JPanel panel;
		JButton button;
		JButton button_1;
		private Font font=new Font("宋体",Font.PLAIN,18);

		public AddBankPanel(){
			initialize();
			frame.setVisible(true);
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
			button.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e) {
					BankVO temp=new BankVO();
					temp.name=name.getText();
					temp.balance=Double.valueOf(name.getText());
					temp.remark=remark.getText();
					
					bankList.add(temp);
					tableModel.addRow(temp);
					frame.dispose();
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
	}
}
