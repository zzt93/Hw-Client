package presentation.SetAccountui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.SetAccountbl.AccountController;
import presentation.RepoUI.GoodsTypePanel;

enum State{
	GOODSTYPE,GOODSINFO,CLIENTINFO,BANKINFO;
}
public class SetAccountFrame {
	private JFrame frame;
	private AccountController controller;
	private State state=State.GOODSTYPE;
	private JPanel panel;
	private GoodsPanel goods;
	private ClientPanel client;
	private BankPanel bank;
	private String newAccount;
	public SetAccountFrame(AccountController controller,String name) {
		this.controller=controller;
		this.newAccount=name;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		GoodsTypePanel temp=new GoodsTypePanel();
		temp.set_GT_navigator_not_visible();
		panel=temp;
		panel.setBounds(0, 0, 800, 500);
		frame.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 784, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("下一步");
		button.setBounds(554, 20, 80, 30);
		panel_1.add(button);
		button.addActionListener(new Next());
		JButton button_1 = new JButton("取消");
		button_1.setBounds(667, 20, 80, 30);
		panel_1.add(button_1);
		
	}
	public class Next implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			switch(state){
			case GOODSTYPE:{
				frame.remove(panel);
				goods=new GoodsPanel(controller);
				panel=goods.getPanel();
				frame.add(panel);
				frame.repaint();
				state=State.GOODSINFO;
				break;
			}
			case GOODSINFO:{
				try {
					controller.creatGoods(goods.goodsList);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());	
					e1.printStackTrace();
				}
				frame.remove(panel);
				client=new ClientPanel(controller);
				panel=client.getPanel();
				frame.add(panel);
				frame.repaint();
				state=State.CLIENTINFO;
				break;
			}
			case CLIENTINFO:{
				try {
					controller.creatClient(client.clientList);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getCause());
					e1.printStackTrace();
				}
				frame.remove(panel);
				bank=new BankPanel();
				panel=bank.getPanel();
				frame.add(panel);
				frame.repaint();
				state=State.BANKINFO;
				break;
			}
			case BANKINFO:{
				try {
					controller.creatCopy();
//					controller.setDefaultAccount(newAccount);
					JOptionPane.showMessageDialog(null, "建立账目成功");
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				break;
			}
			}
		}
		
	}
	public static void main(String[] args){
		SetAccountFrame a=new SetAccountFrame(null,null);
	}
}
