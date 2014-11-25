package presentation.Strategyui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StrategyListUI {

	private JFrame frame;



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
		
		Image background = new ImageIcon("src/main/java/presentation/StrategyUI/background.jpg").getImage();
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("总经理");
		label.setBounds(70, 21, 54, 15);
		frame.getContentPane().add(label);
		

		

		
		JButton button = new JButton("新策略");
		button.setBounds(638, 108, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("筛选");
		button_1.setBounds(638, 170, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("提交审批");
		button_2.setBounds(638, 233, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(638, 299, 93, 23);
		frame.getContentPane().add(button_3);
		
		JLabel lblListHint = new JLabel("我是卖萌的状态栏");
		lblListHint.setBounds(20, 504, 310, 23);
		frame.getContentPane().add(lblListHint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 65, 558, 415);
		frame.getContentPane().add(scrollPane);
		scrollPane.setLayout(null);
		String[] name = {"满足条件","优惠方式","起止时间"};

		TableModel tm = new DefaultTableModel(name,1); 	
		JTable table = new JTable(tm);
		
		table.setBounds(0,0,558,415);
		scrollPane.add(table);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
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
