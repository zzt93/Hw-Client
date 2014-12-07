package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import po.RecPO;
import po.ReceiptPO;
import po.ReceiptType;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.ReceiptConditionVO;
import businesslogic.RunningTablebl.RunTableController;

public class CheckReceiptFrame {
	private JFrame frame;
	private JTextField textRepository;
	private JTable table;
	private JTextField textStartTime;
	private JTextField textEndTime;
	JComboBox boxOperator;
	JComboBox boxType;
	JComboBox boxClient;
	private PublicTableModel tableModel;
	private RunTableController controller;
	private List<ReceiptPO> receiptList;
	
	public CheckReceiptFrame(){
//		try {
//			controller=new RunTableController();
//		} catch (RemoteException | NotBoundException e) {
//			JOptionPane.showMessageDialog(null, "服务器出现问题");
//			e.printStackTrace();
//		}
		initialize();
		frame.setVisible(true);
	} 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("单据类型:");
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
		
		JLabel label_5 = new JLabel("客户:");
		label_5.setBounds(60, 260, 54, 15);
		panel.add(label_5);
		//TODO
		boxClient = new JComboBox();
		boxClient.setBounds(115, 260, 100, 21);
		panel.add(boxClient);
	
		textRepository = new JTextField();
		textRepository.setBounds(115, 217, 100, 21);
		panel.add(textRepository);
		textRepository.setColumns(10);
		 //TODO
		boxOperator = new JComboBox();
		boxOperator.setBounds(115, 177, 100, 21);
		panel.add(boxOperator);
		//TODO
		String[] temp={"进货单","进货退货单","销售单","销售退货单","收款单"
				,"付款单","现金费用单","报溢报损单","库存赠送单"};
		boxType = new JComboBox();
		boxType.setBounds(115, 57, 100, 21);
		panel.add(boxType);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 79, 479, 284);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.RECEIPT);
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JLabel label_6 = new JLabel("单据列表");
		label_6.setBounds(431, 57, 54, 15);
		panel.add(label_6);
		
		JButton btnClear = new JButton("清空");
		btnClear.setBounds(612, 379, 60, 23);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<=table.getRowCount();i++){
					tableModel.removeRow(0);
				}
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
		
		JButton btnCredit = new JButton("红冲");
		btnCredit.setBounds(60, 350, 60, 23);
		panel.add(btnCredit);
		
		JButton btnCreditCopy = new JButton("红冲复制");
		btnCreditCopy.setBounds(60, 400, 80, 23);
		panel.add(btnCreditCopy);
		
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
					//测试代码
			{
				RecPO rec=new RecPO();
				RecPO rec1=new RecPO();
				List<ReceiptPO> tempList=new ArrayList<ReceiptPO>();
				tempList.add(rec);
				tempList.add(rec1);
				tableModel.update(tempList);
			}
				
						
		}
		
	}
	public static void main(String[] args){
		CheckReceiptFrame a=new CheckReceiptFrame();
	}
}
