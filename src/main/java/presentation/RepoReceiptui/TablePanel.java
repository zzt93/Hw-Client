package presentation.RepoReceiptui;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogicservice.RepositoryCheckblservice.RepoCheckBLservice;

public class TablePanel extends JPanel implements TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static MyTableModel tableModel = new MyTableModel();
	static JTable statistic = new JTable(tableModel);
	JScrollPane scrollPane = new JScrollPane(statistic);
	
	RepoCheckBLservice examinBLservice = new RepoCheckBLImpl();
	
	public TablePanel() {
		// TODO Auto-generated constructor stub
		super();
		//add the titled-border
		this.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Table Title",
                TitledBorder.CENTER,
                TitledBorder.TOP));

		statistic.getModel().addTableModelListener(this);
		statistic.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	public boolean addStatistic() {
		examinBLservice.checkAndSum();
		tableModel.fireTableDataChanged();
		return false;
	}

	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
        TableModel model = (TableModel)e.getSource();
        System.out.println("table listener");

	}
}
