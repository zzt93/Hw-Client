package presentation.LoginUI;

import javax.swing.*;

import po.UserPO;
import presentation.RepoUI.MainFrame;
import presentation.mainui.FinancialUI;
import presentation.mainui.ManagerUI;
import presentation.mainui.SalesmanUI;
import businesslogic.Adminbl.AdminController;
import presentation.RepoUI.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoggingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String name = "";
	JTextField userNameField = new JTextField(10);
	JPasswordField passwordField = new JPasswordField(10);
	AdminController adminController;
	ArrayList<UserPO> userList;


	Image image = new ImageIcon("Log_in.jpg")
			.getImage();

	public LoggingPanel() {
		try {
			adminController=new AdminController();
		} catch (RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "服务器出现了问题");
			e.printStackTrace();
		}
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
		userList=null;
		try {
			userList=adminController.show();
//			final HashMap<String, char[]> databaseMap = new HashMap<String, char[]>();
////			databaseMap.put("accountant", new char[] { '1' });
////			databaseMap.put("salesman", new char[] { '2' });
////			databaseMap.put("keeper", new char[] { '3' });
//			UserPO temp;
//			for(int i=0;i<userList.size();i++){
//				temp=userList.get(i);
//				databaseMap.put(temp.getName(), temp.getPassword().toCharArray());
//			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final HashMap<String, char[]> databaseMap = new HashMap<String, char[]>();
//		databaseMap.put("accountant", new char[] { '1' });
//		databaseMap.put("salesman", new char[] { '2' });
//		databaseMap.put("keeper", new char[] { '3' });
		UserPO temp;
		for(int i=0;i<userList.size();i++){
			temp=userList.get(i);
			databaseMap.put(temp.getName(), temp.getPassword().toCharArray());
		}
//		final HashMap<String, char[]> databaseMap = new HashMap<String, char[]>();
//		databaseMap.put("accountant", new char[] { '1' });
//		databaseMap.put("salesman", new char[] { '2' });
//		databaseMap.put("keeper", new char[] { '3' });
//		UserPO temp;
//		for(int i=0;i<userList.size();i++){
//			temp=userList.get(i);
//			databaseMap.put(temp.getName(), temp.getPassword().toCharArray());
//		}
//					
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
						UserPO temp=null;
						for(int i=0;i<userList.size();i++){
							temp=userList.get(i);
							if(temp.getName().equals(name)){
								break;
							}
						}
						String role=temp.getRole();
						if(role.equals("总经理")){
							try {
								ManagerUI manager=new ManagerUI();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
								e1.printStackTrace();
							}
						}else if(role.startsWith("库存")){
							new MainFrame().setVisible(true);
						}else if(role.startsWith("财务")){
							FinancialUI financial=new FinancialUI();
						}else{
							SalesmanUI sales=new SalesmanUI();
						}
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
