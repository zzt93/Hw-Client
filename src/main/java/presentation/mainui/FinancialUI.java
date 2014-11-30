package presentation.mainui;

import presentation.BankManageui.BankManageFrame;
import presentation.FinancialReceiptui.FinancialReceiptFrame;

import javax.swing.*;
import java.awt.*;

public class FinancialUI {
	JFrame frame;
	JTabbedPane mainPanel;
	JPanel topPanel;
	BankManageFrame BMF=new BankManageFrame();
	FinancialReceiptFrame FRF=new FinancialReceiptFrame();
	public FinancialUI(){
		try {
			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		frame=new JFrame();
		frame.setBounds(0, 0,800, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(mainPanel);
		frame.setVisible(true);
		
		topPanel=new JPanel();
		topPanel.setBounds(0,0,800,100);
		topPanel.setLayout(null);
		frame.add(topPanel);
		
		JLabel label = new JLabel("账户：操作员1");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(590, 20, 150, 70);
		topPanel.add(label);
		
		mainPanel=new JTabbedPane(JTabbedPane.TOP);
		mainPanel.setFont(new Font("宋体", Font.PLAIN, 18));
		mainPanel.setBounds(0,105,800,500);
		frame.add(mainPanel);
		mainPanel.add("银行账户",BMF.getPanel());
		mainPanel.add("财务单据",FRF.getPanel());
	}
	public static void main(String[] args){
		FinancialUI main=new FinancialUI();
	}
}
