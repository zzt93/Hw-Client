package presentation.SetAccountui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	public SetAccountFrame(AccountController controller) {
		initialize();
		frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel=new GoodsTypePanel();
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
		frame.setVisible(true);
	}
	public class Next implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			switch(state){
			case GOODSTYPE:{
				GoodsPanel goods=new GoodsPanel(controller);
				panel=goods.getPanel();
				state=State.GOODSINFO;
				break;
			}
			case GOODSINFO:{
				
				ClientPanel client=new ClientPanel(controller);
				panel=client.getPanel();
				break;
			}
			case CLIENTINFO:{
				break;
			}
			case BANKINFO:{
				break;
			}
			}
		}
		
	}
}
