package presentation.RunningTableui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CheckProfitFrame {
	private JFrame frame;
	private JTextField textStartTime;
	private JTextField textEndTime;
	private JTable table;


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("起始时间:");
		label.setBounds(60, 104, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("终止时间:");
		label_1.setBounds(60, 146, 54, 15);
		panel.add(label_1);
		
		textStartTime = new JTextField();
		textStartTime.setBounds(124, 101, 100, 21);
		panel.add(textStartTime);
		textStartTime.setColumns(10);
		
		textEndTime = new JTextField();
		textEndTime.setBounds(124, 143, 100, 21);
		panel.add(textEndTime);
		textEndTime.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 79, 452, 275);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u9500\u552E", null, null, null},
				{"\u62A5\u6EA2\u62A5\u635F", null, null, null},
				{"\u6210\u672C\u8C03\u4EF7", null, null, null},
				{"\u8FDB\u8D27\u9000\u8D27\u5DEE\u4EF7", null, null, null},
				{"\u4EE3\u91D1\u5377\u5DEE\u4EF7", null, null, null},
				{"\u5546\u54C1\u8D60\u51FA", null, null, null},
				{"\u603B\u8BA1", null, null, null},
				{"\u6298\u8BA9", null, null, null},
				{"\u6298\u8BA9\u540E\u603B\u8BA1", null, null, null},
			},
			new String[] {
				"\u9879\u76EE", "\u6536\u5165", "\u652F\u51FA", "\u5229\u6DA6"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("经营情况");
		label_2.setBounds(460, 60, 54, 15);
		panel.add(label_2);
		
		JButton btnQuery = new JButton("查询");
		btnQuery.setBounds(60, 216, 60, 23);
		panel.add(btnQuery);
		
		JButton btnExcel = new JButton("导出EXCEL");
		btnExcel.setBounds(280, 366, 93, 23);
		panel.add(btnExcel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(404, 366, 283, 23);
		panel.add(progressBar);
	}
}
