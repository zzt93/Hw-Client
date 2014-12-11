package presentation.mainui;

import presentation.BankManageui.BankManageFrame;
import presentation.FinancialReceiptui.FinancialReceiptFrame;
import presentation.RunningTableui.CheckReceiptFrame;
import presentation.RunningTableui.SaleRecordFrame;

import javax.swing.*;

import java.awt.*;

public class FinancialUI {
	JFrame frame;
	JTabbedPane mainPanel;
	JPanel topPanel;
	BankManageFrame BMF=new BankManageFrame();
	FinancialReceiptFrame FRF=new FinancialReceiptFrame();
	CheckReceiptFrame CRF=new CheckReceiptFrame();
	SaleRecordFrame SRF=new SaleRecordFrame();
	public FinancialUI(){
		try {
			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
		frame=new JFrame();
		frame.setBounds(0, 0,800, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(mainPanel);
		
		topPanel=new JPanel();
		topPanel.setBounds(0,0,800,60);
		topPanel.setLayout(null);
		frame.add(topPanel);
		
		JLabel label = new JLabel("账户：操作员1");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(590, 20, 150, 50);
		topPanel.add(label);
		
		mainPanel=new JTabbedPane(JTabbedPane.TOP);
		mainPanel.setFont(new Font("宋体", Font.PLAIN, 18));
		mainPanel.setBounds(0,60,800,500);
		frame.add(mainPanel);
		mainPanel.add("银行账户",BMF.getPanel());
		mainPanel.add("财务单据",FRF.getPanel());
		mainPanel.add("经营表格",CRF.getPanel());
		mainPanel.add("销售记录",SRF.getPanel());
		frame.setVisible(true);
	}
	public static void main(String[] args){
		FinancialUI main=new FinancialUI();
	}
}
