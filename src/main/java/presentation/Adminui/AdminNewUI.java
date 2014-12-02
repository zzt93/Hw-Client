package presentation.Adminui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import po.UserPO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			AdminNewUI dialog = new AdminNewUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminNewUI() {
		initialize();
	}

	public AdminNewUI(UserPO po) {
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

		textFieldName = new JTextField();
		textFieldName.setBounds(233, 31, 143, 21);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel labelPassWord = new JLabel("密码");
		labelPassWord.setBounds(52, 95, 54, 15);
		contentPanel.add(labelPassWord);

		textFieldPassword = new JTextField();
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
						userpo = new UserPO(0, textFieldName.getText(),
								textFieldPassword.getText(), (String) comboBox
										.getSelectedItem());
						AdminNewUI.this.dispose();
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

						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
