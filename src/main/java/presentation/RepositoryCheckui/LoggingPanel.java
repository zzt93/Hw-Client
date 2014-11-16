package presentation.RepositoryCheckui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoggingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String name = "";
	JTextField userNameField = new JTextField(10);
	JPasswordField passwordField = new JPasswordField(10);

	Image image = new ImageIcon("src/main/java/presentation/Clientui/Log_in.jpg")
			.getImage();

	public LoggingPanel() {
		setLayout(null);
		userNameField.setBorder(BorderFactory.createEmptyBorder());
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		userNameField.setBounds(370, 312, 130, 20);
		passwordField.setBounds(370, 355, 130, 20);
		this.add(userNameField);
		this.add(passwordField);
		perform();
	}

	public void perform() {

		final HashMap<String, char[]> databaseMap = new HashMap<String, char[]>();
		databaseMap.put("accountant", new char[] { '1' });
		databaseMap.put("salesman", new char[] { '2' });
		databaseMap.put("keeper", new char[] { '3' });
		passwordField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				name = userNameField.getText();
				char[] password = passwordField.getPassword();
				boolean exist = true;

				if (databaseMap.containsKey(name)) {

					if (password.length != databaseMap.get(name).length) {
						JOptionPane.showMessageDialog(Gui.frame,
								"Wrong password", "Warning", 0);
					} else {
						for (int i = 0; i < password.length
								&& i < databaseMap.get(name).length; i++) {
							if (databaseMap.get(name)[i] != password[i]) {
								exist = false;
								break;
							}
						}
						if (exist) {
							Gui.changeTo();
						} else {
							JOptionPane.showMessageDialog(Gui.frame,
									"Wrong password", "Warning", 0);
						}
					}

				} else {
					JOptionPane.showMessageDialog(Gui.frame, "No such user",
							"Warning", 0);
				}

			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Graphics2D g2 = (Graphics2D) g;
		g.drawImage(image, 0, 0, null);
	}

	public Dimension getPreferredSize() {
		if (image != null) {
			System.out.println("---image is not null");
			return new Dimension(image.getWidth(null), image.getHeight(null));
		}
		System.out.println("---image is null");
		return super.getPreferredSize(); // default
	}
}
