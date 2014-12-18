package presentation.Strategyui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import po.StrategyPO;
import businesslogic.Strategybl.StrategyController;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StrategyListUI {

	private JFrame frame;
	public JPanel panel;
	Strategy_List_BLservice strategyList;
	String[][] cellData;
	ArrayList<StrategyPO> arrStrategy;
	JTable table;
	TableModel tm;

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
					JOptionPane.showMessageDialog(null, "服务器出错啦");
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
		
		try {
			strategyList = new StrategyController();
			arrStrategy = strategyList.show();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "未能获取到单据");
			e1.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setBounds(20, 40,750, 500);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		panel.setName("制定促销策略");
		
		JButton buttonNew = new JButton("新策略");
		buttonNew.setBounds(607, 106, 93, 23);
		panel.add(buttonNew);
		
		JButton buttonScreen = new JButton("筛选");
		buttonScreen.setBounds(607, 171, 93, 23);
		panel.add(buttonScreen);
		
		JButton buttonReturn = new JButton("返回");
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonReturn.setBounds(607, 300, 93, 23);
		panel.add(buttonReturn);
		
		JLabel lblListHint = new JLabel("我是卖萌的状态栏");
		lblListHint.setBounds(34, 467, 310, 23);
		panel.add(lblListHint);
		
		JPanel subpanel = new JPanel();
		subpanel.setBounds(34, 10, 553, 438);
		panel.add(subpanel);
		subpanel.setLayout(null);
		
		
		final String[] name = {"满足条件","优惠方式","起止时间"};
		
		cellData = new String[arrStrategy.size()][3];
		refreshTable(name);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 532, 408);

		subpanel.add(scrollPane);
		table.setBounds(10, 20, 558, 415);
		
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("刷新");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					arrStrategy = strategyList.show();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "未能获取到单据");
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(607, 237, 93, 23);
		panel.add(button);		
		
		buttonNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StrategyNewUI.main(null);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "服务器出错了ToT");
							e.printStackTrace();
						}
					}
				});
			}
		});
		
	}
	
	void refreshTable(String name[]) {
		cellData = new String[arrStrategy.size()][3];
		int i = 0;
		for (StrategyPO po : arrStrategy) {
			insert(cellData[i], po);
			i++;
		}
		tm = new MyTableModel(cellData,name); 	
		table = new JTable(tm);
	}
	void insert(String[] item,StrategyPO po){
		item[0]=po.getCondition().toString();
		item[1]=po.getTreatment().toString();
		item[2]=po.getTimePeriod().toString();
	}
	public static class MyTableModel extends DefaultTableModel{

		private static final long serialVersionUID = 1L;
		
		public MyTableModel(Object[][] data, Object[] columnNames) {
		        super(data, columnNames);
		    }

		public boolean isCellEditable(int row, int column){
			return false;
		}
	}
}
