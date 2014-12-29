package presentation.RunningTableui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import businesslogic.RunningTablebl.RunTableController;
import presentation.Saleui.GoodsPaneType;
import presentation.Saleui.GoodsPanel.MouseClick;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.GoodsRecordVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

public class SaleRecordFrame {
//	private JFrame frame;
	private JTextField textRepository;
	private JTable table;
	private JTextField textStartTime;
	private JTextField textEndTime;
	private JTextField textGoods;
	private JTextField boxOperator;
	private JComboBox boxClient;
	private JPanel panel; 
	
	private RunTableController controller;
	private PublicTableModel tableModel;
	private JProgressBar progressBar;
	
	public SaleRecordFrame(){
		try {
			controller=new RunTableController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		initialize();
//		frame.setVisible(true);
	}
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
//		frame.getContentPane().add(panel);
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
		
		JLabel label_3 = new JLabel("业务员:");
		label_3.setBounds(60, 180, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("仓库:");
		label_4.setBounds(60, 220, 54, 15);
		panel.add(label_4);
		
		textRepository = new JTextField();
		textRepository.setBounds(115, 217, 100, 21);
		panel.add(textRepository);
		textRepository.setColumns(10);

		
		
//		boxOperator = new JComboBox(new String[]{null,"操作员1","操作员2"});
		boxOperator = new JTextField();
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
		btnClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tableModel.clear();
			}
		});
		
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
		btnQuery.addActionListener(new Query());
		
		JLabel label_5 = new JLabel("客户:");
		label_5.setBounds(60, 261, 54, 15);
		panel.add(label_5);
		
		//TODO,获得客户列表
		try {
			boxClient=new JComboBox(controller.getClient());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
//		boxClient = new JComboBox(new String[]{null,"客户1","客户2"});
		
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
		
		progressBar = new JProgressBar();
		progressBar.setBounds(404, 410, 283, 23);
		panel.add(progressBar);
		
		JButton btnExcel = new JButton("导出EXCEL");
		btnExcel.setBounds(280, 410, 93, 23);
		panel.add(btnExcel);
		btnExcel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Exporter temp=new Exporter(table,progressBar);
			}
		});
		
		
		textGoods.setEditable(false);
	}
	public JPanel getPanel(){
		return panel;
	}
	public class Query implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SaleConditionVO condition=new SaleConditionVO(
					textStartTime.getText(),
					textEndTime.getText(),
					textGoods.getText(),
					(String)boxClient.getSelectedItem(),
					textRepository.getText(),
					(String)boxOperator.getText());
//			condition.client=(String)boxClient.getSelectedItem();
//			condition.endTime=textEndTime.getText();
//			condition.startTime=textStartTime.getText();
//			condition.goods=textGoods.getText();
//			condition.buisnessman=(String)boxOperator.getSelectedItem();
//			condition.storage=textRepository.getText();
			try{
				GoodsRecordVO[] list=controller.getSaleTable(condition);
				tableModel.update(list);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
			
			
			
		}
		
	}
	public class GoodsList implements ActionListener{
		JFrame listFrame;
		JList<String> goodsList;
		public void actionPerformed(ActionEvent e) {
			showGoodsList();
		}
		public void showGoodsList(){
			if(listFrame==null){
				listFrame=new JFrame();
				listFrame.setBounds(0,0,200,400);
				listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				listFrame.setLocationRelativeTo(null);
				String[] temp=null;
//				temp=new String[]{"商品1","商品2","商品3","商品4"};
				//FIXME，获得商品列表
				try {
					temp=controller.getGoodsList();
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				goodsList=new JList<String>(temp);
				goodsList.addMouseListener(new MouseClick());
				JScrollPane scroll=new JScrollPane();
				scroll.setViewportView(goodsList);
				listFrame.add(scroll);
			}
			listFrame.setVisible(true);
		}
		public class MouseClick extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()>=2){
					String[] temp=goodsList.getSelectedValue().split("\\(");
					String[] goodsName=temp[1].split("\\)");
					textGoods.setText(goodsName[0]);
					listFrame.setVisible(false);
				}
			}
		}
	}
	public static void main(String[] args){
		SaleRecordFrame a=new SaleRecordFrame();
	}
}
