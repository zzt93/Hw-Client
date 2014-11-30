package presentation.Stockui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import po.ReceiptPO;
import po.ReceiptType;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import presentation.Saleui.GoodsTableModel;

public class SaleAndStockReceipt {
	JFrame frame;
	JPanel panel;
	JTable table;
	StockReceiptPO stock;
	SaleReceiptPO sale;
	
	public void SaleAndStockReceipt(ReceiptPO PO){
		if(PO.type==ReceiptType.SALE_ACCEPT||PO.type==ReceiptType.SALE_REJECTION){
			sale=(SaleReceiptPO)PO;

		}else if(PO.type==ReceiptType.STOCK_ACCEPT||PO.type==ReceiptType.STOCK_REJECTION){
			stock=(StockReceiptPO)PO;
		}else{
			System.out.println("传的单据不太对呀");
		}
		salePanel();
		iniFrame();
	}
	public  SaleAndStockReceipt(){
		salePanel();
		iniFrame();
	}
	public void salePanel(){
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("销售商：王尼玛");
		lblNewLabel.setBounds(90, 30, 100, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("仓库：南路仓库");
		lblNewLabel_1.setBounds(270, 30, 200, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("操作员：王尼玛");
		lblNewLabel_2.setBounds(475, 30, 100, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("类型：进货退货单");
		label.setBounds(90, 90, 150, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("日期：2014/05/07");
		label_1.setBounds(270, 90, 150, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("备注：阿萨抠脚大汉卷卡式带黄金卡圣诞节卡萨打算肯德基l");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(90, 145, 600, 15);
		panel.add(lblNewLabel_3);
		
		JLabel label_2 = new JLabel("总额：99999999");
		label_2.setBounds(560, 440, 100, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("折让：8.5");
		label_3.setBounds(90, 185, 108, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("代金券：99999");
		label_4.setBounds(270, 185, 108, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("折让后总额：99999");
		label_5.setBounds(470, 185, 140, 15);
		panel.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 210, 650, 220);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new GoodsTableModel());
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
	}
	public void stockPanel(){
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("供应商：王尼玛");
		lblNewLabel.setBounds(90, 30, 100, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("仓库：南路仓库");
		lblNewLabel_1.setBounds(270, 30, 200, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("操作员：王尼玛");
		lblNewLabel_2.setBounds(475, 30, 100, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("类型：进货退货单");
		label.setBounds(90, 90, 150, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("日期：2014/05/07");
		label_1.setBounds(270, 90, 150, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("备注：阿萨抠脚大汉卷卡式带黄金卡圣诞节卡萨打算肯德基l");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(90, 145, 600, 15);
		panel.add(lblNewLabel_3);
		
		JLabel label_2 = new JLabel("总额：99999999");
		label_2.setBounds(560, 440, 100, 15);
		panel.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 210, 650, 220);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new GoodsTableModel());
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	public void iniFrame(){
		frame=new JFrame();
		frame.setBounds(0,0,750,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		SaleAndStockReceipt a=new SaleAndStockReceipt();
	}
}
