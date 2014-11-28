package presentation.Strategyui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.Strategybl.StrategyController;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;

public class StrategyListUI {

	private JFrame frame;
	Strategy_List_BLservice slb = new StrategyController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StrategyListUI window = new StrategyListUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StrategyListUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0,800, 600);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("总经理");
		label.setBounds(70, 21, 55, 15);
		panel.add(label);
		
		JButton buttonNew = new JButton("新策略");
		buttonNew.setBounds(638, 108, 93, 23);
		panel.add(buttonNew);
		
		JButton buttonScreen = new JButton("筛选");
		buttonScreen.setBounds(638, 170, 93, 23);
		panel.add(buttonScreen);
		
		JButton buttonReturn = new JButton("返回");
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonReturn.setBounds(638, 299, 93, 23);
		panel.add(buttonReturn);
		
		JLabel lblListHint = new JLabel("我是卖萌的状态栏");
		lblListHint.setBounds(22, 532, 310, 23);
		panel.add(lblListHint);
		
		JPanel subpanel = new JPanel();
		subpanel.setBounds(34, 55, 596, 449);
		panel.add(subpanel);
		subpanel.setLayout(null);
		
		
		String[] name = {"满足条件","优惠方式","起止时间"};
		
		final String[][] cellData = new String[4][3];
		TableModel tm = new DefaultTableModel(cellData,name); 	
		final JTable table = new JTable(tm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 558, 415);

		subpanel.add(scrollPane);
		table.setBounds(10, 20, 558, 415);
		scrollPane.setViewportView(table);
		

		
		
		buttonNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StrategyNewUI snu = new StrategyNewUI();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		

		
		
	}
}
