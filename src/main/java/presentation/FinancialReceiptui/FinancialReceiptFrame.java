package presentation.FinancialReceiptui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import po.RecPO;
import po.ReceiptPO;
import presentation.RunningTableui.PayReceiptPane;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class FinancialReceiptFrame {
	private JPanel panel;
	private JTable table;
	private FinReceiptPane receiptPane;
	PublicTableModel tableModel;
	private Font font=new Font("宋体",Font.PLAIN,18);
	private Font font2=new Font("宋体",Font.PLAIN,14);
	private List<ReceiptPO> list;
	public FinancialReceiptFrame(){
		initialize();
		receiptPane=new FinReceiptPane();
		//TODO,获得list
		//测试代码
		{
			RecPO rec=new RecPO();
			list=new ArrayList<ReceiptPO>();
			list.add(rec);
			tableModel.update(list);
		}
	}
	public void initialize(){
		panel = new JPanel();
		panel.setBounds(0, 100, 800, 500);
		panel.setLayout(null);
		
		JButton btnPay = new JButton("付款单");
		btnPay.setFont(font);
		btnPay.setBounds(50, 90, 130, 40);
		panel.add(btnPay);
		btnPay.addActionListener(new Payment());
		
		JButton btnRec = new JButton("收款单");
		btnRec.setFont(font);
		btnRec.setBounds(50, 170, 130, 40);
		panel.add(btnRec);
		btnRec.addActionListener(new Receive());
		
		JButton btnCash = new JButton("现金费用单");
		btnCash.setFont(font);
		btnCash.setBounds(50, 250, 130, 40);
		panel.add(btnCash);
		btnCash.addActionListener(new Cash());
		
		JLabel label = new JLabel("单据情况");
		label.setFont(font);
		label.setBounds(435, 15, 80, 40);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 60, 475, 320);
		panel.add(scrollPane);
		
		tableModel=new PublicTableModel(ModelType.FINRECEIPT);
		table=new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setFont(font2);
		table.setFont(font2);
		table.addMouseListener(new MouseClick());
	}

	public JPanel getPanel(){
		return panel;
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(table.getSelectedRow()<0){
				JOptionPane.showMessageDialog(null,"未选中");
				return;
			}
			if(e.getClickCount()>=2){
				switch(list.get(table.getSelectedRow()).type){
				case CASH:{
					//TODO
					break;
				}
				case PAYMENT:
				case RECEIVE:{
					PayReceiptPane payReceiptPane=new PayReceiptPane(table.getSelectedRow(),tableModel);
					payReceiptPane.set((RecPO)list.get(table.getSelectedRow()));
					payReceiptPane.deal();
					payReceiptPane.visit(true);
				}
				}
			}
		}
	}
	public class Payment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			receiptPane.creatPay();
		}
		
	}
	public class Receive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			receiptPane.creatRec();
		}
	}
	public class Cash implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			receiptPane.creatCash();
		}
	}
}
