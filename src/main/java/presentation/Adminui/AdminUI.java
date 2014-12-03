package presentation.Adminui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.Adminbl.AdminController;
import businesslogicservice.Adminblservice.AdminBLService;
import po.UserPO;

import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI {

	private JFrame frame;
	private JTable table;
	public JPanel panel;
	private AdminBLService am; 
	static ArrayList<UserPO> users = null;
	


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
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		
		
		//FIXME
		try {
			users = am.show();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "连接不上服务器");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String head[] = new String[]{"id","name","role"};
		String data[][]= new String[users.size()][3];
		TableModel tm = new MyTableModel(data,head);
		
		table = new JTable(tm);
		table.setBounds(25, 79, 426, 266);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 100, 679, 422);
		
		scrollPane.setViewportView(table);
		
		
		JButton button = new JButton("新建用户");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminNewUI.main(null);
			}
		});
		button.setBounds(491, 75, 93, 23);
//		frame.getContentPane().add(button);
		panel.add(button);
		
		final JLabel lblHint = new JLabel("负责卖萌的状态栏");
		lblHint.setBounds(25, 358, 271, 15);
//		frame.getContentPane().add(lblNewLabel);
		panel.add(lblHint);
		
		JButton button_1 = new JButton("修改用户");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					am.delete(users.get(table.getSelectedRow()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				users.remove(table.getSelectedRow());
				AdminNewUI admin = new AdminNewUI(users.get(table.getSelectedRow()));
			}
		});
		button_1.setBounds(491, 142, 93, 23);
//		frame.getContentPane().add(button_1);
		panel.add(button_1);
		
		JButton button_2 = new JButton("删除用户");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean judge = false;
				try {
					judge = am.delete(users.get(table.getSelectedRow()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(judge){
					lblHint.setText("删除成功");
					users.remove(table.getSelectedRow());
				}else{
					lblHint.setText("删除失败");
				}
				
				
			}
		});
		button_2.setBounds(491, 207, 93, 23);
//		frame.getContentPane().add(button_2);
		panel.add(button_2);
		
		JButton buttonReturn = new JButton("注销");
		buttonReturn.setBounds(491, 271, 93, 23);
//		frame.getContentPane().add(button_3);
		panel.add(buttonReturn);
		
		JLabel label = new JLabel("用户列表");
		label.setBounds(25, 54, 54, 15);
//		frame.getContentPane().add(label);
		panel.add(label);

		JLabel label_1 = new JLabel("管理员界面");
		label_1.setBounds(25, 29, 93, 15);
//		frame.getContentPane().add(label_1);
		panel.add(label_1);
	}
	
	public class MyTableModel extends DefaultTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public MyTableModel(Object[][] data, Object[] columnNames) {
		        setDataVector(data, columnNames);
		    }

		public boolean isCellEditlable(int row, int column){
			return false;
		}
	}
}
