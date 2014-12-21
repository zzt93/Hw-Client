package presentation.Approveui;

import po.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.Adminbl.Adminbl;
import businesslogic.Approvebl.Approve_List;
import businesslogicservice.Adminblservice.AdminBLService;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import presentation.RunningTableui.*;
import presentation.Strategyui.StrategyListUI.MyTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ApproveUI {

	private JFrame frame;
	private JTable table;
	public JPanel totalPanel;
	private Approve_List_BLservice approveBL;
	// private Approve_Detail_BLservice approveDetail;
	private ArrayList<ReceiptPO> approveIndex;
	//private Approve_Detail_BLservice approveDetail;

	private ArrayList<ReceiptPO> listOfReceipts;
	private String[][] cellData;
	private AdminBLService ad;
	public String[] name = { "编号", "种类", "时间", "审批状态" };
	TableModel tm;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproveUI window = new ApproveUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public ApproveUI() throws Exception {
		initialize();
		new Thread() {
			public void run() {

				try {
					while (true) {
						
						Thread.sleep(20000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}.start();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		totalPanel = new JPanel();
		totalPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					listOfReceipts = approveBL.refresh();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable(name);
			}
		});
		totalPanel.setBounds(0, 0, 750, 498);
		totalPanel.setLayout(null);
		frame.getContentPane().add(totalPanel);
		// TODO 用于Mock的切换
		// /Read Receipts
		approveBL = new Approve_List();
		listOfReceipts = approveBL.showList();
		// listOfReceipts = new Approve_Mock().showList();
		final JLabel labelHint = new JLabel("按住Ctrl键选择多项单据");
		labelHint.setBounds(39, 473, 211, 15);
		totalPanel.add(labelHint);

		// TODO 就是想搞你一下的存根;
		// refreshTableDebug();
		table = new JTable();
	
		tm = new DefaultTableModel(cellData, name);

		table = new JTable(tm);
		
		table.setBounds(10, 10, 507, 249);
		// FIXME 排序
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int pick = table.getTableHeader().columnAtPoint(e.getPoint());
				approveBL.order(name[pick]);
			}
		});
		scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 10, 507, 249);

		totalPanel.add(scrollPane);
		refreshTable(name);

		approveIndex = new ArrayList<ReceiptPO>();
		
		
		// TODO 就是想搞你一下的存根;
		// refreshTableDebug();
		refreshTable(name);
		
		
		JButton buttonApproveAll = new JButton("批量通过");
		buttonApproveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int approves[] = table.getSelectedRows();
				for (int i : approves) {
					if (listOfReceipts.get(i).statement != ReceiptState.approve) {
						listOfReceipts.get(i).statement = ReceiptState.approve;
						refreshTable(name);
						approveIndex.add(listOfReceipts.get(i));
						
					}

				}
			}
		});
		buttonApproveAll.setBounds(572, 111, 93, 23);
		totalPanel.add(buttonApproveAll);

//		JButton buttonScreen = new JButton("筛选");
//		buttonScreen.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				listOfReceipts = approveBL.screen(null);
//				refreshTable(name);
//			}
//		});
//		buttonScreen.setBounds(572, 211, 93, 23);
//		totalPanel.add(buttonScreen);

		JButton buttonReturn = new JButton("刷新");
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listOfReceipts=approveBL.showList();
					refreshTable(name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttonReturn.setBounds(572, 256, 93, 23);
		totalPanel.add(buttonReturn);

		JButton buttonUpload = new JButton("上传");
		buttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 
				 */
				// FIXME 接口关键部分
				try {
//					passList干啥用的
//					approveBL.passList(approveIndex);
					approveBL.upload(approveIndex);
					listOfReceipts = approveBL.showList();
					JOptionPane.showMessageDialog(null,"上传成功");
					labelHint.setText("上传成功！");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "上传失败！！！");
				}

			}
		});
		buttonUpload.setBounds(572, 60, 93, 23);
		totalPanel.add(buttonUpload);

		JButton buttonDetail = new JButton("详细信息");
		buttonDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceiptPO po = null;
				try{
					po = listOfReceipts.get(table.getSelectedRow());
				}catch(ArrayIndexOutOfBoundsException e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "未选择单据");
				}
				
				switch (po.type) {
				case STOCK_ACCEPT:
		    	case STOCK_REJECTION:
		    		new StockReceiptPane(table,approveIndex,(StockReceiptPO)po);
		    		break;
		    	case SALE_ACCEPT:
		    	case SALE_REJECTION:
		    		new SaleReceiptPane(table,approveIndex,(SaleReceiptPO)po);
		    		break;
		    	case RECEIVE:
		    	case PAYMENT:
		    		new PayReceiptPane(table,approveIndex,(RecPO)po);
		    		break;
		    	case CASH:
		    		new CashReceiptPane(table,approveIndex,(CashPO)po);
		    		break;
		    	case REPORECEIPT:
		    		new RepoReceiptPane(table,approveIndex,(RepoReceiptPO)po);
		    		break;
		    	case GOODSRECEIPT:
		    		new GoodsReceiptPane(table,approveIndex,(GoodsReceiptPO)po);
		    		break;
		    	case SIGNAL:
		    		//不可审批
				default:
					break;
				}
			}
		});
		buttonDetail.setBounds(572, 162, 93, 23);
		totalPanel.add(buttonDetail);

	}

	void insert(String[] item, ReceiptPO po) {
		item[0] = po.number;
		item[1] = ReceiptType.getName(po.type);
		item[2] = po.time;
		item[3] = ReceiptState.getName(po.statement);

	}

	public void refreshTable(String[] name) {
		cellData = new String[listOfReceipts.size()][4];
		int i = 0;
		for (ReceiptPO po : listOfReceipts) {
			insert(cellData[i], po);
			i++;
		}
		tm = new MyTableModel(cellData, name);
		table.setModel(tm);
		scrollPane.setViewportView(table);
	}

	void refreshTableDebug() {
		cellData = new String[3][4];
		int i = 0;
		listOfReceipts = new ArrayList<ReceiptPO>();
		try {
			ad = new Adminbl();
			listOfReceipts.add(new RepoReceiptPO("hehe", 12, 12, ad.getUser()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfReceipts.add(new CashPO());
		listOfReceipts.add(new SaleReceiptPO(10, "2", "3", "4", new BigDecimal(
				0),"操作员"));
		for (ReceiptPO po : listOfReceipts) {
			insert(cellData[i], po);
			i++;
		}

	}
}
