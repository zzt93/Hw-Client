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

public class StrategyUI {

	private JFrame frame;
	private JFrame newFrame;
	private JTextField textFieldCondition;
	private JTextField textFieldTreatment;
	private JTextField startTimeText;
	private JTextField endTimeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StrategyUI window = new StrategyUI();
					window.frame.setVisible(true);
					window.newFrame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StrategyUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Image background = new ImageIcon("src/main/java/presentation/StrategyUI/background.jpg").getImage();


		
		newFrame = new JFrame();
		newFrame.setBounds(100, 100, 609, 430);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 29, 583, 352);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelStrategy = new JPanel();
		tabbedPane.addTab("Strategy", null, panelStrategy, null);
		panelStrategy.setLayout(null);
		
		JLabel lblCondition = new JLabel("满足条件");
		lblCondition.setBounds(56, 60, 54, 15);
		newFrame.getContentPane().add(lblCondition);
		
		final JComboBox<JTextField> comboBoxContidion = new JComboBox<JTextField>();
		comboBoxContidion.setBounds(184, 57, 109, 21);
		
		JTextField txtCustomerLevel = new JTextField("用户等级");
		comboBoxContidion.addItem(txtCustomerLevel);
		
		newFrame.getContentPane().add(comboBoxContidion);
		
		JLabel lblTreatment = new JLabel("优惠方式");
		lblTreatment.setBounds(56, 128, 54, 15);
		newFrame.getContentPane().add(lblTreatment);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(184, 125, 109, 21);
//		newFrame.getContentPane().add(comboBox_1);
		
		JButton button = new JButton("新策略");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newFrame.setVisible(true);
			}
		});
		button.setBounds(462, 35, 93, 23);
		panelStrategy.add(button);
		
		JList list = new JList();
		list.setBounds(25, 10, 390, 268);
		panelStrategy.add(list);
		
		JLabel lblListHint = new JLabel("我是卖萌的状态栏");
		lblListHint.setBounds(10, 298, 323, 15);
		panelStrategy.add(lblListHint);
		
		JButton button_1 = new JButton("筛选");
		button_1.setBounds(462, 95, 93, 23);
		panelStrategy.add(button_1);
		
		JButton button_2 = new JButton("提交审批");
		button_2.setBounds(462, 155, 93, 23);
		panelStrategy.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(462, 215, 93, 23);
		panelStrategy.add(button_3);
		
		JLabel label = new JLabel("总经理");
		label.setBounds(100, 10, 54, 15);
		frame.getContentPane().add(label);
		

		
		JLabel lblTimePeriod = new JLabel("起止时间 ");
		lblTimePeriod.setBounds(56, 194, 54, 15);
		newFrame.getContentPane().add(lblTimePeriod);
		
		textFieldCondition = new JTextField();
		textFieldCondition.setBounds(357, 57, 128, 21);
		newFrame.getContentPane().add(textFieldCondition);
		textFieldCondition.setColumns(10);
		
		JComboBox comboBoxTreatment = new JComboBox();
		comboBoxTreatment.setBounds(184, 125, 109, 21);
		newFrame.getContentPane().add(comboBoxTreatment);
		

		
		textFieldTreatment = new JTextField();
		textFieldTreatment.setBounds(357, 125, 128, 21);
		newFrame.getContentPane().add(textFieldTreatment);
		textFieldTreatment.setColumns(10);
		
		JLabel lblHint = new JLabel("新促销策略");
		lblHint.setBounds(10, 366, 386, 15);
		newFrame.getContentPane().add(lblHint);
		
		startTimeText = new JTextField();
		startTimeText.setBounds(184, 191, 109, 21);
		newFrame.getContentPane().add(startTimeText);
		startTimeText.setColumns(10);
		
		JLabel label_1 = new JLabel("到");
		label_1.setBounds(316, 194, 21, 15);
		newFrame.getContentPane().add(label_1);
		
		endTimeText = new JTextField();
		endTimeText.setBounds(357, 191, 128, 21);
		newFrame.getContentPane().add(endTimeText);
		endTimeText.setColumns(10);
		
		JButton button_4 = new JButton("确定");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxContidion.getSelectedItem();
				
			}
		});
		button_4.setBounds(126, 297, 93, 23);
		newFrame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("取消");
		button_5.setBounds(323, 297, 93, 23);
		newFrame.getContentPane().add(button_5);
		
		
	}
}
