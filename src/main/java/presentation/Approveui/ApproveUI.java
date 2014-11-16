package presentation.Approveui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApproveUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproveUI window = new ApproveUI();
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
	public ApproveUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 21, 526, 291);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Approve", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 507, 249);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 507, 249);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("单据详细信息");
		label.setBounds(20, 327, 92, 15);
		frame.getContentPane().add(label);
		
		JList list = new JList();
		list.setBounds(117, 322, 316, 47);
		frame.getContentPane().add(list);
		
		JButton button = new JButton("确认修改");
		button.setBounds(443, 323, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("批量通过");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(572, 123, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("筛选");
		button_2.setBounds(572, 214, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(572, 300, 93, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("审批单据");
		button_4.setBounds(443, 356, 93, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("刷新");
		button_5.setBounds(572, 44, 93, 23);
		frame.getContentPane().add(button_5);
	}
}
