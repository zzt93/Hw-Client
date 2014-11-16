package presentation.GoodsListui;

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

import vo.GoodsVO;
import businesslogic.GoodsListbl.GLBLImpl;
import businesslogicservice.GoodsListblservice.GLBLservice;
/**
 * This is the intersection where ui and bl interact
 * 
 * GoodsList
 * 
 * @author zzt
 *
 */
public class ButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton addButton = new JButton("Add");
	JButton delButton = new JButton("Delete");
	JButton updButton = new JButton("Update");
	JButton seaButton = new JButton("Search");
	
	static GridLayout gridLayout = new GridLayout(2, 2);
	
	public ButtonPanel() {
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
		
		final GLBLservice glbLservice = new GLBLImpl("account");
		
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				JTextField name = new JTextField();
				JTextField id = new JTextField();
				JTextField num = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("name"),
						name,
						new JLabel("id"),
						id,
						new JLabel("Password"),
						num
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
				System.out.println("You entered " +
						name.getText() + ", " +
						id.getText() + ", " +
						num.getText());
				
				try {
					glbLservice.add(new GoodsVO());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
						new JLabel("name"),
						name,
						new JLabel("id"),
						id,
						new JLabel("Password"),
						num
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
				System.out.println("You entered " +
						name.getText() + ", " +
						id.getText() + ", " +
						num.getText());
				
				try {
					glbLservice.delete(new GoodsVO());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		updButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField name = new JTextField();
				JTextField id = new JTextField();
				JTextField num = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("name"),
						name,
						new JLabel("id"),
						id,
						new JLabel("Password"),
						num
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
				System.out.println("You entered " +
						name.getText() + ", " +
						id.getText() + ", " +
						num.getText());
				
				//method of bl

				try {
					glbLservice.update(new GoodsVO());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//update the ui
				TablePanel.tableModel.setValueAt("sa",1, 1);
				
			}
		});
		
		seaButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField name = new JTextField();
				JTextField id = new JTextField();
				JTextField num = new JTextField();
				final JComponent[] inputs = new JComponent[] {
						new JLabel("name"),
						name,
						new JLabel("id"),
						id,
						new JLabel("Password"),
						num
				};
				JOptionPane.showMessageDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
				System.out.println("You entered " +
						name.getText() + ", " +
						id.getText() + ", " +
						num.getText());
				
				try {
					glbLservice.eSearch(id.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

}
