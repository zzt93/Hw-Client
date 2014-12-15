package presentation.SetAccountui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JScrollPane;

import presentation.RepoUI.GoodsTypePanel;

public class AccountFrame {
	private JFrame frame;


	public AccountFrame() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("选择当前账目");
		button.setBounds(64, 99, 120, 40);
		panel.add(button);
		
		JLabel label = new JLabel("当前账目:");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(57, 29, 100, 20);
		panel.add(label);
		
		JLabel label_1 = new JLabel("账目1");
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
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel label_2 = new JLabel("账目列表");
		label_2.setBounds(462, 34, 54, 15);
		panel.add(label_2);
	}
	public class 
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setBounds(0,0,800,700);
		GoodsTypePanel temp=new GoodsTypePanel();
		frame.add(temp);
		frame.setVisible(true);
	}
}
