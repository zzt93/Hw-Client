package presentation.Approveui;

import po.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.Adminbl.Adminbl;
import businesslogic.Approvebl.Approve_Mock;
import businesslogicservice.Adminblservice.AdminBLService;
import businesslogicservice.Approveblservice.Approve_List_BLservice;

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
	//private Approve_Detail_BLservice approveDetail;
	private ArrayList<ReceiptPO> approveIndex;
	private ArrayList<ReceiptPO> listOfReceipts;
	private String[][] cellData;
	private AdminBLService ad;

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
		totalPanel.setBounds(0, 0, 750, 498);
		totalPanel.setLayout(null);
		frame.getContentPane().add(totalPanel);
		//TODO 用于Mock的切换
		// /Read Receipts
		// listOfReceipts = approveBL.showList();
		listOfReceipts = new Approve_Mock().showList();
		final JLabel labelHint = new JLabel("状态栏");
		labelHint.setBounds(39, 473, 211, 15);
		totalPanel.add(labelHint);

		final String[] name = { "编号", "种类", "时间", "审批状态" };

		/**
		 * Details
		 */
		final JScrollPane detailScrollPane = new JScrollPane();
		detailScrollPane.setBounds(108, 322, 557, 81);
		totalPanel.add(detailScrollPane);

		TableModel detailTableModel = new DefaultTableModel(new String[1][2],
				new String[] { "项目", "值" });
		final JTable detailTable = new JTable(detailTableModel);
		detailTable.setRowHeight(100);
		detailTable.setBounds(107, 322, 325, 93);
		detailScrollPane.setViewportView(detailTable);

		// TODO 就是想搞你一下的存根;
		// refreshTableDebug();
		refreshTable();

		TableModel tm = new DefaultTableModel(cellData, name);

		table = new JTable(tm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow = table.getSelectedRow();
				analysis(detailTable, listOfReceipts.get(selectedRow),
						detailScrollPane);

			}
		});
		
		
		table.setBounds(10, 10, 507, 249);
		//FIXME 排序
		table.getTableHeader().addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				int pick = table.getTableHeader().columnAtPoint(e.getPoint());
				approveBL.order(name[pick]);
			}
		});
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 10, 507, 249);
		scrollPane.setViewportView(table);
		totalPanel.add(scrollPane);

		JLabel label = new JLabel("单据详细信息");
		label.setBounds(20, 327, 92, 15);
		totalPanel.add(label);

		JButton buttonConfirm = new JButton("确认修改");
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		buttonConfirm.setBounds(290, 425, 93, 23);
		totalPanel.add(buttonConfirm);

		JButton buttonApproveAll = new JButton("批量通过");
		buttonApproveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int approves[] = table.getSelectedRows();
				for (int i : approves) {
					if(listOfReceipts.get(i).state == ReceiptState.wait){
						listOfReceipts.get(i).state = ReceiptState.approve;
						refreshTable();
						listOfReceipts.get(i).state = ReceiptState.wait;
						approveIndex.add(listOfReceipts.get(i));

					}
					
				}
			}
		});
		buttonApproveAll.setBounds(572, 124, 93, 23);
		totalPanel.add(buttonApproveAll);

		JButton buttonScreen = new JButton("筛选");
		buttonScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listOfReceipts = approveBL.screen(null);
				refreshTable();
			}
		});
		buttonScreen.setBounds(572, 192, 93, 23);
		totalPanel.add(buttonScreen);

		JButton buttonReturn = new JButton("返回");
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonReturn.setBounds(572, 256, 93, 23);
		totalPanel.add(buttonReturn);

		JButton buttonApproveSingle = new JButton("通过");
		buttonApproveSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				if (listOfReceipts.get(selectedRow).state == ReceiptState.approve) {
					labelHint.setText("这是已经通过了的单据");
				} else {
					listOfReceipts.get(selectedRow).state = ReceiptState.approve;
					refreshTable();
					listOfReceipts.get(selectedRow).state = ReceiptState.wait;
					approveIndex.add(listOfReceipts.get(selectedRow));
					labelHint.setText("已审批为通过");
				}

			}
		});
		buttonApproveSingle.setBounds(136, 425, 93, 23);
		totalPanel.add(buttonApproveSingle);

		JButton buttonUpload = new JButton("上传");
		buttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 
				 */
				//FIXME 接口关键部分
				try {
					approveBL.passList(approveIndex);
					approveBL.upload();
					listOfReceipts = approveBL.showList();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "上传失败！！！");
				}

			}
		});
		buttonUpload.setBounds(572, 60, 93, 23);
		totalPanel.add(buttonUpload);

	}

	void insert(String[] item, ReceiptPO po) {
		item[0] = po.receipt_id;
		//item[1] = po.type.toString();
		item[2] = po.time;
		item[3] = po.state.toString();

	}

	void analysis(JTable detailTable, ReceiptPO po, JScrollPane detailsp) {
		DefaultTableModel tm;
		switch (po.type) {
		case CASH:
			CashPO cPO = (CashPO) po;
			String[] headers1 = new String[] { "type", "number", "time",
					"operator", "total", "ItemList", "State" };
			tm = new DefaultTableModel(headers1, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { cPO.type.toString(), cPO.receipt_id, cPO.time,
					cPO.operator, Double.toString(cPO.total),
					cPO.itemList.toString(), cPO.state.toString() });
			break;
		case GOODSRECEIPT:
			GoodsReceiptPO gpo = (GoodsReceiptPO) po;
			String[] headers2 = new String[] { "type", "number", "time",
					"goodsPOs", "sumOfGifts", "State" };
			tm = new DefaultTableModel(headers2, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { gpo.type.toString(), gpo.receipt_id, gpo.time,
					gpo.getGoods().toString(),
					Double.toString(gpo.getSumOfGifts()),
					gpo.state.toString() });
			break;
		case PAYMENT:
			PayPO ppo = (PayPO) po;
			String[] header3 = new String[] { "type", "number", "time",
					"client", "operator", "bankList", "total", "State" };
			tm = new DefaultTableModel(header3, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { ppo.time.toString(), ppo.receipt_id, ppo.time,
					ppo.getClient(), ppo.getOperator(),
					ppo.getBankList().toString(),
					Double.toString(ppo.getTotal()), ppo.state.toString() });
			break;
		case RECEIVE:
			RecPO rpo = (RecPO) po;
			String[] header4 = new String[] { "type", "number", "time",
					"client", "operator", "bankList", "total", "State" };
			tm = new DefaultTableModel(header4, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { rpo.time.toString(), rpo.receipt_id, rpo.time,
					rpo.getClient(), rpo.getOperator(),
					rpo.getBankList().toString(),
					Double.toString(rpo.getTotal()), rpo.state.toString() });
			break;
		case REPORECEIPT:
			RepoReceiptPO rrpo = (RepoReceiptPO) po;
			String[] header5 = new String[] { "type", "number", "time",
					"actualNum", "statisticNum", "date", "id", "State" };
			tm = new DefaultTableModel(header5, 1);
			tm.addRow(new String[] { rrpo.time.toString(), rrpo.receipt_id,
					rrpo.time, Integer.toString(rrpo.getaNum()),
					Integer.toString(rrpo.getcNum()), null, rrpo.getReceipt_id(),
					rrpo.state.toString() });
			break;
		case SALE_ACCEPT:
		case SALE_REJECTION:
			SaleReceiptPO srpo = (SaleReceiptPO) po;
			String[] header6 = new String[] { "type", "number", "time",
					"cliendID", "salesman", "operator", "respository",
					"productList", "totalValue", "allowance", "coupon",
					"actualValue", "comment" };
			tm = new DefaultTableModel(header6, 1);
			tm.addRow(new String[] { srpo.time.toString(), srpo.receipt_id,
					srpo.time, Integer.toString(srpo.getClientId()),
					srpo.getSalesman(), srpo.getOperator().toString(),
					srpo.getRepository(), srpo.getProductList().toString(),
					srpo.getTotalValue().toString(),
					srpo.getActualValue().toString(),
					srpo.getAllowance().toString(),
					srpo.getCoupon().toString(),
					srpo.getActualValue().toString(), srpo.getComment() });
			break;
		case STOCK_ACCEPT:
		case STOCK_REJECTION:
			StockReceiptPO stock = (StockReceiptPO) po;
			String header7[] = new String[] { "type", "number", "time",
					"cliendID", "operator", "respository", "productList",
					"comment", "totalValue" };
			tm = new DefaultTableModel(header7, 1);
			tm.addRow(new String[] { stock.time.toString(), stock.receipt_id,
					stock.time, Integer.toString(stock.getSupplier()),
					stock.getOperator().toString(), stock.getRepository(),
					stock.getProductList().toString(), stock.getComment(),
					stock.getTotalValue().toString() });

			break;
		default:
			break;

		}

	}

	void refreshTable() {
		cellData = new String[listOfReceipts.size()][4];
		int i = 0;
		for (ReceiptPO po : listOfReceipts) {
			insert(cellData[i], po);
			i++;
		}
	}

	void refreshTableDebug() {
		cellData = new String[3][4];
		int i = 0;
		listOfReceipts = new ArrayList<ReceiptPO>();
		try {
			ad = new Adminbl();
			listOfReceipts.add(new RepoReceiptPO("hehe", 12, 12,ad.getUser()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfReceipts.add(new CashPO());
		listOfReceipts.add(new SaleReceiptPO(10,"2","3","4",new BigDecimal(0)));
		for (ReceiptPO po : listOfReceipts) {
			insert(cellData[i], po);
			i++;
		}

	}
}
