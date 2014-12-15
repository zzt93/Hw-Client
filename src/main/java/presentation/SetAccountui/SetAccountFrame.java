package presentation.SetAccountui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import presentation.RepoUI.GoodsTypePanel;

public class SetAccountFrame {
	private JFrame frame;
	private JTable table;


	public SetAccountFrame() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		GoodsTypePanel temp=new GoodsTypePanel();
		temp.setBounds(0, 0, 800, 500);
		frame.add(temp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 784, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("下一步");
		button.setBounds(554, 20, 80, 30);
		panel_1.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(667, 20, 80, 30);
		panel_1.add(button_1);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		SetAccountFrame temp=new SetAccountFrame();
		
	}
}
