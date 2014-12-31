package presentation.Adminui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.Adminbl.AdminController;
import businesslogicservice.Adminblservice.AdminBLService;
import po.ReceiptPO;
import po.UserPO;

import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI {

	private JFrame frame;
	private JTable table;
	public JPanel panel;
	AdminBLService am;
	static ArrayList<UserPO> users = null;
	private String[][] data;
	TableModel tm;
	JScrollPane scrollPane;
	String head[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI window = new AdminUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUI() {
		try {
			am = new AdminController();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		// FIXME
		try {
			users = am.show();
			if (users == null) {
				JOptionPane.showMessageDialog(null, "列表为空");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "连接不上服务器");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		head = new String[] { "id", "name", "role" };
		
		tm = new MyTableModel(data, head);

		table = new JTable(tm);
		table.setBounds(25, 79, 426, 266);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 95, 499, 354);
		panel.add(scrollPane);

		scrollPane.setViewportView(table);
		refreshTable();
		JButton buttonNew = new JButton("新建用户");
		buttonNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminNewUI admin = new AdminNewUI(AdminUI.this);
				admin.setVisible(true);
				try {
					users = am.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable();
				
			}
		});
		buttonNew.setBounds(560, 73, 93, 23);
		// frame.getContentPane().add(button);
		panel.add(buttonNew);

		final JLabel lblHint = new JLabel("负责卖萌的状态栏");
		lblHint.setBounds(27, 478, 271, 15);
		// frame.getContentPane().add(lblNewLabel);
		panel.add(lblHint);

		JButton buttonModify = new JButton("修改用户");
		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				AdminNewUI admin = new AdminNewUI(users.get(table
						.getSelectedRow()),AdminUI.this);

				
					am.delete(users.get(table.getSelectedRow()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					lblHint.setText("你还没选择你要改哪个用户呢！！");
					e1.printStackTrace();
				}
				//users.remove(table.getSelectedRow());
				
				try {
					users = am.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		buttonModify.setBounds(560, 141, 93, 23);
		// frame.getContentPane().add(button_1);
		panel.add(buttonModify);

		JButton buttonRemove = new JButton("删除用户");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean judge = false;
				try {
					judge = am.delete(users.get(table.getSelectedRow()));
					lblHint.setText("删除成功");
					users.remove(table.getSelectedRow());
					
					refreshTable();
					table.repaint();
				} catch (ArrayIndexOutOfBoundsException e2){
					lblHint.setText("你没选你要删哪个吧..");
					e2.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					lblHint.setText("删除失败..");
					e1.printStackTrace();
				}
			}
		});
		buttonRemove.setBounds(560, 206, 93, 23);
		// frame.getContentPane().add(button_2);
		panel.add(buttonRemove);

		JButton buttonReturn = new JButton("注销");
		buttonReturn.setBounds(560, 270, 93, 23);
		// frame.getContentPane().add(button_3);
		panel.add(buttonReturn);

		JLabel label = new JLabel("用户列表");
		label.setBounds(25, 54, 54, 15);
		// frame.getContentPane().add(label);
		panel.add(label);

		JLabel label_1 = new JLabel("管理员界面");
		label_1.setBounds(25, 29, 93, 15);
		// frame.getContentPane().add(label_1);
		panel.add(label_1);
	}

	
	void refreshTable() {
		data = new String[users.size()][3];
		int i = 0;
		for (UserPO po : users) {
			insert(data[i], po);
			i++;
		}
		tm = new DefaultTableModel(data,head);
		table.setModel(tm);
		scrollPane.setViewportView(table);
	}
	private void insert(String[] strings, UserPO po) {
		strings[0] = String.valueOf(po.getId());
		strings[1] = po.getName();
		strings[2] = po.getRole();
		
		
	}
	static class MyTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		public MyTableModel(String[][] data, String[] head) {
			super(data,head);
		}


		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}
