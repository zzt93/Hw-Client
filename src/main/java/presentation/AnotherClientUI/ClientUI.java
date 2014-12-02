package presentation.AnotherClientUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogicservice.Clientblservice.ClientUtility;
import po.ClientLevel;
import po.ClientPO;
import po.ClientType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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

	static ArrayList<ClientPO> clients;
	private ClientUtility cu;


	/**
	 * Create the panel.
	 */
	public ClientUI() {

		setLayout(null);

		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 47, 755, 499);
		add(tabbedPane);

		JPanel tabShow = new JPanel();
		tabbedPane.addTab("客户查询", null, tabShow, null);
		tabShow.setLayout(null);

		textField = new JTextField();
		textField.setBounds(40, 41, 557, 21);
		tabShow.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 107, 570, 271);
		tabShow.add(scrollPane);
		String[] header = new String[] { "姓名", "编号", "类型", "电话", "地址", "邮编",
				"E-mail", "上限", "应收", "应付", "操作员" };

		TableModel tm = new DefaultTableModel(new String[2][11], header);
		JTable listTable = new JTable(tm);
		scrollPane.setViewportView(listTable);
		
		refresh();

		JButton buttonModify = new JButton("修改客户");
		buttonModify.setBounds(221, 426, 93, 23);
		tabShow.add(buttonModify);

		JButton buttonDelete = new JButton("删除客户");
		buttonDelete.setBounds(350, 426, 93, 23);
		tabShow.add(buttonDelete);
		
		JButton buttonAdd = new JButton("增加客户");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		buttonAdd.setBounds(94, 426, 93, 23);
		tabShow.add(buttonAdd);
		JPanel tabAdd = new JPanel();
		tabbedPane.addTab("详细信息", null, tabAdd, null);
		tabAdd.setLayout(null);

		JLabel labelName = new JLabel("姓名");
		labelName.setBounds(87, 57, 54, 15);
		tabAdd.add(labelName);

		JLabel labelPhone = new JLabel("电话");
		labelPhone.setBounds(87, 100, 54, 15);
		tabAdd.add(labelPhone);

		JLabel labelAddress = new JLabel("地址");
		labelAddress.setBounds(87, 146, 54, 15);
		tabAdd.add(labelAddress);

		JLabel labelZip = new JLabel("邮编");
		labelZip.setBounds(87, 187, 54, 15);
		tabAdd.add(labelZip);

		JLabel labelEmail = new JLabel("伊妹儿");
		labelEmail.setBounds(87, 236, 54, 15);
		tabAdd.add(labelEmail);

		JLabel labelUpperBound = new JLabel("上限");
		labelUpperBound.setBounds(87, 283, 54, 15);
		tabAdd.add(labelUpperBound);

		textFieldName = new JTextField();
		textFieldName.setBounds(209, 54, 143, 21);
		tabAdd.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(209, 97, 143, 21);
		tabAdd.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(209, 143, 143, 21);
		tabAdd.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		textFieldZip = new JTextField();
		textFieldZip.setBounds(209, 184, 143, 21);
		tabAdd.add(textFieldZip);
		textFieldZip.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(209, 233, 143, 21);
		tabAdd.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldUpperBound = new JTextField();
		textFieldUpperBound.setBounds(209, 280, 143, 21);
		tabAdd.add(textFieldUpperBound);
		textFieldUpperBound.setColumns(10);

		JButton buttonConfirm = new JButton("确定");
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientPO cpo = new ClientPO(ClientType.STOCKER,
						ClientLevel.LEVEL1, textFieldName.getText(),
						textFieldPhone.getText(), textFieldAddress.getText(),
						textFieldZip.getText(), textFieldEmail.getText(), "王尼玛");
				try {
					cu.addClient(cpo);
					refresh();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttonConfirm.setBounds(126, 396, 93, 23);
		tabAdd.add(buttonConfirm);

		JButton buttonCancel = new JButton("取消");
		buttonCancel.setBounds(329, 396, 93, 23);
		tabAdd.add(buttonCancel);
		
		JLabel label_1 = new JLabel("添加");
		label_1.setBounds(45, 22, 54, 15);
		tabAdd.add(label_1);

		JLabel label = new JLabel("客户管理");
		label.setBounds(32, 22, 54, 15);
		add(label);

		JLabel buttonReturn = new JLabel("我是卖萌的状态栏");
		buttonReturn.setBounds(32, 570, 224, 15);
		add(buttonReturn);

		JButton button_4 = new JButton("返回");
		button_4.setBounds(548, 566, 93, 23);
		add(button_4);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(10, 10, 800, 800);
		frame.setVisible(true);
		ClientUI ui = new ClientUI();
		frame.getContentPane().add(ui);
		frame.repaint();
	}
	
	public void refresh(){
		try {
			clients = (ArrayList<ClientPO>) cu.queryClient(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
