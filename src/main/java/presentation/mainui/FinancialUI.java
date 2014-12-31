package presentation.mainui;

import presentation.BankManageui.BankManageFrame;
import presentation.FinancialReceiptui.FinancialReceiptFrame;
import presentation.RepoUI.MainFrame;
import presentation.RunningTableui.CheckProfitFrame;
import presentation.RunningTableui.CheckReceiptFrame;
import presentation.RunningTableui.SaleRecordFrame;
import presentation.SetAccountui.AccountFrame;

import javax.swing.*;

import businesslogic.Adminbl.AdminController;

import java.awt.*;

public class FinancialUI {
	JFrame frame;
	JTabbedPane mainPanel;
	JPanel topPanel;
	AdminController adminController;
	BankManageFrame BMF=new BankManageFrame();
	FinancialReceiptFrame FRF=new FinancialReceiptFrame();
	CheckReceiptFrame CRF=new CheckReceiptFrame();
	SaleRecordFrame SRF=new SaleRecordFrame();
	CheckProfitFrame CPF=new CheckProfitFrame();
//	AccountFrame AF=new AccountFrame();
	public FinancialUI(){
//		try {
//			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        MainFrame.look_and_feel();

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
		
		
		try {
			adminController=new AdminController();
			JLabel label = new JLabel("账户:"+adminController.getUser());
			label.setFont(new Font("宋体", Font.PLAIN, 18));
			label.setBounds(590, 20, 150, 50);
			topPanel.add(label);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		
		mainPanel=new JTabbedPane(JTabbedPane.TOP);
		mainPanel.setFont(new Font("宋体", Font.PLAIN, 18));
		mainPanel.setBounds(0,60,800,500);
		frame.add(mainPanel);
		mainPanel.add("银行账户",BMF.getPanel());
		mainPanel.add("财务单据",FRF.getPanel());
		mainPanel.add("经营表格",CRF.getPanel());
		mainPanel.add("销售记录",SRF.getPanel());
		mainPanel.add("经营情况",CPF.getPanel());
//		mainPanel.add("账目管理",AF.getPanel());
		frame.setVisible(true);
	}
	public static void main(String[] args){
		FinancialUI main=new FinancialUI();
	}
}
