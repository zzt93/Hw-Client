package presentation.Logui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import businesslogic.Logbl.Logbl;
import businesslogicservice.Logblservice.Logblservice;

public class LogUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Logblservice logbl;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogUI dialog = new LogUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogUI() {
		setBounds(100, 100, 613, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ArrayList<String> str = null;
		try {
			logbl = new Logbl();
		} catch (RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			str = logbl.open();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 577, 281);
		String[][] cellData = new String[str.size()][1];
		for(int i = 0;i<str.size();i++){
			cellData[i][0] = str.get(i);
		}
		TableModel tm = new DefaultTableModel(cellData,null);
		
		JTable table = new JTable(tm);
		table.setBounds(10, 10, 577, 281);
		scrollPane.setViewportView(table);
		contentPanel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
