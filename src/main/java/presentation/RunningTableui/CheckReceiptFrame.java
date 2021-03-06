package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import po.CashPO;
import po.GoodsReceiptPO;
import po.RecPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import po.RepoReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.ReceiptConditionVO;
import businesslogic.RunningTablebl.RunTableController;

public class CheckReceiptFrame {
//	private JFrame frame;
	private JTextField textRepository;
	private JTable table;
	private JTextField textStartTime;
	private JTextField textEndTime;
	private JProgressBar progressBar;
	JComboBox boxOperator;
	JComboBox boxType;
	JComboBox boxClient;
	JButton btnCredit;
	private JPanel panel;
	private PublicTableModel tableModel;
	private RunTableController controller;
	private List<ReceiptPO> receiptList;
	
	public CheckReceiptFrame(){
		try {
			controller=new RunTableController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现问题");
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
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("单据类型:");
		label.setBounds(60, 60, 60, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("起始时间:");
		label_1.setBounds(60, 100, 60, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("终止时间:");
		label_2.setBounds(60, 140, 60, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("操作员:");
		label_3.setBounds(60, 180, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("仓库:");
		label_4.setBounds(60, 220, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("客户:");
		label_5.setBounds(60, 260, 54, 15);
		panel.add(label_5);
		
	
		//TODO,获得客户列表
		try {
			boxClient=new JComboBox(controller.getClient());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
//		boxClient = new JComboBox(new String[]{null,"客户1","客户2"});
		
		boxClient.setBounds(115, 260, 100, 21);
		panel.add(boxClient);
	
		textRepository = new JTextField();
		textRepository.setBounds(115, 217, 100, 21);
		panel.add(textRepository);
		textRepository.setColumns(10);
		
		//TODO,获得操作员列表
		try {
			boxOperator=new JComboBox(controller.getOperator());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
//		boxOperator = new JComboBox(new String[]{null,"操作员1","操作员2"});
		
		boxOperator.setBounds(115, 177, 100, 21);
		panel.add(boxOperator);
		//TODO
		String[] temp={"进货单","进货退货单","销售单","销售退货单","收款单"
				,"付款单","现金费用单","报溢报损单","库存赠送单"};
		boxType = new JComboBox(temp);
		boxType.setBounds(115, 57, 100, 21);
		boxType.addItemListener(new TypeChange());
		panel.add(boxType);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 79, 479, 284);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.RECEIPT);
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseClick());
		//FIXME,test code
//		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
//		list.add(new RecPO());
//		list.add(new RecPO());
//		tableModel.update(list);
		
		JLabel label_6 = new JLabel("单据列表");
		label_6.setBounds(431, 57, 60, 15);
		panel.add(label_6);
		
		JButton btnClear = new JButton("清空");
		btnClear.setBounds(612, 379, 60, 23);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
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
		btnQuery.setBounds(60, 300, 60, 23);
		panel.add(btnQuery);
		btnQuery.addActionListener(new Query());
		
		btnCredit = new JButton("红冲");
		btnCredit.setBounds(60, 350, 60, 23);
		panel.add(btnCredit);
		btnCredit.addActionListener(new Credit());
		
		JButton btnCreditCopy = new JButton("红冲复制");
		btnCreditCopy.setBounds(60, 400, 80, 23);
		btnCreditCopy.setEnabled(false);
		panel.add(btnCreditCopy);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(404, 410, 283, 23);
		progressBar.setStringPainted(true);
		panel.add(progressBar);
		
		JButton btnExcel = new JButton("导出EXCEL");
		btnExcel.setBounds(280, 410, 93, 23);
		panel.add(btnExcel);
		btnExcel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Exporter export=new Exporter(table,progressBar);
			}
		});
		
		
	}
	public JPanel getPanel(){
		return panel;
	}
	public class TypeChange implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			switch(boxType.getSelectedIndex()){
			case 4:{
				//收款单
			}
			case 5:{
				//付款单
				textRepository.setText("");
				textRepository.setEditable(false);
				boxClient.setEnabled(true);
				break;
			}
			case 6:{
				//现金费用单
			}
			case 7:{
				//报溢报损单
			}
			case 8:{
				//库存赠送单
				textRepository.setText("");
				textRepository.setEditable(false);
				boxClient.setSelectedIndex(0);
				boxClient.setEnabled(false);
				break;
			}
			default:{
				boxClient.setEnabled(true);
				textRepository.setEditable(true);
			}
			}
		}
		
	} 
	public class Query implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ReceiptType type;
			ReceiptType[] list=ReceiptType.values();
				type=list[boxType.getSelectedIndex()];
			ReceiptConditionVO condition=new ReceiptConditionVO(
					textStartTime.getText(),
					textEndTime.getText(),
					type,
					(String)boxClient.getSelectedItem(),
					(String)boxOperator.getSelectedItem(),
					textRepository.getText());
			//FIXME，进行查询操作，更新列表
			try {
				receiptList=controller.getReceipt(condition);
				if(receiptList.size()==0){
					JOptionPane.showMessageDialog(null, "无符合条件的数据");
				}
				tableModel.update(receiptList);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
			
//					//测试代码
//			{
//				RecPO rec=new RecPO();
//				RecPO rec1=new RecPO();
//				List<ReceiptPO> tempList=new ArrayList<ReceiptPO>();
//				tempList.add(rec);
//				tempList.add(rec1);
//				tableModel.update(tempList);
//			}
				
						
		}
		
	}
	public class Credit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(table.getSelectedRow()<0){
				JOptionPane.showMessageDialog(null, "请选中单据");
				return ;
			}else{
				ReceiptPO temp=receiptList.get(table.getSelectedRow());
				if(temp.statement==ReceiptState.wait){
					JOptionPane.showMessageDialog(null,"待审的单据不可红冲");
					return;
				}
				switch(temp.type){
				case CASH:{
					CashReceiptPane creditPane=new CashReceiptPane(controller,(CashPO)temp);
					break;
				}
				case RECEIVE:
				case PAYMENT:{
					PayReceiptPane creditPane=new PayReceiptPane(controller,(RecPO)temp);
					break;
				}
				case SALE_ACCEPT:
				case SALE_REJECTION:{
					SaleReceiptPane creditPane=new SaleReceiptPane(controller,(SaleReceiptPO)temp);
					break;
				}
				case STOCK_ACCEPT:
				case STOCK_REJECTION:{
					StockReceiptPane creditPane=new StockReceiptPane(controller,(StockReceiptPO)temp);
					break;
				}
				case GOODSRECEIPT:{
					GoodsReceiptPane creditPane=new GoodsReceiptPane(controller,(GoodsReceiptPO)temp);
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "该单据不可红冲");
				}
			}
			
		}
		
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getClickCount()==2){
				//TODO,响应鼠标点击，弹出单据内容
				ReceiptPO temp=receiptList.get(table.getSelectedRow());
				switch(temp.type){
				case CASH:{
					CashReceiptPane cash=new CashReceiptPane();
					cash.set((CashPO)temp);
					cash.visit(true);
					break;
				}
				case PAYMENT:
				case RECEIVE:{
					PayReceiptPane pay=new PayReceiptPane();
					pay.set((RecPO)temp);
					pay.visit(true);
					break;
				}
				case REPORECEIPT:{
					RepoReceiptPane repo=new RepoReceiptPane();
					repo.set((RepoReceiptPO)temp);
					repo.visit(true);
					break;
				}
				case SALE_ACCEPT:
				case SALE_REJECTION:{
					SaleReceiptPane sale=new SaleReceiptPane();
					sale.set((SaleReceiptPO)temp);
					sale.visit(true);
					break;
				}
				case STOCK_ACCEPT:
				case STOCK_REJECTION:{
					StockReceiptPane stock=new StockReceiptPane();
					stock.set((StockReceiptPO)temp);
					stock.visit(true);
					break;
				}
				case GOODSRECEIPT:{
					GoodsReceiptPane goods=new GoodsReceiptPane();
					goods.set((GoodsReceiptPO)temp);
					goods.visit(true);
					break;
				}
				}
			}
		}
	}
	public void uncredit(){
		btnCredit.setEnabled(false);
	}
	public static void main(String[] args){
		CheckReceiptFrame a=new CheckReceiptFrame();
//		PublicTableModel tableModel=new PublicTableModel(ModelType.RECEIPT);
//		JTable table=new JTable(tableModel);
//		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
////		list.add(new RecPO());
////		list.add(new RecPO());
////		tableModel.update(list);
////		Exporter test=new Exporter(table);
	}
}
