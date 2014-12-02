package presentation.Adminui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogicservice.Adminblservice.AdminBLService;
import po.UserPO;

import java.awt.*;
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
		//FIXME
		if(ads==null){
			try {
				ads = (AdminDataService)RMIUtility.getImpl("Admin");
			} catch (RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			users = (ArrayList<UserPO>)ads.show().getObj();
		} catch (RemoteException e) {
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
				try {
					am.delete(users.get(table.getSelectedRow()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				users.remove(table.getSelectedRow());
				
			}
		});
		button_2.setBounds(491, 207, 93, 23);
//		frame.getContentPane().add(button_2);
		panel.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(491, 271, 93, 23);
//		frame.getContentPane().add(button_3);
		panel.add(button_3);
		
		JLabel label = new JLabel("用户列表");
		label.setBounds(25, 54, 54, 15);
//		frame.getContentPane().add(label);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("负责卖萌的状态栏");
		lblNewLabel.setBounds(25, 358, 271, 15);
//		frame.getContentPane().add(lblNewLabel);
		panel.add(lblNewLabel);
		
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
