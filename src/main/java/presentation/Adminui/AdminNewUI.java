package presentation.Adminui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import businesslogic.Adminbl.AdminController;
import po.UserPO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AdminNewUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	private UserPO userpo;
	private UserPO tempUserPO;
	JComboBox<String> comboBox;
	private AdminController adminController;
	private AdminUI listUI;
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			AdminNewUI dialog = new AdminNewUI(null);
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminNewUI(AdminUI ui) {
		listUI = ui;
		try {
			adminController=new AdminController();
			textFieldName = new JTextField();
			textFieldPassword = new JTextField();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现了问题");
			e.printStackTrace();
		}
		initialize();
	}

	public AdminNewUI(UserPO po,AdminUI ui) {
		listUI = ui;
		try {
			adminController=new AdminController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现了问题");
			e.printStackTrace();
		}
		textFieldName = new JTextField();
		textFieldPassword = new JTextField();
		textFieldName.setText(po.getName());
		textFieldPassword.setText(po.getPassword());
		tempUserPO = po;
		initialize();
		this.setVisible(true);
	}

	public void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelName = new JLabel("用户名");
		labelName.setBounds(52, 34, 66, 15);
		contentPanel.add(labelName);

		
		textFieldName.setBounds(233, 31, 143, 21);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel labelPassWord = new JLabel("密码");
		labelPassWord.setBounds(52, 95, 54, 15);
		contentPanel.add(labelPassWord);

		
		textFieldPassword.setBounds(233, 92, 143, 21);
		contentPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JLabel labelRole = new JLabel("身份");
		labelRole.setBounds(52, 159, 54, 15);
		contentPanel.add(labelRole);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(232, 156, 144, 21);
		contentPanel.add(comboBox);

		/**
		 * This name method is on purpose
		 */
		String tomAndJerry = new String("库存管理人员");
		String zafafa = new String("进货销售人员");
		String caonima = new String("财务人员");
		String haosha = new String("总经理");
		comboBox.addItem(tomAndJerry);
		comboBox.addItem(zafafa);
		comboBox.addItem(caonima);
		comboBox.addItem(haosha);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id=0;
						switch((String) comboBox.getSelectedItem()){
						case "库存管理人员":
							id+=10000;
						case "进货销售人员":
							id+=10000;
						case "财务人员":
							id+=10000;
						case "总经理":
							id+=10000;
							break;
						}
						id+=(int)Math.random()*10000;
						userpo = new UserPO(0, textFieldName.getText(),
								textFieldPassword.getText(), (String) comboBox
										.getSelectedItem());
						boolean judge = false;
						try {
							judge = adminController.confirm(userpo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "连接失败");
							e1.printStackTrace();
						}
						if(judge){
							JOptionPane.showMessageDialog(null, "成功");
							listUI.refreshTable();
							AdminNewUI.this.dispose();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (tempUserPO != null) {
							userpo = new UserPO(tempUserPO);
							try {
								adminController.confirm(userpo);
							} catch (Exception e1) {
							}
						}
						listUI.refreshTable();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
