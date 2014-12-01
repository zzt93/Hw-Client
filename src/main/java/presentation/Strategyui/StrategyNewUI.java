package presentation.Strategyui;

import po.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StrategyNewUI {

	private JFrame frame;
	private JFrame newFrame;
	private JTextField textFieldCondition;
	private JTextField textFieldTreatment;
	private JTextField startTimeText;
	private JTextField endTimeText;
	private ArrayList<GoodsModelPO> goodsPO;
	private ArrayList<GoodsModelPO> tempGoodsPO;
	private ArrayList<GoodsModelPO> goodsPOGive;

	// Strategy_New_BLservice snb = new StrategyController();

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
		comboBoxCondition.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});

		comboBoxCondition.setBounds(184, 57, 109, 21);
		String txtCustomerLevel = new String("用户等级");
		comboBoxCondition.addItem(txtCustomerLevel);
		String txtTotalPrice = new String("总价折扣");
		comboBoxCondition.addItem(txtTotalPrice);
		final String txtComposition = new String("组合商品特价");
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

		JLabel labelTo = new JLabel("到");
		labelTo.setBounds(316, 194, 21, 15);
		newFrame.getContentPane().add(labelTo);

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

		JButton buttonConfirm = new JButton("确定");
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TimePeriod tp = new TimePeriod(startTimeDate.getDate(),
						endTimeDate.getDate());
				Condition c = null;
				Treatment t = null;
				switch (comboBoxCondition.getSelectedIndex()) {
				case 0:
					c = new Condition(CatOfCondition.CUSTOMERLEVEL, Integer
							.parseInt(textFieldCondition.getText()));
					break;
				case 1:
					c = new Condition(CatOfCondition.TOTALPRICE, Double
							.parseDouble(textFieldCondition.getText()));
				case 2:
					c = new Condition(CatOfCondition.COMPOSITION, goodsPO);
				}

				switch (comboBoxTreatment.getSelectedIndex()) {
				case 0:
					t = new Treatment(CatOfTreatment.GIVE, goodsPOGive);
				case 1:
					t = new Treatment(CatOfTreatment.DISCOUNT, Double
							.parseDouble(textFieldTreatment.getText()));
				case 2:
					t = new Treatment(CatOfTreatment.COUPON, Double
							.parseDouble(textFieldTreatment.getText()));
				}
				/*
				 * snb.newStrategy(c, t, tp); if(!snb.examine()){
				 * lblHint.setText("输入折扣价格或时间有误，请检查"); }else{
				 * 
				 * }
				 */
			}
		});
		buttonConfirm.setBounds(126, 297, 93, 23);
		newFrame.getContentPane().add(buttonConfirm);

		JButton buttonCancel = new JButton("取消");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFrame.dispose();
			}
		});
		buttonCancel.setBounds(323, 297, 93, 23);
		newFrame.getContentPane().add(buttonCancel);

		comboBoxCondition.addItemListener(new MyItemListener(comboBoxCondition,
				txtComposition, lblHint, textFieldCondition,goodsPO));
		comboBoxTreatment.addItemListener(new MyItemListener(comboBoxTreatment,
				txtGive,lblHint,textFieldTreatment,goodsPOGive));
	}

	class MyTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTableModel(Object[][] data, Object[] columnNames) {
			setDataVector(data, columnNames);
		}

		public boolean isCellEditlable(int row, int column) {
			return false;
		}
	}

	void insert(String[] item, GoodsModelPO po) {
		item[0] = po.getId();
		item[1] = po.getName();
		// item[2] = po.getModel();

	}

	/**
	 * This means to deal with cases to choose Goods.
	 * @author Mebleyev.G.Longinus
	 *
	 */
	class MyItemListener implements ItemListener {

		JComboBox<String> comboBox;
		String txt;
		JLabel lblHint;
		JTextField textField;
		ArrayList<GoodsModelPO> myGoodsPO;

		public MyItemListener(JComboBox<String> comboBox, String txt,
				JLabel lblHint, JTextField textField,ArrayList<GoodsModelPO> myGoodsPO) {
			super();
			this.comboBox = comboBox;
			this.txt = txt;
			this.lblHint = lblHint;
			this.textField = textField;
			this.myGoodsPO = myGoodsPO;
		}

		public void itemStateChanged(ItemEvent arg0) {
			if (comboBox.getSelectedItem().equals(txt)) {
				final JFrame listFrame;
				listFrame = new JFrame();
				listFrame.setBounds(0, 0, 200, 400);
				listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				GL_manager_BLservice gmb;

				try {
					gmb = new GL_manager_repo_Impl();

					tempGoodsPO = new ArrayList<GoodsModelPO>(gmb
							.getGoodsList().getGoodsModels().values());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String str[] = new String[] { "id", "name", "model" };
				String data[][] = new String[tempGoodsPO.size()][3];

				int i = 0;
				for (GoodsModelPO gpo : tempGoodsPO) {
					insert(data[i], gpo);
					i++;
				}
				TableModel tm = new MyTableModel(data, str);
				final JTable listTable = new JTable(tm);
				JScrollPane scrollpane = new JScrollPane();
				scrollpane.setBounds(0, 0, 190, 380);
				scrollpane.setViewportView(listTable);
				listFrame.getContentPane().add(scrollpane);
				listFrame.setVisible(true);

				JButton subConfirm = new JButton("确定");
				subConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int a[] = listTable.getSelectedRows();
						for (int i : a) {
							myGoodsPO.add(tempGoodsPO.get(a[i]));
							lblHint.setText("已经保存了商品啦");
							String names = "";
							for (GoodsModelPO model : myGoodsPO) {
								names += model.getName() + ",";
							}
							textField.setText(names);
						}

						listFrame.dispose();
					}
				});

			}
		}

	}

}
