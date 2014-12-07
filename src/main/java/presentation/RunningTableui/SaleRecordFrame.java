package presentation.RunningTableui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.RunningTablebl.RunTableController;
import presentation.Saleui.GoodsPaneType;
import presentation.Saleui.GoodsPanel.MouseClick;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

public class SaleRecordFrame {
	private JFrame frame;
	private JTextField textRepository;
	private JTable table;
	private JTextField textStartTime;
	private JTextField textEndTime;
	private JTextField textGoods;
	private JComboBox boxOperator;
	private JComboBox boxClient;
	private RunTableController controller;
	private PublicTableModel tableModel;
	
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("商品:");
		label.setBounds(60, 60, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("起始时间:");
		label_1.setBounds(60, 100, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("终止时间:");
		label_2.setBounds(60, 140, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("操作员:");
		label_3.setBounds(60, 180, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("仓库:");
		label_4.setBounds(60, 220, 54, 15);
		panel.add(label_4);
		
		textRepository = new JTextField();
		textRepository.setBounds(115, 217, 100, 21);
		panel.add(textRepository);
		textRepository.setColumns(10);
		
		boxOperator = new JComboBox();
		boxOperator.setBounds(115, 177, 100, 21);
		panel.add(boxOperator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 79, 479, 284);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.SALERECORD);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnClear = new JButton("清空");
		btnClear.setBounds(612, 379, 60, 23);
		panel.add(btnClear);
		
		textStartTime = new JTextField();
		textStartTime.setBounds(115, 97, 100, 21);
		panel.add(textStartTime);
		textStartTime.setColumns(10);
		
		textEndTime = new JTextField();
		textEndTime.setBounds(115, 137, 100, 21);
		panel.add(textEndTime);
		textEndTime.setColumns(10);
		
		JButton btnQuery = new JButton("查询");
		btnQuery.setBounds(60, 301, 60, 23);
		panel.add(btnQuery);
		
		JLabel label_5 = new JLabel("客户:");
		label_5.setBounds(60, 261, 54, 15);
		panel.add(label_5);
		
		boxClient = new JComboBox();
		boxClient.setBounds(115, 258, 100, 21);
		panel.add(boxClient);
		
		JLabel label_6 = new JLabel("销售记录");
		label_6.setBounds(431, 57, 54, 15);
		panel.add(label_6);
		
		textGoods = new JTextField();
		textGoods.setBounds(96, 57, 100, 21);
		panel.add(textGoods);
		textGoods.setColumns(10);
		
		JButton btnGoodsList = new JButton("...");
		btnGoodsList.setBounds(206, 56, 40, 23);
		panel.add(btnGoodsList);
		btnGoodsList.addActionListener(new GoodsList());
	}
	public class GoodsList implements ActionListener{
		JFrame listFrame;
		JList<String> goodsList;
		public void actionPerformed(ActionEvent e) {
			showGoodsList();
		}
		public void showGoodsList(){
			listFrame=new JFrame();
			listFrame.setBounds(0,0,200,400);
			listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listFrame.setLocationRelativeTo(null);
			String[] temp;
			temp=controller.getGoodsList();
			goodsList=new JList<String>(temp);
			goodsList.addMouseListener(new MouseClick());
			JScrollPane scroll=new JScrollPane();
			scroll.setViewportView(goodsList);
			listFrame.add(scroll);
			listFrame.setVisible(true);
		}
		public class MouseClick extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()>=2){
					textGoods.setText(goodsList.getSelectedValue());
				}
			}
		}
	}
	
}
