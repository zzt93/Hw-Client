package presentation.Clientui;

import businesslogic.Clientbl.ClientUtility;
import businesslogicservice.Clientblservice.ClientUtilityImpl;
import po.ClientLevel;
import po.ClientPO;
import po.ClientType;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class buttonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static ClientUtilityImpl impl = new ClientUtility();
	
	JButton addButton = new JButton("Add");
	JButton delButton = new JButton("Delete");
	JButton updButton = new JButton("Update");
	JButton seaButton = new JButton("Search");
	
	static GridLayout gridLayout = new GridLayout(2, 2);
	
	public buttonPanel() {
		// TODO Auto-generated constructor stub
		super(gridLayout);
		
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
	
	public void addListener(){
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				JTextField name = new JTextField();
				JTextField id = new JTextField();
                JTextField type = new JTextField();
                JTextField level = new JTextField();
				JTextField phone = new JTextField();
                JTextField addr = new JTextField();
                JTextField zip = new JTextField();
                JTextField email = new JTextField();
                JTextField toReceive = new JTextField();
                JTextField toPay = new JTextField();
                JTextField upperBound = new JTextField();
                JTextField salesman = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("id"),
						id,
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
                    impl.addClient(new ClientPO(ClientType.SELLER, ClientLevel.LEVEL1, name.getToolTipText(),
                            phone.getText(), addr.getText(), zip.getText(), email.getText(),
                            "defaultSales"));
                } catch (Exception e1) {
                    JOptionPane.showConfirmDialog(null, e1.getMessage());
                }
            }
		});
		
		delButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField name = new JTextField();
				JTextField id = new JTextField();
				JTextField num = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("id"),
						id,
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                try {
                    impl.deleteClient(id.getText());
                } catch (Exception e1) {
                    JOptionPane.showConfirmDialog(null, e1.getMessage());
                }
                tablePanel.addStatistic();
				
			}
		});
		
		updButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                JTextField name = new JTextField();
                JTextField id = new JTextField();
                JTextField type = new JTextField();
                JTextField level = new JTextField();
                JTextField phone = new JTextField();
                JTextField addr = new JTextField();
                JTextField zip = new JTextField();
                JTextField email = new JTextField();
                JTextField toReceive = new JTextField();
                JTextField toPay = new JTextField();
                JTextField upperBound = new JTextField();
                JTextField salesman = new JTextField();
                final JComponent[] inputs = new JComponent[] {
                        new JLabel("id"),
                        id,
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
				
				//simulation
				tablePanel.tableModel.setValueAt("sa",1, 1);
				
			}
		});
		
		seaButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField id = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("id"),
						id,
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                try {
                    ClientPO clientPO = impl.queryClientById(id.getText());
                    JOptionPane.showConfirmDialog(null, "client name = " + clientPO.getName());
                } catch (Exception e1) {
                    JOptionPane.showConfirmDialog(null, e1.getMessage());
                }
                tablePanel.addStatistic();
				
			}
		});
	}

}
