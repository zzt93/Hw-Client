package presentation.Clientui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Gui {

	static CardLayout cardLayout = new CardLayout();
	
	static JFrame frame = new JFrame();
	static JPanel backPanel = new JPanel(cardLayout);
	
	LoggingPanel logging = new LoggingPanel();
	
	
	public Gui() {
		
		backPanel.add(logging, "LOG");
		
		frame.add(backPanel);
		frame.setLocation(300, 50);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		cardLayout.show(backPanel, "LOG");
		
		frame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				
				
				if (JOptionPane.showConfirmDialog(frame, "Quit the app?", "Reminder", 2)==JOptionPane.YES_OPTION) {
				
					System.exit(0);
				}
			}

			
			
		});
		
	}
	
	
	
	public static void changeTo() {
        DefaultTableModel tableModel = new DefaultTableModel(null,
                new String[]{"id", "type", "level", "name", "phone",
                        "address", "zip", "email", "upperBound",
                        "toReceive", "toPay", "defaultSalesMan"});
        tablePanel tabelJPanel = new tablePanel(tableModel);
        buttonPanel buttonPanel = new buttonPanel(tableModel);
		
		JPanel borderJPanel = new JPanel(new BorderLayout());
		
		borderJPanel.add(buttonPanel, BorderLayout.EAST);
		borderJPanel.add(tabelJPanel, BorderLayout.WEST);
		
		backPanel.add(borderJPanel, "MAIN");
		cardLayout.show(backPanel, "MAIN");
		frame.pack();
	}
}
