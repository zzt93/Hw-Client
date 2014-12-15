package presentation.SetAccountui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JList;
import javax.swing.JScrollPane;

import businesslogic.SetAccountbl.AccountController;
import presentation.RepoUI.GoodsTypePanel;

public class AccountFrame {
//	private JFrame frame;
	private JList list;
	private JPanel panel;
	private AccountController controller;
	public static String currentAccount;
	public static JLabel labelAccount;
	public AccountFrame() {
		try {
			controller=new AccountController();
			currentAccount=controller.getDefaultAccount();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "服务器出现了问题");
			e.printStackTrace();
		}
		initialize();
	}

	public JPanel getPanel(){
		return panel;
	}
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("更换当前账目");
		button.setBounds(64, 99, 120, 40);
		panel.add(button);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String temp=(String)list.getSelectedValue();
				if(temp==null){
					JOptionPane.showMessageDialog(null, "请在右侧选择账目");
				}else{
					try {
						controller.setDefaultAccount(temp);
						currentAccount=temp;
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		labelAccount = new JLabel("当前账目:");
		labelAccount.setFont(new Font("宋体", Font.PLAIN, 18));
		labelAccount.setBounds(57, 29, 100, 20);
		panel.add(labelAccount);
		
		JLabel label_1 = new JLabel(currentAccount);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(148, 32, 100, 15);
		panel.add(label_1);
		
		JButton button_1 = new JButton("查看期初账目");
		button_1.setBounds(64, 159, 120, 40);
		panel.add(button_1);
		
		JButton button_2 = new JButton("期初建账");
		button_2.setBounds(64, 222, 120, 40);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 61, 244, 306);
		panel.add(scrollPane);
		
		
		try {
			list = new JList(controller.getAllAccount());
			scrollPane.setViewportView(list);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		
		JLabel label_2 = new JLabel("账目列表");
		label_2.setBounds(462, 34, 54, 15);
		panel.add(label_2);
	}
	public class SetAccount implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String newAccount=JOptionPane.showInputDialog("请输入账目名称");
			//TODO,加上继承
			try {
				controller.setup(newAccount);
				controller.setDefaultAccount(newAccount);
				SetAccountFrame set=new SetAccountFrame(controller,newAccount);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		
	}
	public class ShowData implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFrame subFrame=new JFrame();
			subFrame.setSize(800, 600);
			subFrame.setLocationRelativeTo(null);
			subFrame.setLayout(null);
			
			JTabbedPane tab=new JTabbedPane();
			tab.setBounds(0, 30, 800, 600);
			GoodsPanel goods=new GoodsPanel(controller);
			goods.checkGoods();
			ClientPanel client=new ClientPanel(controller);
			client.checkClient();
			BankPanel bank=new BankPanel(controller);
			bank.checkBank();
			
			tab.add("商品信息", goods.getPanel());
			tab.add("客户信息", client.getPanel());
			tab.add("银行信息",	bank.getPanel());
			
			subFrame.add(tab);
			subFrame.setVisible(true);
		}
	}
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setBounds(0,0,800,700);
		GoodsTypePanel temp=new GoodsTypePanel();
		frame.add(temp);
		frame.setVisible(true);
	}
}
