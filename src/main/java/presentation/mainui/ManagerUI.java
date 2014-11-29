package presentation.mainui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import presentation.Approveui.ApproveUI;
import presentation.Strategyui.StrategyListUI;


import javax.swing.JTabbedPane;

public class ManagerUI {

	private JFrame frame;
	private StrategyListUI strategyList;
	private ApproveUI approveList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI window = new ManagerUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ManagerUI() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("总经理");
		label.setBounds(34, 20, 54, 15);
		frame.getContentPane().add(label);
		
		JButton buttonLogOut = new JButton("登出");
		buttonLogOut.setBounds(511, 16, 93, 23);
		frame.getContentPane().add(buttonLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 741, 492);
		frame.getContentPane().add(tabbedPane);
		
		strategyList = new StrategyListUI();
		approveList = new ApproveUI();
		
		tabbedPane.addTab("制定促销策略",strategyList.panel);
		tabbedPane.addTab("审批单据",approveList.totalPanel);
		
		

	}
}
