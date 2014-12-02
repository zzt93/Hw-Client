package presentation.LoginUI;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class tablePanel extends JPanel implements TableModelListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static DefaultTableModel tableModel;
    static JTable statistic;
    JScrollPane scrollPane;

    public tablePanel(DefaultTableModel model) {
        // TODO Auto-generated constructor stub
        super();
        tableModel = model;
        statistic = new JTable(tableModel);
        scrollPane = new JScrollPane(statistic);
        //add the titled-border
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory
                        .createEtchedBorder(),
                "Table Title",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        statistic.getModel().addTableModelListener(this);
        statistic.setFillsViewportHeight(true);
        this.add(scrollPane);
    }

    public static boolean addStatistic() {
        return false;
    }

    public void tableChanged(TableModelEvent e) {
        // TODO Auto-generated method stub
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        System.out.println("table listener");

    }
}
