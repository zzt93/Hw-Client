/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Saleui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zzt
 */
public class Query extends JPanel {

    private JTextField textField;
    private JTable table;

    public Query() {
        super();
        setBounds(0, 0, 750, 500);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(142, 10, 370, 30);
        add(textField);
        textField.setColumns(10);

        JButton button = new JButton("查询");
        button.setBounds(541, 10, 90, 30);
        add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 68, 660, 360);
        add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseClick());
        table.setFillsViewportHeight(true);
        table.setModel(new MyTableModel());
        scrollPane.setViewportView(table);

        //frame.setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel {

        String[] name = {"单据编号", "类型", "仓库", "操作员", "总额", "备注"};
        Object[][] data = new Object[10][6];

        public MyTableModel() {
        }

        ;
		public MyTableModel(Object[][] data) {
            this.data = data;
        }

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return name.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        public String getColumnName(int k) {
            return name[k];
        }

    }

    public class MouseClick extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() >= 2) {
                int i = table.getSelectedRow();
                if (i == 0) {
                    System.out.println("啦啦啦");
                }
            }
        }
    }
}
