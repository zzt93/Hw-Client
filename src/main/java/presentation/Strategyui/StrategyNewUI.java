package presentation.Strategyui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businesslogic.Strategybl.StrategyController;
import businesslogicservice.Strategyblservice.Strategy_New_BLservice;
import po.CatOfCondition;
import po.CatOfTreatment;
import po.Condition;
import po.TimePeriod;
import po.Treatment;

public class StrategyNewUI {

	private JFrame frame;
	private JFrame newFrame;
	private JTextField textFieldCondition;
	private JTextField textFieldTreatment;
	private JTextField startTimeText;
	private JTextField endTimeText;

	Strategy_New_BLservice snb = new StrategyController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StrategyNewUI window = new StrategyNewUI();
					window.frame.setVisible(false);
					window.newFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StrategyNewUI() {

		initialize();
		newFrame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		newFrame = new JFrame();
		newFrame.setBounds(100, 100, 609, 430);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.getContentPane().setLayout(null);

		JLabel lblCondition = new JLabel("满足条件");
		lblCondition.setBounds(56, 60, 54, 15);
		newFrame.getContentPane().add(lblCondition);
		final JComboBox<String> comboBoxCondition = new JComboBox<String>();
		comboBoxCondition.setBounds(184, 57, 109, 21);
		String txtCustomerLevel = new String("用户等级");
		comboBoxCondition.addItem(txtCustomerLevel);
		String txtTotalPrice = new String("总价折扣");
		comboBoxCondition.addItem(txtTotalPrice);
		String txtComposition = new String("组合商品特价");
		comboBoxCondition.addItem(txtComposition);

		newFrame.getContentPane().add(comboBoxCondition);

		JLabel lblTreatment = new JLabel("优惠方式");
		lblTreatment.setBounds(56, 128, 65, 15);
		newFrame.getContentPane().add(lblTreatment);

		final JComboBox<String> comboBoxTreatment = new JComboBox<String>();
		comboBoxTreatment.setBounds(184, 125, 109, 21);
		newFrame.getContentPane().add(comboBoxTreatment);
		String txtGive = new String("赠品");
		String txtDiscount = new String("折扣");
		String txtCoupon = new String("代金券");
		comboBoxTreatment.addItem(txtGive);
		comboBoxTreatment.addItem(txtDiscount);
		comboBoxTreatment.addItem(txtCoupon);

		JLabel lblTimePeriod = new JLabel("起止时间 ");
		lblTimePeriod.setBounds(56, 194, 54, 15);
		newFrame.getContentPane().add(lblTimePeriod);

		textFieldCondition = new JTextField();
		textFieldCondition.setBounds(357, 57, 128, 21);
		newFrame.getContentPane().add(textFieldCondition);
		textFieldCondition.setColumns(10);
		textFieldTreatment = new JTextField();
		textFieldTreatment.setBounds(357, 125, 128, 21);
		newFrame.getContentPane().add(textFieldTreatment);
		textFieldTreatment.setColumns(10);

		final JLabel lblHint = new JLabel("新促销策略");
		lblHint.setBounds(10, 366, 386, 15);
		newFrame.getContentPane().add(lblHint);

		startTimeText = new JTextField("单击选择日期");
		startTimeText.setBounds(184, 191, 109, 21);
		// newFrame.getContentPane().add(startTimeText);
		// startTimeText.setColumns(10);

		JLabel label_1 = new JLabel("到");
		label_1.setBounds(316, 194, 21, 15);
		newFrame.getContentPane().add(label_1);

		endTimeText = new JTextField("单击选择日期");
		endTimeText.setBounds(357, 191, 128, 21);
		// newFrame.getContentPane().add(endTimeText);
		// endTimeText.setColumns(10);

		final DateChooser startTimeDate = DateChooser.getInstance("yyyy-MM-dd");
		final DateChooser endTimeDate = DateChooser.getInstance("yyyy-MM-dd");
		startTimeDate.setBounds(184, 191, 109, 21);
		endTimeDate.setBounds(357, 191, 128, 21);

		startTimeDate.register(startTimeText);
		endTimeDate.register(endTimeText);

		newFrame.getContentPane().add(startTimeDate);
		newFrame.getContentPane().add(endTimeDate);

		JButton button_4 = new JButton("确定");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int condiEnum = comboBoxCondition.getSelectedIndex();
				int treatEnum = comboBoxTreatment.getSelectedIndex();
				TimePeriod tp = new TimePeriod(startTimeDate.getDate(),
						endTimeDate.getDate());
				Condition c = new Condition(CatOfCondition.values()[condiEnum],
						textFieldCondition.getText());
				Treatment t = new Treatment(CatOfTreatment.values()[treatEnum],
						textFieldTreatment.getText());
				/*snb.newStrategy(c, t, tp);
				if(!snb.examine()){
					lblHint.setText("输入折扣价格或时间有误，请检查");
				}else{
					
				}*/
			}
		});
		button_4.setBounds(126, 297, 93, 23);
		newFrame.getContentPane().add(button_4);

		JButton button_5 = new JButton("取消");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFrame.dispose();
			}
		});
		button_5.setBounds(323, 297, 93, 23);
		newFrame.getContentPane().add(button_5);

	}

}
