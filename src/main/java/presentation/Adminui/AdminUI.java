package presentation.Adminui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AdminUI {

	private JFrame frame;
	private JTable table;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 79, 426, 266);
		frame.getContentPane().add(table);
		
		JButton button = new JButton("新建用户");
		button.setBounds(491, 75, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("修改用户");
		button_1.setBounds(491, 142, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("删除用户");
		button_2.setBounds(491, 207, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(491, 271, 93, 23);
		frame.getContentPane().add(button_3);
		
		JLabel label = new JLabel("用户列表");
		label.setBounds(25, 54, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("负责卖萌的状态栏");
		lblNewLabel.setBounds(25, 358, 271, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("管理员界面");
		label_1.setBounds(25, 29, 93, 15);
		frame.getContentPane().add(label_1);
	}
}
