package presentation.AnotherClientUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClientUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTextField textFieldZip;
	private JTextField textFieldEmail;
	private JTextField textFieldUpperBound;

	/**
	 * Create the panel.
	 */
	public ClientUI() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 47, 755, 499);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("客户查询", null, panel, null);
		panel.setLayout(null);
				
		textField = new JTextField();
		textField.setBounds(40, 41, 557, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 107, 570, 271);
		panel.add(scrollPane);
		String[] header = new String[]{"姓名","编号","类型","电话","地址","邮编","E-mail","上限","应收","应付","操作员"};
		
		TableModel tm = new DefaultTableModel(new String[2][11],header);
		JTable listTable = new JTable(tm);
		scrollPane.setViewportView(listTable);
		
		JButton buttonModify = new JButton("修改客户");
		buttonModify.setBounds(132, 426, 93, 23);
		panel.add(buttonModify);
		
		JButton buttonDelete = new JButton("删除客户");
		buttonDelete.setBounds(302, 426, 93, 23);
		panel.add(buttonDelete);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("增加客户", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel labelName = new JLabel("姓名");
		labelName.setBounds(87, 57, 54, 15);
		panel_1.add(labelName);
		
		JLabel labelPhone = new JLabel("电话");
		labelPhone.setBounds(87, 100, 54, 15);
		panel_1.add(labelPhone);
		
		JLabel labelAddress = new JLabel("地址");
		labelAddress.setBounds(87, 146, 54, 15);
		panel_1.add(labelAddress);
		
		JLabel labelZip = new JLabel("邮编");
		labelZip.setBounds(87, 187, 54, 15);
		panel_1.add(labelZip);
		
		JLabel labelEmail = new JLabel("伊妹儿");
		labelEmail.setBounds(87, 236, 54, 15);
		panel_1.add(labelEmail);
		
		JLabel labelUpperBound = new JLabel("上限");
		labelUpperBound.setBounds(87, 292, 54, 15);
		panel_1.add(labelUpperBound);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(209, 54, 143, 21);
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(209, 97, 143, 21);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(209, 143, 143, 21);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldZip = new JTextField();
		textFieldZip.setBounds(209, 184, 143, 21);
		panel_1.add(textFieldZip);
		textFieldZip.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(209, 233, 143, 21);
		panel_1.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUpperBound = new JTextField();
		textFieldUpperBound.setBounds(209, 289, 143, 21);
		panel_1.add(textFieldUpperBound);
		textFieldUpperBound.setColumns(10);
		
		JButton buttonConfirm = new JButton("确定");
		buttonConfirm.setBounds(126, 396, 93, 23);
		panel_1.add(buttonConfirm);
		
		JButton buttonCancel = new JButton("取消");
		buttonCancel.setBounds(329, 396, 93, 23);
		panel_1.add(buttonCancel);
		
		JLabel label = new JLabel("客户管理");
		label.setBounds(32, 22, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("我是卖萌的状态栏");
		label_1.setBounds(32, 570, 224, 15);
		add(label_1);
		
		JButton button_4 = new JButton("返回");
		button_4.setBounds(548, 566, 93, 23);
		add(button_4);
		

	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setBounds(10,10,800,800);
		frame.setVisible(true);
		ClientUI ui = new ClientUI();
		frame.getContentPane().add(ui);
		frame.repaint();
	}
}
