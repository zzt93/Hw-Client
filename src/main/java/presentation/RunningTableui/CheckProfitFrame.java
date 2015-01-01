package presentation.RunningTableui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.RunningTablebl.RunTableController;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.ProfitVO;
import vo.ReceiptConditionVO;

public class CheckProfitFrame {
//	private JFrame frame;
	private JTextField textStartTime;
	private JTextField textEndTime;
	private JTable table;
	private JProgressBar progressBar;
	private JPanel panel;
	
	private PublicTableModel tableModel;
	private RunTableController controller;
	public CheckProfitFrame(){
		try {
			controller=new RunTableController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器发生了问题");
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
		
		JLabel label = new JLabel("起始时间:");
		label.setBounds(60, 104, 60, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("终止时间:");
		label_1.setBounds(60, 146, 60, 15);
		panel.add(label_1);
		
		textStartTime = new JTextField();
		textStartTime.setBounds(124, 101, 100, 21);
		panel.add(textStartTime);
		textStartTime.setColumns(10);
		
		textEndTime = new JTextField();
		textEndTime.setBounds(124, 143, 100, 21);
		panel.add(textEndTime);
		textEndTime.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 79, 452, 275);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.PROFIT);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("经营情况");
		label_2.setBounds(460, 60, 60, 15);
		panel.add(label_2);
		
		JButton btnQuery = new JButton("查询");
		btnQuery.setBounds(60, 216, 60, 23);
		panel.add(btnQuery);
		btnQuery.addActionListener(new Query());
		
		progressBar = new JProgressBar();
		progressBar.setBounds(404, 366, 283, 23);
		panel.add(progressBar);
		
		JButton btnExcel = new JButton("导出EXCEL");
		btnExcel.setBounds(280, 366, 93, 23);
		panel.add(btnExcel);
		btnExcel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Exporter temp=new Exporter(table,progressBar);
			}
			
		});
		
	}
	public JPanel getPanel(){
		return panel;
	}
	public class Query implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ReceiptConditionVO condition=new ReceiptConditionVO();
			condition.startTime=textStartTime.getText();
			condition.endTime=textEndTime.getText();
			try {
				ProfitVO profit=controller.getProfit(condition);
				tableModel.update(profit);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args){
		CheckProfitFrame a=new CheckProfitFrame();
	}
}
