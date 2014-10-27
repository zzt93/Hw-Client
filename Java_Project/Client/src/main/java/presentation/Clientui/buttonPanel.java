package presentation.Clientui;

import businesslogic.Clientbl.ClientUtility;
import businesslogicservice.Clientblservice.ClientUtilityImpl;
import po.ClientLevel;
import po.ClientPO;
import po.ClientType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

public class buttonPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static ClientUtilityImpl impl;
    private static DefaultTableModel model;

    JButton addButton = new JButton("Add");
    JButton delButton = new JButton("Delete");
    JButton updButton = new JButton("Update");
    JButton seaButton = new JButton("Search");

    static GridLayout gridLayout = new GridLayout(2, 2);

    public buttonPanel(DefaultTableModel _model) {
        // TODO Auto-generated constructor stub
        super(gridLayout);
        model = _model;

        try {
            impl = new ClientUtility();
            Vector<ClientPO> clientPOVector = impl.queryClient(null);
            String[] rowData = new String[12];
            for (ClientPO clientPO : clientPOVector) {
                rowData[0] = String.valueOf(clientPO.getId());
                rowData[1] = clientPO.getType().toString();
                rowData[2] = clientPO.getLevel().toString();
                rowData[3] = clientPO.getName();
                rowData[4] = clientPO.getPhone();
                rowData[5] = clientPO.getAddress();
                rowData[6] = clientPO.getZip();
                rowData[7] = clientPO.getEmail();
                rowData[8] = clientPO.getUpperBound().toString();
                rowData[9] = clientPO.getToReceive().toString();
                rowData[10] = clientPO.getToPay().toString();
                rowData[11] = clientPO.getDefaultSalesMan();
                model.addRow(rowData);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.add(addButton);
        this.add(delButton);
        this.add(seaButton);
        this.add(updButton);

        addListener();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

    }

    public void addListener() {
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                JTextField name = new JTextField();
                JComboBox<String> type = new JComboBox<>(new String[]{"进货商", "销售商"});
                JComboBox<String> level = new JComboBox<>(new String[]{"级别1", "级别2",
                        "级别3", "级别4", "级别5"});
                JTextField phone = new JTextField();
                JTextField addr = new JTextField();
                JTextField zip = new JTextField();
                JTextField email = new JTextField();
                JTextField toReceive = new JTextField();
                JTextField toPay = new JTextField();
                JTextField upperBound = new JTextField();
                JTextField salesman = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("type"),
                        type,
                        new JLabel("level"),
                        level,
                        new JLabel("name"),
                        name,
                        new JLabel("phone"),
                        phone,
                        new JLabel("addr"),
                        addr,
                        new JLabel("zip"),
                        zip,
                        new JLabel("email"),
                        email,
                        new JLabel("upperBound"),
                        upperBound,
                        new JLabel("toReceive"),
                        toReceive,
                        new JLabel("toPay"),
                        toPay,
                        new JLabel("salesMan"),
                        salesman
                };
                JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                tablePanel.addStatistic();
                try {
                    impl.addClient(new ClientPO(ClientType.values()[type.getSelectedIndex()],
                            ClientLevel.values()[level.getSelectedIndex()], name.getText(),
                            phone.getText(), addr.getText(), zip.getText(), email.getText(),
                            salesman.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        delButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JTextField id = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("id"),
                        id,
                };
                JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                try {
                    impl.deleteClient(Integer.parseInt(id.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                tablePanel.addStatistic();

            }
        });

        updButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JTextField name = new JTextField();
                JComboBox<String> type = new JComboBox<>(new String[]{"进货商", "销售商"});
                JComboBox<String> level = new JComboBox<>(new String[]{"级别1", "级别2",
                        "级别3", "级别4", "级别5"});
                JTextField phone = new JTextField();
                JTextField addr = new JTextField();
                JTextField zip = new JTextField();
                JTextField email = new JTextField();
                JTextField toReceive = new JTextField();
                JTextField toPay = new JTextField();
                JTextField upperBound = new JTextField();
                JTextField salesman = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("type"),
                        type,
                        new JLabel("level"),
                        level,
                        new JLabel("name"),
                        name,
                        new JLabel("phone"),
                        phone,
                        new JLabel("addr"),
                        addr,
                        new JLabel("zip"),
                        zip,
                        new JLabel("email"),
                        email,
                        new JLabel("upperBound"),
                        upperBound,
                        new JLabel("toReceive"),
                        toReceive,
                        new JLabel("toPay"),
                        toPay,
                        new JLabel("salesMan"),
                        salesman
                };
                JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                //method of bl
                try {
                    Vector<ClientPO> clientPOVector = impl.queryClient(null);
                    model.setRowCount(0);
                    String[] rowData = new String[12];
                    for (ClientPO clientPO : clientPOVector) {
                        rowData[0] = String.valueOf(clientPO.getId());
                        rowData[1] = clientPO.getType().toString();
                        rowData[2] = clientPO.getLevel().toString();
                        rowData[3] = clientPO.getName();
                        rowData[4] = clientPO.getPhone();
                        rowData[5] = clientPO.getAddress();
                        rowData[6] = clientPO.getZip();
                        rowData[7] = clientPO.getEmail();
                        rowData[8] = clientPO.getUpperBound().toString();
                        rowData[9] = clientPO.getToReceive().toString();
                        rowData[10] = clientPO.getToPay().toString();
                        rowData[11] = clientPO.getDefaultSalesMan();
                        model.addRow(rowData);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                //simulation

            }
        });

        seaButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JTextField id = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("id"),
                        id,
                };
                JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                try {
                    ClientPO clientPO = impl.queryClientById(Integer.parseInt(id.getText()));
                    JOptionPane.showMessageDialog(null, clientPO);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                tablePanel.addStatistic();

            }
        });
    }

}
