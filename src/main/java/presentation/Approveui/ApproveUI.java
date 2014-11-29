package presentation.Approveui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import po.*;
import businesslogicservice.Approveblservice.Approve_Detail_BLservice;
import businesslogicservice.Approveblservice.Approve_List_BLservice;

public class ApproveUI {

	private JFrame frame;
	private JTable table;
	public JPanel totalPanel;
	//private Approve_List_BLservice approveBL;
	//private Approve_Detail_BLservice approveDetail;
	private ArrayList<ReceiptPO> approveIndex;
	private ArrayList<ReceiptPO> arr;
	private String[][] cellData;

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
		
		///Read Receipts
		//arr = approveBL.showList();
		
		final JLabel labelHint = new JLabel("状态栏");
		labelHint.setBounds(39, 473, 211, 15);
		totalPanel.add(labelHint);
		
		String[] name = { "编号", "种类", "时间", "审批状态" };

		/**
		 * Details
		 */
		final JScrollPane detailScrollPane = new JScrollPane();
		detailScrollPane.setBounds(108, 322, 325, 128);
		totalPanel.add(detailScrollPane);

		TableModel detailTableModel = new DefaultTableModel(new String[1][2],
				new String[] { "项目", "值" });
		final JTable detailTable = new JTable(detailTableModel);
		detailTable.setBounds(107, 322, 325, 93);
		detailScrollPane.setViewportView(detailTable);
		
		// TODO 就是想搞你一下的存根;
		refreshTableDebug();
		//refreshTable();

		TableModel tm = new DefaultTableModel(cellData, name);

		table = new JTable(tm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow = table.getSelectedRow();
				analysis(detailTable, arr.get(selectedRow), detailScrollPane);

			}
		});
		table.setBounds(10, 10, 507, 249);

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
		buttonConfirm.setBounds(443, 323, 93, 23);
		totalPanel.add(buttonConfirm);

		JButton buttonApproveAll = new JButton("批量通过");
		buttonApproveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int approves[] = table.getSelectedRows();
				for (int i : approves) {
					arr.get(i).statement = ReceiptState.approve;
					refreshTable();
					arr.get(i).statement = ReceiptState.disapprove;
					approveIndex.add(arr.get(i));
					
				}
			}
		});
		buttonApproveAll.setBounds(572, 140, 93, 23);
		totalPanel.add(buttonApproveAll);

		JButton buttonScreen = new JButton("筛选");
		buttonScreen.setBounds(572, 223, 93, 23);
		totalPanel.add(buttonScreen);

		JButton buttonReturn = new JButton("返回");
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonReturn.setBounds(572, 300, 93, 23);
		totalPanel.add(buttonReturn);

		JButton buttonApproveSingle = new JButton("通过");
		buttonApproveSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				if(arr.get(selectedRow).statement == ReceiptState.approve){
					labelHint.setText("这是已经通过了的单据");
				}else{
					arr.get(selectedRow).statement = ReceiptState.approve;
					refreshTable();
					arr.get(selectedRow).statement = ReceiptState.disapprove;
					approveIndex.add(arr.get(selectedRow));
					labelHint.setText("已审批为通过");
				}
				
			}
		});
		buttonApproveSingle.setBounds(443, 356, 93, 23);
		totalPanel.add(buttonApproveSingle);

		JButton buttonUpload = new JButton("上传");
		buttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 
				 */
				
				/*try {
					approveBL.passList(approveIndex);
					approveBL.upload();
					arr = approveBL.showList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		buttonUpload.setBounds(572, 60, 93, 23);
		totalPanel.add(buttonUpload);
		

		

	}

	void insert(String[] item, ReceiptPO po) {
		item[0] = po.number;
		item[1] = po.type.toString();
		item[2] = po.time;
		item[3] = po.statement.toString();

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
			tm.addRow(new String[] { cPO.type.toString(), cPO.number, cPO.time,
					cPO.operator, Double.toString(cPO.total),
					cPO.itemList.toString(), cPO.statement.toString() });
			break;
		case GOODSRECEIPT:
			GoodsReceiptPO gpo = (GoodsReceiptPO) po;
			String[] headers2 = new String[] { "type", "number", "time",
					"goodsPOs", "sumOfGifts", "State" };
			tm = new DefaultTableModel(headers2, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { gpo.type.toString(), gpo.number, gpo.time,
					gpo.getGoodsPOs().toString(),
					Double.toString(gpo.getSumOfGifts()),
					gpo.statement.toString() });
			break;
		case PAYMENT:
			PayPO ppo = (PayPO) po;
			String[] header3 = new String[] { "type", "number", "time",
					"client", "operator", "bankList", "total", "State" };
			tm = new DefaultTableModel(header3, 1);
			detailTable.setModel(tm);
			tm.addRow(new String[] { ppo.time.toString(), ppo.number, ppo.time,
					ppo.getClient(), ppo.getOperator(),
					ppo.getBankList().toString(),
					Double.toString(ppo.getTotal()), ppo.statement.toString() });
			break;
		case RECEIVE:
			break;
		case REPORECEIPT:
			break;
		case SALE_ACCEPT:
			break;
		case SALE_REJECTION:
			break;
		case STOCK_ACCEPT:
			break;
		case STOCK_REJECTION:
			break;
		default:
			break;

		}

	}
	
	void refreshTable(){
		cellData = new String[arr.size()][4];
		int i = 0;
		for (ReceiptPO po : arr) {
			insert(cellData[i], po);
			i++;
		}
	}
	
	void refreshTableDebug(){
		cellData = new String[2][4];
		int i = 0;
		ArrayList<ReceiptPO> arr = new ArrayList<ReceiptPO>();
		arr.add(new RepoReceiptPO("hehe", 2, 2));
		arr.add(new CashPO());
		for (ReceiptPO po : arr) {
			insert(cellData[i], po);
			i++;
		}
		
	}
}
